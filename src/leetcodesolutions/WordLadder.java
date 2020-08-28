package leetcodesolutions;
import java.util.*;
public class WordLadder
{
    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
        if(!wordList.contains(endWord))
        {
            return 0;
        }
        if(wordList.contains(beginWord))
        {
            wordList.remove(beginWord);
        }
        return ladderCorrect(endWord, wordList, beginWord, 1) + 1;
        //return 0;    
    }
    public int ladder(String end, List<String> wordList, String currWrd, int len)
    {
        if(currWrd.equals(end))
        {
            return len;
        }
        if(wordList.size() == 0)
        {
            return 0;
        }
        Stack<String> st = new Stack<>();
        for(String s : wordList)
        {
            if(distanceOne(s, currWrd))
            {
                st.push(s);
                if(s.equals(end))
                {
                    return len + 1;
                }
                //wordList.remove(s);
            }
        }
        
        if(st.size() == 0)
        {
            return 0;
        }
        for (int i = st.size() - 1; i >= 0; i--)
        {
            wordList.remove(st.get(i));
        }
        int min = -1;
        while(st.size()!=0)
        {
            String temp = st.pop();
            //wordList.remove(temp);
            int a = ladder(end, wordList, temp, len + 1);
            //wordList.add(temp);
            if(min == -1)
            {
                min = a;
            }
            else if(min == 0 && a != 0)
            {
                min = a;
            }
            else if(min > a && a != 0)
            {
                min = a;
            }
            
        }
        return min;
    }
    public boolean distanceOne(String a, String b)
    {
        int count = 0;
        int aSi =a.length();
        int bSi = b.length();
        count += Math.abs(aSi - bSi);
        int small = aSi < bSi ? aSi : bSi;
        for (int i = 0; i < small; i++)
        {
            if(a.charAt(i) != b.charAt(i))
            {
                count++;
            }
            if(count > 1)
            {
                return false;
            }
        }
        return true;
    }
    public int ladderCorrect(String end, List<String> wordList, String currWrd, int len)
    {
        Queue<String> Q = new LinkedList<>();
        Q.add(currWrd);
        Stack<String> st  = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int level = 0;
        while(!Q.isEmpty())
        {
            currWrd = Q.poll();
            for (int i = 0; i < wordList.size(); i++)
            {
                if(distanceOne(currWrd, wordList.get(i)))
                {
                    st.push(wordList.get(i));
                    Q.add(wordList.get(i));
                    if(wordList.get(i).equals(end))
                    {
                        return level + 1;
                    }
                }
            }
            if(map.containsKey(level + 1))
            {
                map.replace(level + 1, map.get(level + 1) + st.size());
            }
            else
            {
                map.put(level + 1, st.size());
            }
            while(!st.empty())
            {
                wordList.remove(st.pop());
            }
            map.replace(level, map.get(level) - 1);
            if(map.get(level) <= 0)
            {
                level += 1;
            }
        }
        return 0;
    }
}
/*

"teach"
"place"
["peale","wilts","place","fetch","purer","pooch","peace","poach","berra","teach","rheum","peach"]

*/