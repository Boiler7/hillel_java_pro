package hw39.graph;

public class Node {
    int value;
    Node right;
    Node left;

    Node(int value) {
        this.value = value;
        right = left = null;
    }
}