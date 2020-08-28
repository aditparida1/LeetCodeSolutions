/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodesolutions;
import java.util.HashSet;
import java.util.Stack;
/**
 *
 * @author User
 */
public class DeleteDuplicates2
{
    public ListNode deleteDuplicates(ListNode head) 
    {
        if(head == null)
        {
            return null;
        }
        ListNode curr = head;
        ListNode ls = null;
        HashSet<Integer> hs = new HashSet<>();
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> revStack = new Stack<>();
        while(curr != null)
        {
            if(!hs.contains(curr.val))
            {
                st1.push(curr.val);
                hs.add(curr.val);
            }
            else
            {
                if(!st1.isEmpty() && st1.peek() == curr.val)
                {
                    st1.pop();
                }
            }
            curr = curr.next;
        }
        while(!st1.isEmpty())
        {
            revStack.push(st1.pop());
        }
        curr = null;
        while(!revStack.isEmpty())
        {
            if(curr == null)
            {
                curr = new ListNode(revStack.pop());
                ls = curr;
            }
            else
            {
                curr.next = new ListNode(revStack.pop());
                curr = curr.next;
            }
        }
        return ls;
    }
    
}
