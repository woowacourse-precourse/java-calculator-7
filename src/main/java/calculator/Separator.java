package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Separator {

    private List<String> separators;

    public Separator() {
        this.separators = new ArrayList<>(Arrays.asList(",", ";"));
    }

    public List<String> getSeparators() {
        return separators;
    }

    public String containCustomSeparator(String input) {
        if (input.startsWith("//")) {
            System.out.println("// 포함");
        }
        if (input.contains("\\n")) {
            System.out.println("개행 포함");
        }
        if (input.startsWith("//") && input.contains("\\n")) {
            separators.add(input.substring(2, 3));
            this.separators = List.copyOf(separators);
            System.out.println("구분자 적용 후 입력: " + input.substring(5));  // 디버깅용 출력
            return input.substring(5);
        }
        return input;
    }

    public String getRegex() {
        return String.join("|", separators);
    }


}
