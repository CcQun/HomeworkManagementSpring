package org.example.javaee.class01.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @Author CcQun
 * @Date 2020/3/25 14:37
 */
public class DatabasePool {
    private static HikariDataSource hikariDataSource;

    /**
     * 获取数据库连接池
     * @return com.zaxxer.hikari.HikariDataSource
     * @Author CcQun
     * @Date 2020/3/25 15:25
     */
    public static HikariDataSource getHikariDataSource(){
        if(null != hikariDataSource){
            return hikariDataSource;
        }

        synchronized (DatabasePool.class){
            if(null == hikariDataSource){
                String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/school?serverTimezone=GMT";
                HikariConfig hikariConfig = new HikariConfig();
                hikariConfig.setUsername("root");
                hikariConfig.setPassword("Cui5039795891");
                hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
                hikariConfig.setJdbcUrl(jdbcUrl);
                hikariDataSource = new HikariDataSource(hikariConfig);
                return hikariDataSource;
            }
        }

        return null;
    }
}
