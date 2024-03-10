import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        Stack<TreeNode> roots = new Stack<>();

        TreeNode currentNode = root;
        TreeNode poppedNode;
        boolean checkLeft = true;
        boolean iterationControl = true;
        while (iterationControl) {
            if(root == null)
                return values;
            if (currentNode.left != null && checkLeft) {
                roots.push(currentNode);
                currentNode = currentNode.left;
                checkLeft = true;
                continue;
            }
            values.add(currentNode.val);
            if (currentNode.right != null) {
                roots.push(currentNode);
                currentNode = currentNode.right;
                checkLeft = true;
                continue;
            }
            if (roots.empty())
                break;
            poppedNode = roots.pop();
            if (poppedNode.left == currentNode) {
                currentNode = poppedNode;
            } else {
                while (poppedNode.left != currentNode) {
                    if (poppedNode == root) {
                        iterationControl = false;
                        break;
                    }
                    currentNode = poppedNode;
                    poppedNode = roots.pop();
                }
                currentNode = poppedNode;
            }
            checkLeft = false;
        }
        return values;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = null;
        root.left.left = null;
        root.left.right = new TreeNode(2);
        root.left.right.left = null;
        root.left.right.right = null;
        System.out.println(inorderTraversal(root));
        System.out.println("Hello world!");
    }
}