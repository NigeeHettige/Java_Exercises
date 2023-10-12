class TreeString {
    int size;
    int currentSize = 0;
    String array1[];

    TreeString(int size) {
        this.size = size;
        array1 = new String[size];
    }

    public boolean isEmpty() {
        if (currentSize == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (size == currentSize) {
            return true;
        }
        return false;
    }

    public void insertElement(String data) {
        if (isFull()) {
            System.out.println("Tree is full");
        }
        array1[currentSize++] = data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("tree is empty");
        } else {
            for (int i = 0; i < size; i++) {
                if (array1[i] == "") {
                    System.out.print("_ ");
                } else {
                    System.out.print(array1[i] + " ");
                }
            }
        }

    }

    // ******insert at particular index should check it has (i/2)-1 element*****
    public void insertAtElement(int index, String data) {
        if (isFull()) {
            System.out.println("Tree is full");
        } else if (index > size || index < 0) {
            System.out.println("Invalid index");
        } else {
            int num = (index / 2) - 1;

            if (array1[num] != "") {
                array1[index] = data;
                currentSize++;
            }
        }
    }

    public int searchElement(String data) {
        if (isEmpty()) {
            System.out.println("tree is empty");
        } else {
            for (int i = 0; i < currentSize; i++) {
                if (array1[i] == data) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void delete(String data) {
        if (isEmpty()) {
            System.out.println("Tree is empty");
        } else {

            array1[searchElement(data)] = array1[currentSize - 1];
            array1[currentSize - 1] = "";
            currentSize--;
        }
    }

    public void inorder(int index) {
        if (isEmpty()) {
            System.out.println("Tree is empty");
        } else {
            if (index < currentSize && array1[index] != "") {
                inorder(2 * index + 1);
                System.out.print(array1[index] + " ");
                inorder(2 * index + 2);
            } else if (index < currentSize && array1[index] == "") {
                System.out.print("_ ");
                return;
            }
        }
    }

    public void parent(String data) {
        if(isEmpty()){
            System.out.println("Tree is empty");
        }else{
            int index = searchElement(data);
            if( index>-1){
                int ele = (index - 1) / 2;
                System.out.println("Parent of " + data + " is " + array1[ele]);
            }else{
                System.out.println("There is no parent");
            }
        }  
        
    }


    public void setParent(String data,String parent) {
        if(isEmpty()){
            System.out.println("Tree is empty");
        }else{
            int index = searchElement(data);
            if( index>-1){
                int ele = (index - 1) / 2;
                array1[ele] = parent;
               
                // System.out.println("Parent of " + data + " is " + array1[ele]);
            }else{
                System.out.println("There is no parent");
            }
        }
        
        
    }

    public void children(String data) {
        if(isEmpty()){
            System.out.println("Tree is empty");
        }else{
            int index = searchElement(data);
        
            if(index != size-1 && index>-1){
                int left = (index * 2) + 1;
                int right = (index * 2) + 2;
                System.out.println("Right children of " + data + " is " + array1[right]);
                System.out.println("Left children of " + data + " is " + array1[left]);
            }else{
                System.out.println("There is no child");
            }
            
        }
        
        
    }

    
    public void setChildren(String data,String position,String child) {
        if(isEmpty()){
            System.out.println("Tree is empty");
        }else{
            int index = searchElement(data);
        
            if(index != size-1 && index>-1){
                int left = (index * 2) + 1;
                int right = (index * 2) + 2;

                if(position.equals("right")  ){
                    array1[right] = child;
                }
                else{
                    if(position.equals("left")){
                        array1[left] = child;
                    }
                    
                }
            }else{
                System.out.println("Index is not valid");
            }
            
        }
        
        
    }

    public int getHeight(int index) {
        if (index >= currentSize || array1[index] == null) {
            return 0;
        }
        int leftHeight = getHeight(2 * index + 1);
        int rightHeight = getHeight(2 * index + 2);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public void getSize(){
        int count = currentSize;
        for(int i = 0; i <size; i++){
            if(array1[i].equals("")){
                count = count - 1;
            }

        }

        System.out.println("Size of the tree is: "+count);
    }

    public static void main(String[] args) {

        TreeString tree1 = new TreeString(11);
        tree1.insertElement("b");
        tree1.insertElement("i");
        tree1.insertElement("n");
        tree1.insertElement("");
        tree1.insertElement("a");
        tree1.insertElement("r");
        tree1.insertElement("");
        tree1.insertElement("");
        tree1.insertElement("");
        tree1.insertElement("");
        tree1.insertElement("y");

        tree1.display();
        System.out.println();
        tree1.children("y");
        tree1.parent("r");
        tree1.setChildren("n", "right", "o");
        tree1.children("n");
        tree1.setParent("y", "g");
        tree1.parent("y");
        System.out.println("Height of tree is: "+tree1.getHeight(0));
        tree1.getSize();
        
    }
}