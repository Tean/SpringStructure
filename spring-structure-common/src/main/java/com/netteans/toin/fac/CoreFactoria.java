package com.netteans.toin.fac;

/**
 * 构建工厂
 *
 * @param <M> 材料泛型
 * @author netteans
 */
public interface CoreFactoria<M, P> {

    /**
     * 填充材料/备件
     *
     * @param mertira 材料
     */
    CoreFactoria<M, P> fill(M mertira);

    P build(IBuild<M, P> build);
}
