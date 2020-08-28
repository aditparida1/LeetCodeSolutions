
package leetcodesolutions;

public class Sieve
{
    public int countPrimes(int n) 
    {
        if(n <= 2)
        {
            return 0;
        }
        int count = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = i;
        }
        for (int i = 2; i < n; i++)
        {
            if(arr[i] != -1)
            {
                
                count++;
                int div = (n-1) / arr[i];
                //div++;
                for (int j = 2; j <= div; j++)
                {
                    if(arr[i] * j < arr.length)
                    {
                        arr[arr[i] * j] = -1;
                    }
                }
            }
        }
        return count;
    }
}
