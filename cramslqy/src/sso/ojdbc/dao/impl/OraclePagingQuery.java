package sso.ojdbc.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sso.ojdbc.dao.PagingDao;
import sso.ojdbc.dao.PagingQuery;

public class OraclePagingQuery implements PagingQuery {

	/**
     * zero base
     */
    public List query(final String sql, final Object[] args, final int startPage,  final int pageCount, final PagingDao dao) throws Exception {

        List list = (args != null) ? new ArrayList(Arrays.asList(args)) : new ArrayList();
        int start = ((startPage - 1) * pageCount) + 1;
        int end = startPage * pageCount;
        list.add(new Integer(end));
        list.add(new Integer(start));

        return dao.query(getPagingSql(sql), list.toArray());
    }
    
    /**
     * zero base
     */
    public List query2(final String sql, final Object[] args, final int startPage,  final int pageCount, final PagingDao dao) throws Exception {

        List list = (args != null) ? new ArrayList(Arrays.asList(args)) : new ArrayList();
        int start = ((startPage - 1) * pageCount) + 1;
        int end = startPage * pageCount;
        list.add(new Integer(end));
        list.add(new Integer(start));

        return dao.query2(getPagingSql(sql), list.toArray());
    }

    public List query(String sql, int startPage, int pageCount, PagingDao dao) throws Exception {
        return query(sql, null, startPage, pageCount, dao);
    }

    String getPagingSql(final String sql) {
        return "select * from ( select row_.*, rownum rownum_ from (" + sql + ") row_ where rownum <= ?) where rownum_ >= ?";
    }
	
}
