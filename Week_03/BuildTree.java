/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 */
public class BuildTree{

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder == null || inorder == null || preorder.length == 0|| inorder.length == 0 ||  preorder.length != inorder.length){
            return null;
        }

        TreeNode root = buffBuildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        return root;
    }

    public TreeNode buffBuildTree(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd){

        //递归的第一步：递归终止条件，避免死循环
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inorderRootIndex = 0;
        while(preorder[preStart] != inorder[inStart+inorderRootIndex]){
            inorderRootIndex++;
        }

        root.left = buffBuildTree(preorder,preStart+1,preStart+inorderRootIndex,inorder,inStart,inStart+inorderRootIndex-1);
        root.right = buffBuildTree(preorder,preStart+inorderRootIndex+1,preEnd,inorder,inStart+inorderRootIndex+1,inEnd);

        return root;
    }

}