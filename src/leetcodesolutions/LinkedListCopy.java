
package leetcodesolutions;

public class LinkedListCopy
{
    public Nodep copyRandomList(Nodep head) 
    {
        if(head == null)
        {
            return null;
        }
        Nodep curr = head;
        while(curr != null)
        {
            Nodep temp = new Nodep(curr.val, curr.next, null);
            curr.next = temp;
            curr = curr.next.next;
        }
        curr = head;
        while(curr != null)
        {
            curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
        curr = head;
        Nodep newLs = curr.next;
        Nodep newTemp = newLs;
        while(newTemp.next != null)
        {
            newTemp.next = newTemp.next.next;
            newTemp = newTemp.next;
        }
        return newLs;
    }
}
class Nodep {
    public int val;
    public Nodep next;
    public Nodep random;

    public Nodep() {}

    public Nodep(int _val,Nodep _next,Nodep _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};