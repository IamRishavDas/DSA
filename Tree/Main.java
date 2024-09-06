package DSA.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static List<Integer> preorderIterative(Node root){
        if(root == null) return new ArrayList<>();
        ArrayDeque<Node> stack = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node node = stack.pop();
            list.add(node.data);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return list;
    }

    public static List<Integer> inorderIterative(Node root){
        if(root == null) return new ArrayList<>();
        ArrayDeque<Node> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        Node node = root;
        while(true){
            if(node != null){
                stack.push(node);
                node = node.left;
            } else {
                if(stack.isEmpty()) break;
                node = stack.pop();
                list.add(node.data);
                node = node.right;
            }
        }
        return list;
    }

    public static List<Integer> postorderIterative(Node root){
        if(root == null) return new ArrayList<>();
        ArrayDeque<Node> stack1 = new ArrayDeque<>();
        ArrayDeque<Integer> stack2 = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        stack1.push(root);

        while(!stack1.isEmpty()){
            Node node = stack1.pop();
            stack2.push(node.data);
            if(node.left != null) stack1.push(node.left);
            if(node.right != null) stack1.push(node.right);
        }

        while(!stack2.isEmpty()){
            list.add(stack2.pop());
        }

        return list;
    }


    // for the pair of (TreeNode, number of the Node)
    static class StackNode{
        public Node node;
        public int num;
        public StackNode(Node node, int num){
            this.node = node;
            this.num  = num;
        }
    }
    public static List<List<Integer>> preorder_inorder_postorder(Node root){
        if(root == null) return new ArrayList<>();

        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        ArrayDeque<StackNode> stack = new ArrayDeque<>();
        StackNode rootNode = new StackNode(root, 1);
        stack.push(rootNode);
        while(!stack.isEmpty()){
            StackNode node = stack.pop();
            if(node.num == 1){ // for preorder
                preorder.add(node.node.data);
                stack.push(new StackNode(node.node, ++node.num));
                if(node.node.left != null) stack.push(new StackNode(node.node.left, 1));
            } else if(node.num == 2){ // for inorder
                inorder.add(node.node.data);
                stack.push(new StackNode(node.node, ++node.num));
                if(node.node.right != null) stack.push(new StackNode(node.node.right, 1));
            } else if(node.num == 3){ // for postorder
                postorder.add(node.node.data);
            }
        }
        return Arrays.asList(preorder, inorder, postorder);
    }


    // BFS
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
        preorderRecusrive(tree()); System.out.println();
        inorderRecursive(tree()); System.out.println();
        postorderRecursive(tree()); System.out.println();
        // System.out.println(levelOrder(tree()));

        // System.out.println(preorderIterative(tree()));
        // System.out.println(inorderIterative(tree()));
        // System.out.println(postorderIterative(tree()));

        System.out.println(preorder_inorder_postorder(tree()));
    }
}
