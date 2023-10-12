class QueueAny {
    int front;
    int rear;
    int size;
    Object array[];

    QueueAny(int size) {
        this.front = 0;
        this.rear = -1;
        this.size = size;
        array = new Object[size];
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

    public void enqueue(Object data) {
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
            array[front] = "";
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

    public Object peek() {
        if (isEmpty() || front > rear) {
            return "Queue is empty";
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
            array[rear--] = "";
        }

    }

    public static void main(String[] args) {
        
        QueueAny queue2 = new QueueAny(5);
        queue2.enqueue(1);
        queue2.enqueue(2);
        queue2.enqueue(3);
        queue2.enqueue(4);
        queue2.enqueue(5);
        
        queue2.display();

    }
}