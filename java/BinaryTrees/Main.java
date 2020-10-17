import java.math.BigInteger;

import static BinaryTrees.BinaryTreeTraversals.levelorder;

public class Main {

    static void hello(){
        System.out.println("Using Binary trees");
        System.out.println();
        System.out.println();
    }
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left(new Node(2));
        root.right(new Node(3));
        root.left.left(new Node(4));
        root.left.right(new Node(5));
        root.right.left(new Node(6));
        root.right.right(new Node(7));
        levelorder(root);
    }
}
