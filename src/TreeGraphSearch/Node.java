package TreeGraphSearch;

import java.util.ArrayList;

/**
 *
 * @author Joseph
 * @github joseph94m
 */
public abstract class Node<T extends Object> {

    private T value;
    private ArrayList<Node> neighbours;

    @Override
    public abstract boolean equals(Object obj);

    public ArrayList<Node> getNeighbours() {
        return neighbours;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void addNeighbour(Node n) {
        neighbours.add(n);
    }

    public T getValue() {
        return value;
    }

    public Node(T value) {
        this.value = value;
        neighbours = new ArrayList<Node>();
    }

    @Override
    public abstract String   toString();
}