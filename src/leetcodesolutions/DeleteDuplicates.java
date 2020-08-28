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
public class DeleteDuplicates
{
    public int removeDuplicates(int[] nums) 
    {
        if(nums.length <= 2)
        {
            return nums.length;
        }
        int count = 0;
        int currPoin = 0;
        int plceHol = 0;
        int currNum = nums[0];
        for (; currPoin < nums.length; currPoin++)
        {
            if(nums[currPoin] == currNum)
            {
                if(count < 2)
                {
                    int temp = nums[currPoin];
                    nums[currPoin] = nums[plceHol];
                    nums[plceHol] = temp;
                    count++;
                    plceHol++;
                }
            }
            else
            {
                currNum = nums[currPoin];
                int temp = nums[currPoin];
                nums[currPoin] = nums[plceHol];
                nums[plceHol] = temp;
                //count++;
                plceHol++;
                count = 1;
            }
        }
        return plceHol;
    }
}
