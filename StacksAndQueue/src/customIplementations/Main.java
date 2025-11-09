package customIplementations;

import java.util.*;

public class Main {
    static void main(String[] args) throws Exception {
///        Stack Offers insertion and deletion from the one end only and follows LIFO || FILO (Last in First Out || First in last out).
//        Stack<Integer> stack = new Stack<>();
//        stack.add(150);/// returns true.
//        stack.add(1,23); /// adds element to a given index.
//        stack.insertElementAt(23,2); /// similar as above insert element at a given index.
//        stack.push(21); /// Adds/Push element to the end
//        stack.addFirst(1); /// adds elements at start.
//        System.out.println(stack.peek()); /// Get the last element from the stack.
//        System.out.println(stack);
//        System.out.println(stack.pop()); /// Removes the last element from the stack.
//        System.out.println(stack.pop());

///         Queue Offers insertion from one end and deletion from other end, follows FIFO (First In First Out).
//        Queue<Integer> queue = new LinkedList<>(); /// In Java there is no Queue class and LinkedList implements queue that's why queue is used via Linked-list.
//        queue.offer(12);
//        queue.add(10);
//        queue.add(10);
//        queue.add(13);
//        queue.add(14);
//        System.out.println(queue.element()); /// get the head/start of the queue.
//        System.out.println(queue.poll());/// used to remove one item from the queue from the start.
//        System.out.println(queue);
//        queue.remove();
//        queue.add(10);
//        System.out.println(queue);
//        queue.removeIf(a-> a%2==0); /// removes all the elements from the queue which follows the condition.(all Even are removed.)
//        System.out.println(queue);


///        It Offers both insertion and deletion from both the ends.
//        Deque<Integer> deque = new ArrayDeque<>();
//        deque.add(12);
//        deque.add(13);
//        deque.add(14);
//        deque.add(15);
//        deque.add(16);
//        deque.add(17);/// Adds elements at the last index.
//        deque.addFirst(11); /// Adds elements at the first index.
//        deque.addFirst(10);
//        deque.addFirst(9);
//
//        System.out.println(deque);
//        System.out.println(deque.element()); /// retrieves the first element without removal.
//        System.out.println(deque.pollLast()); /// returns and remove  the last element.
//        System.out.println(deque.removeFirst()); /// returns and remove the first element.
//        System.out.println(deque);

        /*
        *       CUSTOM STACK IMPLEMENTATION USES
        * */

//        CustomStack a = new CustomStack();
//        for (int i = 1; i <= 10; i++) {
//            a.push(i*2);
//        }
//        System.out.println(a.getSize());
//        System.out.println(a.peek()); /// returns the last element and don't remove it.
//        System.out.println(a);
////        a.push(21); /// Stack Overflow as the default stack capacity is 10.
//        System.out.println(a.pop()); /// returns and removes the last element.
//        System.out.println(a+" "+a.getSize());


        /*
         *       CUSTOM QUEUE IMPLEMENTATION USES
         * */

//        CustomQueue q = new CustomQueue();
//        q.offer(2);/// add elements to the queue
//        q.add(4);
//        for (int i = 3; i < 11; i++) {
//            q.add(i*2);
//        }
//        System.out.println(q);
////        q.offer(22);/// Throws error of stack overflow as default capacity is 10.
//        System.out.println(q.peek()); /// Only returns and don't remove the Queue head(First Elem).
//        System.out.println(q);
//        System.out.println(q.poll()); /// returns and remove the Queue head(First Elem).
//        System.out.println(q);
//        q.offer(q.poll());
//        System.out.println(q);

        /*
        *       DYNAMIC STACK
        * */
//        DynamicCustomStack stack1= new DynamicCustomStack();
//        System.out.println(stack1.getCapacity()); /// 10 -> as initial capacity is 10
//        for (int i = 1; i < 22; i++) {
//            stack1.push(i);
//        }
//        System.out.println(stack1.getCapacity());
//        System.out.println(stack1);
//        System.out.println(stack1.pop());
//        System.out.println(stack1.pop());
//        System.out.println(stack1.pop());
//        System.out.println(stack1.pop());
//        System.out.println(stack1);

        /*
        *       DYNAMIC QUEUE
        * */
//        DynamicCustomQueue queue1 = new DynamicCustomQueue(5);
//        System.out.println(queue1.getCapacity());
//        queue1.offer(2);
//        queue1.offer(32);
//        for (int i = 1; i < 14; i++) {
//            queue1.add(i*i);
//        }
//        System.out.println(queue1);
//        System.out.println(queue1.size() +" "+queue1.getCapacity());


        /*
        *           CIRCULAR QUEUE
        * */

        CircularQueue queue2 = new CircularQueue(5);
        queue2.add(12);
        queue2.add(13);
        queue2.add(14);
        queue2.add(15);
        queue2.add(16);
        System.out.println(queue2);
//        queue2.add(17);

        System.out.println(queue2.remove());
        System.out.println(queue2.remove());
        System.out.println(queue2.remove());
        System.out.println(queue2);
        queue2.add(17);
        queue2.add(18);
        System.out.println(queue2);
        System.out.println(queue2.remove());
        System.out.println(queue2.remove());
        System.out.println(queue2);
        queue2.remove();
    }
}
