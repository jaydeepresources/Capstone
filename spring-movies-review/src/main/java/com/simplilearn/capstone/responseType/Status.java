package com.simplilearn.capstone.responseType;

public class Status {

	private boolean success;

	public Status() {
		// TODO Auto-generated constructor stub
	}

	public Status(boolean success) {
		super();
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "Status [success=" + success + "]";
	}

}
