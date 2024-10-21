package calculator.global;

import calculator.global.api.CalculatorAPI;
import calculator.global.api.JudgmentAPI;
import calculator.global.api.SeparateAPI;
import calculator.global.config.BeanFactory;
import camp.nextstep.edu.missionutils.Console;

import static calculator.global.constants.StaticString.ANSWER_MESSAGE;
import static calculator.global.constants.StaticString.QUESTION_MESSAGE;

public class Answer {
	private String input;
	private final CalculatorAPI calculatorAPI = BeanFactory.calculator();
	private final JudgmentAPI judgmentAPI = BeanFactory.judgement();
	private final SeparateAPI separateAPI = BeanFactory.separate();

	public Answer() {
		System.out.print(QUESTION_MESSAGE.getString());
		this.input = Console.readLine();


		// Custom Separator 이 있는지 확인 및 추가하고 커스텀 폼 삭제
		String separatedInput = separateAPI.separateInput(input);

		// true, false 로 숫자인지 판별한 배열
		boolean[] validNumbers = judgmentAPI.judgmentNumbers(separatedInput.toCharArray());

		// 숫자 추출해서 저장하고 유효한 구분자가 아닐 시 exception
		separateAPI.findNumbers(separatedInput, validNumbers);

		// domain 에 저장된 값들 계산
		int answer = calculatorAPI.answer();
		System.out.print(ANSWER_MESSAGE.getString() + answer);
	}
}
