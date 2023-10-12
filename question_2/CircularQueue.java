class CircularQueue {
    private int[] queueArray;
    private int front;
    private int rear;
    private int maxSize;
    private int currentSize;

    public CircularQueue(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        
        rear = (rear + 1) % maxSize;
        queueArray[rear] = data;
        currentSize++;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }
        
        front = (front + 1) % maxSize;
        currentSize--;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1; // Return a special value indicating an error
        }
        return queueArray[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue: ");
        int index = front;
        for (int i = 0; i < currentSize; i++) {
            System.out.print(queueArray[index] + " ");
            index = (index + 1) % maxSize;
        }
        System.out.println();
    }



    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(5);

        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        circularQueue.enqueue(4);

        circularQueue.display(); 

        circularQueue.dequeue();
        circularQueue.enqueue(5);

        circularQueue.display();

        System.out.println("Front element: " + circularQueue.peek());
    }
}

// public class CircularQueueExample {
    
// }
