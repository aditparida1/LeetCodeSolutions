
package leetcodesolutions;
import java.util.*;

public class SummaryRange
{
    public List<String> summaryRanges(int[] nums) 
    {
        List<String> ls = new ArrayList<>();
        Range currRange = new Range();
        for (int i = 0; i < nums.length; i++)
        {
            if(!currRange.initialized)
            {
                currRange.low = nums[i];
                currRange.high = nums[i];
                currRange.SwitchInitialized();
            }
            else
            {
                if(nums[i] - currRange.high == 1)
                {
                    currRange.high = nums[i];
                    
                }
                else if(nums[i] - currRange.high >= 1)
                {
                    StringBuilder sb = new StringBuilder();
                    if(currRange.low != currRange.high)
                    {
                        sb.append(Integer.toString(currRange.low));
                        sb.append("->");
                        sb.append(Integer.toString(currRange.high));
                    }
                    else
                    {
                        sb.append(Integer.toString(currRange.low));
                    }
                    ls.add(sb.toString());
                    currRange.low = nums[i];
                    currRange.high = nums[i];
                }
            }
        }
        if(currRange.initialized)
        {
            StringBuilder sb = new StringBuilder();
            if(currRange.low != currRange.high)
            {
                sb.append(Integer.toString(currRange.low));
                sb.append("->");
                sb.append(Integer.toString(currRange.high));
            }
            else
            {
                sb.append(Integer.toString(currRange.low));
            }
            ls.add(sb.toString());
        }
        
        return ls;
    }
}
class Range
{
    public boolean initialized;
    public int low;
    public int high;
    public Range()
    {
        this.initialized = false;
    }
    public void SwitchInitialized()
    {
        initialized = !initialized;
    }
}