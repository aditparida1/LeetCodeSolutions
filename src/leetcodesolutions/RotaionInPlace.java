
package leetcodesolutions;
public class RotaionInPlace
{
    public void rotate(int[][] matrix)
    {
        if(matrix.length == 0 || matrix == null)
        {
            return;
        }
        int rows = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < rows; i++)
        {
            for (int j = i; j < col; j++)
            {
                if(i != j)
                    Swap(matrix,i,j,j,i);
            }
        }
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < rows - j - 1; j++)
            {
                Swap(matrix, i, j, i, rows - j - 1);
            }
        }
    }
    public static void Swap(int[][] matrix, int row1, int col1, int row2, int col2)
    {
        int temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    }
}
