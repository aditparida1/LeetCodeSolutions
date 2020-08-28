
package leetcodesolutions;

public class UniquePathDPSolution
{
    public long uniquePaths(int m, int n)
    {
        long[][] matrix = new long[m][n];
        matrix[m - 1][n - 1] = 1;
        long paths = Paths(matrix, 0, 0, m - 1, n - 1);
        System.out.println(matrix[0][0]);
        return paths;
    }
    
    public long Paths(long[][] matrix,int currRow, int currCol, int m, int n)
    {
        if(matrix[currRow][currCol] != 0)
        {
            return matrix[currRow][currCol];
        }
        else
        {
            long ways = 0;
            if(IsValid(currRow + 1, currCol, m, n))
            {
                ways = Paths(matrix, currRow + 1, currCol, m, n);
                matrix[currRow][currCol] += ways;
            }
            if(IsValid(currRow, currCol + 1, m, n))
            {
                ways = Paths(matrix, currRow, currCol + 1, m, n);
                matrix[currRow][currCol] += ways;
            }
        }
        return matrix[currRow][currCol];
    }
    public static boolean IsValid(int currRow, int currCol, int m, int n)
    {
        return currRow <= m && currCol <= n;
    }
}
