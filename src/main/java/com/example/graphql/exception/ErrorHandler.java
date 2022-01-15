package com.example.graphql.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import graphql.validation.ValidationError;

@Component
public class ErrorHandler implements GraphQLErrorHandler{

	@Override
    public List<GraphQLError> processErrors(List<GraphQLError> errors) {
		 List<GraphQLError> clientErrors = errors.stream()
                 .filter(this::isClientError)
                 .collect(Collectors.toList());

         List<GraphQLError> serverErrors = errors.stream()
                 .filter(e -> !isClientError(e))
                 .map(GraphQLErrorAdapter::new)
                 .collect(Collectors.toList());

         System.out.println(clientErrors);
         System.out.println(serverErrors);
         List<GraphQLError> e = new ArrayList<>();
         e.addAll(clientErrors);
         e.addAll(serverErrors);
         return e;
    }

	protected boolean isClientError(GraphQLError error) {
        return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
    }
	
    private GraphQLError getNested(GraphQLError error) {
    	System.out.println(error);
        if (error instanceof ExceptionWhileDataFetching) {
            ExceptionWhileDataFetching exceptionError = (ExceptionWhileDataFetching) error;
            if (exceptionError.getException() instanceof GraphQLError) {
                return (GraphQLError) exceptionError.getException();
            }
        }
        return error;
    }
}
