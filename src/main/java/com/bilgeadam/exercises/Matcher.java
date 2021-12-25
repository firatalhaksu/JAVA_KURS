package com.bilgeadam.exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * This class has utility methods for matching.
 */

public class Matcher {
    /**
     * verifies that given input has matching '(' ')'
     * @param input A string input
     * @return true if input has matching brackets, false otherwise
     */

    public boolean parenthesisMatcher (String input){

        int balance = 0;

        if (input == null)
            return true;

        for (char c : input.toCharArray()) {
            if (c == '(')
                balance++;
            else if (c == ')'){
                if (--balance < 0){
                    return false;
                }
            }
        }
        return balance == 0;
    }

    public boolean parenthesisMatcherStack (String input){

        Stack<Character> parenthesis = new Stack<>();

        if (input == null)
            return true;

        for (char c : input.toCharArray()) {
            if (c == '(')
                parenthesis.push(c);

            else if (c == ')'){
                if (parenthesis.isEmpty()){
                    return false;
                }
                else
                    parenthesis.pop();
            }
        }
        
        return parenthesis.isEmpty();
    }

    // () [] {} <>

    public boolean multiSymbolsMatcher (String input){

        Stack<Character> parenthesis = new Stack<>();
        HashMap<Character, Character > correspondances = new HashMap<>(){{
            put('(' , ')');
            put('[' , ']');
            put('{' , '}');
            put('<' , '>');
        }};

        if (input == null)
            return true;

        for (char c : input.toCharArray()) {
            if (correspondances.keySet().contains(c))
                parenthesis.push(c);
            else if (correspondances.containsValue(c))
                for (Map.Entry<Character, Character> e : correspondances.entrySet())
                    if (e.getValue() == c)
                        if (!parenthesis.isEmpty() && parenthesis.peek() == e.getKey())
                            parenthesis.pop();
                        else
                            return false;
        }

        return parenthesis.isEmpty();
    }
}