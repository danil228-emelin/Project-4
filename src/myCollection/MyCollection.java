package myCollection;

import java.util.Arrays;
import java.util.stream.Stream;

public class MyCollection<E> implements Functionality<E> {
    public E[] values;



    public MyCollection() {
        values = (E[]) new Object[0];
    }

    @Override
    public void update(int index, E element) {
        try {
            values[index] = element;
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean add(E e) {
        try {


            E[] temp = values;
            values = (E []) new Object[values.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = e;
            return true;
        } catch (ClassCastException error) {
            error.printStackTrace();
        }
        return false;
    }

          @Override
    public void delete(int index) {
        try {
            E[] temp = values;
            values = (E []) new Object[values.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            System.arraycopy(temp, index + 1, values, index, values.length - index - 1);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }


    @Override
    public E get(int index) {
        try {
            return values[index];
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int size() {
        return values.length;
    }

 public Stream<E> getStream(){
return Arrays.stream(values);
 }

}