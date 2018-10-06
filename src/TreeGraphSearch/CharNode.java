package TreeGraphSearch;

/**
 *
 * @author Joseph
 */
public class CharNode<T extends Character> extends Node {

    T value;

    public CharNode(T value) {
        super(value);
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (((Character)((Node) obj).getValue()).equals(new Character(value))) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "" + value;

    }

}
