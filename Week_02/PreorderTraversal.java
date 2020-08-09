/**
 * leetcode 144. 二叉树的前序遍历
 */
public class PreorderTraversal{

    List<Integer> result = new ArrayList();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return result;
        }
        result.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return result;
    }


}