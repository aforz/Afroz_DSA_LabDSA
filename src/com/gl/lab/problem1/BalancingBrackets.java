package com.gl.lab.problem1;

import java.util.Stack;

public class BalancingBrackets {

    public static void main(String[] args) {
//        String input = "([[{}]])";
        String input = "([[{}]]))";
//        String input = "([[{}]])()";
        if (isInputBracketsBalanced(input))
            System.out.println("The entered String has Balanced Brackets");
        else
            System.out.println("The entered Strings do not contain Balanced Brackets");
    }

    private static boolean isInputBracketsBalanced(String input) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                continue;
            }
            if (!stack.isEmpty()) {
                char bracket;
                switch (ch) {
                    case ')':
                        bracket = stack.pop();
                        if (bracket == '{' || bracket == '[')
                            return false;
                        break;
                    case '}':
                        bracket = stack.pop();
                        if (bracket == '(' || bracket == '[')
                            return false;
                        break;
                    case ']':
                        bracket = stack.pop();
                        if (bracket == '(' || bracket == '{')
                            return false;
                        break;
                }
            } else
                return false;
        }
        return stack.isEmpty();
    }
}

