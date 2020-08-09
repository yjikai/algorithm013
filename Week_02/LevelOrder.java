/**
 * N叉树的层序遍历
 * leetCode 429
 */
public class LevelOrder{

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null ){
            return result;
        }
        result = buidData(root,0,result);
        return result;
    }

    public List<List<Integer>> buidData(Node root,int level,List<List<Integer>> result){

        if(level+1>result.size()){
            result.add(new ArrayList<Integer>());
        }

        result.get(level).add(root.val);

        for(int i =0;i<root.children.size();i++){
            buidData(root.children.get(i),level+1,result);
        }
        return result;
    }

}