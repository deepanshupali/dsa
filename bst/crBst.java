// create balanced binary search tree from sorted array

class Bst {
    class Node {
        int val;
        Node left;
        Node right;
    }

    private Node root;

    // Constructor to create BST from sorted array
    public Bst(int[] arr, int si, int ei) {
        root = CreateTree(arr, si, ei);
    }

    // Build balanced BST from sorted array
    private Node CreateTree(int[] in, int si, int ei) {
        if (si > ei) {
            return null;
        }
        int mid = (si + ei) / 2;
        Node nn = new Node();
        nn.val = in[mid];
        nn.left = CreateTree(in, si, mid - 1);
        nn.right = CreateTree(in, mid + 1, ei);
        return nn;
    }

    public void Display() {
        Display(this.root);
    }

    private void Display(Node nn) {
        if (nn == null) {
            return;
        }
        String str = "";
        str = str + nn.val;
        str = "<--" + str + "-->";
        if (nn.left != null) {
            str = nn.left.val + str;
        } else {
            str = "." + str;
        }
        if (nn.right != null) {
            str = str + nn.right.val;
        } else {
            str = str + ".";
        }
        System.out.println(str);
        Display(nn.left); // left subtree visit
        Display(nn.right); // right subtree visit
    }
}

class Main {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 7, 8, 9, 11, 12 };
        Bst tree = new Bst(arr, 0, arr.length - 1);
        tree.Display();
    }
}
