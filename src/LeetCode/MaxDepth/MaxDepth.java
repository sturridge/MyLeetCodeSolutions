package LeetCode.MaxDepth;

import java.util.Stack;

public class MaxDepth {
	
	public static void main(String[] args){
		MaxDepth maxDepth = new MaxDepth();
		int max = maxDepth.maxDepth(maxDepth.constructTree());
		System.out.println(""+max);
	}
	
	public int maxDepth(TreeNode root) {
		int depth = 0;
		int max = 0;
		java.util.Stack<TreeNode> s = new Stack<TreeNode>();
		while (root != null || !s.empty()){
			while (root != null){
				depth++;
				root.val = depth;
				if (depth > max)
					max = depth;
				s.push(root);
				root = root.left;
			}
			if (!s.empty()){
				root = s.pop();
				depth = root.val;
				root = root.right;
			}
		}
		
        return max;
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
