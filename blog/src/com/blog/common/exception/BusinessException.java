package com.blog.common.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

public class BusinessException extends Exception {
	private Throwable cause;

	public BusinessException(String msg) {
		super(msg);
	}

	public BusinessException(String msg, Throwable ex) {
		super(msg);
		this.cause = ex;
	}

	public Throwable getCause() {
		return (this.cause == null ? this : this.cause);
	}

	public String getMessage() {
		String message = super.getMessage();
		Throwable cause = getCause();
		if (cause != null) {
			message = message + ";BusinessException Exception is " + cause;
		}
		return message;
	}

	public void printStackTrace(PrintStream ps) {
		if (getCause() == null) {
			super.printStackTrace(ps);

		} else {
			ps.println(this);
			getCause().printStackTrace(ps);
		}
	}

	public void printStackTrace(PrintWriter pw) {
		if (getCause() == null) {
			super.printStackTrace(pw);
		} else {
			pw.println(this);
			getCause().printStackTrace(pw);
		}
	}

	public void printStackTrace() {
		printStackTrace(System.err);
	}
}
