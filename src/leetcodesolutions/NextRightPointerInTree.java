/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodesolutions;
import java.util.*;
/**
 *
 * @author User
 */
public class NextRightPointerInTree
{
    public Node connect(Node root) 
    {
        int h = Height(root);
        Node[] levels = new Node[h];
        Conn(levels, root, 0);
        return root;
    }
    public void Conn(Node[] levels, Node root, int level)
    {
        if(root == null)
            return;
        if(levels[level] == null)
        {
            levels[level] = root;
        }
        else
        {
            levels[level].next = root;
            levels[level] = root;
        }
        Conn(levels, root.left, level + 1);
        Conn(levels, root.right, level + 1);
    }
    public int Height(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        return max(Height(root.left), Height(root.right)) + 1;
    }
    int max(int a, int b)
    {
        return a > b ? a : b;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
