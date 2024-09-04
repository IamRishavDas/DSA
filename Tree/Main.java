package DSA.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node{
    public int data;
    public Node left = null;
    public Node right = null;
    public Node(int key){
        this.data = key;
    }
}

public class Main {

    public static void preorderRecusrive(Node node){
        if(node == null) return;
        System.out.print(node.data + " ");
        preorderRecusrive(node.left);
        preorderRecusrive(node.right);
    }

    public static void inorderRecursive(Node node){
        if(node == null) return;
        inorderRecursive(node.left);
        System.out.print(node.data + " ");
        inorderRecursive(node.right);
    }

    public static void postorderRecursive(Node node){
        if(node == null) return;
        postorderRecursive(node.left);
        postorderRecursive(node.right);
        System.out.print(node.data + " ");
    }

    public static List<List<Integer>> levelOrder(Node root){
        if(root == null) return new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> sublist = new LinkedList<>();
            int levelNum = q.size();
            for(int i=0; i<levelNum; i++){
                if(q.peek().left != null) q.add(q.peek().left);
                if(q.peek().right != null) q.add(q.peek().right);
                sublist.add(q.remove().data);
            }
            wrapList.add(sublist);
        }
        return wrapList;

    }

    public static Node tree(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        return root;
    }
    public static void main(String[] args) {
        // preorderRecusrive(tree()); System.out.println();
        // inorderRecursive(tree()); System.out.println();
        // postorderRecursive(tree()); System.out.println();
        System.out.println(levelOrder(tree()));
    }
}
