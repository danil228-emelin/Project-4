package itmo.proga.tree;

public interface Functionality<K, V> extends Iterable<V> {

    V get(K key);

    boolean insert(K key, V value);

    boolean delete(K key);

    int size();
}
