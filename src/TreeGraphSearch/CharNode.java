package TreeGraphSearch;

/**
 *
 * @author Joseph
 * @github joseph94m
 */
public class CharNode<T extends Character> extends Node {

    private T value;

    public CharNode(T value) {
        super(value);
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (((Character) ((Node) obj).getValue()).equals(new Character(value))) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "" + value;

    }

    @Override
    public Object clone() {
      return new CharNode(value);
    }

}
