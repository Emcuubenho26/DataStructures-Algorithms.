/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmancoding;

import java.util.Map;
import java.util.PriorityQueue;

class HuffmanTree {
    Node root;

    public HuffmanTree(Map<Character, Integer> frequencyMap) {
        //xếp queue theo thứ tự tăng dần để các node có tần số xuất hiện lớn sẽ đươc ở gần gốc nhất <=> các node có tần số xuất hiện thấp sẽ luôn đươc xử lý trước
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((a, b) -> a.frequency - b.frequency);
        
        //getKey là lấy kí tự    // getValue là lấy tần số 
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            priorityQueue.add(new Node(entry.getKey(), entry.getValue()));
        }

        //xử lý logic 
        while (priorityQueue.size() > 1) { // chạy đến khi chỉ còn 1 node -> node ý là gốc của cây
            
            //lấy 2 node có tần số thấp nhất bằng poll()
            //new Node bằng tổng của 2 node vừa poll()
            Node left = priorityQueue.poll();
            Node right = priorityQueue.poll();
            Node newNode = new Node('\0', left.frequency + right.frequency);
                                                            //'\0' là chỉ Node mới ko chứa ký tự, chỉ chứa tổng tần số của 2 node vừa poll()
            //newNode trở thành node cha của 2 node
            newNode.left = left;
            newNode.right = right;
            priorityQueue.add(newNode);
            
            
        }
        //chạy while đén khi còn 1 node thì lấy làm root
        root = priorityQueue.poll();
    }
}
