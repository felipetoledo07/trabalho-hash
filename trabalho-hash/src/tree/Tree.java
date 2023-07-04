package tree;

public class Tree {

    private Node root;

    public void insert(int key, Object value) {
        this.root = this.insert(this.root, key, value);
    }

    private Node insert(Node root, int key, Object value) {
        if (root == null) {
            Node node = new Node();
            node.setKey(key);
            node.setValue(value);
            return node;
        } else {
            if (key < root.getKey()) {
                root.setLeft(this.insert(root.getLeft(), key, value));
            } else if (key > root.getKey()) {
                root.setRight(this.insert(root.getRight(), key, value));
            }
            return root;
        }
    }

    public Object remove(int key) {

        return this.remove(key, this.root).getValue();
    }

    private Node remove(int key, Node node) {

        if (node == null) {
            return null;
        }

        if (key > node.getKey()) {
            node.setRight(this.remove(key, node.getRight()));
        } else if (key < node.getKey()) {
            node.setLeft(this.remove(key, node.getLeft()));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                Node substitute = this.min(node.getRight());
                node.setValue(substitute.getValue());
                node.setKey(substitute.getKey());
                node.setRight(this.remove(substitute.getKey(), node.getRight()));
            }
        }
        return node;
    }

    public Node min() {
        return this.min(this.root);
    }

    private Node min(Node node) {

        while (node.getLeft() != null) {
            node = node.getLeft();
        }

        return node;
    }



    public Object get (int key) {
        return  this.get(this.root, key);
    }

    private Object get(Node root, int key) {
        if (root != null) {
            if (key < root.getKey()) {
                return this.get(root.getLeft(), key);
            } else if (key > root.getKey()) {
                return this.get(root.getRight(), key);
            } else {
                return root.getValue();
            }
        } else {
            return null;
        }
    }

    private String print(Node root, int lvl) {
        String out = "";
        for (int i = 0; i < lvl; i++) {
            out += "\t";
        }
        out += root.getKey() + ": " + (root.getValue() != null ? root.getValue() : "null");
        out += "\n";
        out += (root.getLeft() != null ? print(root.getLeft(), lvl + 1) : "");
        out += (root.getRight() != null ? print(root.getRight(), lvl + 1) : "");
        return out;

    }

    @Override
    public String toString() {
        if (this.root != null) {
            return this.print(this.root, 0);
        } else {
            return "empty";
        }
    }

    public void preOrder() {
        preOrder(this.root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void inOrder() {
        inOrder(this.root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node != null) {
            preOrder(node.getLeft());
            System.out.print(node.getValue() + " ");
            preOrder(node.getRight());
        }
    }

    private void postOrder() {
        postOrder(this.root);
        System.out.println();
    }

    public void postOrder(Node node) {
        if (node != null) {
            preOrder(node.getLeft());
            preOrder(node.getRight());
            System.out.print(node.getValue() + " ");
        }
    }
}
