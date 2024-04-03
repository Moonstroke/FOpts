package io.github.moonstroke.fopts.test;

import java.util.concurrent.Callable;

/**
 * Utility class to provide no-argument callbacks to pass to {@link CLParser#addOption}
 * overloads.
 *
 * @author Moonstroke
 */
public class NullaryCallback implements Callable<Void> {

	private boolean called = false;


	/**
	 * The callback function.
	 */
	@Override
	public Void call() {
		called = true;
		return null;
	}

	/**
	 * Indicate whether the callback has been called.
	 *
	 * @return {@code true} if and only if this callback has been called (at least once)
	 */
	public boolean wasCalled() {
		return called;
	}
}
