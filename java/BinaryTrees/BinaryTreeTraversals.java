import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraversals {

    private static void preorderR_(Node root){
        if(root == null) return;
        System.out.println(root);
        preorderR_(root.left);
        preorderR_(root.right);
    }
    static void preorderR(Node root){
        System.out.println("Recursive pre order traversal");
        preorderR_(root);
        System.out.println();
    }

    private static void inorderR_(Node root){
        if(root == null) return;
        inorderR_(root.left);
        System.out.println(root);
        inorderR_(root.right);
    }
    static void inorderR(Node root){
        System.out.println("Recursive in order traversal");
        inorderR_(root);
        System.out.println();
    }

    static void postorderR_(Node root){
        if(root == null) return;
        postorderR_(root.left);
        postorderR_(root.right);
        System.out.println(root);
    }
    static void postorderR(Node root){
        System.out.println("Recursive post order traversal");
        postorderR_(root);
        System.out.println();
    }

    static void preorderI(Node root){
        System.out.println("Itrerative pre order traversal");
        Stack<Node> S = new Stack<>();
        S.push(root);
        while(S.size()>0){
            Node curr = S.pop();
            System.out.println(curr);
            if(curr.right != null){
                S.push(curr.right);
            }
            if(curr.left != null){
                S.push(curr.left);
            }
        }
        System.out.println();
    }

    static void inorderI(Node root){
        System.out.println("Itrerative in order traversal");
        Stack<Node> S = new Stack<>();
        if(root.right!= null){
            S.push(root.right);
        }
        S.push(root);
        if(root.left!= null){
            S.push(root.left);
        }
        while(S.size()>0){
            Node curr = S.pop();
            if(curr.left == null || curr.left.done){
                System.out.println(curr);
                curr.done = true;
                continue;
            }
            if(curr.right!= null || !curr.right.done){
                S.push(curr.right);
            }
            S.push(curr);
            if(curr.left!= null || !curr.left.done){
                S.push(curr.left);
            }
        }
        System.out.println();
    }

    static void postorderI(Node root){
        System.out.println("Itrerative post order traversal");
        Stack<Node> S = new Stack<>();
        S.push(root);
        if(root.right!= null){
            S.push(root.right);
        }
        if(root.left!= null){
            S.push(root.left);
        }
        while(S.size()>0){
            Node curr = S.pop();
            if(curr.left == null || curr.left.done){
                System.out.println(curr);
                curr.done = true;
                continue;
            }
            S.push(curr);
            if(curr.right!= null || !curr.right.done){
                S.push(curr.right);
            }
            if(curr.left!= null || !curr.left.done){
                S.push(curr.left);
            }
        }
        System.out.println();
    }

    static void levelorder(Node root){
        System.out.println("Iterative Level order traversal");
        Queue<Node> Q = new LinkedList<>();
        root.level = 0;
        Q.add(root);
        int prevLevel = -1;
        while(Q.size()>0){
            Node curr = Q.poll();
            int currLevel = curr.level;
            if(prevLevel != currLevel){
                System.out.println();
                prevLevel = currLevel;
            }
            System.out.print(curr + " ");

            if(curr.left != null){
                curr.left.level = curr.level+1;
                Q.add(curr.left);
            }
            if(curr.right != null){
                curr.right.level = curr.level+1;
                Q.add(curr.right);
            }
        }

    }
}
