package leetcodesolutions;
public class MinSizeSubarraySum
{
    public int minSubArrayLen(int s, int[] nums) 
    {
        int fp = 0, sp = 0;
        int currSum = 0;
        int subLen = -1;
        for (; fp < nums.length; fp++)
        {
            currSum += nums[fp];
            if(currSum >= s)
            {
                int len = fp - sp + 1;
                if(subLen == -1)
                {
                    subLen = len;                            
                }
                else if(subLen > len)
                {
                    subLen = len;
                }
                for (; sp <= fp && currSum >= s; sp++)
                {
                    currSum -= nums[sp];
                }
                if(sp > fp)
                {
                    subLen = 1;
                    fp = sp;
                }
                else
                {
                    len = fp - sp + 2;
                    if(subLen == -1)
                    {
                        subLen = len;                            
                    }
                    else if(subLen > len)
                    {
                        subLen = len;
                    }
                }
            }
        }
        return subLen == -1 ? 0: subLen;
    }
}
