package leetcodesolutions;
import java.util.*;
public class SortKSorted
{
    public ListNode Sort(ListNode[] ls)
    {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new ComparatorClass());
        for (int i = 0; i < ls.length; i++)
        {
            pq.add(ls[i]);
        }
        ListNode ns = null;
        ListNode curr = null;
        while(pq.size() != 0)
        {
            ListNode temp = pq.poll();
            if(temp.next != null)
            {
                pq.add(temp.next);
                temp.next = null;
            }
            if(ns == null)
            {
                ns = temp;
                curr = temp;
            }
            else
            {
                curr.next = temp;
                curr = curr.next;
            }
            
        }
        return ns;
    }
    class ComparatorClass implements Comparator<ListNode>
    {
        @Override
        public int compare(ListNode o1, ListNode o2)
        {
            return o1.val < o2.val ? -1 : 1;
        }
    }
}
