class Stack {
    int top;
    int size;
    int array[];

    Stack(int size) {
        this.top = -1;
        this.size = size;
        array = new int[size];
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (top == array.length - 1) {
            return true;
        }
        return false;

    }

    public void Push(int data) {
        if (isFull() == true) {
            System.out.println("Stack is full");
        } else {

            array[++top] = data;
        }

    }

    public void Display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.print(array[i] + " ");
            }
        }

    }

    public void Pop() {
        if (isEmpty() == true) {
            System.out.println("Stack is empty");
        }
        array[top--] = 0;

    }

    public void Peek() {
        System.out.println(top);
    }

    public void Binary(int number){
        Stack stack2 = new Stack(32);
        
        while(number>0){
            int reminder = number%2;
            stack2.Push(reminder);
            number = number/2;
            

        }
        System.out.println("Binary representation:");
        stack2.Display();
        System.out.println();

    }

  

    public static void main(String[] args) {
        Stack stack1 = new Stack(10);
        stack1.isEmpty();
        stack1.isFull();
        stack1.Push(3);
        stack1.Push(5);
        stack1.Push(6);
        stack1.Push(9);
        stack1.Pop();
        stack1.Display();
        System.out.println();
        stack1.Peek();
        stack1.Binary(15);
        stack1.Binary(45);
        
        
      

    }
}