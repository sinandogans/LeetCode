public class Main {
    public static boolean isValidBST(TreeNode root) {
        if (root.left != null) {
            if (root.val < root.left.val)
                return false;
            isValidBST(root.left);
        }
        else if (root.right != null) {
            if (root.val > root.right.val)
                return false;
            return isValidBST(root.right);
        }
            return true;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}