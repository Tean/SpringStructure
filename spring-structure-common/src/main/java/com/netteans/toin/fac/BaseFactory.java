package com.netteans.toin.fac;

/**
 * 基础工厂类
 *
 * @author netteans
 */
public abstract class BaseFactory<M> implements CoreFactoria<M, Object> {
    private M m;

    @Override
    public CoreFactoria<M, Object> fill(M mertira) {
        return null;
    }

    @Override
    public Object build(IBuild<M, Object> build) {
        return null;
    }
}
