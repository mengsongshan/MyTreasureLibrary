package com.water.music.util;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.sql.*;
import java.util.*;

public final class JdbcUtil {
    private static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(JdbcUtil.class);

    private static String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Properties JDBC_PROPERTIES;
    private static Connection con;
    private static Map<String,JdbcUtil> jdbcUtils = new HashMap<>();
    private static JdbcUtil jdbcUtil;

    public static JdbcUtil getJdbcUtil(String serverType){
        if(Strings.isNullOrEmpty(serverType)){
            logger.error("please specify server type , can be : oracle|mysql");
            return null;
        }
        if(serverType.equalsIgnoreCase("oracle") || serverType.equalsIgnoreCase("mysql")){
            logger.error("server type nonsupport");
        }

        return new JdbcUtil(serverType);
    }

    private JdbcUtil(String serverType){
        jdbcUtil = jdbcUtils.get(serverType);
        if(jdbcUtil == null){
            init(serverType);
            jdbcUtils.put(serverType,this);
        }
    }

    private void init(String serverType){
        try {
            JDBC_PROPERTIES = new Properties();
            JDBC_PROPERTIES.load((new ClassPathResource("jdbc.properties")).getInputStream());
            if(serverType.equalsIgnoreCase("mysql")){
                Class.forName(MYSQL_DRIVER);
            }else if(serverType.equalsIgnoreCase("oracle")){
                Class.forName(ORACLE_DRIVER);
            }

        } catch (ClassNotFoundException e) {
            logger.error("fail load driver ");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized Connection[] getConnection(int num){
        Connection cons[] = new Connection[num];
        for(int i =0 ; i < num; i++){
            try {
                cons[i] = DriverManager.getConnection(JDBC_PROPERTIES.getProperty("url"),JDBC_PROPERTIES);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cons;
    }

    public synchronized Connection getConnection(){
        if(con == null){
            try {
                 con = DriverManager.getConnection(JDBC_PROPERTIES.getProperty("url"),JDBC_PROPERTIES);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return con;
    }

    public void closeConnection(Connection con){
        if (con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                logger.error("fail close connection ");
            }
        }
    }
    public PreparedStatement getPreparedStatement(String sql) {
        PreparedStatement ps = null;
        try {
           ps = getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (ps != null){
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ps;
    }

    public static int executeSql(String sql){
        return 0;
    }

    public void testConnect(){
        try {
           boolean result = getConnection().createStatement().execute("select count(1) from help_keyword");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
