
package leetcodesolutions;
public class numDecodingsDP
{
    public int numDecodings(String s) 
    {
        if(s.length() == 0)
            return 0;
        if(s.length() == 1)
        {
            if(Integer.parseInt(s) <= 9 && Integer.parseInt(s) > 0)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        int[] num = new int[s.length()];
        if(Integer.parseInt(s.substring(s.length()-1,s.length())) > 0)
        {
            num[num.length - 1] = 1;
        }
        else
        {
            num[num.length - 1 ] = 0;
        }
        for (int i = s.length() - 2; i >= 0; i--)
        {
            String twoChars = s.substring(i,i+2);
            int number = Integer.parseInt(twoChars);
            if(Integer.parseInt(s.substring(i,i+1)) > 0)
            {
                num[i] = num[i + 1];
                if(number <= 26 && number > 0)
                {
                    if(i + 2 < num.length)
                    {
                        num[i] += num[i + 2];
                    }
                    else
                    {
                        num[i] += 1;
                    }
                }
            }
            else
            {
                num[i] = 0;
            }
        }
        return num[0];        
    }
}
