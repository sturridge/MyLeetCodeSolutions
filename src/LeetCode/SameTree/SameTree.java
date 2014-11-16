package LeetCode.SameTree;

import java.util.Stack;

public class SameTree {
	public static void main(String[] args){
		SameTree sameTree = new SameTree();
		boolean isSame = sameTree.isSameTree(sameTree.constructTree(), sameTree.constructTree1());
		System.out.println(""+isSame);
	}
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		java.util.Stack<TreeNode> s1 = new Stack<TreeNode>();
		java.util.Stack<TreeNode> s2 = new Stack<TreeNode>();
		if (p == null){
			if (q == null)
				return true;
			else
				return false;
		}
		else {
			while (p != null || !s1.empty()){
				while (p != null){
					if (q == null)
						return false;
					else{
						if (p.val != q.val)
							return false;
					}
					s1.push(p);
					s2.push(q);
					p = p.left;
					q = q.left;
					if (p == null & q != null)
						return false;
				}
				
				if (!s1.empty()){
					p = s1.pop();
					q = s2.pop();
					p = p.right;
					q = q.right;
					if (p == null & q != null)
						return false;
				}
			}
		}
        return true;
    }
	
	private TreeNode constructTree(){
		TreeNode tn = new TreeNode(0);
//		tn.left = new TreeNode(1);
		tn.right = new TreeNode(1);
//		tn.left.left = new TreeNode(2);
		tn.right.left = new TreeNode(2);
		tn.right.left.right = new TreeNode(3);
		tn.right.right = new TreeNode(2);
		tn.right.right.left = new TreeNode(3);
		tn.right.right.right = new TreeNode(3);
//		tn.left.left.left = new TreeNode(3);
//		tn.left.left.right = new TreeNode(3);
		
		return tn;
	}
	
	private TreeNode constructTree1(){
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

/**
 * 更好的方法，使用递归
 * 
bool btree<T>::equal(btreenode<T> *p,btreenode<T> *q)
{
    bool eq;
    if(p==NULL && q==NULL) eq=true;
    else
    {
        if(p==NULL || q==NULL) eq=false;
        else
        eq=(p->data==q->data)&&equal(p->lchild,q->lchild)&&equal(p->rchild,q->rchild);
    }
    return(eq);
}//是否相等
 *
 */