package com.uberall.data;

import java.util.List;

public interface Store<T, M> {

	public T get(M searchCriteria);

	default public List<T> getAll() {
		return null;
	}

	public T add(T item);
}
