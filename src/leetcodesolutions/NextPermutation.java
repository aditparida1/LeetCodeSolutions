
package leetcodesolutions;
import java.util.Arrays;

public class NextPermutation
{
    public void nextPermutation(int[] nums) 
    {
        boolean flag = false;
        for (int i = nums.length - 1; i >= 0; i--)
        {
            for (int j = nums.length - 1; j > i; j--)
            {
                if(nums[i] < nums[j])
                {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    flag = true;
                    Arrays.sort(nums, i+1, nums.length);
                    break;                    
                }
            }
            if(flag)
            {
                break;
            }
        }
        
        if(!flag)
        {
            Arrays.sort(nums);
        }
    }
}
