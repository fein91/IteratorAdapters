/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteratorstest;

import java.util.Iterator;
import java.lang.Integer;

/**
 *
 * @author otatarik
 */
class ArrayIterable<T> implements Iterable<T> {

    final T[] arr;

    public ArrayIterable(T[] arr) {
        this.arr = arr;
    }

    @Override
    public Iterator<T> iterator() {
        return new IntIterator<>();
    }

    private class IntIterator<T> implements Iterator<T> {

        private int flag = 0;

        @Override
        public boolean hasNext() {
            if (flag < arr.length) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            return (T) arr[flag++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
