package calculator.util;

import calculator.constant.ErrorStatus;
import java.util.Arrays;
import java.util.List;

public class Separator {

    private Separator() {
    }

    public static List<String> separate(String input) {
        if (input.isBlank()) {
            return List.of("0");
        }
        // 커스텀 구분자 구분
        if (input.startsWith("//")) {
            int end = input.indexOf("\\n");
            if (end == -1) {
                throw new IllegalArgumentException(ErrorStatus.NO_SEPARATOR.getMessage());
            }
            String custom = input.substring(2, end);
            input = input.substring(end + 2).replaceAll(custom, ",");
        }
        input = input.replaceAll(":", ",");
        return Arrays.stream(input.split(","))
                .filter(s -> !s.isBlank())
                .toList();
    }
}
