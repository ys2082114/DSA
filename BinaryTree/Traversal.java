import java.util.*;
class TreeNode{
	int data;
	TreeNode left, right;
	public TreeNode(int value){
		data = value;
		left = right = null;
	}
}
public class Traversal{
	
	//(1) inorder traversal
	public static void inorder(TreeNode root){
		if(root == null) return ;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	//(2) preorder traversal
	public static void preorder(TreeNode root){
		if(root == null) return ;
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}
	
	//(3) postorder traversal
	public static void postorder(TreeNode root){
		if(root == null) return ;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " ");
	}
	
	//(4) printing nodes at a particular level of a binary tree
	public static void printLevel(TreeNode root, int k){
		if(root == null) return ;
		if(k == 1) System.out.print(root.data + " ");
		else{
			printLevel(root.left, k - 1);
			printLevel(root.right, k - 1);
		}
	}
	
	//(5) for printing the maximum height/ maximum depth of a tree
	public static int height(TreeNode root){
		if(root == null) return 0;
		int left = height(root.left);
		int right = height(root.right);
		return Math.max(left, right) + 1;
	}
	
	//(6) for returning total number of nodes in a tree
	public static int NumberOfNodes(TreeNode root){
		if(root == null) return 0;
		return 1 + NumberOfNodes(root.left) + NumberOfNodes(root.right);
	}
	
	//(7) to check if a node exists in a tree
	public static boolean exists(TreeNode root, int val){
		if(root == null) return false;
		if(root.data == val) return true;
		boolean lefta = exists(root.left, val), righta = exists(root.right, val);
		return (lefta || righta);
	}
	
	//(8) finding maximum node in a tree
	public static int findMax(TreeNode root){
		if(root == null) return Integer.MIN_VALUE;
		int leftMax = findMax(root.left);
		int rightMax = findMax(root.right);
		return Math.max(root.data, Math.max(leftMax, rightMax));
	}
	
	//(9) to return number of leaves in a tree
	public static int countLeaves(TreeNode root){
		if(root == null) return 0;
		if(root.left == null && root.right == null) return 1;
		int lefta = countLeaves(root.left);
		int righta = countLeaves(root.right);
		return lefta + righta;
	}
	
	//(10) to return number of non-leaves in a tree
	public static int countNonLeaves(TreeNode root){
		if(root == null) return 0;
		if(root.left == null && root.right == null) return 0;
		int lefta = countNonLeaves(root.left);
		int righta = countNonLeaves(root.right);
		return lefta + righta + 1;
	}
	
	//(11) to return the sum of all node values in a tree
	public static int sum(TreeNode root){
		if(root == null) return 0;
		int leftans = sum(root.left);
		int rightans = sum(root.right);
		return root.data + leftans + rightans;
	}
	
	//(12) Insert a new node in the first available position(level-order insertion)
	static void insertLevelOrder(TreeNode root, int value) {
        if (root == null){
            root = new TreeNode(value);
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if (current.left == null){
                current.left = new TreeNode(value);
                return;
            } 
			else{
                queue.add(current.left);
            }
            if(current.right == null){
                current.right = new TreeNode(value);
                return;
            } 
			else{
                queue.add(current.right);
            }
        }
    }
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(30);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		// root.right.left = new TreeNode(6);
		// root.right.right = new TreeNode(7);
		
		System.out.print("Inorder traversal: ");
		inorder(root);
		
		System.out.println("\nMaximum height of tree: " + height(root));
		
		System.out.println("Number of nodes: " + NumberOfNodes(root));
		
		System.out.println("Is 3 in tree? " + exists(root, 3));
		System.out.println("Is 19 in tree? " + exists(root, 19));
		
		System.out.print("Elements at level 3: " + " ");
		printLevel(root, 3); // won't print anything for 0 <= level || level > 3
		// only works for 1, 2, 3 levels
		System.out.println();
		
		System.out.println("Maximum node in the tree: " + findMax(root));
		
		System.out.println("Number of leaves in the tree: " + countLeaves(root));
		
		System.out.println("Number of non-leaves in the tree: " + countNonLeaves(root));
		
		System.out.println("Sum of all nodes in a tree: " + sum(root));
		
		System.out.print("Postorder traversal: ");
		postorder(root);
		System.out.println();
		
		insertLevelOrder(root, 300);
		System.out.print("Postorder traversal after insert level order: ");
		postorder(root);
	}
}