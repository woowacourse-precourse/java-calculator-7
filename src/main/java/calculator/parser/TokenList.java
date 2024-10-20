package calculator.parser;

import java.util.Arrays;
import java.util.List;

/**
 * TokenList 클래스는 파싱된 문자열 토큰을 List로 저장하고 관리하는 역할을 합니다.
 */
public class TokenList {
    private final List<String> tokens;

    /**
     * TokenList 생성자입니다. 문자열 배열을 받아 List로 변환하여 저장합니다.
     *
     * @param tokens 파싱된 문자열 토큰 배열
     */
    public TokenList(String[] tokens) {
        this.tokens = Arrays.asList(tokens);
    }

    /**
     * 저장된 문자열 토큰 목록을 반환합니다.
     *
     * @return 문자열 토큰 목록
     */
    public List<String> getTokens() {
        return tokens;
    }
}
