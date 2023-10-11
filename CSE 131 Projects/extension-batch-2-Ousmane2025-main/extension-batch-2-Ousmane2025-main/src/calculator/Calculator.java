package calculator;

import java.util.Arrays;

import support.cse131.ArgsProcessor;

public class Calculator {
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);

		String text = ap.nextString();
		String One = "";
		String Two = "";
		char Operation = 'i';
		int Answer = 0;
		
		for (int i = 0; i < text.length(); i++) {
			if(Character.isDigit(text.charAt(i))) {
				One += text.charAt(i);
				
			}
			
			if (!Character.isWhitespace(text.charAt(i)) && !Character.isDigit(text.charAt(i))) {
				Operation = text.charAt(i);
				i = text.length();
			}
			
		}

		
		int firstInteger = Integer.parseInt(One);
		
		for (int i = One.length() + 3; i < text.length(); i++) {
			if(Character.isDigit(text.charAt(i)) == true) {
				
				Two += text.charAt(i);
				
			}
			
			else {
				i = text.length();
			}
			
		}
		
		int secondInteger = Integer.parseInt(Two);
		if(Operation == '+') {
			Answer = firstInteger + secondInteger;
		}
		
		if(Operation == '-') {
			Answer = firstInteger - secondInteger;
		}
		
		if(Operation == '*') {
			Answer = firstInteger * secondInteger;
		}
		
		if(Operation == '/') {
			Answer = firstInteger / secondInteger;
		}
		
		System.out.println(text + " = " + Answer);
		
	}
	
}
