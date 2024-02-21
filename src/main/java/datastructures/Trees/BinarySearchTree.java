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

    void remove(int value) {
        if(isNull(getRoot())) {
            return;
        }
        TreeNode currentNode = getRoot();
        TreeNode parentNode = null;

        while(currentNode!=null) {
            if(currentNode.getValue()>value) {
                parentNode = currentNode;
                currentNode = currentNode.getLeft();
            } else if (currentNode.getValue()<value) {
                parentNode = currentNode;
                currentNode = currentNode.getRight();
            } else {

                //CASE1: No Right Child
                if(isNull(currentNode.getRight())) {
                    if(isNull(parentNode)) { //deletion of root node
                        root = currentNode.getLeft();
                    } else {
                        //if parent > current, make CURRENT LEFT child as a LEFT child of parent
                        if(parentNode.getValue() > currentNode.getValue()) {
                            parentNode.setLeft(currentNode.getLeft());
                        }
                        //if parent < current, make CURRENT LEFT child as a RIGHT child of parent
                        if(parentNode.getValue() < currentNode.getValue()) {
                            parentNode.setRight(currentNode.getLeft());
                        }
                    }
                    //CASE2: Right child which doesn't have a left child
                } else if (isNull(currentNode.getRight().getLeft())) {
                    if(isNull(parentNode)) {
                        root = currentNode.getRight();
                    } else {
                        // if current < parent, make current's right child a left child of parent
                        if (currentNode.getValue() < parentNode.getValue()) {
                            parentNode.setLeft(currentNode.getRight());
                        }
                        // if current > parent, make current's right child a right child of parent
                        else if (currentNode.getValue() > parentNode.getValue()) {
                            parentNode.setRight(currentNode.getRight());
                        }
                    }
                } // Option 3: RIGHT CHILD WHICH HAVE LEFT CHILD
                else {
                    if (parentNode == null) {
                        // save reference of left and right nodes of the root
                        TreeNode leftNode = root.getLeft();
                        TreeNode rightNode = root.getRight();
                        // root.right.left node becomes new root
                        root = currentNode.getRight().getLeft();
                        rightNode.setLeft(rightNode.getRight().getRight());
                        // set back the saved reference of left and right nodes of root.
                        root.setLeft(leftNode);
                        root.setRight(rightNode);
                    } else {
                        if (currentNode.getValue() < parentNode.getValue()) {
                            parentNode.setLeft(currentNode.getRight().getLeft());
                        } else if (currentNode.getValue() > parentNode.getValue()) {
                            parentNode.setRight(currentNode.getRight().getLeft());
                        }
                    }
                }
                return;
            }
        }
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
        tree.remove(1);
        tree.printTree(tree.getRoot());
    }

}
