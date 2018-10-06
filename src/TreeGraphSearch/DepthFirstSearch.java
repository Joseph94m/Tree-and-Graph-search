package TreeGraphSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Joseph
 */
public class DepthFirstSearch {

    private Node root;

    public DepthFirstSearch(Node root) {
        this.root = root;
    }

    public List<Node> searchTree(char value, int depth) {
        return searchTree(value, new Stack(), new Stack(), new HashSet<Node>(), root, depth);
    }

    private List<Node> searchTree(char value, Stack fringe, Stack currentPath, Set<Node> explored, Node root, int depth) {
        if (root == null || depth == -1) {
            return null;
        }
        if (explored.contains(root)) {
            System.out.println(((Node) root).getValue());
            return null;
        }
        currentPath.add(root);
        explored.add(root);
        if (((Node) currentPath.peek()).getValue().equals(value)) {
            return currentPath;
        }

        boolean noNeighbours = true;

        for (Node n : (ArrayList<Node>) root.getNeighbours()) {

            if (n != null) {
                noNeighbours = false;
            }
        }
        if (noNeighbours) {
            return null;
        }

        for (Node n : (ArrayList<Node>) root.getNeighbours()) {
            if (!explored.contains(n)) {
                fringe.add(n);
            }

        }

        List<Node> path = null;

        for (int i = 0; i < root.getNeighbours().size(); ++i) {

            path = searchTree(value, (Stack) fringe, (Stack) currentPath.clone(), explored, (Node) fringe.pop(), depth - 1);
            if (path != null) {

                return path;
            }
        }

        return null;

    }

}
