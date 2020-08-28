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
public class MaxPathToLast
{
    public static int find(int[][] mat)
    {
        List<Integer> ls = new ArrayList<Integer>();
        Stack<Integer> st = new Stack<>();
        FindTheMin(mat, 0, 0, st, ls);
        int largest = ls.get(ls.size() - 1);
        for (int i : ls)
        {
            if(i > largest)
            {
                largest = i;
            }
        }
        return largest;
    }
    public static void FindTheMin(int[][] matrix, int currRow, int currCol, Stack<Integer> st, List<Integer> smalllist)
    {
        if(currRow == matrix.length - 1 && currCol == matrix[0].length - 1)
        {
            st.push(matrix[currRow][currCol]);
            int smallest = st.peek();
            for (int i = st.size() - 1; i >= 0; i--)
            {
                if(smallest > st.get(i))
                {
                    smallest = st.get(i);
                }
            }
            smalllist.add(smallest);
            st.pop();
        }
        else
        {
            st.push(matrix[currRow][currCol]);
            if(isValid(currRow + 1, currCol, matrix))
            {
                FindTheMin(matrix, currRow + 1, currCol, st, smalllist);
            }
            if(isValid(currRow, currCol + 1, matrix))
            {
                FindTheMin(matrix, currRow, currCol + 1, st, smalllist);
            }
            st.pop();
        }
    }
    public static boolean isValid(int row, int col, int[][] matrix)
    {
        if(row < matrix.length && col < matrix[0].length)
        {
            return true;
        }
        return false;
    }
}
