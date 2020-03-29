package com.water.music.controller;

import com.water.music.Bootstrap;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public
class UserControllerTests {

    @Test
    public void oneConnectMutilThreadTest(){
        Bootstrap.OneConnectMutilThread();
    }

    @Test
    public void testList(){
        List<String> list = new ArrayList<>();
        list.add("order");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        list.get(0);
        System.out.println(list.size());
        list.get(1);
        System.out.println(list.size());
    }
}
