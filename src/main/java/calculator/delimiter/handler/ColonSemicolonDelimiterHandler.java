package calculator.delimiter.handler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// ,와 :로 이루어진 문자열 처리 핸들러
public class ColonSemicolonDelimiterHandler implements DelimiterHandler {
    @Override
    public List<String> split(String str) throws IllegalArgumentException {
        if (!isSupport(str)) {
            throw new IllegalArgumentException("형식이 일치하지 않습니다.");
        }

        String[] splits = str.split("[,:]");
        if (Arrays.stream(splits).anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException("구분자가 연속해서 있습니다.");
        }
        
        return Arrays.stream(splits)
                .collect(Collectors.toList());
    }

    // 문자열이 비어있지 않으며, 양수 문자열, 콤마(,), 콜론(:)이 들어있는 문자열만 처리한다.
    @Override
    public boolean isSupport(String str) {
        return !str.isEmpty() && str.matches("[\\d,:]*");
    }
}