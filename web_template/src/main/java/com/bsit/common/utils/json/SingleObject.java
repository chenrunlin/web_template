package com.bsit.common.utils.json;

public class SingleObject<T> extends AbstractJsonObject {

	private static final long serialVersionUID = 4256192728686238769L;

	private T object;

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

}
