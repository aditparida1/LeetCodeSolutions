package leetcodesolutions;
import java.util.*;
public class MaxSquare221
{
    public int maximalSquare(char[][] matrix) 
    {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
        {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int maxSq = row > col ? row : col;
        boolean doesExist = false;
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if(matrix[i][j] == '1')
                {
                    doesExist = true;
                    break;
                }
                if(doesExist)
                {
                    break;
                }
            }
        }
        if(!doesExist)
        {
            return 0;
        }
        boolean bn = true;
        for (int size = 2; size <= maxSq; size++)
        {
            bn = false;
            for (int i = 0; i < row; i++)
            {
                for (int j = 0; j < col; j++)
                {
                    if(matrix[i][j] == (char)(size - 1 + '0'))
                    {
                        boolean isSq = isSquare(matrix, size, i, j);
                        if(isSq)
                        {
                            matrix[i][j] = (char)(size + '0');
                            bn = true;
                        }
                    }
                }
            }
            if(!bn)
            {
                return size - 1;
            }
        }
        return maxSq;
    }
    public boolean isSquare(char[][] matrix, int size, int startR, int startC)
    {
        if(startR + size > matrix.length || startC + size > matrix[0].length)
        {
            return false;
        }
        int rowC = startR + size - 1;
        int colC = startC + size - 1;
        for (int i = 0; i < size; i++)
        {
            if(matrix[rowC][startC + i] == '0' || matrix[startR + i][colC] == '0')
            {
                return false;
            }
        }
        return true;
    }
}
