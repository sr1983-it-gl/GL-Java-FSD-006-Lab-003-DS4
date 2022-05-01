package com.gl.javafsd.ds4.generaltree.pairfinder;

import java.util.LinkedHashSet;
import java.util.Set;

public class GeneralTreePairFinder {

	private GeneralTreeNode<Integer> root;
	private boolean found =  false;
	
	public GeneralTreePairFinder(GeneralTreeNode<Integer> root) {
		
		this.root = root;
	}
	
	public void findPair(int sum) {
		
		Set<Integer> nodes = new LinkedHashSet<Integer>();
		
		findPairInternal(sum, root, nodes);
	
		if (!found) {
			System.out.println("For the sum [" + sum + "], Matching nodes NOT found");
		}
	}
	
	private void findPairInternal(int sum, GeneralTreeNode<Integer> aNode, 
		Set<Integer> nodes) {


		int difference = sum -  aNode.getData();
		
		if (nodes.contains(difference)) {
			
			found = true;
			System.out.println("For the sum [" + sum + "], Matching nodes -> [" + aNode.getData() + ", " + difference + "]");
		}else {

			nodes.add(aNode.getData());

			for (GeneralTreeNode<Integer> child : aNode.getChildren()) {
								
				findPairInternal(sum, child, nodes);
			}
		}		
	}

}
