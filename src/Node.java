public class Node<T> {
        public Node<T> left, right;
        public Integer key;

        public Node(Integer key, Node<T> right, Node<T> left) {
            this.right = right;
            this.left = left;
            this.key = key;
        }


    }
