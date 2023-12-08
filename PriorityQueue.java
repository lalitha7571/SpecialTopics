import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(10);

        pq.add(3);
        pq.add(1);
        pq.add(2);
        pq.add(5);
        pq.add(4);

        System.out.println("Priority queue: " + pq);

        System.out.println("Peek: " + pq.peek());

        pq.poll();

        System.out.println("Priority queue after removing top element: " + pq);

        System.out.println("Does the queue contain 3? " + pq.contains(3));

        System.out.println("Size of queue: " + pq.size());

        pq.clear();

        System.out.println("Is the queue empty? " + pq.isEmpty());
    }
}
