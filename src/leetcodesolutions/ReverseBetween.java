
package leetcodesolutions;
import java.util.*;
public class ReverseBetween
{
    public ListNode reverseBetween(ListNode head, int m, int n) 
    {
        if(head == null || head.next ==null)
        {
            return head;
        }
        
        ListNode curr1 = head;
        //ListNode curr2 = head;
        Queue<ListNode> queueF;
        queueF = new LinkedList<>();
        Queue<ListNode> queueB;
        
        queueB = new LinkedList<>();
        Stack<ListNode> st = new Stack<>();
        int i = 1;
        for (; i < m; i++)
        {
            ListNode temp2 = curr1;
            queueF.add(curr1);
            curr1 = curr1.next;
            temp2.next = null;
                        
        }
        for (; i <= n; i++)
        {
            ListNode temp2 = curr1;
            st.push(curr1);
            curr1 = curr1.next;
            temp2.next = null;
        }
        while(curr1!=null)
        {
            ListNode temp2 = curr1;
            queueB.add(curr1);
            curr1 = curr1.next;
            temp2.next = null;
        }
        ListNode temp = head;
        head = null;
        while(queueF.size() != 0)
        {
            ListNode ls = queueF.poll();
            if(head == null)
            {
                head = ls;
                temp = head;
            }
            else
            {
                head.next = ls;
                head = head.next;
            }
        }
        while(st.size() != 0)
        {
            if(head == null)
            {
                head = st.pop();
                temp = head;
            }
            else
            {
                head.next = st.pop();
                head = head.next;
            }
        }
        while(queueB.size() != 0)
        {
            ListNode ls = queueB.poll();
            if(head == null)
            {
                head = ls;
                temp = head;
            }
            else
            {
                head.next = ls;
                head = head.next;
            }
        }
        return temp;
    }
}
