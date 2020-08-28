
package leetcodesolutions;
import java.util.*;

public class RightViewOfTree
{
    int thresholdDepth;
    public List<Integer> rightSideView(TreeNode root) 
    {
        thresholdDepth = -1;
        List<Integer> fls = new ArrayList<>();
        GetRightView(root, fls, 0);
        return fls;
    }
    public void GetRightView(TreeNode root, List<Integer> fls, int depth)
    {
        if(root == null)
        {
            return;
        }
        if(depth > thresholdDepth)
        {
            thresholdDepth = depth;
            fls.add(root.val);
        }
        GetRightView(root.right, fls, depth + 1);
        GetRightView(root.left, fls, depth + 1);
    }
}
