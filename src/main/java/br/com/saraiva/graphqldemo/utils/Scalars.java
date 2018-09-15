package br.com.saraiva.graphqldemo.utils;

import graphql.schema.GraphQLScalarType;

/**
 * Created by sara on set, 2018
 */
public class Scalars {
	public static GraphQLScalarType dateTime = new GraphQLScalarType("DateTime",
			"DateTime scalar", new DateCoercing());

	public static GraphQLScalarType email = new GraphQLScalarType("Email", "Email scalar",
			new EmailCoercing());
}