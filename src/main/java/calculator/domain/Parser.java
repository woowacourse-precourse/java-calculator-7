package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import calculator.common.ErrorMessages;
import calculator.common.LoggerFactory;
import calculator.util.SeparatorValidator;

public class Parser {
	private static final Logger logger = LoggerFactory.getLogger(Parser.class);
	private static final String DEFAULT_SEPARATOR = ",:";
	private static final String CUSTOM_SEPARATOR_PREFIX = "//";
	private static final String CUSTOM_SEPARATOR_SUFFIX = "\\\\n";
	private static final String NUMBER_REGEX = "\\d+";

	private final SeparatorValidator separatorValidator;

	public Parser() {
		this.separatorValidator = new SeparatorValidator();
	}

	public List<Integer> parseInput(String input) {
		String separator = getSeparator(input);
		String[] items = getItems(input, separator);
		return separateItems(items);
	}

	private String getSeparator(String input) {
		String[] parts = input.split(CUSTOM_SEPARATOR_SUFFIX);
		return parts.length > 1
			? getCustomSeparator(parts[0])
			: DEFAULT_SEPARATOR;
	}

	private String getCustomSeparator(String part) {
		separatorValidator.validate(part);
		return createRegexPattern(extractSeparator(part));
	}

	private char extractSeparator(String part) {
		return part.charAt(CUSTOM_SEPARATOR_PREFIX.length());
	}

	private String createRegexPattern(char separator) {
		String customSeparator = Pattern.quote(String.valueOf(separator));
		return "[" + customSeparator + DEFAULT_SEPARATOR + "]";
	}

	private String[] getItems(String input, String separator) {
		String[] parts = input.split(CUSTOM_SEPARATOR_SUFFIX);
		String content = parts.length > 1 ? parts[1] : input;
		return content.split(separator);
	}

	private List<Integer> separateItems(String[] items) {
		return Arrays.stream(items)
			.map(String::trim)
			.filter(item -> !item.isEmpty())
			.map(this::parseItem)
			.collect(Collectors.toList());
	}

	private Integer parseItem(String item) {
		if (item.matches(NUMBER_REGEX)) {
			return Integer.parseInt(item);
		}
		logger.log(Level.SEVERE, ErrorMessages.SEPARATOR_NOT_ALLOWED.getMessage());
		throw new IllegalArgumentException(item);
	}
}
