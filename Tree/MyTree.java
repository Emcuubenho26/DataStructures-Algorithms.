
import java.util.LinkedList;
import java.util.Queue;

public class MyTree {
    TreeNode root;
    //Using collections
    public void BFS(TreeNode p){
        if (p==null) return;
        Queue <TreeNode> mQ = new LinkedList<>();
        mQ.add(p);
        TreeNode q;
        while (!mQ.isEmpty()){
            q=mQ.poll();
            System.out.print(q.data+" ");
            if (q.left!=null) mQ.add(q.left);
            if (q.right!=null) mQ.add(q.right);
        }
    }
    //Using given Queue
    public void breathTraversal(TreeNode p) throws Exception{
        if (p==null) return;
        MyQueue mQ = new MyQueue();
        mQ.enqueue(p);
        TreeNode q;
        while (!mQ.isEmpty()){
            q=(TreeNode) mQ.dequeue();
            System.out.print(q.data+" ");
            if (q.left!=null) mQ.enqueue(q.left);
            if (q.right!=null) mQ.enqueue(q.right);
        }
    }
    public void preOrder(TreeNode p){
        if (p==null) return;
        System.out.print(p.data+" ");
        preOrder(p.left);
        preOrder(p.right);
    }
    
    public void inOrder(TreeNode p){
        if (p==null) return;
        inOrder(p.left);
        System.out.print(p.data+" ");
        inOrder(p.right);
    }
    
    public void postOrder(TreeNode p){
        if (p==null) return;
        postOrder(p.left);
        postOrder(p.right);
        System.out.print(p.data+" ");
    }
    
    public void init(){
        TreeNode n1,n2,n3,n4,n5,n6,n7,n8,n9,n10,n11,n12,n13;
        n1=new TreeNode(9);
        n2=new TreeNode(6);
        n3=new TreeNode(12);
        n4=new TreeNode(11);
        n5=new TreeNode(8);
        n6=new TreeNode(15);        
        n7=new TreeNode(7);
        n8=new TreeNode(9);
        n9=new TreeNode(5);
        n10=new TreeNode(3);
        n11=new TreeNode(2);
        n12=new TreeNode(4); 
        n13=new TreeNode(7); 
        root=n1;
        root.left=n2;
        root.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.right=n6;
        n5.left=n7;
        n5.right=n8;
        n6.left=n9;
        n6.right=n10;
        n7.left=n11;
        n7.right=n12;
        n10.left=n13;
    }
}
