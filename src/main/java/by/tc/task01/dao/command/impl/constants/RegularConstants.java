package by.tc.task01.dao.command.impl.constants;

import java.util.regex.Pattern;

public final class RegularConstants {

	public static final Pattern DOUBLE_OR_INT = Pattern.compile("(\\d+\\.\\d+)|(\\d+)");
	public static final Pattern INT = Pattern.compile("^[0-9]+");
	public static final Pattern STRING = Pattern.compile("[a-zA-Z]+");
	public static final Pattern STRING_SPECIFIC_SYMBOL = Pattern.compile("[a-zA-Z0-9-]+");
	public static final Pattern RANGE = Pattern.compile("((\\d+\\.\\d+)|(\\d+))-((\\d+\\.\\d+)|(\\d+))");

	public static final Pattern FINDER = Pattern.compile("([\\w.-]+)=([\\w.-]+)");

	private RegularConstants() {
	}

}
