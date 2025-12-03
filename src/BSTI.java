public class BSTI {
    public Node root;

    public BSTI(Node root) {
        this.root = root;
    }

    public Boolean search(Integer value) {
        if (root == null) return false;
        Node temp = root;
        while (temp != null) {
            if (value.equals(temp.key)) return true;
            else if (value < temp.key) temp = temp.left;
            else temp = temp.right;
        }
        return false;
    }

    public Integer findMax() {
        if (root == null) return null;
        Node temp = root;
        while (temp.right != null) {
            temp = temp.left;
        }
        return temp.key;
    }

    public Integer findMin() {
        if (root == null) return null;
        Node temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp.key;
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node(value, null, null);
            return;
        }
        Node temp = root;
        while (true) {
            if (temp.key > value) {
                if (temp.left == null) {
                    temp.left = new Node(value, null, null);
                    return;
                }
                temp = temp.left;
            }

            if (temp.key < value) {
                if (temp.right == null) {
                    temp.right = new Node(value, null, null);
                    return;
                }
                temp = temp.right;
            } else return;
        }
    }


}
