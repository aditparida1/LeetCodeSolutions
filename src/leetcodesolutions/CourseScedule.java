/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodesolutions;
import java.util.*;
/**
 *
 * @author User
 */

public class CourseScedule
{
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        if(prerequisites.length == 0)
        {
            return true;
        }
        List<List<Integer>> gList = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++)
        {
            gList.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++)
        {
            gList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < visited.length; i++)
        {
            if(visited[i] == 0)
            {
                boolean b = isPossible(visited, i, gList);
                if(!b)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isPossible(int[] visited, int node, List<List<Integer>> gList)
    {
        List<Integer> ls = gList.get(node);
        for(int child : ls)
        {
            if(visited[child] == 2)
            {
                continue;
            }
            if(visited[child] == 1)
            {
                return false;
            }
            visited[child] = 1;
            boolean isPoss = isPossible(visited, child, gList);
            if(!isPoss)
            {
                return false;
            }
            visited[child] = 2;
        }
        return true;
    }
}
