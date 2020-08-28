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
public class Pascals
{
    public List<List<Integer>> generate(int numRows) 
    {
        List<List<Integer>> fls = new ArrayList<List<Integer>>();
        for(int i = 0; i <  numRows; ++i)
        {
            List<Integer> ls = new ArrayList<Integer>();
            for(int j = 0; j < i + 1; ++j)
            {
                if(j == 0 || j == i)
                {
                    ls.add(1);
                }
                else
                {
                    List<Integer> temp = fls.get(i - 1);
                    ls.add(temp.get(j) + temp.get(j - 1));                    
                }
                
            }
            fls.add(ls);
        }
        return fls;
    }
}
