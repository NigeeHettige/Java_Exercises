class Graph {
    int size;
    int array[][];
    int currentSize = 0;

    Graph(int size) {
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
            array[destination][source] = weight;
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
            currentSize--;
        }
    }

    public void edgeDelete(int source, int destination) {
        array[source][destination] = 0;
        array[destination][source] = 0;
    }


    

    public static void main(String[] args) {

        Graph graph1 = new Graph(5);
        graph1.insertNode();
        graph1.insertNode();
        graph1.insertNode();

        graph1.insertEdge(0, 1, 20);
        graph1.insertEdge(1, 2, 30);

        graph1.display();

        graph1.nodeDeletion(2);
        graph1.edgeDelete(0, 1);
        graph1.display();

    }
}