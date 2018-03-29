package org.mybatis.extend.interceptor;

/**
 * Oracle方言的实现
 * @author JeromeWang
 */
public class OracleDialect extends Dialect {
    
    /**
     * 分页sql的处理
     */
    public String getPageSql(String querySelect,  PageExample pageExample) {
    	int offset = pageExample.getRowBounds().getOffset();
    	int limit = pageExample.getRowBounds().getLimit();
        String sql = getLineSql(querySelect); 
        if(sql.toLowerCase().indexOf("count(*)") > -1 ){ //select found_rows() 是查询总记录数，不用加limit。
        	return sql;
        }
        int pageSize = 0;
        if(offset <= 0){
            pageSize = 0;
        }else{
            pageSize = (offset - 1) * limit; 
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
        sql = sb.toString();
        sb = new StringBuilder();
        //sb.append(" limit ").append(pageSize).append(",").append(limit);  
        sb.append("select * from (");
        sb.append("select rownum rn,temp_0002.* from ( ");
        sb.append(sql);
        sb.append(") temp_0002 ) where rn > "+pageSize+" and rn<="+(limit+pageSize));
        /*int whereOffset = sql.toLowerCase().lastIndexOf("where");
        int whereEnd = whereOffset+5;
        int orderOffset = sql.toLowerCase().lastIndexOf("order");
        int orderEnd = orderOffset+5;
        if(whereOffset > -1){
        	sb.append(sql.substring(6,whereOffset));//截取select后与最后一个where之间的语句
        	sb.append(" where rownum <= ");
        	sb.append(limit+pageSize);
        	sb.append(" , ");
        	sb.append(sql.substring(whereEnd));
        }else if(orderOffset > -1){
        	sb.append(sql.substring(6,orderOffset));
        	sb.append(" where rownum <= ");
        	sb.append(limit+pageSize);
        	sb.append(" ");
        	sb.append(sql.substring(orderOffset));
        }else{
        	sb.append(" where rownum <= ");
        	sb.append(limit+pageSize);
        	sb.append(" ");
        }
        
        sb.append(") tmp where tmp.rn >= ");
        sb.append(pageSize);*/
        
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
