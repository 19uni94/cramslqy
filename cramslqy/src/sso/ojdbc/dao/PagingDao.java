package sso.ojdbc.dao;

import java.util.List;

/**
 * @author Ken
 * @version 創建時間：2016-02-02
 */
public interface PagingDao {

	List query(final String sql) throws Exception;

    List query(String sql, Object[] args) throws Exception;
    
    public List query2(final String sql, final Object[] args) throws Exception;

    /**
     * zero base
     */
    List query(String sql, Object[] args, int startPage, int pageCount) throws Exception;
    
    /**
     * zero base
     */
    List query(String sql, int startPage, int pageCount) throws Exception;
	
}
