package chapter4;

import java.util.ArrayList;
import java.util.LinkedList;

public class General {
	public static TreeNode addToTree(int arr[], int start, int end){
		if (end < start){
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(arr[mid]);
		n.left = addToTree(arr, start, mid-1);
		n.right = addToTree(arr, mid+1, end);
		return n;
	}
	
	public static TreeNode createMinimalBST(int array[]){
		return addToTree(array, 0, array.length - 1);
	}
	
	// 4.4 
	public ArrayList<LinkedList<TreeNode>> findLevelLinkList(TreeNode root){
		int level = 0;
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		list.add(root);
		result.add(level, list);
		
		while (true){
			list = new LinkedList<TreeNode>();
			for (int i = 0; i < result.get(level).size(); i++){
				TreeNode n = (TreeNode) result.get(level).get(i);
				if (n != null){
					if (n.left != null) list.add(n.left);
					if (n.right != null) list.add(n.right);
				}
			}
			if (list.size() > 0){
				result.add(level + 1, list);
			} else {
				break;
			}
			level ++;
		}
		return result;
	}
	
	// 4.5
	public static TreeNode inorderSucc(TreeNode e){
		if (e != null){
			TreeNode p;
			// Found right children -> return 1st inorder node on right
			if (e.parent == null || e.right != null){
				p = leftMostChild(e.right);
			} else {
				// Go up until we're on left instead of right(case 2b)
				while ((p = e.parent) != null){
					if (p.left == e)
						break;
					e = p;
				}
			}
			return p;
		}
		return null;
	}
	
	public static TreeNode leftMostChild(TreeNode e){
		if (e == null) return null;
		if (e.left != null)
		    leftMostChild(e.left);
		return e;
	}
	
	//4.6
	private static int TWO_NODES_FOUND = 2;
	private static int ONE_NODE_FOUND = 1;
	private static int NO_NODES_FOUND = 0;
	
	// Checks how many "special" nodes are located under this root
	public int covers(TreeNode root, TreeNode p, TreeNode q){
		int ret = NO_NODES_FOUND;
		if (root == null) return ret;
		if (root == p || root == q) ret += 1;
		ret += covers(root.left, p, q);
		if (ret == TWO_NODES_FOUND)
			return ret;
		return ret + covers(root.right, p, q);
	}
	
	public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if (q == p && (root.left == q || root.right == q)) return root;
		int nodesFromLeft = covers(root.left, p, q);
		if (nodesFromLeft == TWO_NODES_FOUND){
			if (root.left == p || root.left == q) return root.left;
			else return commonAncestor(root.left, p, q);
		} else if (nodesFromLeft == ONE_NODE_FOUND){
			if (root == p) return p;
			else if (root == q) return q;
		}
		
		int nodesFromRight = covers(root.right, p, q);
		if (nodesFromRight == TWO_NODES_FOUND){
			if (root.right == p || root.right == q) return root.right;
			else return commonAncestor(root.right, p, q);
		} else if (nodesFromRight == ONE_NODE_FOUND){
			if (root == p) return p;
			if (root == q) return q;
		}
		if (nodesFromRight == ONE_NODE_FOUND && nodesFromLeft == ONE_NODE_FOUND)
			return root;
		else return null;
	}
	
	//4.7, preorder travaersal and substring search
	// alternative --
	public boolean containsTree(TreeNode t1, TreeNode t2){
		if (t2 == null) return true;
		else return subtree(t1, t2);
	}
	
	public boolean subTree(TreeNode r1, TreeNode r2){
		if (r1 == null)
			return false;
		if (r1.data == r2.data){
			if (matchTree(r1, r2)) return true;
		}
		return (subTree(r1.left, r2)) || subTree(r1.right, r2));
	}
	
	public boolean matchTree(TreeNode r1, TreeNode r2){
		if (r2 == null && r1 == null){
			return true;
		if (r1 == null || r2 == null)
			return false;
		if (r1.data != r2.data)
			return false;
		return (matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right));
		}
	}
	
	//4.8
	public void findSum(TreeNode head, int sum, ArrayList<Integer> buffer, int level){
		if (head == null) return;
		int tmp = sum;
		buffer.add(head.data)
		for (int i = level; i > -1; i--){
			tmp -= buffer.get(i);
			if (tmp == 0) print(buffer, i, level);
		}
		ArrayList<Integer> c1 = (ArrayList<Integer>) buffer.clone();
		ArrayList<Integer> c2 = (ArrayList<Integer>) buffer.clone();
		findSum(head.left, sum, c1, level + 1);
		findSum(head.right, sum, c2, level + 1);
	}
}
