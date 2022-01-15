package com.example.graphql.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class InvalidEmployeeException extends RuntimeException implements GraphQLError {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> extensions = new HashMap<>();

	String message;
	
	public InvalidEmployeeException(String message, int id) {
		super(message);
		this.message=message;
		extensions.put("invalid employeeid", id);
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public List<SourceLocation> getLocations() {
		return null;
	}

	@Override
	public List<Object> getPath() {
		return null;
	}

	@Override
	public Map<String, Object> getExtensions() {
		return extensions;
	}

	@Override
	public ErrorType getErrorType() {
		return ErrorType.DataFetchingException;
	}
}
