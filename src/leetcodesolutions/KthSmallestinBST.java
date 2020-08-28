
package leetcodesolutions;
import java.util.*;

public class KthSmallestinBST
{
    public int kthSmallest(TreeNode root, int k) 
    {
        List<Integer> ls = new ArrayList<>();
        InOrder(root, ls, k);
        return ls.get(ls.size() - 1);
    }
    public void InOrder(TreeNode root, List<Integer> ls, int k)
    {
        if(root == null || ls.size() == k)
        {
            return;
        }
        if(ls.size() < k)
        {
            InOrder(root.left, ls, k);
        }
        if(ls.size() < k)
        {
            ls.add(root.val);
        }
        if(ls.size() < k)
        {
            InOrder(root.right, ls, k);
        }
    }
}
