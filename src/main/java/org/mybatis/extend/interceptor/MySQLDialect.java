/*
 * Copyright (C), 2012-2013, 苏宁云商股份有限公司电子商务经营总部北京研发中心
 */
package org.mybatis.extend.interceptor;

/**
 * Mysql方言的实现
 * @author 牛绍刚
 */
public class MySQLDialect extends Dialect {
    
    /**
     * 分页sql的处理
     */
    public String getPageSql(String querySelect,  PageExample pageExample) {
    	int offset = pageExample.getRowBounds().getOffset();
    	int limit = pageExample.getRowBounds().getLimit();
        String sql = getLineSql(querySelect); 
        if(sql.toLowerCase().indexOf("found_rows()") > -1){ //select found_rows() 是查询总记录数，不用加limit。
        	return sql;
        }
        int pageSize = 0;
        if(offset <= 0){
            pageSize = 0;
        }else{
            pageSize = (offset - 1) * limit; 
        }
        
        if(sql.toLowerCase().indexOf("select") == 0){//select 开头的sql语句
        	sql = "select SQL_CALC_FOUND_ROWS * from (" + sql + ") pageSql";
        }
        
       // sql = sql.replaceAll("[^\\s,]+\\.", "") + " limit " + pageSize + "," + limit; 
        StringBuilder sb = new StringBuilder(sql);
        if(!sql.toLowerCase().contains("order by") && pageExample.getOrderByClause() != null && pageExample.getOrderByClause().trim().length() > 0){
        	if(pageExample.getOrderByClause().toLowerCase().contains("order by")){
        		sb.append(pageExample.getOrderByClause());
        	}else{
        		sb.append(" order by ").append(pageExample.getOrderByClause());
        	}
        }
        sb.append(" limit ").append(pageSize).append(",").append(limit);
        

        return sb.toString();  
    }
    
    /** 
     * 将SQL语句变成一条语句，并且每个单词的间隔都是1个空格 
     * @param sql SQL语句 
     * @return 如果sql是NULL返回空，否则返回转化后的SQL 
     */  
    private static String getLineSql(String sql) {  
        return sql.replaceAll("[\r\n]", " ").replaceAll("\\s{2,}", " ");  
    } 

}
