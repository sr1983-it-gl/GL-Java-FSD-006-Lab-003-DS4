package com.gl.javafsd.ds4.brackets;

import java.util.Set;
import java.util.Stack;

public class BalancedBracketsChecker {

	private String brackets;	
	
	public BalancedBracketsChecker(String brackets) {
		this.brackets = brackets;				
	}
	
	public boolean check() {
		
		// Quick check
		
		if (brackets.length() %2 != 0) {
			return false;
		}
		
		Stack<Character> stack = new Stack<Character>();
		
		Set<Character> openBracketsSet 
			= BracketsManager.getOpenBracketCharsSet();
		Set<Character> closeBracketsSet 
			= BracketsManager.getCloseBracketCharsSet();
		
		
		for (int index = 0; index < brackets.length(); index ++) {
			
			char aChar = brackets.charAt(index);
			
			// If aChar belongs to 'open brackets'
			if (openBracketsSet.contains(aChar)) {

				// ( [
				
				stack.push(aChar);
				
			}else if (closeBracketsSet.contains(aChar)) {
				
				// ] )
				
				Bracket bracketObj = BracketsManager.getBracket(aChar);
				
				Character openCharFromStack = stack.pop();
				
				if (openCharFromStack.equals(bracketObj.getOpenChar())) {
					
					// Match
					continue;
				}
			}else {
				
				System.out.println("Invalid character encountered "
						+ "during traversal.." + aChar);
			}			
		}
		
		return stack.isEmpty();
	}	
}
