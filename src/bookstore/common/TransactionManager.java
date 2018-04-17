package bookstore.common;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.SQLException;

public class TransactionManager {
	
	public static void begin() {
		try {
			ConnectionManager.getConnection().setAutoCommit(false);
		} catch (SQLException e) {
			throw new TransactionException();
		}
	}
	
	public static void commit() {
		try {
			ConnectionManager.getConnection().setAutoCommit(false);
		} catch (SQLException e) {
			throw new TransactionException();
		}finally {
			ConnectionManager.release();
		}
	}
	
	public static void rollback() {
		try {
			ConnectionManager.getConnection().rollback();
		} catch (SQLException e) {
			throw new TransactionException();
		}finally {
			ConnectionManager.release();
		}
	}
	
	public static class TransactionException extends RuntimeException{
		private static final long serialVersionUID = -4517957987944032232L;

		@Override
		public synchronized Throwable fillInStackTrace() {
			// TODO Auto-generated method stub
			return super.fillInStackTrace();
		}

		@Override
		public synchronized Throwable getCause() {
			// TODO Auto-generated method stub
			return super.getCause();
		}

		@Override
		public String getLocalizedMessage() {
			// TODO Auto-generated method stub
			return super.getLocalizedMessage();
		}

		@Override
		public String getMessage() {
			// TODO Auto-generated method stub
			return super.getMessage();
		}

		@Override
		public StackTraceElement[] getStackTrace() {
			// TODO Auto-generated method stub
			return super.getStackTrace();
		}

		@Override
		public synchronized Throwable initCause(Throwable arg0) {
			// TODO Auto-generated method stub
			return super.initCause(arg0);
		}

		@Override
		public void printStackTrace() {
			// TODO Auto-generated method stub
			super.printStackTrace();
		}

		@Override
		public void printStackTrace(PrintStream arg0) {
			// TODO Auto-generated method stub
			super.printStackTrace(arg0);
		}

		@Override
		public void printStackTrace(PrintWriter arg0) {
			// TODO Auto-generated method stub
			super.printStackTrace(arg0);
		}

		@Override
		public void setStackTrace(StackTraceElement[] arg0) {
			// TODO Auto-generated method stub
			super.setStackTrace(arg0);
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString();
		}
		
	}

}
