class Queue {
    int front;
    int rear;
    int size;
    int array[];

    Queue(int size) {
        this.front = 0;
        this.rear = -1;
        this.size = size;
        array = new int[size];
    }

    public boolean isEmpty() {
        if (rear == -1) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (rear == size - 1) {
            return true;
        }
        return false;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            // rear = rear + 1;
            array[++rear] = data;
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else if (front > rear) {
            System.out.println("Queue is empty");
        } else {
            
            array[front] = 0;
            front++;
        }
        
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            for (int i = front; i < rear + 1; i++) {
                System.out.print(array[i] + " ");
            }
        }
    }

    public int peek() {
        if (isEmpty() || front > rear) {
            return 0;
        }
        return array[front];
    }

    public void dequeue_front() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {

            for (int i = 0; i < rear; i++) {
               
                array[i] = array[i + 1];
            }
            array[rear--] = 0;
        }

    }

    public void remove(int k){
        if(isEmpty()){
            System.out.println("Queue is empty");
        }
        else{
            Stack stack1 = new Stack(k);
            for(int i = 0; i < k; i++){
                int num = peek();
                dequeue_front();
                stack1.Push(num);
        }

            for(int i = 0; i<k; i++){
            int num1 = stack1.Peek();
            stack1.Pop();
            enqueue(num1);
            }
            display();
            }
        
    }
    public static void main(String[] args) {
        Queue queue1 = new Queue(5);
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);
        queue1.enqueue(4);
        queue1.enqueue(5);
        System.out.println("Original queue: ");
        queue1.display();
        System.out.println();
        System.out.println("After reversing k number of elements: ");
        queue1.remove(3);

        System.out.println();
        Queue queue2 = new Queue(4);
        queue2.enqueue(3);
        queue2.enqueue(6);
        queue2.enqueue(9);
        queue2.enqueue(12);
       
        System.out.println("Original queue: ");
        queue2.display();
        System.out.println();
        System.out.println("After reversing k number of elements: ");
        queue2.remove(2);

    }
}