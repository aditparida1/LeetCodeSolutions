
package leetcodesolutions;
import java.util.*;

public class LeetCodeSolutions
{

    
    public static void main(String[] args)
    {
        int[] nums = new int[]{1,2,3,4};
        int[] mul =new ProductArrayExceptSelf().productExceptSelf(nums);
        for(int i : mul)
        {
            System.out.println(i);
        }
    }
    static ListNode Create(int[] ls)
    {
        ListNode l = null;
        ListNode p = null;
        for(int i : ls)
        {
            if(l ==null)
            {
                l = new ListNode(i);
                p = l;
            }
            else
            {
                l.next = new ListNode(i);
                l=l.next;
            }
        }
        return p;
    }
    static <T> List<T> createList(T[] ip)
    {
        List<T> ls = new ArrayList<>();
        for(T a : ip)
        {
            ls.add(a);
        }
        return ls;
    }
    public List<String> letterCombinations(String digits) 
    {
        if(digits.length() == 0)
        {
            return new ArrayList<String>();
        }
        char[][] charArray = new char[10][];
        for (int i = 0; i < 10; i++)
        {
            if(i == 0 || i == 1)
            {
                charArray[i] = new char[0];
            }
            else if(i == 7 || i == 9)
            {
                charArray[i] = new char[4];
            }
            else
            {
                charArray[i] = new char[3];
            }
            
        }
        int alph = 97;
        for (int i = 2; i < 10; i++)
        {
            for (int j = 0; j < charArray[i].length; j++)
            {
                charArray[i][j] = (char)alph;
                alph++;
            }            
        }
        List<String> finalList = new ArrayList<>();
        char[] finalString = new char[digits.length()];
        CreateCombination(digits, null, 0, finalString, finalList, charArray);
        return finalList;
    }
    public static void CreateCombination(String digits, String Combination, int pos, char[] finalString, List<String> strList, char[][] numberPad)
    {
        if(pos >= digits.length())
        {
            String newStr =  new String(finalString);
            strList.add(newStr);
            return;
        }
        if(digits.charAt(pos) == '1' ||  digits.charAt(pos) == '0')
        {
            CreateCombination(digits, Combination, pos + 1, finalString, strList, numberPad);
        }        
        else
        {
            int intToCons = Integer.parseInt(Character.toString(digits.charAt(pos)));
            for (int i = 0; i < numberPad[intToCons].length; i++)
            {
                finalString[pos] = numberPad[intToCons][i];
                CreateCombination(digits, Combination, pos + 1, finalString, strList, numberPad);                
            }
        }
    }
}
