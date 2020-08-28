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
public class PathSuminTree
{
    public List<List<Integer>> pathSum(TreeNode root, int sum) 
    {
        List<List<Integer>> fls = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        Sum(ls, root, sum, fls);
        return fls;
    }
    public void Sum(List<Integer> ls,  TreeNode root, int sum, List<List<Integer>> fls)
    {
        if(root == null) return;
        if(sum < root.val)
        {
            return ;
        }
        if(sum == root.val)
        {
            if(root.right != null || root.left != null)
            {
                return;
            }
            else
            {
                ls.add(root.val);
                List<Integer> temp = new ArrayList<>(ls);
                fls.add(temp);
                ls.remove(ls.size() - 1);
                return;
            }
        }
        ls.add(root.val);
        Sum(ls, root.left,  sum - root.val, fls);
        Sum(ls, root.right, sum - root.val, fls);
        ls.remove(ls.size() - 1);
    }
}
