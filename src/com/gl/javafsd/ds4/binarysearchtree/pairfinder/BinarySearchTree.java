package com.gl.javafsd.ds4.binarysearchtree.pairfinder;

public class BinarySearchTree {

	private BinarySearchTreeNode root;
	
	public BinarySearchTree() {
		root = null;
	}

	public void insert(Integer value) {
		
		root = insert(root, value);
	}

	private BinarySearchTreeNode insert(
		BinarySearchTreeNode rootNode, Integer value){
		
		if (rootNode == null) {
			return newNode(value);					
		} else if (value <= rootNode.getData()) {
			
			BinarySearchTreeNode newNode 
				= insert(rootNode.getLeftNode(), value);
			
			rootNode.setLeftNode(newNode);
			return rootNode; 
		}else {
			
			BinarySearchTreeNode newNode 
				= insert(rootNode.getRightNode(), value);
			
			rootNode.setRightNode(newNode);
			return rootNode;
		}
	}

	private BinarySearchTreeNode newNode(Integer value) {
	
		BinarySearchTreeNode newNode 
			= new BinarySearchTreeNode(value);
		return newNode;
		
	}
	
	public void preOrderTraversal() {
		
		preOrderTraversal(this.root);
	}
	
	private void preOrderTraversal(BinarySearchTreeNode aNode) {
		
		if (aNode == null) {
			return;
		}
		
		System.out.println(aNode.getData());
		preOrderTraversal(aNode.getLeftNode());
		preOrderTraversal(aNode.getRightNode());
	}
	
	public BinarySearchTreeNode getRoot() {
		return root;
	}
}
