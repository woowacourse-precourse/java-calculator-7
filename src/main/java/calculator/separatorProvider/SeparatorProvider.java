package calculator.separatorProvider;

import java.util.Set;

/**
 * 입력에 따른 구분자를 제공하는 역할
 */
public interface SeparatorProvider {

    /**
     * 구분자를 반환한다.
     * 만약 커스텀구분자가 지정되었을 경우에는 기본구분자를 반환한다.
     *
     * @param separatorPart 구분자부분 문자열
     * @return 구분자 리스트
     */
    Set<Character> getSeparator(String separatorPart);
}
