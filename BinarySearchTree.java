class Node{
    int data;
    Node nextNode;
    Node previousNode;

    Node(int data){
        this.data = data;
        this.nextNode = null;
        this.previousNode = null;
    }

}

public class BinarySearchTree{
    Node root;

    BinarySearchTree(){
        this.root = null;
    }

    //isEmpty
    public boolean isEmpty(){
        return root == null;
    }

    //insertElements
    public Node insertElements(int data, Node current){
        if(isEmpty()){
            root = new Node(data);
            return root;
        }

        if(current == null){
            current = new Node(data);
            return current;
        }
        if(data < current.data){
            current.previousNode = insertElements(data, current.previousNode);
        } else if(data > current.data){
            current.nextNode = insertElements(data, current.nextNode);
        }

        return current;
    }

    //minimum value
    public int findMin(Node current){
        if(isEmpty()){
            System.out.println("The Binary Tree is empty!");
        } else {
            while(current.previousNode != null){
                current = current.previousNode;
            }
        }
         return current.data;
    }

    //max value
    public int findMax(Node current){
        if(isEmpty()){
            System.out.println("The Binary Tree is empty!");
        } else {
            while(current.nextNode != null){
                current = current.nextNode;
            }
        }
        return current.data;
    }

    //inorder traversal
    public void inOrderTraversal(Node current){
        if(current != null){
            inOrderTraversal(current.previousNode);
            System.out.print(current.data + " ");
            inOrderTraversal(current.nextNode);
        }
    }

    //preorderTraversal
    public void preOrderTraversal(Node current){
        if(current != null){
            System.out.print(current.data + " ");
            inOrderTraversal(current.previousNode);
            inOrderTraversal(current.nextNode);
        }
    }

    //postorderTraversal
    public void postOrderTraversal(Node current){
        if(current != null){
            inOrderTraversal(current.previousNode);
            inOrderTraversal(current.nextNode);
            System.out.print(current.data + " ");
        }
    }
    
    //search element
    public Node search(Node cNode,int data){

        if(isEmpty()){
            System.out.println("Tree is empty");
            return null;
        }

        if(cNode == null){
             System.out.println("Data is not in the tree");
             return null;
        }
        
        if(data < cNode.data){
            cNode = search(cNode.previousNode, data);
            return cNode;
        }else if(data>cNode.data){
            cNode  = search(cNode.nextNode, data);
        }else {
            System.out.println("Data is in the tree");
            return cNode;    
        }
       
        return cNode;
       
        
    }

    
    //deletion
    public Node deletion(int data, Node current){
        if(isEmpty()){
            System.out.println("The Binary Search Tree is empty!");
            return null;
        } else {
            if(current.data > data){
                current.previousNode = deletion(data, current.previousNode);
            } else if(current.data < data){
                current.nextNode = deletion(data, current.nextNode);
            } else {
                if(current.previousNode == null && current.nextNode == null){
                    return null;
                } else if(current.previousNode == null){
                    current = current.nextNode;
                    return current;
                } else if(current.nextNode == null){
                    current = current.previousNode;
                    return current;
                } else {
                    int minValue = findMin(current.nextNode);
                    current.data = minValue;
                    current.nextNode = deletion(minValue, current.nextNode);
                   
                }
            }
            return current;
        }
        
    }
        
    
    public static void main(String[] args){

        BinarySearchTree bs1 = new BinarySearchTree();
        
        bs1.insertElements(50, bs1.root);
        bs1.insertElements(30, bs1.root); 
        bs1.insertElements(70, bs1.root);  
        bs1.insertElements(20, bs1.root); 
        bs1.insertElements(40, bs1.root);  
        bs1.insertElements(60, bs1.root); 
        bs1.insertElements(80, bs1.root); 

        System.out.println("Inorder Traversal");
        bs1.inOrderTraversal(bs1.root);
        System.out.println();

        System.out.println("Preorder Traversal");
        bs1.preOrderTraversal(bs1.root);
        System.out.println();

        System.out.println("Postorder Traversal");
        bs1.postOrderTraversal(bs1.root);
        System.out.println();

       

        bs1.search(bs1.root,40);
        bs1.search(bs1.root,90);
        

        System.out.println("min value : " + bs1.findMin(bs1.root));
        System.out.println("max value : " + bs1.findMax(bs1.root));


        bs1.deletion(80, bs1.root);
        bs1.deletion(70, bs1.root);
        bs1.deletion(30, bs1.root);


        System.out.println("After deletion inorder Traversal");
        bs1.inOrderTraversal(bs1.root);
        System.out.println();

        System.out.println("After deletion preorder Traversal");
        bs1.preOrderTraversal(bs1.root);
        System.out.println();

        System.out.println("After deletion postorder Traversal");
        bs1.postOrderTraversal(bs1.root);
        System.out.println();
    }
}