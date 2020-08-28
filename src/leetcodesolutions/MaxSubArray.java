
package leetcodesolutions;

public class MaxSubArray
{
    public int maxSubArray(int[] nums)
    {
        int sum = 0;
        int max = -1;
        for (int i = 0; i < nums.length; i++)
        {
            if(i == 0)
            {
                max = nums[i];                
            }
            sum += nums[i];
            if(sum >= max )
            {
                max = sum;
            }
            if(sum < 0)
            {
                sum = 0;
            }
        }
        return max;
    }
}
