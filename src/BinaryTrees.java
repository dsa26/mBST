public class BinaryTrees {
    public Node root;

    public BinaryTrees(Node root) {
        this.root = root;
    }

    //still casting as an int
    public void insert(Node root, Node n) {
        Node parent = root;
        Boolean tracking = true;

        if (root == null) {
            root = n;
        }

        while (tracking) {
            if ((int) n.value < (int) parent.value) {
                if (parent.left == null) {
                    parent.left = n;
                    break;
                }
                parent = parent.right;
            }
            if ((int) n.value < (int) parent.value){
                if (parent.right == null) {
                    parent.right = n;
                    break;
                }
                parent = parent.left;
            }
        }
    }

    //smaller values on the left, larger on the right
    private Node findBranch(Integer o, Node<Integer> n) {
        if (n == null) {
            return null;
        } else if (n.left.value == o || n.right.value == o) {
            return n;
        } else if (n.value > o) {
            return findBranch(o, n.left);
        } else {
            return findBranch(o, n.right);
        }
    }

    /// contains

    //how to search for an object that isn't an integer?
    public boolean contains(Integer o) {
        if (findBranch(o, root) == null) return false;
        return true;
    }

    /// delete- ask bakker to explain
    // find least node in subtree
    // replace node with value
    //delete node
    public void delete(Integer o) {
        Node parent = findBranch(o, root);
        if (parent == null) return;
        Node toDeleteLeft = null;
        Node toDeleteRight = null;

        if (parent.left.value == o) {
            Node toDelete = parent.left;

            if (toDelete.left != null) toDeleteLeft = toDelete.left;
            if (toDelete.right != null) toDeleteRight = toDelete.right;

            parent.left = toDeleteRight;
            toDeleteRight.left = toDeleteLeft;

        } else if (parent.right.value == o) {
            Node toDelete = parent.right;

            if (toDelete.left != null) toDeleteLeft = toDelete.left;
            if (toDelete.right != null) toDeleteRight = toDelete.right;

            parent.right = toDeleteLeft;
            toDeleteLeft.right = toDeleteRight;
        }
    }

    /// height
    // verify correctness
    public int FindHeight() {
        if (heightRightHelper(root, 0) > heightLeftHelper(root, 0)) return heightRightHelper(root, 0);
        else return heightLeftHelper(root, 0);
    }


    private int heightRightHelper(Node n, int count) {
        if (n.right == null) return count;
        else return heightRightHelper(n.right, count++);
    }

    private int heightLeftHelper(Node n, int count) {
        if (n.left == null) return count;
        else return heightLeftHelper(n.left, count++);
    }

    /// empty
    Boolean isEmpty() {
        if (root == null) return true;
        return false;
    }

    /// max
    //how to search for object rather than int?
    public int findMax() {
        return findMaxHelper(root);
    }

    private int findMaxHelper(Node n) {
        if (isEmpty()) return 0;
        if (n.right != null) return findMaxHelper(n.right);
        return (int) n.value;
    }

    /// min
    public int findMin() {
        return findMinHelper(root);
    }

    private int findMinHelper(Node n) {
        if (isEmpty()) return 0;
        if (n.left != null) return findMinHelper(n.left);
        return (int) n.value;
    }

    /// size
    public int size() {
        return sizeHelper(root, 0);
    }

    private int sizeHelper(Node n, int count) {
        if (isEmpty()) return 0;
        if (n.right != null) count += sizeHelper(n.right, count++);
        if (n.left != null) count += sizeHelper(n.left, count++);
        return count;
    }


    //todo (R): levelOrder, inOrder, postOrder, preOrder, put
    //todo (I): find min/max, search, inOrderTraversal, preOrderTraversal, postOrderTraversal, delete

}
