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
public abstract class UninformedSearch<T extends Object> {

    private Node root;

    public  UninformedSearch(Node root) {
        this.root = root;
    }

    public abstract List<Node> searchTree(T value) ;

    protected abstract  List<Node> search(T value, Node root) ;
       
}
