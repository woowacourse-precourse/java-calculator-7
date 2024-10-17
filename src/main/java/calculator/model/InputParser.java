package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class InputParser {
	private final String input;
	List<String> delimiters;

	public InputParser(String input) {
		// 원본 문자열에서 커스텀 구분자를 빼고, delimiters 에 추가한다.
		this.input = removeCustomDelimiter(input);

		// 만약 사용자가 커스텀 구분자를 입력했다면, 커스텀 구분자를 따로 추출해서 구분자 목록에 추가한다..
		List<String> delimiters = Arrays.asList(",", ":");
		extractCustomDelimiter(input).ifPresent(delimiters::add);
		this.delimiters = delimiters;
		validateDelimiter(this.input);
	}

	/**
	 * 핵심 로직
	 */
	// 1차 가공된 입력값에서 숫자를 추출
	public List<Integer> extractNumbers(String input, List<String> delimiters) {
		String[] splitParts = splitInput(input, delimiters);

		return saveNumbers(splitParts);
	}

	// 구분자들을 이용해 정규식을 만들고, 이를 이용해 입력값을 분리
	private String[] splitInput(String input, List<String> delimiters) {
		String regex = String.join("|",
			delimiters.stream()
				.map(Pattern::quote) // 구분자를 정규식에 안전하게 포함 (특수 문자의 경우 혼동의 여지가 있음)
				.toArray(String[]::new)
		);

		return input.split(regex);
	}

	// 분리된 각 부분에서 숫자로 변환하여 리스트에 추가
	private List<Integer> saveNumbers(String[] splitParts) {
		List<Integer> numbers = new ArrayList<>();
		Arrays.stream(splitParts)
			.map(String::trim)
			.filter(s -> !s.isEmpty())
			.forEach(part -> {
				validateNumber(part);
				numbers.add(Integer.parseInt(part));
			});

		return numbers;
	}

	private void validateNumber(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("구분자 사이에 숫자가 아닌 값이 포함되어 있습니다.");
		}
	}

	/**
	 * 문자열 전처리
	 */
	// 입력값에서 커스텀 구분자를 추출 (없을 수 있음)
	private Optional<String> extractCustomDelimiter(String input) {
		Optional<String> customDelimiter = Optional.empty();

		if (hasCustomDelimiter(input)) {
			int delimiterStart = input.indexOf("//") + 2;
			int delimiterEnd = input.indexOf("\n");

			customDelimiter = Optional.of(input.substring(delimiterStart, delimiterEnd));
		}

		return customDelimiter;
	}

	// 입력값에서 커스텀 구분자를 제거한 문자열을 반환
	public String removeCustomDelimiter(String input) {
		if (hasCustomDelimiter(input)) {
			int delimiterEnd = input.indexOf("\n");

			return input.substring(delimiterEnd + 1); // \n 이후의 문자열 반환
		}

		return input; // 커스텀 구분자가 없을 경우 원본 문자열 반환
	}

	// 입력값에 커스텀 구분자가 있는지 확인
	private boolean hasCustomDelimiter(String input) {
		return input.startsWith("//");
	}

	private void validateDelimiter(String input) {
		if (input.chars()
			.anyMatch(c -> !delimiters.contains(String.valueOf((char)c)))) {
			throw new IllegalArgumentException("입력값에 약속되지 않은 구분자가 포함되어 있습니다.");
		}
	}
}
