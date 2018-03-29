package org.mybatis.extend.interceptor;

import org.apache.ibatis.session.RowBounds;

/**
 * 分页使用的Example基类<br>
 * 
 * @author 牛绍刚
 */
public class PageExample {
	
	protected String orderByClause;
	
    /** 行范围 */
    protected RowBounds rowBounds;

    /**
     * @return the rowBounds
     */
    public RowBounds getRowBounds() {
        return rowBounds;
    }

    /**
     * @param rowBounds the rowBounds to set
     */
    public void setRowBounds(RowBounds rowBounds) {
        this.rowBounds = rowBounds;
    }

    /**
     * 对于空值的判断及处理
     * 
     * @param value 原始值
     * @return 处理后的值
     */
    public static Object empty(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof String) {
            String val = ((String) value).trim();
            if (val.length() == 0 || "%".equalsIgnoreCase(val) || "%%".equalsIgnoreCase(val)
                    || "%null%".equalsIgnoreCase(val) || "%null".equalsIgnoreCase(val) || "null%".equalsIgnoreCase(val)) {
                return null;
            }
        }
        return value;
    }

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}
}
