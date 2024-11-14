/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmancoding;
import java.util.*;
class HuffmanCoding {
    private Map<Character, String> huffmanCodeMap;
     private Map<Character, Integer> frequencyMap;

    public HuffmanCoding(HuffmanTree tree,  Map<Character, Integer> frequencyMap) {
        huffmanCodeMap = new HashMap<>();
        this.frequencyMap = frequencyMap;
        generateCodes(tree.root, "");
    }

    private void generateCodes(Node node, String code) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            huffmanCodeMap.put(node.character, code);
        }
        generateCodes(node.left, code + "0");
        generateCodes(node.right, code + "1");
    }

    public Map<Character, String> getHuffmanCodeMap() {
        return huffmanCodeMap;
    }
    
    
    public void printCharacterBits() {
        System.out.println("Character Bit Representation:");
        for (Map.Entry<Character, String> entry : huffmanCodeMap.entrySet()) {
            char character = entry.getKey();
            String code = entry.getValue();
            int bits = code.length();
            System.out.println("Character: '" + character + "' -> Code: " + code + " (" + bits + " bits)");
        }
    }

    public String encode(String text) {
        StringBuilder encodedText = new StringBuilder();
        for (char character : text.toCharArray()) {
            encodedText.append(huffmanCodeMap.get(character));
        }
        return encodedText.toString();
    }

    public String decode(String encodedText, Node root) {
        StringBuilder decodedText = new StringBuilder();
        Node currentNode = root;
        for (char bit : encodedText.toCharArray()) {
            currentNode = (bit == '0') ? currentNode.left : currentNode.right;
            if (currentNode.left == null && currentNode.right == null) {
                decodedText.append(currentNode.character);
                currentNode = root;
            }
        }
        return decodedText.toString();
    }
    
    
     public int countBits() {
        int totalBits = 0;
        for (Map.Entry<Character, String> entry : huffmanCodeMap.entrySet()) {
            char character = entry.getKey();
            String code = entry.getValue();
            int frequency = frequencyMap.get(character);
            totalBits += code.length() * frequency;
        }
        return totalBits;
    }
}

