
package leetcodesolutions;
import java.util.*;

public class PermutationClass
{
    public void Permute(int[] ip, int pos, List<List<Integer>> fls)
    {
        if(pos >= ip.length - 1)
        {
            ArrayList<Integer> ls = new ArrayList<>();
            for (int i = 0; i < ip.length; i++)
            {                
                ls.add(ip[i]);
            }
            fls.add(ls);
            return;
        }
        for (int i = pos; i < ip.length; i++)
        {
            Swap(ip, i, pos);
            Permute(ip, pos + 1, fls);
            Swap(ip, i, pos);
        }
    }
    public static void Swap(int ip[], int i, int pos)
    {
        int temp = ip[i];
        ip[i] = ip[pos];
        ip[pos] = temp;
    }    
    public List<List<Integer>> permute(int[] nums) 
    {
        Arrays.sort(nums);
        nums = new int[]{-1,0,0,1,1,-1};
        List<List<Integer>> fls = new ArrayList<>();
        Permute2(nums,0,fls);
        return fls;
    }
    public void Permute2(int[] ip, int pos, List<List<Integer>> fls)
    {
        
        if(pos >= ip.length - 1)
        {
            ArrayList<Integer> ls = new ArrayList<>();
            for (int i = 0; i < ip.length; i++)
            {                
                ls.add(ip[i]);
            }
            fls.add(ls);
            return;
        }
        
        for (int i = pos; i < ip.length; i++)
        {
            boolean flag = false;
            if(i - 1 >= 0 && ip[i] != ip[pos] && ip[i] != ip[i - 1])
            {
                Swap(ip, i, pos);
                flag = true;
            }
            if(flag || i == pos)
            Permute2(ip, pos + 1, fls);
            if(flag)
            Swap(ip, i, pos);
        }
    }
}
