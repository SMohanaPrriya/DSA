package datastructures.Trees;

public class BinarySearchTree {

    private TreeNode root;

    BinarySearchTree () {
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    //insertion
    void insert(int value) {
        if(isNull(getRoot())) {
            root = new TreeNode(value);
            return;
        }
        TreeNode currentNode = getRoot();
        while(true) {
            if(currentNode.getValue() > value) {
                if(isNull(currentNode.getLeft())) {//new left node
                    currentNode.setLeft(new TreeNode(value));
                    return;
                }
                currentNode = currentNode.getLeft();
            } else {
                if(isNull(currentNode.getRight())) {//new right node.
                    currentNode.setRight(new TreeNode(value));
                    return;
                }
                currentNode = currentNode.getRight();
            }
        }
    }

    public boolean isNull(TreeNode node) {
        return  node == null;
    }

    private void printTree(TreeNode node) {
        System.out.print(node.getValue());
        System.out.println();
        int count = 1;
        if(node.getLeft() != null) {
            System.out.print("\t".repeat(Math.max(0, count)) + "Left: ");
            printTree(node.getLeft());
        }
        if(node.getRight() != null) {
            System.out.print("\t".repeat(Math.max(0, count)) +"Right: ");
            printTree(node.getRight());
        }
    }

    //lookup - search for the passed node.
    TreeNode lookup(int value) {
        if(isNull(getRoot())) {
            return null;
        }
        TreeNode currentNode = getRoot();
        while(!isNull(currentNode)) {
            if(currentNode.getValue() == value) {
                return currentNode;
            }
            currentNode = currentNode.getValue() > value ?
                    currentNode.getLeft() :
                    currentNode.getRight();
        }
        return null;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(9);
        tree.insert(4);
        tree.insert(6);
        tree.insert(20);
        tree.insert(170);
        tree.insert(15);
        tree.insert(1);
        System.out.println(!tree.isNull(tree.lookup(9)));
        System.out.println(!tree.isNull(tree.lookup(10)));
        System.out.println(!tree.isNull(tree.lookup(1)));
        System.out.println(!tree.isNull(tree.lookup(1070)));
    }

}
