/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteratorstest.adapters;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author otatarik
 */
public class InputStreamIteratorAdapter implements Iterator<Integer> {

    private final InputStream is;
    private int flag = 0;

    public InputStreamIteratorAdapter(InputStream is) {
        this.is = is;
    }

    @Override
    public boolean hasNext() {
        try {
            if (flag < is.available()) {
                return true;
            }
        } catch (IOException ex) {
            Logger.getLogger(InputStreamIteratorAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Integer next() {
        try {
            //int b;
            is.skip(flag);
            return (Integer) is.read();
        } catch (IOException ex) {
            Logger.getLogger(InputStreamIteratorAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
