package calculator;

import java.util.ArrayList;
import java.util.List;

public class Division {
    private static final List<String> word = new ArrayList<>();

    static {
        word.add(":");
        word.add(",");
    }

    public static void add(String customWord) {
        word.add(customWord);
    }

    public static String regularExpression() {
        StringBuilder regularWord = new StringBuilder();
        for (int i = 0; i < word.size(); i++) {
            regularWord.append(word.get(i));
            if (i != word.size() - 1) {
                regularWord.append("|");
            }
        }
        // 정규표현식 사용하는데 있어서, 정규표현식을 사용할 문자열 안에 \ 백슬래시를 온전히 문자로 보기위함
//        regularWord.append("\\\\");
        return String.valueOf(regularWord);
    }

}
