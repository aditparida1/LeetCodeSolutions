
package leetcodesolutions;



public class BalancedBstFromSortedList
{
    public TreeNode sortedListToBST(ListNode head) 
    {
        if(head == null)
        {
            return null;
        }
        //Finding the mid element
        ListNode node = head;
        ListNode slow = head;
        ListNode speed = head;
        while(speed != null)
        {
            if(speed.next ==null)
                break;
            slow = slow.next;
            speed = speed.next.next;
        }
        TreeNode tn = new TreeNode(slow.val);
        if(node != slow)
        {
            while(node.next != slow)
            {
                node = node.next;
            }
            
        }
        if(node.next == slow)
        {
            node.next = null;
            tn.left = sortedListToBST(head);
        }
        else
        {
            tn.left = null;
        }
        
        tn.right = sortedListToBST(slow.next);
        return tn;
    }
}
