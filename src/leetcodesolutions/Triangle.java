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
public class Triangle
{
    public int minimumTotal(List<List<Integer>> triangle) 
    {
        triangleDP(triangle);
        return 0;
    }
    public int triangleT(List<List<Integer>> triangle, int sum, int row, int col)
    {
        if(row > triangle.size())
        {
            return sum;
        }
        sum += triangle.get(row).get(col);
        int sum1 = triangleT(triangle, sum, row + 1, col);
        int sum2 = triangleT(triangle, sum, row + 1, col + 1);
        if(sum1<sum2)
        {
            return sum1;
        }
        else
        {
            return sum2;
        }
    }
    public int triangleDP(List<List<Integer>> triangle)
    {
        int[][] dpTable = new int[triangle.size()][triangle.size()];
        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++)
        {
            dpTable[triangle.size() - 1][i] = triangle.get(triangle.size() - 1).get((i));            
        }
        int len = triangle.size();
        for (int i = len - 2; i >= 0; i--)
        {
            for (int j = 0; j <= i; j++)
            {
                int curr = triangle.get(i).get(j);
                int l = dpTable[i + 1][j];
                int r = dpTable[i+1][j+1];
                dpTable[i][j] = l + curr > r + curr ? r + curr : l + curr;
            }
        }
        return dpTable[0][0];
    }
    public int triangleDPSpaceOPT(List<List<Integer>> triangle)
    {
       int[] dpTable = new int[triangle.size()];
       for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++)
        {
            dpTable[i] = triangle.get(triangle.size() - 1).get((i));
        }
       int len = triangle.size();
        for (int i = len - 2; i >= 0; i--)
        {
            for (int j = 0; j <= i; j++)
            {
                int curr = triangle.get(i).get(j);
                int l = dpTable[j];
                int r = dpTable[j + 1];
                dpTable[j] = l + curr > r + curr ? r + curr : l + curr;
            }
        }
        return dpTable[0];
    }
}
