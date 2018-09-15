package br.com.saraiva.graphqldemo.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseValueException;
import graphql.schema.GraphQLScalarType;

/**
 * Created by sara on set, 2018
 */
public class Scalars {
	public static GraphQLScalarType dateTime = new GraphQLScalarType("DateTime",
			"DateTime scalar", new Coercing() {
				@Override
				public Object serialize(Object input) {
					return ((LocalDateTime) input)
							.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
				}

				@Override
				public Object parseValue(Object input) {
					if (input instanceof String) {
						// validate
						LocalDateTime.parse((CharSequence) input);
						return input;
					}
					throw new CoercingParseValueException(
							"Unable to parse variable value " + input + " as an date");
				}

				@Override
				public Object parseLiteral(Object input) {
					if (input instanceof StringValue) {
						return LocalDateTime.parse(((StringValue) input).getValue());
					}
					return null;
				}
			});
}