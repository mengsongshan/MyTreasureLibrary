package com.water.music.util;

import org.junit.Test;

public
class JdbcUtilTests {
    JdbcUtil jdbcUtil = JdbcUtil.getJdbcUtil("mysql");

    @Test
    public void testConnectTest(){
        jdbcUtil.testConnect();
    }
}
