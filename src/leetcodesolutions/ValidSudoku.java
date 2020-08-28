
package leetcodesolutions;
import java.util.*;
/**
 *
 * @author User
 */
public class ValidSudoku
{
    public boolean IsValid(char sudoku[][])
    {
        HashSet[] rowSet = new HashSet[9];
        HashSet[] columnSet = new HashSet[9];
        HashSet[] smallBoxes = new HashSet[9];
        for (int i = 0; i < 9; i++)
        {
            rowSet[i] = new HashSet();
            columnSet[i] = new HashSet();
            smallBoxes[i] = new HashSet();
        }
        boolean isValid = true;
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (sudoku[i][j] == '.')
                {
                    continue;                    
                }                
                if(rowSet[i].contains(sudoku[i][j]))
                {
                    isValid = false;
                    return isValid;
                }
                else
                {
                    rowSet[i].add(sudoku[i][j]);
                }
                if (columnSet[j].contains(sudoku[i][j]))
                {
                    isValid = false;
                    return isValid;
                }
                else
                {
                    columnSet[j].add(sudoku[i][j]);
                }
                if(i >= 0 && i <= 2 && j >= 0 && j <= 2)
                {
                    if(smallBoxes[0].contains(sudoku[i][j]))
                    {
                        isValid = false;
                        return isValid;
                    }
                    else
                    {
                        smallBoxes[0].add(sudoku[i][j]);
                    }
                }
                if(i >= 0 && i <= 2 && j >= 3 && j <= 5)
                {
                    if(smallBoxes[1].contains(sudoku[i][j]))
                    {
                        isValid = false;
                        return isValid;
                    }
                    else
                    {
                        smallBoxes[1].add(sudoku[i][j]);
                    }
                }
                if(i >= 0 && i <= 2 && j >= 6 && j <= 8)
                {
                    if(smallBoxes[2].contains(sudoku[i][j]))
                    {
                        isValid = false;
                        return isValid;
                    }
                    else
                    {
                        smallBoxes[2].add(sudoku[i][j]);
                    }
                    
                }
                if(i >= 3 && i <= 5 && j >= 0 && j <= 2)
                {
                    if(smallBoxes[3].contains(sudoku[i][j]))
                    {
                        isValid = false;
                        return isValid;
                    }
                    else
                    {
                        smallBoxes[3].add(sudoku[i][j]);
                    }
                }
                if(i >= 3 && i <= 5 && j >= 3 && j <= 5)
                {
                    if(smallBoxes[4].contains(sudoku[i][j]))
                    {
                        isValid = false;
                        return isValid;
                    }
                    else
                    {
                        smallBoxes[4].add(sudoku[i][j]);
                    }
                }
                if(i >= 3 && i <= 5 && j >= 6 && j <= 8)
                {
                    if(smallBoxes[5].contains(sudoku[i][j]))
                    {
                        isValid = false;
                        return isValid;
                    }
                    else
                    {
                        smallBoxes[5].add(sudoku[i][j]);
                    }
                }
                if(i >= 6 && i <= 8 && j >= 0 && j <= 2)
                {
                    if(smallBoxes[6].contains(sudoku[i][j]))
                    {
                        isValid = false;
                        return isValid;
                    }
                    else
                    {
                        smallBoxes[6].add(sudoku[i][j]);
                    }
                }
                if(i >= 6 && i <= 8 && j >= 3 && j <= 5)
                {
                    if(smallBoxes[7].contains(sudoku[i][j]))
                    {
                        isValid = false;
                        return isValid;
                    }
                    else
                    {
                        smallBoxes[7].add(sudoku[i][j]);
                    }
                    
                }
                if(i >= 6 && i <= 8 && j >= 6 && j <= 8)
                {
                    if(smallBoxes[8].contains(sudoku[i][j]))
                    {
                        isValid = false;
                        return isValid;
                    }
                    else
                    {
                        smallBoxes[8].add(sudoku[i][j]);
                    }
                }
                
            }
            if(!isValid)
                break;
        }
        
        return isValid;
    }
}

