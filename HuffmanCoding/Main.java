/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmancoding;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String text = "aaaaaaaaa";
        System.out.println("Tran Binh Minh");

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char character : text.toCharArray()) {
            frequencyMap.put(character, frequencyMap.getOrDefault(character, 0) + 1);
        }

        HuffmanTree huffmanTree = new HuffmanTree(frequencyMap);
        HuffmanCoding huffmanCoding = new HuffmanCoding(huffmanTree, frequencyMap);
        
        huffmanCoding.printCharacterBits();

        String encodedText = huffmanCoding.encode(text);
        System.out.println("Encoded Text: " + encodedText);
        
         int bitCount = huffmanCoding.countBits();
        System.out.println("Total Bits: " + bitCount);

        String decodedText = huffmanCoding.decode(encodedText, huffmanTree.root);
        System.out.println("Decoded Text: " + decodedText);
    }
}
