
package leetcodesolutions;
import java.util.*;

public class LevelOrder
{
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> fls = new ArrayList<>();
        Level(root, fls, 0);
        return fls;
    }
    public void Level(TreeNode root, List<List<Integer>> fls, int level)
    {
        if(root != null)
        {
            if(level > fls.size() - 1)
            {
                List<Integer> ls = new ArrayList<>();
                ls.add(root.val);
                fls.add(ls);
            }
            else
            {
                List<Integer> ls = fls.get(level);
                ls.add(root.val);
            }
            if(root.left != null)
            {
                Level(root.left, fls, level + 1);
            }
            if(root.right != null)
            {
                Level(root.right, fls, level + 1);
            }
        }
    }
}
