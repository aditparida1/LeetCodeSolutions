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
public class SearchRotatedSortedArray
{
    public int search(int[] nums, int target) 
    {
        int pivot = -1;
        for (int i = 0; i < nums.length - 1; i++)
        {
            if(nums[i] > nums[i + 1])
            {
                pivot = i + 1;
            }
        }
        if(pivot == -1)
        {
            if(target < nums[0] || target > nums[nums.length - 1])
            {
                return -1;
            }
            int found = SearchBinary(nums, target, 0, nums.length - 1);
            return found;
        }
        else
        {
            int found = -1;
            int pivotEnd = nums.length - 1;
            int fstEnd = pivot - 1;
            if(target >= nums[0])
            {
                found = SearchBinary(nums, target, 0, fstEnd);
            }
            else
            {
                found = SearchBinary(nums, target, pivot, pivotEnd);
            }
            return found;
        }
        
        //return -1;
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
