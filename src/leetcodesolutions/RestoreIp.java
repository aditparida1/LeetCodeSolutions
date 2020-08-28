package leetcodesolutions;
import java.util.*;
public class RestoreIp
{
    public List<String> restoreIpAddresses(String st) 
    {
        if(st.length() < 3)
        {
           return new ArrayList<String>();
        }
        List<String> fls = new ArrayList<>();
        Stack<String> s = new Stack<>();
        RestoreIP(st, 1, s, fls, 0);
        return fls;
    }
    public void RestoreIP(String st, int dotNum, Stack<String> s, List<String> fls, int idx)
    {
        if(st.length() <= 3)
        {
            return;
        }
        if(dotNum >= 4)
        {
            String sub = st.substring(idx , st.length());
            if(sub.length() < 1)
            {
                return;
            }
            if(sub.charAt(0) == '0' && sub.length() != 1)
            {
                return;
            }
            if(sub.charAt(0) != '0' && sub.length() >= 3)
            {
                return;
            }
            int num = Integer.parseInt(sub);
            if(num >= 0 && num <= 255)
            {
                s.push(sub);
            }
            else
            {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = s.size() - 1; i >= 0; i--)
            {
                sb.insert(0, "." + s.get(i));
            }
            sb.deleteCharAt(0);
            s.pop();
            fls.add(sb.toString());
        }
        else if(idx < st.length())
        {
            int start = idx;
            if(st.charAt(idx) == '0')
            {
                s.push(st.substring(idx,idx+1));
                RestoreIP(st, dotNum + 1, s, fls, idx + 1);
                s.pop();
            }
            else
            {
                for (int i = 1; i < 4 && idx + i < st.length(); i++)
                {
                    String sub = st.substring(idx, idx + i);
                    if(Integer.parseInt(sub) <= 255 && Integer.parseInt(sub) >= 0)
                    {
                        s.push(sub);
                        RestoreIP(st, dotNum + 1, s, fls, idx + i);
                        s.pop();
                    }
                }
            }
        }
    }
}
