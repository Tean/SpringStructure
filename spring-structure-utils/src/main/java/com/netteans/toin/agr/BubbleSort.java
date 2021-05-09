package com.netteans.toin.agr;

import java.util.Comparator;

public class BubbleSort<T extends Comparable> implements ISort<T> {
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
        return null;
    }

    private T[] sort0(T[] arr, boolean asc, Comparator<T> c) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (i == j) {
                    continue;
                }
                if ((c.compare(arr[i], arr[j]) > 0 && asc) || (c.compare(arr[i], arr[j]) < 0 && !asc)) {
                    T t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
        return arr;
    }
}