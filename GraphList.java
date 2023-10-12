class Node{
    Node next;
    int data;

    Node(int data){
        this.next = null;
        this.data = data;
    }
}


class GraphList{
    Node array[];
    int currentSize;
    int maxVertices;

    GraphList(int maxVertices){
        this.maxVertices = maxVertices;
        this.currentSize = 0;
        array = new Node[maxVertices];

    }


    public boolean isEmpty(){
        if(currentSize == 0){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if(currentSize == maxVertices){
            return true;

        }
        return false;
    }


    public void  insertVertice(){
        if(isFull()){
            System.out.println("Graph's vertices are full");
        }else{
            currentSize++;
        }
    }


    //For the directed graph
    public void insertEdge(int source,int data){
       
        if(source >= 0 && source <currentSize && data >= 0 && data < currentSize){
            Node newNode = new Node(data);
            newNode.next = array[source];
            array[source] = newNode;

            // Node newNoder = new Node(source);
            // newNoder.next = array[data];
            // array[data] = newNoder;

        }else{
            System.out.println("Invalid Vertice");
        }

        // if undirected graph should not comment
            // Node newNoder = new Node(source);
            // newNoder.next = array[data];
            // array[data] = newNoder;

    }


    public void display(){
        Node current;
        for(int i = 0; i < maxVertices; i++){
            current = array[i];
            System.out.print(i+" ->  ");
            while(current != null){
                System.out.print(current.data+" ");
                current = current.next;
            }
            System.out.println();
        }

    }

    public boolean isEdge(int source,int data){
        Node current = array[source];
        
        while(current != null){

            if(current.data == data){
                return true;    
            }
            current = current.next;
        }
       
        return false;
    }



    public void deleteEdge(int source, int destination){
       array[source] = deleteNode(array[source], destination);
    }

    public Node deleteNode(Node head ,int data){
      
        if(head == null){
            return null;
        } 

        if(head.data == data){
            head = head.next;
            return head;
        }

       Node current = head;
       while(current.next != null ){
            if(current.next.data == data){
                current.next = current.next.next;
                break;
            }
            current.next = current.next.next;
       }
       return head;

    }

    
    public void deleteVertex(int source){
        array[source] = null;

        for(int i =0; i < currentSize; i++){
           if(isEdge(i,source)){
              deleteEdge(i,source);
           }
            
        }
       
    }


    public static void main(String args[]){
        GraphList gl1 = new GraphList(5);
        gl1.insertVertice();
        gl1.insertVertice();
        gl1.insertVertice();
        gl1.insertVertice();
        gl1.insertVertice();

        gl1.insertEdge(0,1);
        gl1.insertEdge(0,2);
        gl1.insertEdge(1,2);
        gl1.insertEdge(2,3);
        gl1.insertEdge(2,1);
        gl1.insertEdge(3,4);
        gl1.insertEdge(4,1);
        gl1.insertEdge(4,3);

        gl1.display();

        System.out.println("The edge is in the graph: "+ gl1.isEdge(0,1));


        gl1.deleteEdge(0,1);
        gl1.deleteVertex(3);

       

        gl1.display();

    }
}