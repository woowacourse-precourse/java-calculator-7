package calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * 구분자를 저장하고, 저장된 구분자에 의해 주어진 문자열에서 숫자 문자열만을 파싱하는 클래스입니다.
 */
public class Separator {
    /**
     * 기본 구분자는 콜론(:)과 쉼표(,)의 두 가지로, 불변 정적 객체로 선언하여
     * 모든 인스턴스에서 공유되고 변경이 불가능한 값입니다.
     */
    private static final List<Character> defaultDividers = List.of(':', ',');
    /**
     * 구분자들을 저장하는 변수는 불변 객체로, 생성자에서 값을 초기화한 뒤
     * 저장된 값만을 사용합니다.
     */
    private final List<Character> dividers;

    /**
     * 생성자는 커스텀 구분자를 매개변수로 받고, {@code dividers}에 기본 구분자를 포함한
     * 모든 구분자를 저장합니다.
     * @param divider 커스텀 구분자로 쓸 문자이며, null 값은 기본 구분자만을 사용하는
     *                것으로 인식합니다.
     */
    public Separator(Character divider) {
        if (divider == null || defaultDividers.contains(divider)) {
            dividers = defaultDividers;
        } else {
            List<Character> tempDividers = new ArrayList<>(defaultDividers);
            tempDividers.add(divider);
            dividers = List.copyOf(tempDividers);
        }
    }

    /**
     * 저장된 구분자들을 가져오는 getter입니다.
     * @return {@code dividers} 값
     */
    public List<Character> getDividers() {
        return dividers;
    }

    /**
     * 저장된 구분자들을 기준으로 입력받은 값을 나눈 리스트를 반환하는 함수입니다.
     * 입력에 숫자가 아닌 값이 섞여있을 시 {@code IllegalArgumentException}이 발생합니다.
     * @param input 커스텀 구분자와 구분 형식이 제외된 입력 값을 받습니다. null값을
     *              입력받으면 {@code NullPointerException}이 발생합니다.
     *
     * @return 모든 값이 숫자 문자열을 가지는 리스트
     */
    public List<String> separate(String input) {
        List<String> separatedString = new ArrayList<>();
        int offset = 0;

        for (int i = 0; i < input.length(); i++) {
            // 문자가 구분자에 해당하는 경우
            if(dividers.contains(input.charAt(i))) {
                // 바로 이전 문자가 구분자일 경우 빈 값이 저장되는 문제를 방지
                if(offset < i){
                    separatedString.add(input.substring(offset, i));
                }
                offset = i + 1;
            } else if (Character.isDigit(input.charAt(i))) {
                // 문자가 숫자일 시 다음 루프 수행
            } else {
                // 문자가 구분자에도 해당 안되고 숫자도 아닐 시 오류 발생
                throw new IllegalArgumentException("잘못된 입력값입니다.");
            }
        }

        // 저장되지 않은 마지막 숫자 문자열 저장
        if(offset < input.length()) {
            separatedString.add(input.substring(offset));
        }

        return separatedString;
    }
}
