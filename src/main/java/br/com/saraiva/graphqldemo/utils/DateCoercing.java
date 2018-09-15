package br.com.saraiva.graphqldemo.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;

/**
 * Created by sara on set, 2018
 */
public class DateCoercing implements Coercing<Object, String> {

	@Override
	public String serialize(Object dataFetcherResult) throws CoercingSerializeException {
		return ((LocalDateTime) dataFetcherResult)
				.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	}

	@Override
	public Object parseValue(Object input) throws CoercingParseValueException {
		if (input instanceof String) {
			// validate
			LocalDateTime.parse((CharSequence) input);
			return input;
		}
		throw new CoercingParseValueException(
				"Unable to parse variable value " + input + " as an date");
	}

	@Override
	public LocalDateTime parseLiteral(Object input) throws CoercingParseLiteralException {
		if (input instanceof StringValue) {
			return LocalDateTime.parse(((StringValue) input).getValue());
		}
		return null;
	}
}
