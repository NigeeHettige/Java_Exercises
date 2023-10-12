class Node{
    Node previous;
    Object data;
    Node next;

    Node(Object data){
        this.data = data;
        this.previous = null;
        this.next = null;
    }
}

class Generic{
    Node head;

    Generic(){
        this.head = null;
    }
 
    public boolean isEmpty(){
        return head == null;
    }

    //insert at the beginning
    public void insertStart(Object data){
        Node newNode = new Node(data);
        if(isEmpty()){
            head = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
    }

    public void insertAtEnd(Object data){
        Node newNode = new Node(data);
        Node current = head;

        if(isEmpty()){
            head = newNode;
        }else{
            while(current.next != null){
                current = current.next;
        }
        newNode.previous = current;
        newNode.next = null;
        current.next = newNode;

        }
       
        
    }

    public int getSize(){
        Node current = head;
        int count = 0;
        while(current.next != null){
            count++;
            current = current.next;
        }
        return count;
    }

    public void InsertatMiddle(Object data,int index){

        if(index <0 || index > getSize()){
            System.out.println("wrong index");
            return;
        } else if(index == 0){
            insertStart(data);
            return;
        }
        int count = 0;
        Node current = head;
        Node newNode = new Node(data);
        while(count < index-1){
            current = current.next;
            count++;
        }
        newNode.next = current.next;
        current.next.previous = newNode;
        newNode.previous = current;
        current.next = newNode;
        
        

    }

    public void Reverse(){
        Node current = head;
        
        if(isEmpty()){
            System.out.println("List is empty");
        }else{
            while(current.next != null){
                current = current.next;

            }

            while(current != null){
                System.out.print(current.data + " ");
                current = current.previous;
            }
        }
    }


    public void deleteAtGivenKey(Object key){
        Node current = head;

        while(current.next.data == key){
            current = current.next;
        }

        current.previous.next = current.next;
        current.next.previous = current.previous; 
        
    }

    //display
    public void display(){
        if(isEmpty()){
            System.out.println("Linked List is empty!");
        } else {
            Node current = head;
            while(current != null){
                System.out.print(current.data + " ");
                current = current.next;
            }
        }
    }

    public static void main(String[] args){
        Generic d1 = new Generic();
        d1.insertStart(10);
        d1.insertStart("Hello");
        d1.insertStart(30);
        d1.insertAtEnd(15);
        d1.insertAtEnd(23);
        d1.InsertatMiddle(11,2);
        // d1.display();
        // System.out.println();
        // d1.Reverse();

        d1.deleteAtGivenKey("Hello");
        d1.display();
        
    }

}