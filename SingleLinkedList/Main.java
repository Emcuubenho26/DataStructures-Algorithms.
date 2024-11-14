
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MySingleLinkedList myList = new MySingleLinkedList();
//        myList.addLast(5);
//        myList.addLast(3);
        myList.readData("E:\\Temp\\Data.txt");
        myList.DisplayList();
        Scanner sn = new Scanner(System.in);
        int sel, kw = 0, newValue=0, pos1=0, pos2=0;
        menu();
        sel = sn.nextInt();
        sn.nextLine();      //Clear buffer
        switch (sel) {
            case 1:
                myList.DisplayList();
                break;
            case 2:
                System.out.print("Input value to add first: ");
                kw = sn.nextInt();
                myList.addFirst(kw);
                myList.DisplayList();
                break;
            case 3:
                System.out.print("Input value to add last: ");
                kw = sn.nextInt();
                myList.addLast(kw);
                myList.DisplayList();
                break;
            case 4:
                System.out.print("Input value to add odd even: ");
                kw = sn.nextInt();
                myList.myAdd(kw);
                myList.DisplayList();
                break;
            case 5:
                System.out.print("Input value to find its pos: ");
                kw = sn.nextInt();
                myList.DisplayList();
                System.out.println("Postion of " + kw + " is: " + myList.findPos(kw));
                break;
            case 6:
                System.out.print("Input pos: ");
                kw = sn.nextInt();
                myList.DisplayList();
                System.out.println("Value at " + kw + " is: " + myList.getValueAtPos(kw));
                break;
            case 7:
                myList.delFirst();
                myList.DisplayList();
                break;
            case 8:
                myList.delLast();
                myList.DisplayList();
                break;
            case 9:
                System.out.print("Input pos to delete: ");
                kw = sn.nextInt();
                myList.DisplayList();
                myList.delNodeAtPos(kw);
                break;
            case 10:
                System.out.print("Input pos: ");
                kw = sn.nextInt();         
                System.out.print("Input new value: ");
                newValue=sn.nextInt();
                myList.addNodeAtPos(newValue, kw);
                myList.DisplayList();
                break;
            case 11:
                System.out.print("Input pos: ");
                kw = sn.nextInt();         
                System.out.print("Input new value: ");
                newValue=sn.nextInt();
                myList.modifyNodeAtPos(newValue, kw);
                myList.DisplayList();
                break;
            case 12:
                System.out.println("Number of nodes: "+ myList.countNode());                
                break;
            case 13:
                System.out.print("Input value of node to count frequency: ");
                newValue=sn.nextInt();                
                System.out.println("The frequency of node with value as "+newValue + " is: "+myList.countFrequencyOfNode(newValue));
                break;
            case 14:
                System.out.println("The maximum value is: "+myList.findMax());
                break;
            case 15:
                System.out.println("The minimum value is: "+myList.findMin());
                break;
            case 16:                    
//                myList.sortASC();
                myList.sortASCXXX();
                myList.DisplayList();
                break;
            case 17:
                myList.sortDesc();
                myList.DisplayList();
                break;
            case 18:
//                System.out.print("Input pos1 = ");
//                pos1=sn.nextInt();
//                System.out.print("Input pos2 = ");
//                pos2=sn.nextInt();
                myList.DisplayList();
                System.out.println("");
//                myList.sortFromXToY(pos1, pos2);
                myList.sortMax1ToMax3();
                myList.DisplayList();
                break;
            case 19:
                System.out.print("Input value to search: ");
                kw = sn.nextInt();                
                myList.findAllPosOfX(kw);
                break;
            case 20:
                myList.DisplayList();
                System.out.println("");
                myList.f20_DelRightBeforeFirstMax();
                myList.DisplayList(); break;
            case 21:
                myList.DisplayList();
                System.out.println("");
                myList.f21_UpdateRightAfterSecondMax(88);
                myList.DisplayList(); break;
            case 0:
                System.out.println("Bye!!!!");
                break;
            default:
                System.out.println("Select again!");
        }
        System.out.println("");
    }

    public static void menu() {
        System.out.println("\n\n1. Disppay list");
        System.out.println("2. Add a node at the first");
        System.out.println("3. Add a node at the last");
        System.out.println("4. Add odd even");
        System.out.println("5. Find the position of a node");
        System.out.println("6. Get value of a node at pos");
        System.out.println("7. Delete the first node");
        System.out.println("8. Delete node at last");
        System.out.println("9. Delete node at a specific position");
        System.out.println("10. Add a new node at pos");
        System.out.println("11. Update node at pos");
        System.out.println("12. Count number of nodes");
        System.out.println("13. Count the frequency of a node");
        System.out.println("14. Find maximum value");
        System.out.println("15. Find minimum value");
        System.out.println("16. Sort the list ASC");
        System.out.println("17. Sort the list Desc");
        System.out.println("18. Sort special condition");
        System.out.println("19. Find all pos of a node");
        System.out.println("20. Delete a node right before the first Max");
        System.out.println("21. Update value of a node right after the second Max");
        System.out.println("0. Quit!");
        System.out.print("=> Which option would you choose? ");
    }

}
