package leetcodesolutions;
import java.util.*;


public class ContainsDuplicate3
{
    public int binarySearch(int[] nums, int k)
    {
        int l = 0;
        int h = nums.length - 1;
        while(l <= h)
        {
            int mid = l + h;
            mid /= 2;
            if(nums[mid] == k)
            {
                return mid;
            }
            else if (nums[mid] < k)
            {
                l = mid + 1;
            }
            else
            {
                h = mid - 1;
            }
        }
        return -1;
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) 
    {
        int[] tempArr = new int[k + 1];
        int[] diff = new int[k];
        for (int j = 0; j < tempArr.length; j++)
        {
            tempArr[j] = nums[j];
        }
        boolean isFirst = true;
        for (int i = tempArr.length - 1; i < nums.length; i++)
        {
            if(!isFirst)
            {
                int idx = binarySearch(tempArr, nums[i - k - 1]);
                tempArr[idx] = nums[i];
            }
            else
            {
                isFirst = false;
            }
            Arrays.sort(tempArr);
            for (int j = 0; j < tempArr.length - 1; j++)
            {
                diff[j] = Math.abs(tempArr[j] - tempArr[j + 1]);                
            }
            Arrays.sort(diff);
            if(diff[0] <= t)
            {
                return true;
            }
            
        }
        return false;
    }
}
