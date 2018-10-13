package TreeTest;

import TreeGraphSearch.UninformedSearch;
import TreeGraphSearch.*;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joseph
 * @github joseph94m
 */
public class UninformedTreeTest {

    UninformedSearch ts_dfs;
    UninformedSearch ts_bfs;

    public UninformedTreeTest() {

        Node i = new CharNode(new Character('i'));
        Node h = new CharNode(new Character('h'));
        Node d = new CharNode(new Character('d'));
        Node g = new CharNode(new Character('g'));
        Node b = new CharNode(new Character('b'));
        Node e = new CharNode(new Character('e'));
        Node a = new CharNode(new Character('a'));
        Node r = new CharNode(new Character('r'));
        Node c = new CharNode(new Character('c'));
        Node f = new CharNode(new Character('f'));
        Node j = new CharNode(new Character('j'));
        Node k = new CharNode(new Character('k'));

        r.addNeighbour(a);
        r.addNeighbour(b);
        r.addNeighbour(c);
        a.addNeighbour(d);
        a.addNeighbour(e);
        a.addNeighbour(f);
        b.addNeighbour(h);
        b.addNeighbour(i);
        c.addNeighbour(j);
        e.addNeighbour(g);
        j.addNeighbour(k);

        ts_dfs = new DFS(r);
        ts_bfs = new BFS(r);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void CharTreeDFS() {

        char chars[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'r'};

        String strat = "DFS";
        System.out.println("Strategy:" + strat);
        for (char c : chars) {
            List<Node> path = ts_dfs.searchTree(c);
            for (Node n : path) {
                System.out.print(n.getValue() + " ");
            }
            System.out.println("");
        }

        char solutions[][] = {
            {'r', 'a'},
            {'r', 'b'},
            {'r', 'c'},
            {'r', 'a', 'd'},
            {'r', 'a', 'e'},
            {'r', 'a', 'f'},
            {'r', 'a', 'e', 'g'},
            {'r', 'b', 'h'},
            {'r', 'b', 'i'},
            {'r', 'c', 'j'},
            {'r', 'c', 'j', 'k'},
            {'r'}
        };

        for (int j = 0; j < chars.length; ++j) {
            List<Node> path = ts_dfs.searchTree(chars[j]);

            char result[] = new char[path.size()];

            for (int i = 0; i < path.size(); ++i) {
                result[i] = ((Character) (path.get(i).getValue())).charValue();

            }
            Assert.assertArrayEquals(result, solutions[j]);
        }
        System.out.println("");
    }

    @Test
    public void CharTreeBFS() {

        char chars[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'r'};

        String strat = "BFS";
        System.out.println("Strategy:" + strat);
        for (char c : chars) {
            List<Node> path = ts_bfs.searchTree(c);
            for (Node n : path) {
                System.out.print(n.getValue() + " ");
            }
            System.out.println("");
        }

        char solutions[][] = {
            {'r', 'a'},
            {'r', 'b'},
            {'r', 'c'},
            {'r', 'a', 'd'},
            {'r', 'a', 'e'},
            {'r', 'a', 'f'},
            {'r', 'a', 'e', 'g'},
            {'r', 'b', 'h'},
            {'r', 'b', 'i'},
            {'r', 'c', 'j'},
            {'r', 'c', 'j', 'k'},
            {'r'}
        };

        for (int j = 0; j < chars.length; ++j) {
            List<Node> path = ts_bfs.searchTree(chars[j]);

            char result[] = new char[path.size()];

            for (int i = 0; i < path.size(); ++i) {
                result[i] = ((Character) (path.get(i).getValue())).charValue();

            }
            Assert.assertArrayEquals(result, solutions[j]);
        }
        System.out.println("");
    }

}
