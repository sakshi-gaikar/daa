
import java.util.*;

class Huffman {
    static class Node {
        char ch;
        int freq;
        Node left, right;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    static Map<Character, String> codes = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> a.freq - b.freq
        );

        for (char c : text.toCharArray()) {
            if (codes.containsKey(c)) continue;

            int count = 0;
            for (char x : text.toCharArray())
                if (x == c) count++;

            pq.add(new Node(c, count));
            codes.put(c, "");
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node('-', left.freq + right.freq);
            parent.left = left;
            parent.right = right;

            pq.add(parent);
        }

        System.out.println("\nHuffman Codes:");
        printCodes(pq.poll(), "");

        String encoded = "";
        for (char c : text.toCharArray())
            encoded += codes.get(c);

        System.out.println("\nOriginal Text: " + text);
        System.out.println("Encoded Text: " + encoded);

        sc.close();
    }

    static void printCodes(Node root, String code) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            codes.put(root.ch, code.isEmpty() ? "0" : code);
            System.out.println(root.ch + " : " + root.freq + ":"+ codes.get(root.ch));
            return;
        }
        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }}

