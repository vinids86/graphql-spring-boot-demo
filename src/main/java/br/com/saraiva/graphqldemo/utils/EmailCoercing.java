package br.com.saraiva.graphqldemo.utils;

import java.util.function.Predicate;
import java.util.regex.Pattern;

import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;

/**
 * Created by sara on set, 2018
 */
public class EmailCoercing implements Coercing<Object, String> {

	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(
			"^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	private Predicate<Object> validEmail = e -> VALID_EMAIL_ADDRESS_REGEX
			.matcher(e.toString()).find();

	private Predicate<Object> isString = o -> o instanceof String;

	@Override
	public String serialize(Object dataFetcherResult) throws CoercingSerializeException {
		if (validEmail.test(dataFetcherResult))
			return (String) dataFetcherResult;
		throw new CoercingSerializeException(
				"Unable to serialize " + dataFetcherResult + " as an email address");

	}

	@Override
	public Object parseValue(Object input) throws CoercingParseValueException {
		if (isString.and(validEmail).test(input)) {
			return input;
		}
		throw new CoercingParseValueException(
				"Unable to parse variable value " + input + " as an email address");

	}

	@Override
	public Object parseLiteral(Object input) throws CoercingParseLiteralException {
		if (isString.and(validEmail).test(input)) {
			return input;
		}
		throw new CoercingParseLiteralException(
				"Value is not any email address : '" + String.valueOf(input) + "'");

	}
}
