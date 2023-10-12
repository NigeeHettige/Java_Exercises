class Node<T>{
   T data;
   Node<T> next;
   
   public Node(T data){
    this.data = data;
    this.next = null;
   }
}


class GenericStack<T>{
    Node<T> top;

   public boolean isEmpty(){
     if(top == null){
        return true;
     }
     return false;
   } 


   public void Push(T data){
     Node<T> newNode = new Node<>(data);
     newNode.next = top;
     top = newNode;
   }

   public void Pop(){
    if(isEmpty()){
        System.out.println("Stack is empty");

    }else{
       top = top.next; 
    }
   }

   public void Peek(){
    System.out.println(top.data);
   }

   public void Display(){
    Node<T> current;
    current = top;

    if(isEmpty()){
        System.out.println("Stack is empty");
    }else{
        while(current != null){
            System.out.print(current.data+" ");
            current = current.next;
        }
    }
   }


   
   

   public static void main(String[]args){
    GenericStack<Integer> stack1 = new GenericStack<>();
    stack1.Push(10);
    stack1.Push(20);
    stack1.Push(33);
    stack1.Push(55);
    stack1.Display();
   }
}
