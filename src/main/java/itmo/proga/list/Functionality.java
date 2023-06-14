package itmo.proga.list;

import java.util.stream.Stream;

public interface Functionality<E> {
    boolean add(E element);

    void delete(int index);

    E get(int index);

    int size();

    void update(int index, E e);

    Stream<E> getStream();
}

