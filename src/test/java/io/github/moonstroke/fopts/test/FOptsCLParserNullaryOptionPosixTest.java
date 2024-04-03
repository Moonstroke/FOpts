package io.github.moonstroke.fopts.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.github.moonstroke.fopts.CLParser;

class FOptsCLParserNullaryOptionPosixTest {

	private static final String SHORT_NAME = "o";
	private static final String LONG_NAME = "option";
	private static final String BAD_SHORT_NAME = "opt";

	private static final String SHORT_OPTION = "-o";
	private static final String LONG_OPTION = "--option";
	private static final String BAD_LONG_OPTION = "-option";
	private static final String SHORT_OPTION_UPPERCASE = "-O";
	private static final String LONG_OPTION_UPPERCASE = "--OPTION";
	private static final String OPTIONS_END_MARKER = "--";

	private CLParser parser;
	private NullaryCallback callback;


	@BeforeAll
	void initParser() {
		parser = new CLParser();
		parser.optStyle(CLParser.OptStyle.POSIX);
		callback = new NullaryCallback();
	}

	@Test
	void testAddOptionShortName() {
		parser.addOption(SHORT_NAME, callback);
		parser.parse(new String[] { SHORT_OPTION });
		assertTrue(callback::wasCalled);
	}

	@Test
	void testAddOptionLongName() {
		parser.addOption(LONG_NAME, callback);
		parser.parse(new String[] { LONG_OPTION });
		assertTrue(callback::wasCalled);
	}

	@Test
	void testAddOptionBothNamesParseShortName() {
		parser.addOption(LONG_NAME, SHORT_NAME, callback);
		parser.parse(new String[] { SHORT_OPTION });
		assertTrue(callback::wasCalled);
	}

	@Test
	void testAddOptionBothNamesParseLongName() {
		parser.addOption(LONG_NAME, SHORT_NAME, callback);
		parser.parse(new String[] { LONG_OPTION });
		assertTrue(callback::wasCalled);
	}

	@Test
	void testAddOptionBothNamesParseLongNameExpectsTwoDashes() {
		parser.addOption(LONG_NAME, SHORT_NAME, callback);
		assertThrows(IllegalArgumentException.class, () -> parser.parse(new String[] { BAD_LONG_OPTION }),
		             "Option " + LONG_NAME + " expects no argument");
	}

	@Test
	void testAddOptionNullaryBothNamesExpects1CharShortName() {
		assertThrows(IllegalArgumentException.class, () -> parser.addOption(LONG_NAME, BAD_SHORT_NAME, callback),
		             "POSIX short option name must be a single character");
	}

	@Test
	void testAddOptionBothNamesParseShortNameIsCaseSensitive() {
		parser.addOption(LONG_NAME, SHORT_NAME, callback);
		parser.parse(new String[] { SHORT_OPTION_UPPERCASE });
		assertFalse(callback::wasCalled);
	}

	@Test
	void testAddOptionBothNamesParseLongNameIsCaseSensitive() {
		parser.addOption(LONG_NAME, SHORT_NAME, callback);
		parser.parse(new String[] { LONG_OPTION_UPPERCASE });
		assertFalse(callback::wasCalled);
	}

	@Test
	void testAddOptionBothNamesParseMarkerEndsParsing() {
		parser.addOption(LONG_NAME, SHORT_NAME, callback);
		parser.parse(new String[] { OPTIONS_END_MARKER, LONG_OPTION });
		assertFalse(callback::wasCalled);
	}
}
