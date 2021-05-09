package com.netteans.toin.fac;

import java.lang.reflect.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 工厂构建代理
 *
 * @author netteans
 */
public class FacProxy<T, P> implements InvocationHandler {

    private final Map<Class<? extends CoreFactoria<T, P>>, CoreFactoria<T, P>> invokerClassMap = new ConcurrentHashMap<>();

    private final Class<? extends CoreFactoria<T, P>> cur;

    private FacProxy(Class<? extends CoreFactoria<T, P>> clz) {
        this.cur = clz;
        invokerClassMap.putIfAbsent(clz, new CoreFactoria<T, P>() {
            private T m;

            @Override
            public CoreFactoria<T, P> fill(T mertira) {
                this.m = mertira;
                return this;
            }

            @Override
            public P build(IBuild<T, P> build) {
                return build.build(this.m);
            }
        });
    }

    public static <T, P> CoreFactoria<T, P> inst(Class<? extends CoreFactoria<T, P>> clz) {
        return (CoreFactoria<T, P>) Proxy.newProxyInstance(FacProxy.class.getClassLoader(), new Class[]{clz}, new FacProxy(clz));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (!Object.class.equals(method.getDeclaringClass())) {
            try {
                CoreFactoria<T, P> aClass = invokerClassMap.get(this.cur);
                return method.invoke(aClass, args);
            } catch (InvocationTargetException ite) {
                throw ite;
            }
        }
        return method.invoke(this, args);
    }


}
