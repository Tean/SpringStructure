package com.netteans.toin;

import com.netteans.toin.fac.CoreFactoria;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 核心注入反射类
 *
 * @author netteans
 */
public class CoreInjection {

    private Map<String, CoreFactoria> coreFactoriaMap = new ConcurrentHashMap<>();

    public CoreInjection() {
        this.doLoop();
    }

    private void doLoop() {
        String path = CoreInjection.class.getResource(".").getPath();
        System.out.println(path);
        path = CoreInjection.class.getResource("/").getPath();
        System.out.println(path);
    }

}
