package leetcodesolutions;
public class CreteTreeFromTraversal
{
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        return BuildIt(preorder, inorder, 0, inorder.length - 1, 0);
    }
    public TreeNode BuildIt(int[] preorder, int[] inorder, int l, int h, int pos)
    {
        int num = preorder[pos];
        TreeNode root = new TreeNode(num);
        int idx =  SearchIndex(inorder, num, l, h);
        int leftl = l;
        int lefth = idx - 1;
        int rightl = idx + 1;
        int righth = h;
        if(leftl <= lefth)
        {
            int lenl = lefth - leftl + 1;
            root.left = BuildIt(preorder, inorder, leftl, lefth, pos + 1);
            pos += lenl;
        }
        if(rightl <= righth)
        {
            root.right = BuildIt(preorder, inorder, rightl, righth, pos + 1);
            //pos += 1;
        }
        return root;
    }
    public int SearchIndex(int[] arr, int num, int l, int h)
    {
        for (int i = l; i < h + 1; i++)
        {
            if(arr[i] == num)
            {
                return i;
            }
        }
        return -1;
    }
}
