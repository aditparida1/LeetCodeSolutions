
package leetcodesolutions;
import java.util.*;
public class WordSearch
{
    public boolean FindWord(char[][] board, int currM, int currN, int visited[][], String word, int idx)
    {
        if(word.charAt(idx) == board[currM][currN] && idx == word.length() - 1)
        {
            return true;
        }
        if(word.charAt(idx) != board[currM][currN])
        {
            return false;
        }
        if(word.charAt(idx) == board[currM][currN])
        {
            
            if(IsValid(visited, board.length, board[0].length, currM + 1, currN))
            {
                visited[currM + 1][currN] = 1;
                boolean flag = FindWord(board, currM + 1, currN, visited, word, idx + 1);
                if(flag)
                    return true;
                visited[currM + 1][currN] = 0;
            }
            if(IsValid(visited, board.length, board[0].length, currM - 1, currN))
            {
                visited[currM - 1][currN] = 1;
                boolean flag = FindWord(board, currM - 1, currN, visited, word, idx + 1);
                if(flag)
                    return true;
                visited[currM - 1][currN] = 0;
            }
            if(IsValid(visited, board.length, board[0].length, currM, currN + 1))
            {
                visited[currM][currN + 1] = 1;
                boolean flag = FindWord(board, currM, currN + 1, visited, word, idx + 1);
                if(flag)
                    return true;
                visited[currM][currN + 1] = 0;
            }
            if(IsValid(visited, board.length, board[0].length, currM, currN - 1))
            {
                visited[currM][currN - 1] = 1;
                boolean flag = FindWord(board, currM, currN - 1, visited, word, idx + 1);
                if(flag)
                    return true;
                visited[currM][currN - 1] = 0;
            }
        }
        
        return false;
    }
    public boolean exist(char[][] board, String word) 
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                    int[][] visited = new int[board.length][board[0].length];
                    visited[i][j] = 1;
                    boolean found = FindWord(board, i, j, visited, word, 0);
                    if(found)
                        return true;
                }
            }
            
        }
        return false;
    }
    public boolean IsValid(int[][] check, int m, int n, int currM, int currN)
    {
        if(currN < n && currM < m && currN >= 0 && currM >= 0 && check[currM][currN] != 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
