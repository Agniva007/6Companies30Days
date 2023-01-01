package com.agniva;

import java.util.Stack;

public class reversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                Integer first = stack.pop();
                Integer second = stack.pop();
                stack.push(first + second);
            } else if (token.equals("-")) {
                Integer first = stack.pop();
                Integer second = stack.pop();
                stack.push(second - first);
            } else if (token.equals("*")) {
                Integer first = stack.pop();
                Integer second = stack.pop();
                stack.push(first * second);
            } else if (token.equals("/")) {
                Integer first = stack.pop();
                Integer second = stack.pop();
                stack.push(second / first);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
