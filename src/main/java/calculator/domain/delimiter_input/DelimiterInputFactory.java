package calculator.domain.delimiter_input;

import calculator.Input;

/**
 * DelimiterInputFactory 클래스는 입력된 문자열에 따라
 * 기본 구분자 또는 커스텀 구분자를 사용하는 DelimiterInput 객체를 생성하는 팩토리 클래스입니다.
 */
public class DelimiterInputFactory {

    /**
     * 입력된 Input 객체를 기반으로 DelimiterInput 객체를 생성합니다.
     * 만약 입력에 커스텀 구분자가 포함되어 있으면 CustomDelimiterInput 객체를,
     * 그렇지 않으면 DefaultDelimiterInput 객체를 반환합니다.
     *
     * @param input 사용자로부터 입력받은 계산할 문자열을 포함하는 Input 객체
     * @return 생성된 DelimiterInput 객체
     */
    public static DelimiterInput createDelimiterInput(Input input) {
        if (isCustomDelimiterInput(input)) {
            return new CustomDelimiterInput(input);
        }

        return new DefaultDelimiterInput(input);
    }

    /**
     * 입력된 Input 객체가 커스텀 구분자를 포함하는지 확인합니다.
     * 커스텀 구분자는 "//"로 시작하는 패턴입니다.
     *
     * @param input 검사할 Input 객체
     * @return 커스텀 구분자가 포함되어 있으면 true, 그렇지 않으면 false
     */
    private static boolean isCustomDelimiterInput(Input input) {
        return input.input().startsWith("//");
    }
}
