package com.glearning.lab03;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

static boolean lettersOrNumbers = false;
	
	private  boolean BalancedOrNot(String brackets) {
		
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<brackets.length(); i++) {
			
			char s = brackets.charAt(i);
			
			if(s == '(' || s == '{' || s == '[' || s == ']' || s == '}' || s == ')') {
				
				lettersOrNumbers = false;
				
				if(s == '(' || s == '{' || s == '[') {
					stack.push(s);
					continue;
				}
				if (stack.empty()) {
					return false;
				}
				
				char poppedBracket;
				
				switch(s) {
				case ']':
					poppedBracket = stack.pop();
					if(poppedBracket == '}' || poppedBracket == ')') 
						return false;
					break;
					
				case '}':
					poppedBracket = stack.pop();
					if(poppedBracket == ']' || poppedBracket == ')')
						return false;	
					
					break;
					
				case')':
					poppedBracket = stack.pop();
					if(poppedBracket == ']' || poppedBracket == '}') 
						return false;
				
					break;
				}
				}else {
					lettersOrNumbers = true;
					continue;
				
				}
			
			}
		return (stack.isEmpty());
				
		}
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the series of brackets to check they are balanced or not:");
		String expression = input.next();
		BalancedBrackets obj = new BalancedBrackets();
		boolean status = obj.BalancedOrNot(expression);
		if (lettersOrNumbers) {
			System.out.println("please enter a valid string with brackets to evalute if balanced or not!");
		}
		if (status == true && lettersOrNumbers == false) {
			System.out.println("The enter string has balanced brackets");
		}
		else if (status == false && lettersOrNumbers == false) {
			System.out.println("The entered strings did not contain balanced brackets");
		}
		input.close();
		
	}
}
