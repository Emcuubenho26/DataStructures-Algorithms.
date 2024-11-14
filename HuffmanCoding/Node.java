/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmancoding;

import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;

class Node {
    char character;
    int frequency;
    Node left;
    Node right;

    Node(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }
}
