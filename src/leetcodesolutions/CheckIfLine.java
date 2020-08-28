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
public class CheckIfLine
{
    public boolean checkStraightLine(int[][] coordinates) 
    {
        if(coordinates.length <= 2)
        {
            return true;
        }
        int y1diff = coordinates[0][1] - coordinates[1][1];
        int x1diff = coordinates[0][0] - coordinates[1][0];
        if(x1diff == 0)
        {
            for(int i = 1; i < coordinates.length; ++i)
            {
                if(coordinates[i][0] != coordinates[i - 1][0])
                {
                    return false;
                }
            }
            return true;
        }
        double m = (double)y1diff / x1diff;
        
        double c = (coordinates[0][1] - m * coordinates[0][0]);
        for (int i = 0; i < coordinates.length; i++)
        {
            if( coordinates[i][1] != m * coordinates[i][0] + c)
            {
                return false;
            }
        }
        return true;
    }
    static int gcd(int a, int b) 
    { 
        // Everything divides 0  
        if (a == 0) 
          return b; 
        if (b == 0) 
          return a; 
       
        // base case 
        if (a == b) 
            return a; 
       
        // a is greater 
        if (a > b) 
            return gcd(a-b, b); 
        return gcd(a, b-a); 
    } 
}
