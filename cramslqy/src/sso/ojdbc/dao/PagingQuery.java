package sso.ojdbc.dao;

import java.util.List;

/**
 * @author Ken
 * @version 創建時間：2016-02-02
 */
public interface PagingQuery {

	/**
     * zero base
     * dao must support function : public List query(String sql, Object[] args);
     */
    List query(String sql, Object[] args, int start, int end, PagingDao dao) throws Exception;
    
    List query2(String sql, Object[] args, int start, int end, PagingDao dao) throws Exception;

    /**
     * zero base
     * dao must support function : public List query(String sql, Object[] args);
     */
    List query(String sql, int start, int end, PagingDao dao) throws Exception;
	
}
