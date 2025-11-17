public class Node<T> {
        public Node<T> left, right;
        public T value;

        public Node(T value, Node<T> right, Node<T> left) {
            this.right = right;
            this.left = left;
            this.value = value;
        }


    }
