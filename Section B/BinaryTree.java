// TODO: Just adapt an array instead of using the built in linked list

/*
    This class defines the BinaryTree data structure implementation
*/

import java.util.LinkedList;

public class BinaryTree {
    // Each BinaryTree object will hold a pointer to its root node and keep count of its size
    private Node root;
    private int size = 0;

    // This method adds new node into the binary tree data structure
    public void add(String value) {
        
        try {
            Integer.parseInt(value);
            this.root = addProcess(this.root, value);
        }
        catch(NumberFormatException e) {
            // TODO: Write to error logs
        }
        
    }

    // This method handles the actual process of adding nodes to the binary tree
    private Node addProcess(Node currentNode, String value) {
        // If the current node is null, insert the value into the node
        if (currentNode == null) {
            this.size++;
            return new Node(value);
        }

        // Convert the values into integer
        int baseValue = Integer.parseInt(currentNode.value);
        int targetValue = Integer.parseInt(value);

        // Traverse through the binary tree
        if (targetValue < baseValue) {
            currentNode.left = addProcess(currentNode.left, value);
        } 
        else if (targetValue > baseValue) {
            currentNode.right = addProcess(currentNode.right, value);
        }

        // If there is duplicate value, don't insert the value into the binary tree
        return currentNode;
    }

    // This method returns the size of the binary tree data structure
    public int getSize() {
        return this.size;
    }

    // This method returns the sorted binary tree in string array format
    public String[] toStringArray() {
        // Initialize important data variables
        LinkedList<String> list = new LinkedList<String>();

        // Generate the string array
        toStringArrayProcess(root, list);

        // Return the string array
        return list.toArray(new String[0]);
    }

    // This method handles the actual process of creating the sorted string array from the binary tree
    public void toStringArrayProcess(Node node, LinkedList<String> list) {
        // Traverse throught the binary tree in order
        if (node != null) {
            toStringArrayProcess(node.left, list);
            list.add(node.value);
            toStringArrayProcess(node.right, list);
        }
    }
}