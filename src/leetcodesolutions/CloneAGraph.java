
package leetcodesolutions;
import java.util.*;
public class CloneAGraph
{
    public Noden cloneGraph(Noden node) 
    {
        Queue<Noden> q = new LinkedList<>();
        Map<Integer, Noden> ht = new HashMap<>();
        Noden finalN = null;
        if(node != null)
        {
            q.add(node);
            
        }
        while(!q.isEmpty())
        {
            Noden temp = q.poll();
            if(finalN == null)
            {
                finalN = new Noden(temp.val, new ArrayList<Noden>());
                ht.put(finalN.val, finalN);
                for(Noden p: temp.neighbors)
                {
                    q.add(p);
                    Noden nei = new Noden(p.val, new ArrayList<Noden>());
                    ht.put(nei.val, nei);
                    finalN.neighbors.add(nei);
                }
            }
            else
            {
                Noden temp2 = ht.get(temp.val);
                for(Noden p: temp.neighbors)
                {
                    if(ht.containsKey(p.val))
                    {
                        temp2.neighbors.add(ht.get(p.val));
                    }
                    else
                    {
                        Noden nei = new Noden(p.val, new ArrayList<Noden>());
                        ht.put(nei.val, nei);
                        q.add(p);
                        temp2.neighbors.add(nei);
                    }
                }
            }
        }
        return finalN;
    }
    
}

class Noden {
    public int val;
    public List<Noden> neighbors;

    public Noden() {}

    public Noden(int _val,List<Noden> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
