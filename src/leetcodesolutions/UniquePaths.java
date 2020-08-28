/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodesolutions;

/**
 *
 * @author User
 */
public class UniquePaths
{
    //2^n^2 complexity
    public int uniquePaths(int m, int n) 
    {
        int[] sum = new int[]{0};
        Paths(0, 0, m - 1, n - 1, sum);
        return sum[0];
    }
    public void Paths(int currRow, int currCol, int m, int n, int[] sum)
    {
        if(currRow == m && currCol == n)
        {
            sum[0]++;
        }
        else
        {
            if(IsValid(currRow + 1, currCol, m, n))
            {
                Paths(currRow + 1, currCol, m, n, sum);
            }
            if(IsValid(currRow, currCol + 1, m, n))
            {
                Paths(currRow, currCol + 1, m, n, sum);
            }
        }
    }
        public static boolean IsValid(int currRow, int currCol, int m, int n)
        {
            return currRow <= m && currCol <= n;
        }
        
}
