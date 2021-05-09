package com.netteans.toin.test;

import com.netteans.toin.CoreInjection;
import com.netteans.toin.fac.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCase {

    @BeforeEach
    public void before(){
        System.out.println("before");
    }

    @Test
    public void testLoop(){
        new CoreInjection();
    }

    @Test
    public void test() {
        CoreFactoria<String, Integer> fill = FacProxy.inst(StringIntegerFactoria.class).fill("1");
        Integer builded = fill.build(Integer::parseInt);
        System.out.println(builded);

        CoreFactoria<Double, Double> filld = FacProxy.inst(DoubleModFactoria.class).fill(1.0);
        Double build = filld.build(aDouble -> aDouble * 2);
        System.out.println(build);
    }

}
