package org.mybatis.extend.interceptor;

/**
 * SQL的方言
 * @author 牛绍刚
 */
public abstract class Dialect {
    
   /**
    * 方言类型
    */
    public static enum Type {  
        MYSQL,
        ORACLE 
    } 
  
    /** 
     * @descrption 获取分页SQL 
     * @param sql 原始查询SQL 
     * @param offset 开始记录索引（从零开始） 
     * @param limit 每页记录大小 
     * @return 返回数据库相关的分页SQL语句 
     */  
    public abstract String getPageSql(String sql, PageExample pageExample);
}
