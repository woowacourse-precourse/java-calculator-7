package calculator.parser;

import java.util.Set;
import java.util.StringTokenizer;

public class BasicSeparatorParser implements SeparatorParser{


	private boolean isValid(String text) {
		if (text.length() > 2 && text.startsWith("//")) {
			return true;
		} else {
			throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
		}
	}

	@Override
	public String parse(String text, Set<String> separators) {
		StringTokenizer tokenizer = new StringTokenizer(text, "\\n");
		while (tokenizer.countTokens() > 1){
			String now = tokenizer.nextToken();

			if(isValid(now)){
				String separator = now.substring(2, now.length());
				if(!separators.add(separator)){
					throw new IllegalArgumentException("중복된 구분자입니다.");
				}
			}
		}

		String mathematicalExpression = tokenizer.nextToken();
		return mathematicalExpression;
	}

	@Override
	public String generateRegex(Set<String> separators) {
		if(separators.isEmpty()){
			return "";
		}
		StringBuilder separatorRegex = new StringBuilder();

		for (String separator : separators) {
			separatorRegex.append("|").append(separator);
		}

		separatorRegex.deleteCharAt(0);
		return separatorRegex.toString();
	}

}
