package leetcodesolutions;
public class UniqueBST
{
    public int numTrees(int n) 
    {
        if(n == 0)
        {
            return 0;
        }
        if(n == 1)
        {
            return 1;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        res[2] = 2;
        
        for (int i = 3; i <= n; i++)
        {
            int sum = 0;
            int newnum = i - 1;
            if(newnum % 2 == 0)
            {
                int split = newnum / 2;
                sum += res[split] * res[split];
                
            }
            int idx1 = 0;
            int idx2 = newnum;
            while(idx1 < idx2)
            {
                sum += (2 * res[idx1] * res[idx2]);
                idx2--;
                idx1++;
            }
            res[i] = sum;
        }
        return res[n];
    }
        
}
