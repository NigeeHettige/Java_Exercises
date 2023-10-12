class GraphDirected {
    int size;
    int array[][];
    int currentSize = 0;

    GraphDirected(int size) {
        this.size = size;
        array = new int[size][size];
        currentSize = 0;
    }

    public boolean isEmpty() {
        if (currentSize == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (currentSize == size) {
            return true;
        }
        return false;
    }

    public void insertNode() {
        if (isFull()) {
            System.out.println("Graph is full");
        } else {

            currentSize++;
        }
    }

    public void insertEdge(int source, int destination, int weight) {
        if (source < currentSize && destination < currentSize && source >= 0 && destination >= 0) {
            array[source][destination] = weight;
            // array[destination][source] = weight;
        } else {
            System.out.println("Invalid source and destination");
        }

    }

    public void display() {
        for (int i = 0; i < currentSize; i++) {
            for (int j = 0; j < currentSize; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void nodeDeletion(int node) {
        if (isEmpty()) {
            System.out.println("Graph is empty");
        } else {
            for (int i = 0; i < currentSize; i++) {
                array[i][node] = 0;
                array[node][i] = 0;
            }
            
        }
    }

    public void edgeDelete(int source, int destination) {
        array[source][destination] = 0;
    //     array[destination][source] = 0;
    }

    public boolean isEdge(int source,int destination){
        if(isEmpty()){
            return false;
        }else{
            if(array[source][destination] <= 0){
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {

        GraphDirected graph1 = new GraphDirected(5);
        graph1.insertNode();
        graph1.insertNode();
        graph1.insertNode();
        graph1.insertNode();
        graph1.insertNode();

        graph1.insertEdge(0, 1, 1);
        graph1.insertEdge(0, 2, 1);
        graph1.insertEdge(1, 2, 1);
        graph1.insertEdge(2, 3, 1);
        graph1.insertEdge(2, 1, 1);
        graph1.insertEdge(3, 4, 1);
        graph1.insertEdge(4, 1, 1);
        graph1.insertEdge(4, 3, 1);

        graph1.display();


        System.out.println("The edge is in the graph: "+ graph1.isEdge(0,1));

        graph1.edgeDelete(0, 1);
        graph1.nodeDeletion(3);
        
        graph1.display();

    }
}