public class BinaryTrees {
    public Node root;

    public BinaryTrees(Node root) {
        this.root = root;
    }

    //





    public void insert(Node n, int value) {
        while (true) {
            if (n == null) {
                n = new Node(value, null, null);
                return;
            }

            if (n.key > value) {
                if (n.left == null) {
                    n.left = new Node(value, null, null);
                    break;
                }
                n = n.left;
            }

            if (n.key < value) {
                if (n.right == null) {
                    n.right = n;
                    break;
                }
                n = n.right;
            }
        }
    }




    /// delete- ask bakker to explain
    // find least node in subtree
    // replace node with value
    //delete node
    public void delete(Node n) {
        findMin(Node n);
    }

    public boolean contains(Integer o, Node n) {
        if (n.key == o) return true;
        else if (o>n.key) return contains(o, n.left);
        else if (o<n.key)return contains(o, n.right);
        else return false;
    }

    private int height(Node n) {
        if (n == null) return 0;
        else if (height(n.left) > height(n.right)) {
            return 1 + height(n.left);
        }
        else return 1 + height(n.right);
    }

    Boolean isEmpty() {
        if (root == null) return true;
        else return false;
    }

    private int findMaxHelper(Node n) {
        if (n.right == null) return n.key;
        else return findMaxHelper(n.right);
    }

    private int findMin(Node n) {
        if (n.left == null) return n.key;
        else return findMin(n.left);

    }

    private int size(Node n) {
        if (n==null) return 0;
        return 1 + size(n.right) +size(n.left);
    }

    /// level order iterative:
    ///while q isn't empty
    ///     dequeue
    ///     print value
    ///     enqueue val's left and right
    ///


    /// preorder: left bias, parent-left-right
    ///
    /// postorder left, right, parent
    ///
    /// inorder: left, parent, right


    private void levels() {
    }

    //todo (R): levelOrder, inOrder, postOrder, preOrder, put
    //todo (I): find min/max, search, inOrderTraversal, preOrderTraversal, postOrderTraversal, delete


    //isAllEven
    //sum
    //smallest
    //countLeaves
    //isBalanced (size, depth, shape)
}
