
package leetcodesolutions;
import java.util.*;


public class Calculators
{
    
    public int calculate(String s) 
    {
        String ip = s.trim();
        String pfx = PostFix(s);
        String[] splitExp = pfx.split(",");
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < splitExp.length; i++)
        {
            if(isAlphaNumeric(splitExp[i]))
            {
                st.push(Integer.parseInt(splitExp[i]));
            }
            else
            {
                int a = st.pop();
                int b = st.pop();
                st.push(ProcessOperator(splitExp[i], a, b));
            }
        }
        if(st.isEmpty())
        {
            return 0;
        }
        else
        {
            return st.pop();
        }
    }
    public int ProcessOperator(String op, int a, int b)
    {
        switch(op)
        {
            case"+":
                return a + b;
            case "-":
                return b - a;
            case "*":
                return a * b;
            case "/":
                return b / a;
        }
        return 0;
    }
    public String PostFix(String input)
    {
        Stack<String> st = new Stack();
        st.push("(");
        StringBuilder pfx = new StringBuilder();
        for (int i = 0; i < input.length(); i++)
        {
            String currChar = Character.toString(input.charAt(i));
            if(currChar.trim().isEmpty())
            {
                continue;
            }
            if(isAlphaNumeric(currChar))
            {
                pfx.append(currChar + ",");
            }
            else
            {
                ProcessChar(currChar, st, pfx);
            }
        }
        while(!st.isEmpty() && !st.peek().equals("("))
        {
            pfx.append(st.pop() + ",");
        }
        
        return pfx.toString();
    }
    public void ProcessChar(String currChar, Stack<String> st, StringBuilder sb)
    {
        if(currChar.equals("("))
        {
            st.push(currChar);
        }
        else if(currChar.equals(")"))
        {
            while(!st.isEmpty() && !st.peek().equals("("))
            {
                sb.append(st.pop() + ",");
            }
            st.pop();
        }
        else
        {
            while(!st.isEmpty() && Precedence(currChar) <= Precedence(st.peek()))
            {
                sb.append(st.pop() + ",");
            }
            st.push(currChar);
        }
    }
    
    int Precedence(String charip)
    {
        switch (charip)
        {
            case "+":
            case "-":
                return 1;
            case "*":
            case"/":
                return 2;
            case "^":
                return 3;
            default:
                return -1;
        }
    }
    public static boolean isAlphaNumeric(String s) 
    {
        return s != null && s.matches("^[a-zA-Z0-9]*$");
    }

}
