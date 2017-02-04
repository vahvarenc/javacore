package bracechecker;

import bracechecker.util.Stack;
import bracechecker.util.StackImpl;

public class BraceChecker {
    private String message;
    private Stack<Character> stack;


    public BraceChecker() {
        stack = new StackImpl<Character>();
        message = "No Error";
    }

    public String getMessage(){
        return message;
    }

    public void parse(String text) {
        stack.reset();
        int i = 0;
        Character ch = 0;
        Character lastElement = 0;

        lab:
        for (; i < text.length(); i++) {
            ch = text.charAt(i);
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                    lastElement = stack.pop();
                    if (lastElement != null && lastElement != '(' || lastElement == null) {
                        break lab;
                    }
                    break;

                case '}':
                    lastElement = stack.pop();
                    if (lastElement != null && lastElement != '{' || lastElement == null) {
                        break lab;
                    }
                    break;

                case ']':
                    lastElement = stack.pop();
                    if (lastElement != null && lastElement != '[' || lastElement == null) {
                        break lab;
                    }
                    break;

            }
        }

        if (i < text.length()){
            if(lastElement == null){
                message = ch + " is closed but not opened";
            }else{
                message = "opened " + lastElement + " but closed " + ch;
            }
        } else {
            Character last = stack.pop();
            if (last != null) {
                message = last + " is opened but not closed";
            }
        }
    }
}