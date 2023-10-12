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

    public int Peek() {
       return array[top];
    }


}