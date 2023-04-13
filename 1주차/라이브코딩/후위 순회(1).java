import java.util.*; 



class Node{
    
    int val;
    Node left;
    Node right; 
    
    public Node(int val){
        this.val = val; 
    }
    
}



public class Main {
    
    public static int cnt = 0; 
    
    public void postOrderTraversal(Node root, int index){
        
        if(root == null){
            return; 
        }
        
        
        postOrderTraversal(root.left, index);
        postOrderTraversal(root.right, index);
        cnt++; 
        if(cnt == index){
            System.out.println(root.val);
        }    
        
        
    }
    
    
    
    
    public static void main(String args[]) {
      
        Main T = new Main();
        
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6); 
        
        
        int index = 4; 
        
        T.postOrderTraversal(root, index);





    }
    
    
    
    
    
}
