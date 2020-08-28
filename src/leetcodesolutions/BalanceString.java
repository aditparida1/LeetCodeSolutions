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
public class BalanceString
{
    public int balancedString(String s) 
    {
        int[] count = new int[4];
        int len = s.length();
        int limit = len/4;
        for (int i = 0; i < len; i++)
        {
            if(s.charAt(i) == 'Q')
            {
                count[0]++;
            }
            else if(s.charAt(i) == 'W')
            {
                count[1]++;
            }
            else if(s.charAt(i) == 'E')
            {
                count[2]++;
            }
            else
            {
                count[3]++;
            }
        }
        int total = 0;
        
        for (int i = 0; i < count.length; i++)
        {
            if(count[i] > limit)
            {
                total += count[i] - limit;
                //temp += count[i] - limit;
                count[i] = count[i] - limit;
                if(count[i] < 0)
                {
                    count[i] = 0;
                }
            }
            else
            {
                count[i] = 0;
            }
        }
        if(total ==0)
            return 0;
        int[] temp = new int[4];
        for (int i = 0; i < temp.length; i++)
        {
            temp[i] = count[i];
        }
        int idx = 0;
        while(!IsZero(temp))
        {
            if(s.charAt(idx) == 'Q')
            {
                temp[0]--;
            }
            else if(s.charAt(idx) == 'W')
            {
                temp[1]--;
            }
            else if(s.charAt(idx) == 'E')
            {
                temp[2]--;
            }
            else
            {
                temp[3]--;
            }
            idx++;
        }
        idx = idx - 1;
        int size = idx + 1;
        for (int i = 1; i < s.length(); i++)
        {
            int[] temp1 = new int[4];
            for (int j = 0; j < temp1.length; j++)
            {
                temp1[j] = count[j];
            }
            idx = i;
            while(!IsZero(temp1) && idx < s.length() && idx - i <= size)
            {
                if(s.charAt(idx) == 'Q')
                {
                    temp1[0]--;
                }
                else if(s.charAt(idx) == 'W')
                {
                    temp1[1]--;
                }
                else if(s.charAt(idx) == 'E')
                {
                    temp1[2]--;
                }
                else
                {
                    temp1[3]--;
                }
                idx++;
            }
            if(IsZero(temp1) && size > idx - i)
            {
                size = idx - i;
            }
        }
//        int temp = total;
//        for (int i = 0; i < count.length; i++)
//        {
//            if(count[i] < limit)
//            {
//                int need = limit - count[i];
//                if(need <= temp)
//                {
//                    temp -= need;
//                }
//                else
//                {
//                    need -= temp;
//                    temp = 0;
//                    total += need;
//                }
//            }            
//        }
        return size;
    }
    public static boolean IsZero(int[] p)
    {
        for (int i = 0; i < p.length; i++)
        {
            if(p[i] > 0)
            {
                return false;
            }
        }
        return true;
    }
}
