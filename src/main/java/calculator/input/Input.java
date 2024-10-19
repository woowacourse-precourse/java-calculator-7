package calculator.input;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * 문자열을 입력받고, 가공합니다.
 */
public class Input {
    private final String startWith;
    private final String endWith;

    /**
     * 구분자 추가를 위한 기준 문자열을 설정합니다.
     * @param startWith 구분자 추가를 위한 문자열의 시작점
     * @param endWith 구분자 추가를 위한 문자열의 끝점
     */
    public Input(String startWith, String endWith) {
        this.startWith = startWith;
        this.endWith = endWith;
    }

    /**
     * 주어진 reader 로 문자열을 입력받아서 가공합니다.
     * @param reader 문자열을 읽는 방법
     * @return (있다면)추가 구분자와 피연산자로 나뉜 문자열 List 를 반환
     * @throws IllegalArgumentException 추가 구분자를 넣을 때, 시작점 혹은 끝점만 존재할 때, 발생합니다
     */
    public List<String> read(Supplier<String> reader) {
        String content = reader.get();

        if(content.contains(startWith) ^ content.contains(endWith)) {
            // 어느 한쪽만 있다면, 문법 오류
            throw new IllegalArgumentException("must start with: " + startWith + " and end with: "
                    + endWith + " at the same time");
        }

        List<String> inputs;
        if(content.contains(startWith)) {
            // 구분자 추가 문자열이 존재
            inputs = Arrays.asList(content.substring(startWith.length(), content.indexOf(endWith)),
                    content.substring(content.indexOf(endWith) + endWith.length()));
        } else {
            // 피연산자만 존재
            inputs = List.of(content);
        }

        return inputs;
    }
}
