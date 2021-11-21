import java.util.*;


public class Main {

    public static void main(String[] args){
        // stack();
        // queues();
        PQueue();
       
    }

    public static void stack(){

         /* Stack = LIFO data structure. Last-In First-Out
                stores objects into a sort of virtical tower
                push() method adds an item to the top of the stack
                pop() method removes an item from the top of the Stack

            Uses of Stacks?
            1. undo/redo features in text editors, browsers etc ..
            2. to move back/forward through browser history
            3. backtracking algorithms (maze, file directories)
            4. calling functions (call stack)
         
        */
        

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

    public static void queues(){

        /* Queue = FIFO data structure. First-In First-out
                   A collection designed for holding elements prior to processing linear data structure

                   add = enqueue, offer()
                   remove = dequeued, poll()
            Queues inherit properties of the Collections class.         
        */

        Queue<String> queue = new LinkedList<String>(); // we used a linked list because a Queue is an interface and not a class. Hence why we cannot intsantiate objects.
        
        // Add Items to the tail of the queue.  
        queue.offer("karen");
        queue.offer("Chad");
        queue.offer("Steve");
        queue.offer("Harold");
        
        System.out.println("The Queue: " + queue); //output queue
        System.out.println("Item at the head: " + queue.peek()); //look at or examine object at the head of the queue.


        // Remove Items from the head of the queues
        queue.poll();
        System.out.println("The Queue: " + queue); //output queue

       /* Where can we use Queues ?

        1. Keyboard buffer(letters should appear on the screen in the order they're pressed)
        2. printer Queue (Print jobs should be completed in order)
        3. Used in LinkedLists, PriorityQueues, Breath-first Search*/

    }

    public static void PQueue(){

        // Normal Queue
        Queue<Double> gpa = new LinkedList<Double>();

        gpa.offer(3.0);
        gpa.offer(2.5);
        gpa.offer(4.0);
        gpa.offer(1.5);
        gpa.offer(2.0);

    
        // A PriorityQueue
        Queue<Double> Pgpa = new PriorityQueue<Double>();
        Queue<Double> RPgpa = new PriorityQueue<Double>(Collections.reverseOrder());
        Queue<String> SPgpa = new PriorityQueue<String>();



        Pgpa.offer(3.0);
        Pgpa.offer(2.5);
        Pgpa.offer(4.0);
        Pgpa.offer(1.5);
        Pgpa.offer(2.0);

        RPgpa.offer(3.0);
        RPgpa.offer(2.5);
        RPgpa.offer(4.0);
        RPgpa.offer(1.5);
        RPgpa.offer(2.0);

        SPgpa.offer("A");
        SPgpa.offer("R");
        SPgpa.offer("C");
        SPgpa.offer("B");
        SPgpa.offer("L");

        while(!Pgpa.isEmpty()){
            // System.out.println(gpa.poll());
            System.out.println(Pgpa.poll());
            // System.out.println("Unreversed String PriorityQueue" + SPgpa.poll());

        }

    }
    
}
