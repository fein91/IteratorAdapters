/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteratorstest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import iteratorstest.adapters.*;
import java.io.BufferedInputStream;

/**
 *
 * @author otatarik
 */
public class Main {

    public static void main(String[] args) throws IOException {
     //   testIterToIsAdapter();
        testIsToIterAdapter();
    }

    private static void testIterToIsAdapter() {
        Iterator<Integer> iter = new ArrayIterable<>(new Integer[]{1, 2, 3, 4, 5,}).iterator();
        InputStream is = new BufferedInputStream(new IteratorInputStreamAdapter(iter));
        try {
            int b;
            while ((b = is.read()) != -1) {
                System.out.println(b);
            }

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void testIsToIterAdapter() {
         byte[] buf = {};
        InputStream is = new ByteArrayInputStream(buf);
        Iterator iter = new InputStreamIteratorAdapter(is);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
