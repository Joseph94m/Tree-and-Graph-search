
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
class Node {

    private char value;
    private ArrayList<Node> neighbours;

    @Override
    public boolean equals(Object obj) {
        if (((Node) obj).getValue() == value) {
            return true;
        }
        return false;
    }

    public ArrayList<Node> getNeighbours() {
        return neighbours;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public void addNeighbour(Node n) {
        neighbours.add(n);
    }

    public char getValue() {
        return value;
    }

    public Node(char value) {
        this.value = value;
        neighbours = new ArrayList<Node>();
    }
}

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
        currentPath.add(root);
        explored.add(root);
        if (((Node) currentPath.peek()).getValue() == value) {
            return currentPath;
        }

        boolean noNeighbours = true;

        for (Node n : root.getNeighbours()) {

            if (n != null) {
                noNeighbours = false;
            }
        }
        if (noNeighbours) {
            return null;
        }

        for (Node n : root.getNeighbours()) {
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

    public static void main(String[] args) {
        Node i = new Node('i');
        Node h = new Node('h');
        Node d = new Node('d');
        Node g = new Node('g');
        Node b = new Node('b');
        b.addNeighbour(h);
        b.addNeighbour(i);
        Node e = new Node('e');
        e.addNeighbour(g);
        Node a = new Node('a');
        a.addNeighbour(d);
        a.addNeighbour(e);
        Node r = new Node('r');
        r.addNeighbour(a);
        r.addNeighbour(b);
        i.addNeighbour(a);
        i.addNeighbour(b);
        h.addNeighbour(g);
        h.addNeighbour(r);
        d.addNeighbour(b);
        d.addNeighbour(h);
        g.addNeighbour(e);
        g.addNeighbour(g);
        DepthFirstSearch ts = new DepthFirstSearch(r);
        char chars[] = {'a', 'b', 'd', 'e', 'g', 'h', 'i'};
        for (char c : chars) {
            List<Node> path = ts.searchTree(c, 15);
            for (Node n : path) {
                System.out.print(n.getValue() + " ");
            }
            System.out.println("");
        }

    }

}
