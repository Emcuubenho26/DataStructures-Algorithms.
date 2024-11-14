
import java.io.RandomAccessFile;

public class MySingleLinkedList {

    Node head, tail;

    
    public MySingleLinkedList() {
        head=tail=null;
    }
    
    public boolean isEmpty(){
        return head==null;
    }
    
    public void addLast(int x){
        Node newNode = new Node(x);
        if (isEmpty()) {
            head=tail=newNode;
        } else {
            Node p = head;
            while (p.next!=null){
                p=p.next;
            }
            p.next=newNode;
            tail=newNode;
        }
    }
    public void addFirst(int x){
        Node newNode = new Node(x);
        if (isEmpty()) {
            head=tail=newNode;
        } else {
            newNode.next=head;
            head=newNode;
        }            
    }
    //Add a node with value as x at position - pos
    public void addNodeAtPos(int x, int pos){
        if (pos>=0 && pos<=countNode()) {
            if (pos==0) {
                addFirst(x); return;
            }
            if (pos==countNode()) {
                addLast(x); return;
            }            
            Node newNode = new Node(x);
            int count=0;
            Node p=head;
            while (p!=null){
                if (count==pos-1) {
                    newNode.next=p.next;
                    p.next=newNode;
                    break;
                }
                count++;
                p=p.next;
            }
        }
    }       
    public void myAdd(int x){
        if (x%2==0) addFirst(x);
        else addLast(x);
    }
    //Find the position of x in the list
    //Return its position. Return -1 in case not found
    public int findPos(int x){
        int pos=0;
        Node p=head;
        while(p!=null){
            if (p.data==x) return pos;           
            pos++;
            p=p.next;
        }
        return -1;
    }
    //Find all position of x in the list
    public void findAllPosOfX(int x){
        int pos=-1;
        boolean found = false;
        Node p=head;
        while(p!=null){
            pos++;
            if (p.data==x) {  
                found = true;
                System.out.print(pos+" ");          
            }
            p=p.next;
        }
        if (!found) System.out.println("Find not found "+x+" in the list.");
    }
    public int countFrequencyOfNode(int x) {
        int count=0;
        Node p=head;
        while (p!=null){
            if (p.data==x) count++;
            p=p.next;                
        }
        return count;
    }  
   
    public int findMax() {
        int max=head.data;
        Node p=head;
        while (p!=null){
            if (p.data>max) max=p.data;
            p=p.next;
        }
        return max;
    }
    
    public int findMin() {
        int min=head.data;
        Node p=head;
        while (p!=null){
            if (p.data<min) min=p.data;
            p=p.next;
        }
        return min;
    }    
    //Sort the list in ascending order
    public void sortASC() {
        for (Node i=head; i.next!=tail; i=i.next) {
            for (Node j = head; j!=tail; j=j.next) {
                if (j.data>j.next.data) {
                    int t=j.data;j.data=j.next.data; j.next.data=t;
                }
            }
        }        
    }
    public void sortASCXXX() {
        for (int i = 0; i < countNode()-1; i++) {
            Node p=head;
            for (int j = 0; j < countNode()-i-1; j++) {
                if (p.data>p.next.data) {
                    int t=p.data; p.data=p.next.data; p.next.data=t;
                }
                p=p.next;
            }
        }
    }    
    //Sort the list in descending order
    public void sortDesc() {
        for (Node i=head; i.next!=tail; i=i.next) {
            for (Node j = head; j!=tail; j=j.next) {
                if (j.data<j.next.data) {
                    int t=j.data;j.data=j.next.data; j.next.data=t;
                }
            }
        }         
    }
        
    public void sortMax1ToMax3() {
        int posMax1=0, posMax3=0, count=0, k=0;
        Node p=head;
        int max = findMax();
        while (p!=null){
            if (p.data==max) {
                posMax1=count; break;
            }
            count++;
            p=p.next;
        }
        p=head; count=0;
        while (p!=null){
            if (p.data==max) {
                k++;
                if (k==3) {
                    posMax3=count; break;
                }               
            }
            count++;
            p=p.next;
        }       
        sortFromXToY(posMax1, posMax3);
    }
    
    public void sortFromXToY(int pos1, int pos2) {
        for (Node i=getNodeAtPos(pos1); i.next!=getNodeAtPos(pos2); i=i.next) {
            for (Node j = getNodeAtPos(pos1) ; j!=getNodeAtPos(pos2); j=j.next) {
                if (j.data>j.next.data) {
                    int t=j.data;j.data=j.next.data; j.next.data=t;
                }
            }
        }         
    }
    
    public void f20_DelRightBeforeFirstMax() {
        int max=findMax();
        int pos=0;
        Node p=head;
        if (p.data==max) return;
        while (p.next!=null){
            if (p.next.data==max) {
                delNodeAtPos(pos); break;
            }
            pos++;
            p=p.next;
        }
    }
    public void f21_UpdateRightAfterSecondMax(int x) {
        int max=findMax();
        int k=0, count=0;
        Node p=head;
        while (p!=null){
            if (p.data==max) {
                k++;
                if (k==2) {
                    if (p.next!=null) {
                        modifyNodeAtPos(x, count+1);
                        break;
                    }
                }                
            }
            count++;
            p=p.next;
        }
        if (k<2) {
            return;
        }        
    }    
    //Get value at pos
    public Node getNodeAtPos(int pos){
        Node p=head;
        int count=0;
        while(p!=null){
            if (count==pos) return p;            
            count++;
            p=p.next;
        }
        return null;
    } 
    
    public int getValueAtPos(int pos){
        int rs=-999;
        if (pos>=0 && pos<countNode()) {
            Node p=head;
            int count=0;
            while (p!=null){
                if (count==pos) {
                    rs=p.data;
                    break;
                }
                count++;
                p=p.next;
            }
        }
        return rs;
    }
    
    public void delFirst(){
        if (!isEmpty()) {
            if (head.next==null) {
                head=tail=null;
            }else{
                head=head.next;
            }
        }
    }
    
    public void delLast(){
        if (!isEmpty()) {
            if (head.next==null) {
                head=tail=null;
            } else {
                Node p=head;
                while(p.next.next!=null){
                    p=p.next;
                }
                p.next=null;
                tail=p;
            }
        }
    }
    
    public void delNodeAtPos(int pos){
        if (!isEmpty() && pos>=0 && pos<countNode()) {
            if (pos==0) {
                delFirst(); return;
            }
            if (pos==countNode()-1) {
                delLast(); return;
            }
            int count=0;
            Node p=head;
            while (p!=null)    {
                if (count==pos-1) {
                    p.next=p.next.next;
                    return;
                }
                count++;
                p=p.next;
            }
        }
    }
    
    public int countNode(){
        Node p=head;
        int count=0;
        while (p!=null){
            count++;
            p=p.next;
        }
        return count;
    }
    
    public void modifyNodeAtPos(int x, int pos){
        int count=0;
        Node p=head;
        while(p!=null){
            if (count==pos) {p.data=x; break;}
            count++;
            p=p.next;
        }
    }
    
    public void DisplayList(){
        Node p = head;
        while (p!=null){
            System.out.print(p.data+" ");
            p=p.next;
        }
    } 
    
    public void readData(String fname){
        try {
            RandomAccessFile rf = new RandomAccessFile(fname, "r");
            String line = rf.readLine();
            String[] arr = line.trim().split("\\s+");
            for (int i = 0; i < arr.length; i++) {
                int x = Integer.parseInt(arr[i]);
                    addLast(x);
//                if (x%2==0) addFirst(x);
//                else addLast(x);
            }            
            rf.close();
        } catch (Exception e) {
            System.out.println(e);
        }        
    }    
    
    void sortFirstKElement(int k){
        for (int i = 0; i < k - 1;i++ ){
            int count = 0;
            for(Node pj = head; count < k - 1; pj = pj.next) {
                count++;
                if(pj.data > pj.next.data) {
                    int temp = pj.data;
                    pj.data = pj.next.data;
                    pj.next.data = temp;
                }
            }
        }
    }
    
    void sortLastKElements(int k){
        int count = countNode() - k;
        Node pi = head,pj;
        while(count-- > 0) pi = pi.next;
        
        while(pi != null) {
            pj = pi.next;
            while(pj != null){
               if(pj.data > pj.next.data) {
                    int temp = pj.data;
                    pj.data = pj.next.data;
                    pj.next.data = temp;
                }
               pj=pj.next;
            }
        }
    }
    
    void reverse(){
        Node prev = null, current = head, next;
        boolean updateTail = false;
        while (current != null) {
            next = current.next;
            current.next = prev;
            if(!updateTail) {
                tail = current;
                updateTail = true;
            }
            prev = current;
            current = next;
        }
        head = prev;
    }
    
    
    void revesreFirstKElements(int k){
        Node temp = head, connect;
        while(k-- > 1)temp = temp.next;
        connect = temp.next;
        temp.next = null;
        
        Node prev = null, current = head, next;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
                    
        }
                head = prev;
    }
    
    void reverseLastKElement(int k) {
        int count = countNode() - k;
        Node connect = head;
        while (count-- > 1) connect = connect.next;
        Node prev = null, current = connect.next, next;
        connect.next = tail;
        while (current != null) {
            next = current.next;
            current.next = prev;
          
            prev = current;
            current = next;
        }
        
    }
    
    
}
