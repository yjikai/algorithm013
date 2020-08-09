/**
 * N叉树的后续遍历(只会递归实现)
 * leetcode 590
 */
public class Postorder{

    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> postorder(Node root) {
        if(root == null || root.children == null){
            return result;
        }
        for(int i = 0;i<root.children.size();i++){
            postorder(root.children.get(i));
        }
        result.add(root.val);

        return result;
    }
}