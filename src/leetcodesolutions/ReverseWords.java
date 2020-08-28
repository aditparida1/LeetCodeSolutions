
package leetcodesolutions;

public class ReverseWords
{
    public String reverseWords(String s) 
    {
        String[] splits = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = splits.length - 1; i >= 0; i--)
        {
            if(!splits[i].isBlank())
            {
                sb.append(" ");
                sb.append(splits[i]);
            }
            
        }
        return sb.toString().trim();
    }
}
