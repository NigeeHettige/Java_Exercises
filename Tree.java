class Tree{
    String array[];
    int currentSize;
    int maxSize;

    Tree(int maxSize){
        this.currentSize = 0;
        this.maxSize = maxSize;
        this.array = new String[maxSize];
    }

    public boolean isEmpty(){
        if(currentSize == 0){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if(currentSize == maxSize-1){
            return true;
        }
        return false;
    }

    public void insert(String data){
        if(isFull()){
            System.out.println("Tree is full");
        }else{
            array[currentSize] = data;
            currentSize++;
        }

    }


    public void getChild(String data){
        
        int i = 0;
        while(i>=0 && i <currentSize){
            if(data.equals(array[i]) ){
                break;
            }
            i++;
        }
        int left = 2*i+1;
        int right = 2*i+2;

        if(left >= 0 && left < currentSize ){
            System.out.println("Left child of "+data+" is :"+ array[left]);
        }if(right >= 0 && right < currentSize){
            System.out.println("Right child of "+data+" is :"+ array[right]);
        }else{
            System.out.println(data+" has not child");
        }
        }
    
        


    public void getParent(String data){
        
        int i = 0;
        while(i>=0 && i <currentSize){
            if(data.equals(array[i])){
                break;
            }
            i++;
        }

        System.out.println("Parent of the "+data+ (i-1/2));
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Tree is empty");
        }else{
            for(int i = 0; i<currentSize; i++){
                System.out.print(array[i]+" ");
            }
        }
    }

    public void setleftChild(String data,String parent){
        int i = 0;
        while(1 != currentSize){
            if(parent.equlas(array[i])){
                break;
            }
            i++;
        }

        int left = 2*i+1;
        if(left>= 0 && left<currentSize){
            array[left] = data;
        }

        
    }
    public void setRightChild(String data,String parent){
        int i = 0;
        while(1 != currentSize){
            if(parent.equlas(array[i])){
                break;
            }
            i++;
        }

        int right = 2*i+2;
        if(right>= 0 && right<currentSize){
            array[right] = data;
        }

        
    }

    // public void setParent(String data,String child ){

    // }


    public static void main(String[]args){
        Tree tree1 = new Tree(12);
        tree1.insert("b");
        tree1.insert("i");
        tree1.insert("n");
        tree1.insert("_");
        tree1.insert("a");
        tree1.insert("r");
        tree1.insert("_");
        tree1.insert("_");
        tree1.insert("_");
        tree1.insert("_");
        tree1.insert("y");

        tree1.display();
        System.out.println();

        tree1.getChild("y");
        tree1.getChild("n");
        // tree1.setParent("k", "r");
        tree1.display();
        System.out.println();
}
}