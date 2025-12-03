public class BSTR {
    public Node root;

    public BSTR(Node root) {
        this.root = root;
    }


    //find node I dont want
    //find least node in subtree
    //replace node with value
    //repeat until last node
    //delete min node if it doesn't
    public void delete(Integer i, Node n) {
        if (n == null) return;

        if (n.left != null && n.left.key == i) {
            Node toDelete = n.left;
            if (toDelete.left == null && toDelete.right == null) {
                n.left = null;
            } else if (toDelete.right != null) {
                Node min = findMin(toDelete.right);
                toDelete.key = min.key;
                delete(min.key, toDelete.right);
            } else {
                n.left = toDelete.left;
            }
            return;
        }

        if (n.right != null && n.right.key == i) {
            Node toDelete = n.right;
            if (toDelete.left == null && toDelete.right == null) {
                n.right = null;
            } else if (toDelete.right != null) {
                Node min = findMin(toDelete.right);
                toDelete.key = min.key;
                delete(min.key, toDelete.right);
            } else {
                n.right = toDelete.left;
            }
            return;
        }

        if (i < n.key) delete(i, n.left);
        else delete(i, n.right);
    }

    public boolean contains(Integer o, Node n) {
        if (n == null) return false;
        if (n.key == o) return true;
        else if (o > n.key) return contains(o, n.right);
        else if (o < n.key) return contains(o, n.left);
        else return false;
    }

    private int height(Node n) {
        if (n == null) return 0;
        else if (height(n.left) > height(n.right)) {
            return 1 + height(n.left);
        } else return 1 + height(n.right);
    }

    Boolean isEmpty() {
        if (root == null) return true;
        else return false;
    }

    private int findMaxHelper(Node n) {
        if (n.right == null) return n.key;
        else return findMaxHelper(n.right);
    }

    private Node findMin(Node n) {
        if (n.left == null) return n;
        else return findMin(n.left);

    }

    private int size(Node n) {
        if (n == null) return 0;
        return 1 + size(n.right) + size(n.left);
    }

    /// WP2

    public void put(Integer key, Node n) {
        if (root == null) {
            root = new Node(key, null, null);
            return;
        }

        if (key < n.key) {
            if (n.left == null) {
                n.left = new Node(key, null, null);
            } else {
                put(key, n.left);
            }
        } else if (key > n.key) {
            if (n.right == null) {
                n.right = new Node(key, null, null);
            } else {
                put(key, n.right);
            }
        }
    }

    //left, parent, right
    public void inOrder(Node n) {
        if (n == null) return;
        inOrder(n.left);
        System.out.print(n.key + " ");
        inOrder(n.right);
    }

    //parent, left, right
    public void preOrder(Node n) {
        if (n == null) return;
        System.out.print(n.key + " ");
        preOrder(n.left);
        preOrder(n.right);
    }

    //left, parent, right
    public void postOrder(Node n) {
        if (n == null) return;
        postOrder(n.left);
        System.out.print(n.key + " ");
        postOrder(n.right);
    }


    //extra problems


    public int countLeaves(Node n) {
        if (n == null) return 0;
        if (n.left == null && n.right == null) return 1;
        return countLeaves(n.left) + countLeaves(n.right);

    }

    public Boolean isBalancedHeight(Node n) {
        if (n == null) return true;
        if (height(n.left) == height(n.right)) return true;
        return false;
    }

    public int sum(Node n) {
        if (n == null) return 0;
        return n.key + sum(n.left) + sum(n.right);
    }


}
