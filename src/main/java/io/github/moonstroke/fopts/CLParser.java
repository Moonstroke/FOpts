package io.github.moonstroke.fopts;

import java.util.concurrent.Callable;
import java.util.function.Consumer;

/**
 * A simple, fluent, low-boilerplate command-line options parser.
 *
 * It implements an event-driven framework, using user-supplied callbacks to
 * interact with the options encountered.
 *
 * @author Moonstroke
 */
public class CLParser {

	/**
	 * Declare an option taking no argument.
	 *
	 * @param name     The name of the option
	 * @param callback The function to call upon encountering the option
	 *
	 * @return this object
	 */
	public CLParser addOption(String name, Callable<Void> callback) {
		throw new UnsupportedOperationException("Not implemented yet"); // TODO
	}

	/**
	 * Declare an option taking no argument.
	 *
	 * @param longName  The long name of the option
	 * @param shortName The short name of the option
	 * @param callback  The function to call upon encountering the option
	 *
	 * @return this object
	 */
	public CLParser addOption(String longName, String shortName, Callable<Void> callback) {
		throw new UnsupportedOperationException("Not implemented yet"); // TODO
	}

	/**
	 * Declare an option taking one argument.
	 *
	 * @param name     The name of the option
	 * @param callback The function to call upon encountering the option
	 *
	 * @return this object
	 */
	public CLParser addOption(String name, Consumer<String> callback) {
		throw new UnsupportedOperationException("Not implemented yet"); // TODO
	}

	/**
	 * Declare an option taking one argument.
	 *
	 * @param longName  The long name of the option
	 * @param shortName The short name of the option
	 * @param callback  The function to call upon encountering the option
	 *
	 * @return this object
	 */
	public CLParser addOption(String longName, String shortName, Consumer<String> callback) {
		throw new UnsupportedOperationException("Not implemented yet"); // TODO
	}


	/**
	 * Specify to raise an error when an argument is missing to an option, instead
	 * of passing a {@code null} argument value to the callback.
	 *
	 * @return this object
	 */
	public CLParser strictParsing() {
		throw new UnsupportedOperationException("Not implemented yet"); // TODO
	}


	/**
	 * Parse the given command-line arguments.
	 *
	 * @param args The command-line arguments
	 *
	 * @return the number of elements parsed (or, equivalently, the index in the
	 *         array at which the parser stopped processing)
	 *
	 * @throws IllegalArgumentException if the arguments cannot be parsed: an
	 *                                  undeclared option is found or strict parsing
	 *                                  is enabled and an option is missing an
	 *                                  argument.
	 */
	public int parse(String[] args) throws IllegalArgumentException {
		throw new UnsupportedOperationException("Not implemented yet"); // TODO
	}
}
