class Node{
    Node previous;
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.previous = null;
        this.next = null;
    }
}

class doublyList{
    Node head;

    doublyList(){
        this.head = null;
    }
 
    public boolean isEmpty(){
        return head == null;
    }

    //insert at the beginning
    public void insertStart(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            head = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
    }

//Insert element at the end
    public void insertAtEnd(int data){
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

//Get the list size
    public int getSize(){
        Node current = head;
        int count = 0;
        while(current.next != null){
            count++;
            current = current.next;
        }
        return count;
    }

//Insert at the given index
    public void InsertatMiddle(int data,int index){

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

//Reverse
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
        doublyList d1 = new doublyList();
        d1.insertStart(10);
        d1.insertStart(20);
        d1.insertStart(30);
        d1.insertAtEnd(15);
        d1.insertAtEnd(23);
        d1.InsertatMiddle(11,2);
        d1.display();
        System.out.println();
        d1.Reverse();
    
        System.out.println();


        doublyList d2 = new doublyList();
        d2.insertStart(34);
        d2.insertStart(30);
        d2.insertStart(60);
        d2.insertAtEnd(67);
        d2.insertAtEnd(68);
        d2.InsertatMiddle(25,3);
        d2.display();
        System.out.println();
        d2.Reverse();
        
    }

}