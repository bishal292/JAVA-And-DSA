package customImplementation;

import java.util.Scanner;

public class BinaryTree {
    private Node root;
    private static class Node{
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        Node(int value, Node left , Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public void populate(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Root Node.");
        root = new Node(scanner.nextInt());
        populateTree(scanner,root);
        scanner.close();
    }

    private void populateTree(Scanner scanner, Node node) {
        System.out.println("Do you want to insert Node Left to the node: "+node.value);
        boolean flag = scanner.nextBoolean();
        if (flag){
            System.out.println("Enter Node Left to the node: "+node.value);
            node.left = new Node(scanner.nextInt());
            populateTree(scanner,node.left);
        }

        System.out.println("Do you want to insert Node Right to the node: "+node.value);
        flag = scanner.nextBoolean();
        if (flag){
            System.out.println("Enter Node Right to the node: "+node.value);
            node.right = new Node(scanner.nextInt());
            populateTree(scanner,node.right);
        }
    }

    public void display(){
        display(root,"");
    }

    private void display(Node node, String indent) {
        if (node == null)return;
        System.out.println(indent + node.value);
        display(node.left,indent+"\t");
        display(node.right,indent+"\t");
    }
    
    public void prettyDisplay(){
        prettyDisplay(root,0);
    }

    private void prettyDisplay(Node node, int level) {
        if (node == null)return;
        prettyDisplay(node.right , level +1);

        if (level != 0){
            for (int i = 0;i<level-1;i++){
                System.out.print("|\t\t");
            }
            System.out.println("|------>"+node.value);
        }else{
            System.out.println(node.value);
        }
        prettyDisplay(node.left , level +1);
    }

    static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.populate();
        binaryTree.display();
        binaryTree.prettyDisplay();
    }
}
