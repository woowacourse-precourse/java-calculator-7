package calculator.delimiter.handler;

import java.util.ArrayList;
import java.util.List;

public class NoDelimiterHandler implements DelimiterHandler {
    @Override
    public List<String> split(String str) {
        if (!isSupport(str)) {
            throw new IllegalArgumentException("형식이 일치하지 않습니다.");
        }
        List<String> ret = new ArrayList<>();
        if (!str.isEmpty()) {
            ret.add(str);
        }
        return ret;
    }

    // 문자열이 비어있거나, 양수만 포함하는 문자열이 들어오는 경우 처리한다.
    @Override
    public boolean isSupport(String str) {
        return str.isEmpty() || str.matches("\\d+");
    }
}
