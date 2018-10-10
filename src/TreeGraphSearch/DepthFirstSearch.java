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

    public List<Node> searchTree(T value, int depth, String Strategy) {
        if (Strategy.equals("DFS")) {
            return DFS(value, new Stack(), new Stack(), new HashSet<Node>(), root, depth);
        }

        if (Strategy.equals("BFS")) {
            return BFS(value, root, depth);
        }

        throw new IllegalArgumentException(Strategy + " Unknown strategy");
    }

    private List<Node> DFS(T value, Stack<Node> fringe, Stack<Node> currentPath, Set<Node> explored, Node root, int depth) {
        if (root == null || depth == -1) {
            return null;
        }
        currentPath.add(root);
        explored.add(root);

        if (((Node) currentPath.peek()).getValue().equals(value)) {
            return currentPath;
        }

        int added = 0;
        for (Node n : (ArrayList<Node>) root.getNeighbours()) {
            if (!explored.contains(n)) {
                fringe.add(n);
                ++added;
            }
        }
        List<Node> path = null;

        for (int i = 0; i < added; ++i) {

            path = DFS(value, (Stack) fringe, (Stack) currentPath.clone(), explored, (Node) fringe.pop(), depth - 1);
            if (path != null) {

                return path;
            }
        }

        return null;

    }

    private List<Node> BFS(T value, Node root, int depth) {

        List<Stack<Node>> queue = new LinkedList();
        Stack<Node> tmp = new Stack();
        tmp.add(root);
        queue.add(tmp);
        Stack<Node> newPath = null;
        Stack<Node> path;
        while (!queue.isEmpty()) {
            path = queue.get(0);
            queue.remove(0);
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

        //System.out.println(possiblePaths.get(0).get(0).getValue());
        return null;
    }
}
