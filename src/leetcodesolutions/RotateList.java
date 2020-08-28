/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodesolutions;

/**
 *
 * @author User
 */
public class RotateList
{
    public ListNode rotateRight(ListNode head, int k) 
    {
        int size = Size(head);
        if(size == 1)
        {
            return head;
        }
        int rotations = size % k;
        
        ListNode toRemove = ReturnOneLast(head, rotations);
        ListNode newHead = toRemove.next;
        ListNode curr = newHead;
        while(curr.next!=null)
        {
            curr = curr.next;
        }
        toRemove.next = null;
        curr.next = head;
        
        return newHead;
    }
    public static ListNode ReturnOneLast(ListNode head, int rotations)
    {
        int count = 0;
        ListNode removeNode = head;
        while(head.next != null)
        {
            if(count < rotations + 1)
            {
                head = head.next;
            }
            else
            {
                removeNode = removeNode.next;
                head = head.next;
            }
            count++;
        }
        return removeNode;
    }
    public static int Size(ListNode head)
    {
        int count = 0;
        while(head != null)
        {
            count++;
            head = head.next;
        }
        return count;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
