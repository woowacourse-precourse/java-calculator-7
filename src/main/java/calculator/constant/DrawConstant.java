package calculator.constant;

public class DrawConstant {
	public static final String CUSTOM_DELIMITER_START_SIGN = "//";
	public static final int CUSTOM_DELIMITER_FORMULA_NUMBER_START_INDEX = 5;
	public static final int CUSTOM_DELIMITER_INDEX = 2;
	public static final String CUSTOM_DELIMITER_FORMULA_REGEX = "//[^\\d]{1}\\\\n(\\d+([^\\d]{1}\\d+)*)|//[^\\d]{1}\\\\n\\d+";
	public static final String FORMULA_REGEX = "(\\d+([^\\d]{1}\\d+)*)|\\d+";
	public static final String ZERO_SUM_FORMULA_CONTAINS_CUSTOM_DELIMITER_REGEX = "//[^\\d]{1}\\\\n";
	public static final String INEVITABLE_CONTAINS_HYPHEN_FORMAT = "--";
}
