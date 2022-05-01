package com.gl.javafsd.ds4.brackets;

import java.util.Set;
import java.util.Stack;

public class BalancedBracketsChecker {

	private String brackets;	
	
	public BalancedBracketsChecker(String brackets) {
		this.brackets = brackets;			
	}
	
	public boolean check() {
		
		// Quick Sanity check		
		if (brackets.length() % 2 != 0) {
			return false;
		}
		
		Stack<Character> stack = new Stack<Character>();
		
		Set<Character> openBracketsSet 
			= BracketsManager.getOpenBrackets();
		Set<Character> closeBracketsSet 
			= BracketsManager.getCloseBrackets();
		
		
		for (int index = 0; index < brackets.length(); index ++) {
			
			char aChar = brackets.charAt(index);
			
			if (openBracketsSet.contains(aChar)) {

				stack.push(aChar);
				
			}else if (closeBracketsSet.contains(aChar)) {
								
				char closedChar = aChar;

				Character openCharFromStack = stack.pop();
				
				// ( ) / [ ] -> RELATED
				// ( } ->  NOT RELATED
				
				Bracket bracketObj 
					= BracketsManager.getBracket(closedChar);
				
				if (openCharFromStack.equals(
					bracketObj.getOpenBracket())) {
					
					// Match
					continue;
				}
			}else {
				
				System.out.println("Invalid character encountered "
						+ "during traversal.." + aChar);
				return false;
			}			
		}
		
		return stack.isEmpty();
	}	
}
