package TreeGraphSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Joseph
 * @github joseph94m
 */
public class DepthFirstSearch<T extends Object> {

    private Node root;

    public DepthFirstSearch(Node root) {
        this.root = root;
    }

    public List<Node> searchTree(T value, String Strategy) {

        return search(value, root, Strategy);

    }

    private List<Node> search(T value, Node root, String Strategy) {
        if (!Strategy.equals("DFS") && !Strategy.equals("BFS")) {
            throw new IllegalArgumentException(Strategy + " Unknown strategy");
        }

        List<Stack<Node>> queue = new LinkedList();
        Stack<Node> tmp = new Stack();
        tmp.add(root);
        queue.add(tmp);
        Stack<Node> newPath = null;
        Stack<Node> path = null;
        while (!queue.isEmpty()) {
            if (Strategy.equals("DFS")) {
                path = queue.get(queue.size() - 1);
                queue.remove(queue.size() - 1);
            }
            if (Strategy.equals("BFS")) {
                path = queue.get(0);
                queue.remove(0);
            }

            if (path.peek().getValue().equals(value)) {
                return path;
            }
            List<Node> neighbours = path.peek().getNeighbours();
            for (Node n : neighbours) {
                if (!path.contains(n)) {
                    newPath = (Stack<Node>) path.clone();
                    newPath.add(n);
                    queue.add(newPath);
                }
            }

        }

        return null;
    }
}
