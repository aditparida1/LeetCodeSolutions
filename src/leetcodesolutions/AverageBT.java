
package leetcodesolutions;
public class AverageBT
{
    public int[] GetAverageTree(TreeNode tn)
    {
        if(tn == null)
        {
            return new int[]{0, 0};
        }
        else
        {
            int[] leftSum = GetAverageTree(tn.left);
            int[] rightSum = GetAverageTree(tn.right);
            int totalSum = leftSum[0] + rightSum[0] + tn.val;
            int numNodes = leftSum[1] + rightSum[1] + 1;
            tn.val = totalSum / numNodes;
            return new int[]{totalSum, numNodes};
        }
    }
}
