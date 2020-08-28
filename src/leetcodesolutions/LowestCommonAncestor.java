
package leetcodesolutions;
import java.util.*;

public class LowestCommonAncestor
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        Stack<TreeNode> stp = new Stack<>();
        Stack<TreeNode> stq = new Stack<>();
        SearchNode(root, p, stp);
        SearchNode(root, q, stq);
        Stack<TreeNode> rstp = new Stack<>();
        Stack<TreeNode> rstq = new Stack<>();
        while(stp.size() != 0)
        {
            rstp.push(stp.pop());
        }
        while(stq.size() != 0)
        {
            rstq.push(stq.pop());
        }
        TreeNode currSim = rstp.peek();
        while(rstp.size() != 0 && rstq.size() !=0 && rstp.peek().val == rstq.peek().val)
        {
            currSim = rstp.pop();
            rstq.pop();
        }
        return currSim;
    }
    public void SearchNode(TreeNode root, TreeNode node, Stack<TreeNode> st)
    {
        if(root == null)
        {
            return;
        }
        if(root.val != node.val)
        {
            st.push(root);
            SearchNode(root.left, node, st);
            if(st.peek().val != node.val)
            {
                SearchNode(root.right, node, st);
            }
            if(st.peek().val != node.val)
            {
                st.pop();
            }
        }
        else
        {
            st.push(root);
        }
    }
}
