package com.netteans.toin.agr;

import java.util.Comparator;

public interface ISort<T> {

    T[] sort(T[] arr, boolean asc);

    T[] sort(T[] arr, boolean asc, Comparator<T> comparator);
}
