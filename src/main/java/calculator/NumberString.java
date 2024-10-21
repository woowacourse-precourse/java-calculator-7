package calculator;

import java.util.List;

/**
 * 문자열에서 커스텀 구분자를 가져오고, 숫자 문자열을 생성하는 유틸 클래스입니다.
 */
public final class NumberString {
    // 유틸리티 클래스의 인스턴스 생성방지
    private NumberString(){

    }

    /**
     * "//"와 "\n"이 문자열의 시작 부분에 있을 때, 두 문자열의 사이의 문자를 추출하는 함수입니다.
     * @param Input null을 입력받으면 {@code NullPointerException}이 발생합니다.
     * @return 커스텀 구분자가 있다면 해당 문자를 반환하고, 없다면 null을 반환합니다
     */
    public static Character getCustomDivider(String Input) {
        if(Input.startsWith("//") && Input.startsWith("\\n", 3)){
            return Input.charAt(2);
        }
        return null;
    }

    /**
     * 문자열에서 숫자 문자열만을 리스트로 파싱하는 함수입니다.
     * 파싱하는 과정 중 잘못된 값이 있을 시 {@code IllegalArgumentException}이 발생합니다.
     * @param input null을 입력받으면 {@code NullPointerException}이 발생합니다.
     * @return 파싱한 숫자 문자열 리스트를 반환합니다.
     */
    public static List<String> parse(String input){
        Character customDivider = getCustomDivider(input);
        if(customDivider != null) {
            // 커스텀 구분자를 가진 문자열은 앞 부분을 제외한 숫자 문자열만을 입력으로 사용
            input = input.substring(5);
        }

        Separator separator = new Separator(customDivider);
        return separator.separate(input);
    }
}
