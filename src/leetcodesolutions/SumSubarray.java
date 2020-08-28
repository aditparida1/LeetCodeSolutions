
package leetcodesolutions;
import java.util.*;


public class SumSubarray
{
    public int minSubArrayLen(int sum, int[] nums) 
    {
        Hashtable<Integer, Integer> hm = new Hashtable<Integer,Integer>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int currSum = 0;
        for (int i = 0; i < nums.length; i++)
        {
            currSum+= nums[i];
            if(hm.containsKey(currSum - sum))
            {
                int beg = hm.get(currSum - sum);
                int len = i - beg;
                pq.add(len);
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
        return pq.poll();
    }
}
