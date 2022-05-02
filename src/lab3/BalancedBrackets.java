package lab3;
import java.util.*;
public class BalancedBrackets {
	 static boolean areBracketsBalanced(String expr)
	    {  	Deque<Character> stack= new ArrayDeque<Character>();
	    
	    for (int i = 0; i < expr.length(); i++)
        {
            char x = expr.charAt(i);
 
            if (x == '(' || x == '[' || x == '{')
            {
                stack.push(x);
                continue;
            }
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
            case ')':
                check = stack.pop();
                if (check == '{' || check == '[')
                    return false;
                break;
 
            case '}':
                check = stack.pop();
                if (check == '(' || check == '[')
                    return false;
                break;
 
            case ']':
                check = stack.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
            }
        }
 
        // Check Empty Stack
        return (stack.isEmpty());
    

        }

public static void main(String[] args ) {
	
	String expr = "( [ [ { } ] ] )";

    if (areBracketsBalanced(expr))
        System.out.println("The entered string is Balanced String");
    else
        System.out.println("The entered string is Not Balanced ");
}

}

