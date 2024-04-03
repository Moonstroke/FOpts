package io.github.moonstroke.fopts.test;

import java.util.function.Consumer;

/**
 * Utility class to provide 1-argument callbacks to pass to
 * {@link CLParser#addOption}
 * overloads.
 *
 * @author Moonstroke
 */
class UnaryCallback implements Consumer<String> {

	private boolean called = false;
	private String argument = null;


	/**
	 * The callback function.
	 *
	 * @param arg The callback parameter
	 */
	@Override
	public void accept(String arg) {
		called = true;
		argument = arg;
	}

	/**
	 * Indicate whether the callback has been called.
	 *
	 * @return {@code true} if and only if this callback has been called (at least once)
	 */
	public boolean wasCalled() {
		return called;
	}

	/**
	 * Return the argument that was passed to the callback at the last call.
	 *
	 * @return the last value with which this callback was called, or {@code null} if it has never been called
	 */
	public String getArgument() {
		return argument;
	}
}
