package com.gl.javafsd.ds4.brackets;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class BracketsManager {

	private static Set<Bracket> predefinedBrackets;
	
	public BracketsManager() {
		// SOP (1)
	}
	
	static {
		
		// SOP (Called from static)
						
		// new HashSet<>();
		predefinedBrackets = new LinkedHashSet<Bracket>();
		
		// Round brackets / Function brackets
		predefinedBrackets.add(new Bracket('(', ')'));
		
		// Square Brackets / Array brackets
		predefinedBrackets.add(new Bracket('[', ']'));
		
		// Curly brackets / Braces
		predefinedBrackets.add(new Bracket('{', '}'));
		
		// Angle Brackets 
		predefinedBrackets.add(new Bracket('<', '>'));
		
//		// Angle Brackets 
//		predefinedBrackets.add(new Bracket('M', 'W'));
		
	}
	
	// ( [ { <
	public static Set<Character> getOpenBrackets(){		
		
		Set<Character> result = new LinkedHashSet<Character>();
		
		Iterator<Bracket> iterator = predefinedBrackets.iterator();
		
		while (iterator.hasNext()) {
			
			Bracket bracket = iterator.next();
			
			result.add(bracket.getOpenBracket());			
		}		
		return result;
	}

	// ) ] } > 
	public static Set<Character> getCloseBrackets(){
		
		Set<Character> result = new LinkedHashSet<Character>();
		
		Iterator<Bracket> iterator = predefinedBrackets.iterator();
		
		while (iterator.hasNext()) {
			
			Bracket bracket = iterator.next();
			
			result.add(bracket.getCloseBracket());			
		}		
		return result;
	}
	
	public static Bracket getBracket(Character closeBracket) {
				
		for (Bracket predefinedBracket : predefinedBrackets) {
			
			if (predefinedBracket.getCloseBracket().equals(
					closeBracket)) {
				return predefinedBracket;
			}
		}
		return null;
	}

}
