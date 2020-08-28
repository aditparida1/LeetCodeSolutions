/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodesolutions;

public class SearchPositionRangeInSortedArray
{
    
    public int[] searchRange(int[] nums, int target) 
    {
        int last = -1;
        int first = -1;
        if(nums == null || nums.length == 0)
            return new int[]{-1,-1};
        
        int initialPos = SearchBinary(nums, target, 0, nums.length - 1);
        if(initialPos == -1)
        {
            return new int[]{-1, -1};
        }
        int newStart = initialPos; 
        // get the right boundary
        while(true)
        {
            newStart = newStart + 1;
            if(IsValid(nums, newStart))
            {
                int temp = newStart;
                newStart = SearchBinary(nums, target, newStart, nums.length - 1);
                if(newStart == -1)
                {
                    newStart = temp;
                    break;
                }
            }
            else
            {
                break;
            }
            //break;
        }
        newStart--;
        last = newStart;
        newStart = initialPos;
        while(true)
        {
            newStart = newStart - 1;
            if(IsValid(nums, newStart))
            {
                int temp = newStart;
                newStart = SearchBinary(nums, target, 0, newStart);
                if(newStart == -1)
                {
                    newStart = temp;
                    break;
                }
            }
            else
            {
                break;
            }
            //break;
        }
        newStart++;
        first = newStart;
        
        return new int[]{first, last};
    }
    public static boolean IsValid(int[] nums, int position)
    {
        if(position < 0 || position >= nums.length)
        {
            return false;
        }
        return true;
    }
    public static int SearchBinary(int[] nums, int target, int start, int end)
    {
        while(start <= end)
        {
            int mid = start + end;
            mid /= 2;
            if(nums[mid] == target)
            {
                return mid;
            }
            else if(target > nums[mid])
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        return -1;
    }
}
