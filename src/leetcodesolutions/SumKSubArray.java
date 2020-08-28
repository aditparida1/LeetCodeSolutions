package leetcodesolutions;

import java.util.HashMap;
import java.util.Hashtable;

public class SumKSubArray
{
    public int[] Search(int[] arr, int sum)
    {
        Hashtable<Integer,Integer> hm = new Hashtable<Integer, Integer>();
        int currSum = 0;
        for (int i = 0; i < arr.length; i++)
        {
            currSum += arr[i];
            if(hm.containsKey(currSum - sum))
            {
                int beg = hm.get(currSum - sum);
                int[] finArr = new int[i - beg];
                for (int j = beg + 1; j <= i; j++)
                {
                    finArr[j - beg - 1] = arr[j];
                }
                return finArr;
            }
            if(hm.containsKey(currSum))
            {
                hm.replace(currSum, i);
            }
            else
            {
                hm.put(currSum, i);
            }
            
        }
        return null;
    }
}
