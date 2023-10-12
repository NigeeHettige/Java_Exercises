import Stack.Node;

class Node{
    int data;
    Node next;

    Node(int data){
        this.next = null;
        this.data = data;
    }
}


class LinkedList{
    Node head;

    LinkedList(){
        this.head = null;
    }

    public boolean isEmpty(){
        if(head == null){
            return true;
        }
        return false;
    }

    public void insertAtBegining(int data){
        Node newNode =  new Node(data);
        if(isEmpty()){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;       
        }
    }

    public void insertAtEnd(int data){
        Node newNode =  new Node(data);
        Node current = head;
        if(isEmpty()){
            head = newNode;
        }else{
           while(current.next != null){
            current = current.next;
           }

           current.next = newNode;
        }
    }

    public void insertAtIndex(int index,int data){
        Node newNode =  new Node(data);
        Node current = head;
        if(isEmpty()){
            head = newNode;
        }else{
           int i = 0;
           while(i< index-1){
             current = current.next;
             i++;

           }
           newNode.next = current.next;
           current.next = newNode;
        }
    }

    public void display(){
        Node current = head;
        if(isEmpty()){
            System.out.println("List is empty");
        }else{
            while(current != null){
                System.out.print(current.data +" ");
                current = current.next;
            }
        }
    }


    public void deleteAtBegining(){
        if(isEmpty()){
            System.out.println("List is empty");
        }else{
            head = head.next;
        }
    }


    public void deleteAtEnd(){
        if(isEmpty()){
            System.out.println("List is empty");
        }else{
            Node current = head;
            while(current.next.next != null){
                current = current.next;
            }

            current.next = null;
        }
    }

    public void deleteAtIndex(int index){
        
        Node current = head;
        if(isEmpty()){
            System.out.println("List is empty");
        }else{
           int i = 0;
           while(i< index-1){
             current = current.next;
             i++;

           }
          
           current.next = current.next.next;
        }
    }


    public boolean search(int data){
        boolean isThere = false;
        if(isEmpty()){
            isThere = false;
        }else{
            Node current = head;
            while(current != null){
                if(current.data == data){
                    isThere = true;
                    break;
                }
                current = current.next;
            }
        }

        return isThere;
    }
    
    public static void  main(String[]args){
        LinkedList list1 = new LinkedList();
        list1.insertAtBegining(10);
        list1.insertAtBegining(3);
        list1.insertAtEnd(5);
        list1.insertAtEnd(11);
        list1.insertAtEnd(13);
        list1.deleteAtEnd();
        list1.deleteAtIndex(3);
        list1.display();
        System.out.println(list1.search(3));
    }
}