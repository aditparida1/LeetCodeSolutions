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
public class MinInRotatedArray
{
    public int Min(int[] arr, int low, int high)
    {
        if(arr.length == 0)
        {
            return -1;
        }
        if(arr.length == 1)
        {
            return arr[0];
        }
        if (arr.length == 2)
        {
            return arr[0] < arr[1] ? arr[0] : arr[1];
        }
        
        int left = arr[0];
        if(arr[0] < arr[arr.length - 1])
        {
            return arr[0];
        }
        while(low <= high)
        {
            if(low == high)
            {
                return arr[low];
            }
            int mid = low + high;
            mid /= 2;
            if(mid == 0)
            {
                if(arr[mid] < arr[mid + 1])
                {
                    return arr[mid];
                }
                else
                {
                    return arr[1];
                }
            }
            if(mid == arr.length - 1)
            {
                if(arr[mid] > arr[mid - 1])
                {
                    return arr[mid - 1];
                }
                else
                {
                    return arr[mid];
                }
            }
            if(arr[mid] < arr[mid - 1])
            {
                return arr[mid];
            }
            else
            {
                if(arr[mid] < left)
                {
                    high = mid - 1;
                }
                else
                {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
    
}

