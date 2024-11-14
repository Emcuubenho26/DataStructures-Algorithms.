package AVLTRee;

import java.util.LinkedList;
import java.util.Queue;

public class MyAVLTree {

    Node root;

    public MyAVLTree() {
    }

    public MyAVLTree(Node root) {
        this.root = root;
    }

    public int getHeight(Node p) {
        if (p == null) {
            return 0;
        }
        return p.height;
    }

    public int getBalance(Node p) {
        if (p == null) {
            return 0;
        }
        return getHeight(p.left) - getHeight(p.right);
    }

    public Node rightRotate(Node p) {
        Node k = p.left;
        p.left = k.right;
        k.right = p;
        p.height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
        k.height = Math.max(getHeight(k.left), getHeight(k.right)) + 1;
        return k;
    }

    public Node leftRotate(Node p) {
        Node k = p.right;
        p.right = k.left;
        k.left = p;
        p.height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
        k.height = Math.max(getHeight(k.left), getHeight(k.right)) + 1;
        return k;
    }

    public Node addAVLNode2(Node xRoot, int x) {
        if (xRoot == null) {
            return new Node(x);
        }
        if (x < xRoot.data) {
            xRoot.left = addAVLNode(xRoot.left, x);
        } else if (x > xRoot.data) {
            xRoot.right = addAVLNode(xRoot.right, x);
        } else {
            return xRoot;
        }
        xRoot.height = Math.max(getHeight(xRoot.left), getHeight(xRoot.right)) + 1;
        int balance = getBalance(xRoot);
        //TH1
        if (balance > 1 && x < xRoot.left.data) {
            return rightRotate(xRoot);
        }
        //TH2
        if (balance < -1 && x > xRoot.right.data) {
            return leftRotate(xRoot);
        }
        //TH3
        if (balance > 1 && x > xRoot.left.data) {
            xRoot.left = leftRotate(xRoot.left);
            return rightRotate(xRoot);
        }
        //TH4
        if (balance < -1 && x < xRoot.right.data) {
            xRoot.right = rightRotate(xRoot.right);
            return leftRotate(xRoot);
        }
        return xRoot;
    }

    public Node addAVLNode(Node root, int x) {
        Node newNode = new Node(x);
        if (root == null) {
            return newNode;
        }
        if (x < root.data) {
            if (root.left == null) {
                root.left = newNode;
            } else {
                root.left = addAVLNode(root.left, x);
            }
        } else if (x > root.data) {
            if (root.right == null) {
                root.right = newNode;
            } else {
                root.right = addAVLNode(root.right, x);
            }
        } else {
            return root;
        }
        int balance = getBalance(root);
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        //Case 1:
        if (balance > 1 && x < root.left.data) {
            return rightRotate(root);
        }
        //Case 2: 
        if (balance < -1 && x > root.right.data) {
            return leftRotate(root);
        }
        //Case 3: 
        if (balance > 1 && x > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        //Case 4:
        if (balance < -1 && x < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    //Find the minimum node of the right sub tree
    public Node findTheLeftMostNode(Node root) {
        if (root == null) {
            return null;
        }
        Node p = root;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    public Node delAVLByMerging(Node root, int x) {
        if (root == null) {
            return null;
        }
        if (x < root.data) {
            root.left = delAVLByMerging(root.left, x);
        } else if (x > root.data) {
            root.right = delAVLByMerging(root.right, x);
        } else if (x == root.data) {
            //Case 1: x is a leaf
            if (root.left == null && root.right == null) {
                return null;
            }
            //Case 2: x has a left child
            if (root.left != null && root.right == null) {
                return root.left;
            }
            //Case 3: x has a right child
            if (root.left == null && root.right != null) {
                return root.right;
            }
            //Case 4: x has two children
            Node newNode = findTheLeftMostNode(root.right);
            root.data = newNode.data;
            root.right = delAVLByMerging(root.right, newNode.data);

            //Balance the tree
            int balance = getBalance(root);
            root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
            //Case 1:
            if (balance > 1 && x < root.left.data) {
                return rightRotate(root);
            }
            //Case 2: 
            if (balance < -1 && x > root.right.data) {
                return leftRotate(root);
            }
            //Case 3: 
            if (balance > 1 && x > root.left.data) {
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
            //Case 4:
            if (balance < -1 && x < root.right.data) {
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }
        } else {
            System.out.println("Find not found " + x);
        }
        return root;
    }

    //Find the maximum node of left sub tree for delbyCopying
    public Node findTheRightMostNode(Node root) {
        if (root == null) {
            return null;
        }
        Node p = root;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

    public Node delAVLByCopying(Node root, int x) {
        if (root == null) {
            return null;
        }
        if (x < root.data) {
            root.left = delAVLByCopying(root.left, x);
        } else if (x > root.data) {
            root.right = delAVLByCopying(root.right, x);
        } else if (x == root.data) {
            //Case 1: x is a leaf node 
            if (root.left == null && root.right == null) {
                return null;
            }
            //Case 2: x has a left sub tree
            if (root.left != null && root.right == null) {
                return root.left;
            }
            //Case 3: x has a right sub tree
            if (root.left == null && root.right != null) {
                return root.right;
            }
            //Case 4: x has two children
            Node newNode = findTheRightMostNode(root.left);
            root.data = newNode.data;
            root.left = delAVLByCopying(root.left, newNode.data);
            //Balance the tree
            int balance = getBalance(root);
            root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
            //Case 1:
            if (balance > 1 && x < root.left.data) {
                return rightRotate(root);
            }
            //Case 2: 
            if (balance < -1 && x > root.right.data) {
                return leftRotate(root);
            }
            //Case 3: 
            if (balance > 1 && x > root.left.data) {
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
            //Case 4:
            if (balance < -1 && x < root.right.data) {
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }
        } else {
            System.out.println("Find not found " + x);
        }
        return root;
    }

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
}
