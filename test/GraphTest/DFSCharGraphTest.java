package GraphTest;

import TreeGraphSearch.CharNode;
import TreeGraphSearch.DepthFirstSearch;
import TreeGraphSearch.Node;
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
 */
public class DFSCharGraphTest {

    DepthFirstSearch ts;

    public DFSCharGraphTest() {

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
        a.addNeighbour(r);
        b.addNeighbour(h);
        b.addNeighbour(i);
        b.addNeighbour(f);
        c.addNeighbour(j);
        c.addNeighbour(b);
        d.addNeighbour(e);
        e.addNeighbour(g);
        j.addNeighbour(k);
        j.addNeighbour(c);
        k.addNeighbour(i);
        f.addNeighbour(r);

        ts = new DepthFirstSearch(r);
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
    public void CharGraphDFS() {

        char chars[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'r'};
        for (char c : chars) {
            List<Node> path = ts.searchTree(c, 15);
            for (Node n : path) {
                System.out.print(n.getValue() + " ");
            }
            System.out.println("");
        }

        char solutions[][] = {
            {'r', 'a'},
            {'r', 'c','b'},
            {'r', 'c'},
            {'r', 'a', 'd'},
            {'r', 'a', 'e'},
            {'r', 'c','b','f'},
            {'r', 'a', 'e', 'g'},
            {'r', 'c','b', 'h'},
            {'r', 'c','b', 'i'},
            {'r', 'c', 'j'},
            {'r', 'c', 'j', 'k'},
            {'r'}
        };

        for (int j = 0; j < chars.length; ++j) {
            List<Node> path = ts.searchTree(chars[j], 15);

            char result[] = new char[path.size()];

            for (int i = 0; i < path.size(); ++i) {
                result[i] = ((Character) (path.get(i).getValue())).charValue();

            }
            Assert.assertArrayEquals(result, solutions[j]);
        }

    }

}
