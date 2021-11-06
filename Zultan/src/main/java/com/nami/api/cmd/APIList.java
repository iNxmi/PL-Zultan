package com.nami.api.cmd;

public class APIList<T> {

	public T[] data;
	
	//TODO i dont like this annotation!
	
	@SafeVarargs
	public APIList(T... data) {
		this.data = data;
	}
	
	public T[] getData() {
		return data;
	}
	
}
