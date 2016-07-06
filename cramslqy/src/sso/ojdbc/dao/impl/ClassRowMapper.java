package sso.ojdbc.dao.impl;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

/**
 * 
 * @author Ken
 * @version 創建時間：2016-02-05
 */
public class ClassRowMapper implements RowMapper {

	final Logger logger = Logger.getLogger(getClass());
	static final String METHOD_PREFIX = "set";
	List operations;
	Class clazz;

	public ClassRowMapper(final String className) throws Exception {
		this.clazz = Class.forName(className);
		this.operations = new ArrayList();

		Method[] methods = this.clazz.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			String methodName = method.getName();
			if (!methodName.startsWith(METHOD_PREFIX)) {
				continue;
			}
			Class[] parameterTypes = method.getParameterTypes();
			if (1 != parameterTypes.length) {
				continue;
			}
			Map operation = new HashMap();
			operation.put("setMethod", method);
			operation.put("columnName", methodName.substring(methodName.indexOf(METHOD_PREFIX) + METHOD_PREFIX.length()).toLowerCase());
			operation.put("getMethod", getSuitableMethod(parameterTypes[0].getName()));
			this.operations.add(operation);
		}
	}

	public Object mapRow(final ResultSet rs, final int index) throws SQLException {
		Object object = null;
		try {
			object = clazz.newInstance();
			for (int i = 0; i < operations.size(); i++) {
				try {
					Map operation = (Map) operations.get(i);
					Method setMethod = (Method) operation.get("setMethod");
					String columnName = (String) operation.get("columnName");
					Method getMethod = (Method) operation.get("getMethod");
					setMethod.invoke(object, new Object[] { getMethod.invoke(rs, new Object[] { columnName }) });
				} catch (Exception e) { // some property can not directly get
										// from db column
					// logger.warn("", e);
				}
			}
		} catch (Exception e) {
			logger.error("", e);
			throw new SQLException(e.getMessage());
		}
		return object;
	}

	/*
	 * depends on ResultSet method
	 */
	Method getSuitableMethod(final String className) throws Exception {
		String classShortName = className.substring(className.lastIndexOf(".") + 1);
		String methodName = "get" + classShortName.substring(0, 1).toUpperCase() + classShortName.substring(1);
		if ("Integer".equals(classShortName)) {
			methodName = "getInt";
		}
		Method method = null;
		try {
			method = ResultSet.class.getMethod(methodName, new Class[] { String.class });
		} catch (Exception e) {
			method = ResultSet.class.getMethod("getObject", new Class[] { String.class });
		}
		return method;
	}
	
}
