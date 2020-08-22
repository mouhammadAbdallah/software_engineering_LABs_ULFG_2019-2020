/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPattern;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Moham
 */
public class Set implements ISet, Iterator<Object> {

    ArrayList<Object> array;
    int count = 0;

    public Set() {
        array = new ArrayList();
        count = 0;
    }

    @Override
    public void add(Object o) {
        if (!array.contains(o)) {
            array.add(o);
        }
    }

    @Override
    public boolean app(Object o) {
        return array.contains(o);
    }

    @Override
    public boolean hasNext() {
        if (count == array.size()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        Object ob = array.get(count);
        count++;
        return ob;
    }

}
