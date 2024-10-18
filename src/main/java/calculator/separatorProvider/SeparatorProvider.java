package calculator.separatorProvider;

import java.util.List;

/**
 * 기본구분자와 커스텀구분자를 제공하는 역할
 */
public interface SeparatorProvider {

    /**
     * 커스텀구분자 문자열을 받아 커스텀구분자들을 분리하여 리스트로 반환한다.
     *
     * @param str 커스텀구분자 문자열
     * @return 분리된 커스텀구분자 리스트
     */
    List<Character> extractCustomSeparator(String str);

    /**
     * 기본구분자들을 반환한다.
     *
     * @return 기본구분자 리스트
     */
    List<Character> getDefaultSeparator();
}
