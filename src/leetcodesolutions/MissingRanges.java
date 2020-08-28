package leetcodesolutions;
import java.util.*;
public class MissingRanges
{
    public List<String> findMissingRanges(int[] nums, int lower, int upper) 
    {
       List<String> ls = new ArrayList<String>();
        if(nums == null || nums.length ==0)
        {
            StringBuilder sb = new StringBuilder();
            if(lower != upper)
            {
                sb.append(Integer.toString(lower));
                sb.append("->");
                sb.append(Integer.toString(upper));
            }
            else
            {
                sb.append(Integer.toString(lower));
            }
            if(!sb.toString().isEmpty())
            {
                ls.add(sb.toString());
            }
            return ls;
        }
        if(lower != nums[0])
        {
            StringBuilder sb = new StringBuilder();
            if(lower + 1 == nums[0])
            {
                sb.append(Integer.toString(lower));
            }
            else
            {
                sb.append(Integer.toString(lower));
                sb.append("->");
                sb.append(Integer.toString(nums[0] - 1));
            }
            if(!sb.toString().isEmpty())
            ls.add(sb.toString());
        }
        for (int i = 0; i < nums.length - 1; i++)
        {
            int l = nums[i];
            int h = nums[i + 1];
            StringBuilder sb = new StringBuilder();
            if(l + 1 <= h && l != h)
            {
                if(l + 1 == h)
                {
                    continue;
                }
                if(l + 1 == h - 1)
                {
                    sb.append(Integer.toString(l + 1));
                }
                else
                {
                    sb.append(Integer.toString(l + 1));
                    sb.append("->");
                    sb.append(Integer.toString(h - 1));
                }
            }
            if(!sb.toString().isEmpty())
            ls.add(sb.toString());
        }
        if(upper != nums[nums.length - 1])
        {
            StringBuilder sb = new StringBuilder();
            if(nums[nums.length - 1] + 1 == upper)
            {
                sb.append(Integer.toString(upper));
            }
            else
            {
                sb.append(Integer.toString(nums[nums.length - 1] + 1));
                sb.append("->");
                sb.append(Integer.toString(upper));
            }
            ls.add(sb.toString());
        }
        return ls;
    }
}
