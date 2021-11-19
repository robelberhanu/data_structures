import java.util.*;


public class Main {

    public static void main(String[] args){

        // Stack = LIFO data structure. Last-In First-Out
        //         stores objects into a sort of virtical tower
        // push() method adds an item to the top of the stack
        // pop() method removes an item from the top of the Stack

        Stack<String> stack = new Stack<String>();

        // System.out.println(stack.empty()); // Check if stack is empty. Returns false if not satisfied.
        stack.push("Robel"); // add item to the top of the stack.
        stack.push("John");
        stack.push("Abraham");
        stack.push("Joe");
        // System.out.println("The stack: " + stack);


        System.out.println("Is empty: " + stack.empty()); // Check if stack is empty. Returns false if not satisfied.

        // stack.pop(); // removes top most item from the stack.
        System.out.println("The stack: " + stack);

        String name = stack.pop(); // removes top most item for the stack and assigns it to the variable.
        System.out.println("Removed Top item: " + name);
        System.out.println("Unremoved Top Item: " + stack.peek()); // ckeck top most object without removing it.

        // Search an Item with in the stack. Pass object as arguements. Returns the position of the item. -1 returned if item not found.
        System.out.println("Object Position: " + stack.search("Robel"));

    }
    
}
