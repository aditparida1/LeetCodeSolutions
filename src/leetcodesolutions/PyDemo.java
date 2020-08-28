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
public class PyDemo
{
    int[] pi = {0,1,0,0};
    int[][] A = {{1,0,0,0},{0,0,0,1},{0,4,3,3},{3,2,2,3}};
    int[][] B = {{1,0,0,0,0},{0,5,5,0,0},{0,2,2,3,3},{0,0,0,5,5}};
    public void Findlist(StringBuilder sb, List<String> ls, int pos, Stack<Integer> st)
    {
        if(pos == 0)
        {
            sb.append('0');
            ls.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
        }
        else
        {
            for (int i = 0; i < 4; i++)
            {
                if(A[pos][i] > 0)
                {
                    for (int j = 0; j < 5; j++)
                    {
                        if(ls.size() < 10 && B[pos][j] > 0 )
                        {
                            sb.append(j);
                            Findlist(sb, ls, i, st);
                            sb.deleteCharAt(sb.length() - 1);
                        }
                    }
                }
            }
        }
    }
}
