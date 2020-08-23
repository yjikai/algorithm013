## 学习笔记
这周比较忙，学习有点落下了。争取下周能补回来，还是要继续坚持。
广度优先遍历和深度优先遍历。明白怎么回事了，但是代码模板还不是很熟练，还是需要多练。
在这记录一下三个模板：
### BFS
```
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> allResults = new ArrayList<>();
    if (root == null) {
        return allResults;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
        int size = nodes.size();
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode node = nodes.poll();
            results.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        allResults.add(results);
    }
    return allResults;
}
```
### DFS
```
public List<List<Integer>> dfsOrder(TreeNode root){
    List<List<Integer>> allResult = new ArrayaList<List<Integer>>();
    if(root == null){
        return allResult;
    }
    travel(root,0,allResult);
    return allResult;
}
private void travel(TreeNode root,int level,List<List<Integer>> results){
    if(results.size() == level){
        results.add(new ArrayList<Integer>());
    }
    results.get(level).add(root.val);
    if(root.left != null){
        travel(root.left,level+1,results);
    }
    if(root.right != null){
        travel(root.right,level+1,results);
    }
}
```
### 二分查找代码模板
```
public List<List<Integer>> dfsOrder(TreeNode root){
    List<List<Integer>> allResult = new ArrayaList<List<Integer>>();
    if(root == null){
        return allResult;
    }
    travel(root,0,allResult);
    return allResult;
}
private void travel(TreeNode root,int level,List<List<Integer>> results){
    if(results.size() == level){
        results.add(new ArrayList<Integer>());
    }
    results.get(level).add(root.val);
    if(root.left != null){
        travel(root.left,level+1,results);
    }
    if(root.right != null){
        travel(root.right,level+1,results);
    }
}
```

我一定要把这三个模板代码记录下来，前段时间在面试过程中就遇到了一个DFS的算法题。
所以在做面试总结的时候，这几个模板代码也是在必须掌握范围内。