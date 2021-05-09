package com.netteans.toin.agr;

import java.lang.reflect.Array;
import java.util.*;

public class QuickSort<T extends Comparable> implements ISort<T> {

    @Override
    public T[] sort(T[] arr, boolean asc) {
        return sort0(arr, asc, (o1, o2) -> {
            if (o1 instanceof Comparable && o2 instanceof Comparable) {
                return o1.compareTo(o2);
            }
            return 0;
        });
    }

    @Override
    public T[] sort(T[] arr, boolean asc, Comparator<T> comparator) {
        return sort0(arr, asc, comparator);
    }

    private T[] sort0(T[] arr, boolean asc, Comparator<T> c) {
        if (arr.length < 2) {
            return arr;
        }

        T[] ist = (T[]) Array.newInstance(arr[0].getClass(), 0);
        int m = getMiddleIndex(arr);
        T l = arr[m];
        List<T> lLst = new ArrayList<>();
        List<T> rLst = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i == m) {
                continue;
            }
            if ((c.compare(arr[i], l) > 0 && asc) || (c.compare(arr[i], l) < 0 && !asc)) {
                rLst.add(arr[i]);
            } else {
                lLst.add(arr[i]);
            }
        }
        T[] left = sort0(lLst.toArray(ist), asc, c);
        T[] right = sort0(rLst.toArray(ist), asc, c);

        T[] r = (T[]) Array.newInstance(arr[0].getClass(), arr.length);
        System.arraycopy(left, 0, r, 0, left.length);
        r[left.length] = l;
        System.arraycopy(right, 0, r, left.length + 1, right.length);
        return r;
    }

    private int getMiddleIndex(T[] arr) {
        return 0;
    }
}
