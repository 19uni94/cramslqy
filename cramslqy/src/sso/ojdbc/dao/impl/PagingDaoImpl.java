package sso.ojdbc.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import sso.ojdbc.dao.PagingDao;
import sso.ojdbc.dao.PagingQuery;

/**
 * @author Ken
 * @version 創建時間：2016-02-02
 */
@SuppressWarnings("rawtypes")
public class PagingDaoImpl implements PagingDao {

	protected JdbcTemplate jdbcTemplate;
    protected JdbcTemplate jdbcTemplate2;
    protected RowMapper rowMapper;
    protected PagingQuery pagingQuery;

	public List query(final String sql) throws Exception {
        return getJdbcTemplate().query(sql, getRowMapper());
    }

    public List query(final String sql, final Object[] args) throws Exception {
        return getJdbcTemplate().query(sql, args, getRowMapper());
    }
    
    public List query2(final String sql, final Object[] args) throws Exception {
        return getJdbcTemplate2().query(sql, args, getRowMapper());
    }

    /**
     * zero base
     */
    public List query(final String sql, final Object[] args, final int start, final int end) throws Exception {
        return pagingQuery.query(sql, args, start, end, this);
    }
    
    /**
     * zero base
     */
    public List query2(final String sql, final Object[] args, final int start, final int end) throws Exception {
        return pagingQuery.query2(sql, args, start, end, this);
    }

    /**
     * zero base
     */
    public List query(final String sql, final int start, final int end) throws Exception {
        return pagingQuery.query(sql, start, end, this);
    }

    /**
     * @return the jdbcTemplate
     */
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    /**
     * @param jdbcTemplate the jdbcTemplate to set
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    /**
     * @return the jdbcTemplate2
     */
    public JdbcTemplate getJdbcTemplate2() {
		return jdbcTemplate2;
	}

    /**
     * @param jdbcTemplate2 the jdbcTemplate2 to set
     */
	public void setJdbcTemplate2(JdbcTemplate jdbcTemplate2) {
		this.jdbcTemplate2 = jdbcTemplate2;
	}

	/**
     * @return the rowMapper
     */
    public RowMapper getRowMapper() {
        return rowMapper;
    }

    /**
     * @param rowMapper the rowMapper to set
     */
    public void setRowMapper(RowMapper rowMapper) {
        this.rowMapper = rowMapper;
    }

    /**
     * @return the pagingQuery
     */
    public PagingQuery getPagingQuery() {
        return pagingQuery;
    }

    /**
     * @param pagingQuery the pagingQuery to set
     */
    public void setPagingQuery(PagingQuery pagingQuery) {
        this.pagingQuery = pagingQuery;
    }
	
}
