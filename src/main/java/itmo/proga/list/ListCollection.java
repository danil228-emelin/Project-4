package itmo.proga.list;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class ListCollection<E> implements Functionality<E> {
    public E[] values;

    @SuppressWarnings("unchecked")
    public ListCollection() {
        values = (E[]) new Object[0];
    }

    @Override
    public void update(int index, E element) {
        Optional<E> optional = Optional.ofNullable(values[index]);
        if (optional.isPresent()) {
            values[index] = element;
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean add(E e) {

            E[] temp = values;
            values = (E[]) new Object[values.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = e;
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void delete(int index) {

            E[] temp = values;
            values = (E[]) new Object[values.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            System.arraycopy(temp, index + 1, values, index, values.length - index - 1);

    }


    @Override
    public E get(int index) {
        Optional<E> optional = Optional.ofNullable(values[index]);
        return optional.orElse(null);
    }

    @Override
    public int size() {
        return values.length;
    }

    public Stream<E> getStream() {
        return Arrays.stream(values);
    }

}