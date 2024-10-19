package calculator.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Parser {
	private static final Logger logger = LoggerFactory.getLogger(Parser.class);
	private static final String DEFAULT_SEPARATOR = "[,:]";
	private static final String NUMBER_REGEX = "\\d+";

	public List<Integer> stringToInt(String input) {
		String separator = getSeparator(input);
		String[] items = getItems(input, separator);
		return separateItems(items);
	}

	private String getSeparator(String input) {
		String[] parts = input.split("\n");
		return parts.length > 1 ? parts[0] : DEFAULT_SEPARATOR;
	}

	private String[] getItems(String input, String separator) {
		String[] parts = input.split("\n");
		String content = parts.length > 1 ? parts[1] : input;
		return content.split(separator);
	}

	private List<Integer> separateItems(String[] items) {
		try {
			return Arrays.stream(items)
				.map(String::trim)
				.filter(item -> !item.isEmpty())
				.map(this::parseItem)
				.collect(Collectors.toList());
		} catch (IllegalArgumentException e) {
			logger.log(Level.SEVERE, "잘못된 구분자 에러", e);
			return new ArrayList<>();
		}
	}

	private Integer parseItem(String item) {
		if (item.matches(NUMBER_REGEX)) {
			return Integer.parseInt(item);
		} else {
			throw new IllegalArgumentException("잘못된 구분자: " + item);
		}
	}
}
