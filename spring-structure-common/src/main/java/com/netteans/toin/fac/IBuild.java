package com.netteans.toin.fac;

@FunctionalInterface
public interface IBuild<M, P> {

    P build(M m);
}
