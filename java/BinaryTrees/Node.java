class Node{
    int data;
    boolean done ;
    int level ;
    Node left = null;
    Node right = null;

    Node(int x){
        this.data = x;
        this.left = this.right = null;
        this.done = false;
        this.level = -1;
    }


    void right(Node n){
        this.right = n;
    }

    void left(Node n){
        this.left = n;
    }

    public String toString(){
        return Integer.toString(this.data);
    }
}
