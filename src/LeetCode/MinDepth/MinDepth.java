package LeetCode.MinDepth;

import java.util.Stack;

public class MinDepth {
	public static void main(String[] args){
		MinDepth minDepth = new MinDepth();
		int min = minDepth.minDepth(minDepth.constructTree());
		System.out.println(""+min);
	}
	
	public int minDepth(TreeNode root) {
		int depth = 0;
		int min = 0;
		boolean flag = false; // 用于设定min的初值
		
		java.util.Stack<TreeNode> s = new Stack<TreeNode>();
		while(root != null || !s.empty()){
			while(root != null){
				depth++;
				root.val = depth;
				s.push(root);
				root = root.left;
			}
			if (!s.empty()){
				root = s.pop();
				depth = root.val;
				if(root.left == null && root.right == null){ // 叶节点
					if(!flag){
						min = depth;
						flag = true;
					}	
					
					if (depth < min)
						min = depth;
				}
				root = root.right;
			}
		}
		
        return min;
    }
	
	private TreeNode constructTree(){
		TreeNode tn = new TreeNode(0);
		tn.left = new TreeNode(1);
		tn.right = new TreeNode(1);
		tn.left.left = new TreeNode(2);
		tn.right.left = new TreeNode(2);
		tn.right.left.right = new TreeNode(3);
		tn.right.right = new TreeNode(2);
		tn.right.right.left = new TreeNode(3);
		tn.right.right.right = new TreeNode(3);
		tn.left.left.left = new TreeNode(3);
		tn.left.left.right = new TreeNode(3);
		
		return tn;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}