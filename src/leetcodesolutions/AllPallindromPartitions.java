package leetcodesolutions;
/**
 *
 * @author User
 */
import java.util.*;
 
public class AllPallindromPartitions
{
    public List<List<String>> partition(String s) 
    {
        List<List<String>> fls = new ArrayList<>();
        Stack<String> st = new Stack<>();
        getPartitions(fls, st, s, 0);
        return fls;
    }
    public void getPartitions(List<List<String>> fls, Stack<String> st, String s, int currIndex)
    {
        if(currIndex >= s.length())
        {            
            List<String> ls = new ArrayList<>();            
            for (int i = 0; i < st.size(); i++)
            {
                ls.add(st.get(i));
            }            
            fls.add(ls);
        }
        else
        {
            for (int i = currIndex; i < s.length(); i++)
            {
                String sub = s.substring(currIndex, i + 1);
                if(isPallindrom(sub))
                {
                    st.push(sub);
                    getPartitions(fls, st, s, i + 1);
                    st.pop();
                }
            }
        }
    }
    public boolean isPallindrom(String s)
    {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return s.equals(sb.toString());
    }
}
