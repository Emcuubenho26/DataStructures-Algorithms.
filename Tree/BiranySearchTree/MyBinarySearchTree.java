package BiranySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class MyBinarySearchTree {

    Node root;

    //Add a BST node
    public void addABSTNode(int x) {
        Node newNode = new Node(x);
        if (root == null) {
            root = newNode;
            return;
        }
        if (root.data == x) {
            System.out.println(x + " already existed.");
            return;
        }
        Node p = root;
        while (p != null) {
            if (x < p.data) {
                if (p.left == null) {
                    p.left = newNode;
                    break;
                } else {
                    p = p.left;
                }
            } else {
                if (p.right == null) {
                    p.right = newNode;
                    break;
                } else {
                    p = p.right;
                }
            }
        }
    }
    //Find the minimum node of the right sub tree
    public Node findTheLeftMostNode(Node root) {
        if (root==null) return null;
        Node p=root;
        while (p.left!=null){
            p=p.left;
        }
        return p;
    }
    public Node delByMerging(Node root, int x) {
        if (root==null) return null;
        if (x<root.data) {
            root.left=delByMerging(root.left, x);
        } else if (x>root.data) {
            root.right=delByMerging(root.right, x);
        } else {
            //Case 1: x is a leaf
            if (root.left==null && root.right==null) {
                return null;
            }
            //Case 2: x has a left child
            if (root.left!=null && root.right==null) {
                return root.left;
            }
            //Case 3: x has a right child
            if (root.left==null && root.right!=null) {
                return root.right;
            }
            //Case 4: x has two children
            Node newNode = findTheLeftMostNode(root.right);
            root.data=newNode.data;
            root.right=delByMerging(root.right, newNode.data);
        }
        return root;
    }
    //Find the maximum node of left sub tree for delbyCopying
    public Node findTheRightMostNode(Node root) {
        if (root==null) return null;
        Node p=root;
        while (p.right!=null){
            p=p.right;
        }
        return p;
    }
    public Node delByCopying(Node root, int x) {       
        if (root==null) return null;
        if (x<root.data) {
            root.left=delByCopying(root.left, x);
        } else if (x>root.data) {
            root.right=delByCopying(root.right, x);
        } else if (x==root.data) {            
            //Case 1: x is a leaf node 
            if (root.left==null && root.right==null) {
                return null;
            }
            //Case 2: x has a left sub tree
            if (root.left!=null && root.right==null) {
                return root.left;
            }
            //Case 3: x has a right sub tree
            if (root.left==null && root.right!=null) {
                return root.right;
            }
            //Case 4: x has two children
            Node newNode = findTheRightMostNode(root.left);
            root.data=newNode.data;
            root.left=delByCopying(root.left, newNode.data);
        } else {
            System.out.println("Find not found "+x);
        }
        return root;
    }
    
    //Dell all nodes which only have a left child
    public Node delAllNodeOnlyLeftChild(Node root) {
        if (root==null) return null;
        if (root.left!=null && root.right==null) {
            return root.left;
        }
        root.left=delAllNodeOnlyLeftChild(root.left);
        root.right=delAllNodeOnlyLeftChild(root.right);
        return root;
    }
   
    //Dell all nodes which only have a right child
    public Node delAllNodeOnlyRightChild(Node root) {
        if (root==null) return null;
        if (root.left==null && root.right!=null) {
            return root.right;
        }
        root.left=delAllNodeOnlyRightChild(root.left);
        root.right=delAllNodeOnlyRightChild(root.right);
        return root;        
    }  
    
    //Count number of nodes in the tree
    public int countTreeNode(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> mQ = new LinkedList<>();
        mQ.add(root);
        Node q;
        int count=0;
        while (!mQ.isEmpty()) {
            q = mQ.poll();
            count++;
            if (q.left != null) {
                mQ.add(q.left);
            }
            if (q.right != null) {
                mQ.add(q.right);
            }
        }        
        return count;
    }
    //Count node with value in the range [x,y]
    public int countNodeInARange(Node root, int x, int y) {
        if (root == null) {
            return 0;
        }
        Queue<Node> mQ = new LinkedList<>();
        mQ.add(root);
        Node q;
        int count=0;
        while (!mQ.isEmpty()) {
            q = mQ.poll();
            if (q.data>=x && q.data<=y) {
                count++;
            }            
            if (q.left != null) {
                mQ.add(q.left);
            }
            if (q.right != null) {
                mQ.add(q.right);
            }
        }        
        return count;        
    }
    //Count number of nodes which only have a left child.
    public int countLeftNode(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> mQ = new LinkedList<>();
        mQ.add(root);
        Node q;
        int count=0;
        while (!mQ.isEmpty()) {
            q = mQ.poll();
            if (q.left!=null && q.right==null) {
                count++;
            }            
            if (q.left != null) {
                mQ.add(q.left);
            }
            if (q.right != null) {
                mQ.add(q.right);
            }
        }        
        return count; 
    }
    //Count number of nodes which only have a right child.
    public int countRightNode(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> mQ = new LinkedList<>();
        mQ.add(root);
        Node q;
        int count=0;
        while (!mQ.isEmpty()) {
            q = mQ.poll();
            if (q.left==null && q.right!=null) {
                count++;
            }            
            if (q.left != null) {
                mQ.add(q.left);
            }
            if (q.right != null) {
                mQ.add(q.right);
            }
        }        
        return count;
    }
    //Count number of nodes which have two children
    public int countNodeTwoChidren(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> mQ = new LinkedList<>();
        mQ.add(root);
        Node q;
        int count=0;
        while (!mQ.isEmpty()) {
            q = mQ.poll();
            if (q.left!=null && q.right!=null) {
                count++;
            }            
            if (q.left != null) {
                mQ.add(q.left);
            }
            if (q.right != null) {
                mQ.add(q.right);
            }
        }        
        return count;
    }
    //Using collections
    public void BFS(Node p) {
        if (p == null) {
            return;
        }
        Queue<Node> mQ = new LinkedList<>();
        mQ.add(p);
        Node q;
        while (!mQ.isEmpty()) {
            q = mQ.poll();
            System.out.print(q.data + " ");
            if (q.left != null) {
                mQ.add(q.left);
            }
            if (q.right != null) {
                mQ.add(q.right);
            }
        }
    }

    public void preOrder(Node p) {
        if (p == null) {
            return;
        }
        System.out.print(p.data + " ");
        preOrder(p.left);
        preOrder(p.right);
    }

    public void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        System.out.print(p.data + " ");
        inOrder(p.right);
    }

    public void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        System.out.print(p.data + " ");
    }
}
