package com.water.music.util;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public
class JdbcPool {
    private static
    List<Connection> connections = new ArrayList<>(8);

    private static int offset = 0;
    static {
        for(int i = 0 ; i< 8 ;i++){
            connections.add(JdbcUtil.getJdbcUtil("mysql").getConnection());
        }
    }
    public static synchronized Connection borrowCon(){
        Connection con = connections.get(offset);
        if(offset > 6){
            offset--;
        }else {
            offset++;
        }
        return con;
    }

    public static Connection returnCon(){
        return null;
    }

    public int getPoolSize(){
        return connections.size();
    }
}
