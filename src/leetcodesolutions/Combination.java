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
public class Combination
{
    public List<List<Integer>> combine(int n, int k) 
    {
        if(n == 0 || k == 0)
        {
            return new ArrayList<>();
        }
        if(k > n)
        {
            return new ArrayList<>();
        }
        List<List<Integer>> finalLs = new ArrayList<>();
        int value_To_Consider = 1;
        for (; value_To_Consider <= n - k + 1; value_To_Consider++)
        {
            List<Integer> ls = new ArrayList<>();
            ls.add(value_To_Consider);
            combineRest(value_To_Consider + 1, k - 1, n, ls, finalLs);
        }
        return finalLs;
    }
    public void combineRest(int num, int k, int n, List<Integer> ls, List<List<Integer>> finalLs)
    {
        if(k > 0 && num > n)
        {
            return;
        }
        if(k == 0)
        {
            finalLs.add(new ArrayList(ls));
            return;
        }
        else
        {
            for (int i = num; i <= n - k + 1; i++)
            {
                ls.add(i);
                combineRest(i+1, k - 1, n, ls, finalLs);
                ls.remove(ls.size() - 1);
            }
            
        }
    }
}
