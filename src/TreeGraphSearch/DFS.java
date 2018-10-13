/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreeGraphSearch;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Joseph
 */
public class DFS<T extends Object> extends UninformedSearch{
    
    
    @Override
    public  List<Node> search(Object value, Node root) {

        List<Stack<Node>> queue = new LinkedList();
        Stack<Node> tmp = new Stack();
        tmp.add(root);
        queue.add(tmp);
        Stack<Node> newPath = null;
        Stack<Node> path = null;
        while (!queue.isEmpty()) {
                path = queue.get(queue.size() - 1);
                queue.remove(queue.size() - 1);

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
