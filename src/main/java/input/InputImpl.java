package input;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;
import choose.Choose;
import divide.Divide;
import validate.Validate;

public class InputImpl implements Input {
	private final Validate validate;
	private final Choose choose;
	
	// 의존성 주입 (DI)
	public InputImpl(Validate validate, Choose choose) {
		this.validate = validate;
		this.choose = choose;
	}

	@Override
	public int inputStr() {
		// 문자열 입력 받기
		String str = Console.readLine();
		
		// 문자열 유효성 검사
		if (!validate.isValid(str)) {
			throw new IllegalArgumentException("올바른 값을 입력해주세요.");
		}
		
		// 기본 구분자와 커스텀 구분자 중 무엇을 사용하는지 구별
		Divide divide = choose.chooseStrategy(str);
		
		// 위에서 구별한 기준으로 숫자들을 분리하여 리턴
		int[] numbers = divide.divideNumbers(str);
		
		// 모든 숫자들의 합 리턴
		return Arrays.stream(numbers).sum();
	}
}
