
package leetcodesolutions;
import java.util.*;
public class ReorderList
{
    public void reorderList(ListNode head) 
    {
        if(head == null)
        {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null || fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        
        Stack<ListNode> st = new Stack<>();
        while(mid != null)
        {
            st.push(mid);
            mid = mid.next;
        }
        while(!st.isEmpty())
        {
            ListNode temp = st.pop();
            temp.next = head.next;
            head.next = temp;
            head = head.next.next;
        }
    }
}
