package calculator.numberExtractor;

import java.util.List;

/**
 * 구분자와 숫자문자열을 통해 각 숫자들을 분리/추출하는 역할
 */
public interface NumberExtractor {

    /**
     * @param str        숫자문자열
     * @param separators 구분자 리스트
     * @return 분리된 숫자 리스트
     */
    List<Integer> extract(String str, List<Character> separators);
}
