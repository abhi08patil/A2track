package com.dao.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GenericDAOImpl {

		 protected final Log log = LogFactory.getLog(getClass());
		 protected boolean isDebugEnabled=log!=null?log.isDebugEnabled():false;
		 protected boolean isInfoEnabled=log!=null?log.isInfoEnabled():false;
		 protected boolean isErrorEnabled=log!=null?log.isErrorEnabled():false;
		 protected boolean isWarnEnabled=log!=null?log.isWarnEnabled():false;
}
