package calculator.validation;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	//TODO: "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자를 사용하였는가?, 문자열 도입부에 있는가?(테스트 - 앞쪽에 와 있는지)
	public static boolean isCustomDelimiter(String input){
		Pattern pattern = Pattern.compile("^//(.+)\\n");
		Matcher matcher = pattern.matcher(input);
		return matcher.find();
	}

	//TODO: 쉼표(,) 또는 콜론(:) 구분자 사용 + 추가적인 구분자 + 숫자 말고 다른 것이 있는가? (받기 전에 앞 구분자를 삭제해야함)
	public static boolean isDefaultDelimiters(String input, List<String> delimiters) {
		for (Character c : input.toCharArray()) {
			String s = Character.toString(c);
			if(!Character.isDigit(c) && !delimiters.contains(s)){
				return false;
			}
		}
		return true;
	}


}
