/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteratorstest.adapters;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 *
 * @author otatarik
 */
public class IteratorInputStreamAdapter extends InputStream {

    private final Iterator<Integer> iter;

    public IteratorInputStreamAdapter(Iterator<Integer> iter) {
        this.iter = iter;
    }

    @Override
    public int read() throws IOException {
        if (iter.hasNext()) {
            return iter.next();
        } else {
            return -1;
        }
    }

}
