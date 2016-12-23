/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llist;

/**
 *
 * @author phoenix
 */
public class Expression{
    
    public static boolean isBlank(String value) {
        return (value == null || value.equals("") || value.equals("null") || value.trim().equals(""));
    }
    
    
    public static boolean isBlank(Character value) {
        return (value == ' ' || value == null);
    }
    
    public static boolean isOperand(String value) {
        boolean ret = false;
        if (!isBlank(value)) {
            ret = value.matches("^[0-9]+$");
        }
        return ret;
    }
    
    public static boolean isOperand(Character value) {
        if (!isBlank(value)) {
            return Character.isDigit(value) || Character.isAlphabetic(value);
            /*return (value >= 0 && value <= 9 ||
                    value >= 'a' && value <= 'z' ||
                    value >= 'A' && value <= 'Z');*/
        }
        return false;
    }
    
    public static boolean isOperator(Character op) {
        switch (op) {
            case '+' :
            case '-' :
            case '*' :
            case '/' :
            case '(' :
            case ')' :
                return true;
            default:
                return false;
        }
    }
    
    public static Integer precOperator(Character op) {
        switch(op) {
            case '+' :
            case '-' :
                return 1;
            case '*' :
            case '/' :
                return 2;
            case '(' :
            case ')' :
                return 3;
            default:
                return 0;
        }
    }
    
    public static String infixToPostfix(String exp) {
        Stack<Character> stack = new Stack<>();
        String tmp = "";
        System.out.println(exp);
        Character curr;
        for(int i = 0; i < exp.length(); i++) {
            curr = exp.charAt(i);
            if(isBlank(curr)) {
            }
            else if(isOperand(curr)) {
                tmp += curr;
            }
            else if(isOperator(curr)) {
                if(curr == '(') {
                    stack.push(curr);
                }
                else if(curr == ')') {
                    while(stack.peek() != '(') {
                        tmp += stack.pop();
                    }
                    stack.pop();
                }
                else {
                    while (!stack.isEmpty() && 
                                (!(stack.peek() == '(') && 
                                precOperator(curr) <= precOperator(stack.peek()))) {
                        tmp += stack.pop();
                    }
                    stack.push(curr);
                }
            }
        }
        
        while (!stack.isEmpty()) {
            tmp += stack.pop();
        }
        
        return tmp;
    }
    
    public static Float evalPostfix(String postfix) {
        Float res;
        Stack<Float> stack = new Stack<>();
        Character curr;
        for(int i = 0; i < postfix.length(); i++) {
            curr = postfix.charAt(i);
            if(!isBlank(curr)) {
                if(isOperand(curr)) {
                    stack.push((float)Integer.parseInt(curr.toString()));
                }
                else if(isOperator(curr)) {
                    Float val1 = stack.pop();
                    Float val2 = stack.pop();
                    switch(curr) {
                        case '+':
                            stack.push(val2 + val1);
                            break;
                        case '-':
                            stack.push(val2 - val1);
                            break;
                        case '*':
                            stack.push(val2 * val1);
                            break;
                        case '/':
                            stack.push(val2 / val1);
                            break;
                        default:
                            System.err.println("Err: Invalid Operator");
                    }
                }
            }
        }
        return stack.pop();
    }
}
