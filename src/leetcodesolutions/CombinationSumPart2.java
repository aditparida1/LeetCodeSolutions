
package leetcodesolutions;
import java.util.*;

public class CombinationSumPart2
{
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        List<List<Integer>> finalLs = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        Arrays.sort(candidates);
        if(candidates == null || candidates.length == 0)
        {
            return finalLs;
        }
        int boundary = -1;
        for (int i = 0; i < candidates.length; i++)
        {
            if(candidates[i] > target)
            {
                boundary = i;
                break;
            }
            else if(i == candidates.length - 1)
            {
                boundary = candidates.length;
            }
        }
        for (int i = 0; i < boundary; i++)
        {
            if(i != 0 && candidates[i] == candidates[i - 1])
            {
                continue;
            }
            AllCombinations(candidates, i, boundary, finalLs, ls, 0, target);
        }
        return finalLs;
    }
    public static void AllCombinations(int[] candidates, int start, int boundary, List<List<Integer>> finalLs, List<Integer> ls, int sum, int target)
    {
        if(sum == target)
            {
                ArrayList<Integer> newLs = new ArrayList<>();
                for(int j: ls)
                {
                    newLs.add(j);
                }
                if(finalLs.size() == 0)
                {
                    finalLs.add(newLs);
                    return;
                }
                List<Integer> temp = finalLs.get(finalLs.size() - 1);
                boolean flag = true;
                if(temp.size() == newLs.size())
                {
                    for (int i = 0; i < temp.size(); i++)
                    {
                        if(temp.get(i) != newLs.get(i))
                        {
                            flag = false;
                            break;
                        }
                    }
                if(!flag)
                finalLs.add(newLs);
                return;
                }
                //if(!flag)
                finalLs.add(newLs);
                return;
            }
        for (int i = start; i < boundary; i++)
        {
            if(candidates[i] + sum <= target)
            {
                ls.add(candidates[i]);
                AllCombinations(candidates, i + 1, boundary, finalLs, ls, sum + candidates[i], target);                
                int removed = ls.remove(ls.size() - 1);
                while(removed == candidates[i + 1])
                {
                    i++;
                }
                if(ls.isEmpty())
                {
                    return;
                }
            }
        }
    }
}
