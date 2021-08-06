package com.example.portfolio.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.lang.NonNull;

public interface BaseDao<T extends Object> extends Serializable {

	T get(@NonNull String id);

	List<T> get(@NonNull Collection<String> id);

	T createOrUpdate(@NonNull T newEntry);

	T delete(@NonNull String id);

	List<T> getAll();

}
