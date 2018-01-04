package com.thinksys.demo.util;

import java.util.List;

public class Response {



	private Object scalarResult;
	private boolean status;
	private List<?> data;

	public List<?> getData() {
		return data;
	}


	public void setData(List<?> data) {
		this.data = data;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public Object getScalarResult()
	{
		return this.scalarResult;
	}


	public void setScalarResult(Object scalarResult)
	{
		this.scalarResult = scalarResult;
	}
}
