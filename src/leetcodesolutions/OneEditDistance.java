package leetcodesolutions;
public class OneEditDistance
{
    //some wrong
    public boolean isOneEditDistance(String s, String t) 
    {
        int sLen = s.length();
        int tLen = t.length();
        int diff = Math.abs(sLen - tLen);
        if(diff >= 2)
        {
            return false;
        }
        if(sLen ==0 || tLen == 0)
        {
            return true;
        }
        boolean isLarger = sLen > tLen;
        String finalString = ChangedString(s, t, isLarger);
        return finalString.equals(t);
        
    }
    public String ChangedString(String s, String t, boolean isLarger)
    {
        int len = (isLarger?t.length() : s.length());
        int pos = -1;
        for (int i = 0; i < len; i++)
        {
            if(s.charAt(i) != t.charAt(i))
            {
                pos = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        
        if(s.length() < t.length())
        {
            if(pos != -1)
            {
                String fh = s.substring(0,pos);
                String sh = s.substring(pos, s.length());
                sb.append(fh);
                sb.append(t.charAt(pos));
                sb.append(sh);
            }
            else
            {
                sb.append(s);
                sb.append(t.charAt(t.length() - 1));
            }
            
        }
        else if(s.length() > t.length())
        {
            if(pos != -1)
            {
                String fh = s.substring(0,pos);
                String sh = s.substring(pos+1, s.length());
                sb.append(t.charAt(pos));
                sb.append(sh);
            }
            else
            {
                sb.append(s.substring(0, s.length() - 1));                
            }
        }
        else
        {
            String fh = s.substring(0,pos);
            String sh = s.substring(pos+1, s.length());
            sb.append(fh);
            sb.append(t.charAt(pos));
            sb.append(sh);
        }
        return sb.toString();
    }
    
    
}
