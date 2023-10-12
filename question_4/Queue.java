class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class QueueLL {
    Node front = null;
    Node rear = null;

    public boolean isEmpty() {
        if (front == null && rear == null) {
            return true;
        } else {
            return false;
        }
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        }else{
             rear.next = newNode;
             rear = newNode;
        }       

    }

    public void dequeue() {
        front = front.next;
    }

    public int peek() {
        return front.data;
    }

    public void display() {
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

    }

    public int getSize(){
        int count = 0;
        Node current = front;
        while(current!=null){
            count++;
            current = current.next;
        }
        return count;
    }

   

    public void divide() {
    if (isEmpty()) {
        System.out.println("Queue is empty");
    } else {
       
            QueueLL queueLL2 = new QueueLL();
            int halfSize = getSize() / 2;

            for (int i = 0; i < halfSize; i++) {
                queueLL2.enqueue(peek());
                dequeue();
            }

            // Display the divided queues
            System.out.println("Queue 1:");
            display();
            System.out.println("\nQueue 2:");
            queueLL2.display();
            System.out.println();

            QueueLL output = new  QueueLL();

            for(int i=0; i<halfSize; i++){
                output.enqueue(queueLL2.peek());
                queueLL2.dequeue();
                output.enqueue(peek());
                dequeue();
                
            }

            output.display();
        } 
    
}


    public static void main(String[] args) {
        QueueLL queueLL1 = new QueueLL();
        queueLL1.enqueue(1);
        queueLL1.enqueue(2);
        queueLL1.enqueue(3);
        queueLL1.enqueue(4);
        queueLL1.enqueue(5);
        queueLL1.enqueue(6);        
        

        queueLL1.divide();


    }

}