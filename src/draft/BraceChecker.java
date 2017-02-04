package draft;


import draft.util.Stack;
import draft.util.StackImpl;

/**
 * Created by Vahag on 10/1/2016.
 */
public class BraceChecker {
    private String message;
    private Stack<Character> stack;

    BraceChecker(){
        message = "No error";
        stack = new StackImpl<Character>();
    }

    public String getMessage(){
        return message;
    }

    void parse (String text){
        char ch = 0;
        int i = 0;
        Character lastElement = null;

        lab:
        for (; i < text.length(); i++) {
            ch = text.charAt(i);
            switch (ch){
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                    lastElement = stack.pop();
                    if(lastElement != null && lastElement != '(' || lastElement == null){
                        break lab;
                    }
                    break;
                case ']':
                    lastElement = stack.pop();
                    if(lastElement != null && lastElement != '[' || lastElement == null){
                        break lab;
                    }
                    break;
                case '}':
                    lastElement = stack.pop();
                    if(lastElement != null && lastElement != '{' || lastElement == null){
                        break lab;
                    }
                    break;
            }
        }

        if (i < text.length()){
            if(lastElement == 0) {
                message = ch + "is closed but not opened";
            }else{
                message = "opened" + lastElement + "but closed" + ch;
            }
        }else{
            char last = stack.pop();
            if(last != 0){
                message = ch + "is opened but not closed";
            }
        }
    }

}
