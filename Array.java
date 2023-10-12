class Array{
    int array[];
    int size;
    int currentSize;

    Array(int size){
        this.size = size;
        this.array = new int[size];
        this.currentSize = 0;
    }

    public boolean isEmpty(){
        if(currentSize == 0){
            return true;
        }
        return false;
    }


    public boolean isFull(){
        if(currentSize == size){
            return true;
        }
        return false;
    }

    public void add(int data){
        if(isFull()){
            System.out.println("Array is full");
        }else{
            array[currentSize] = data;
            currentSize++;
        }
    }

    public void insert(int index,int data){
       if(isFull()){
        System.out.println("Array is full");
       }else{
            if(0 <= index && index <= currentSize){
               for(int i= currentSize; i>= index; i--){
                    array[i] = array[i-1];
                    
               }
               array[index] = data;
               
            }
            currentSize++;
       }
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Array is empty");
        }
        else{
            for(int i = 0; i<currentSize; i++){
            System.out.print(array[i]+" ");
        }
        }
    }

    public void delete(int index){
        if(isEmpty()){
            System.out.println("Array is empty");
        }else{
            for(int i = index ; i<currentSize-1 ; i++){
                array[i] = array[i+1];
            }
            currentSize--;
        }
    }

    public void update(int index,int data){
        array[index] = data;
    }

    public int getElement(int index){
        if(0<= index && index <= currentSize){
            return array[index];
        }
        return -1;
    }

    public boolean searchElement(int data){
        
        boolean isThere = true;
        if(isEmpty()){
            isThere = false;
        }else{
            int i = 0;
            while(i<currentSize){
                if(array[i] == data){
                    isThere = true;
                    break;
                    
                }else{
                  isThere = false;
                }
                i++;
            }
        }
        return isThere;
    }


    public void sort(){
        if(isEmpty()){
            System.out.println("Array is empty");
        }else{
            int temp = 0;
           for(int j = 0; j<currentSize; j++){
                 for(int i = 0; i < currentSize; i++){
                    if(array[j] < array[i]){
                        temp = array[i];
                        array[i] = array[j];
                        array[j] = temp; 
                }
            }
           }
        }
    }

    public void min(){
       
        System.out.println(array[0]);
    }
    public void max(){
       
        System.out.println(array[currentSize-1]);
    }

    public static void main (String[] args){
        Array array1 = new Array(5);
        array1.add(4);
        array1.add(1);
        array1.add(10);
        array1.add(3);
        array1.insert(2,6);
        array1.delete(2);
        array1.display();
        System.out.println();
        System.out.println("element is there: "+ array1.searchElement(8));
        System.out.println("element is there: "+ array1.searchElement(10));
        array1.sort();
        array1.display();
        System.out.println();
        array1.min();
        array1.max();
    }

}