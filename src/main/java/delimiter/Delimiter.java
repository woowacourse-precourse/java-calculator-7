package delimiter;

import delimiter.custom.CustomDelimiter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {

    private final String baseDelimiter;
    String customDelimiter = "";
    String delimiters = "";

    private Delimiter(String baseDelimiter) {
        this.baseDelimiter = baseDelimiter;
    }

    public static Delimiter of(String baseDelimiter) {
        return new Delimiter(baseDelimiter);
    }

    public String getDelimiters() {
        return delimiters;
    }

    public String checkDelimiter(String userInput) {
        // 커스텀 구분자
        // 5-2. "\n"만 존재하는 경우
        if (hasEndDelimiter(userInput)) {
            if (hasNotStartDelimiter(userInput)) {
                throw new IllegalArgumentException("질못된 입력입니다.");
            }
        }

        // 5-3. "\n"이 "//"보다 더 앞에 있는 경우
        if (isEndDelimiterBeforStartDelimiter(userInput)) {
            throw new IllegalArgumentException("질못된 입력입니다.");
        }

        // 5-5. "//"와 "\n"이 문자열 맨 앞에 존재하지 않는 경우
        if (hasStartDelimiter(userInput) && hasEndDelimiter(userInput)) {
            if (isNotStartWithStartDelimiter(userInput)) {
                throw new IllegalArgumentException("질못된 입력입니다.");
            }
        }

        if (isStartWithStartDelimiter(userInput)) {
            // 5-6. "//"가 2번 이상 존재하는 경우
            if (hasTwoStartDelimiter(userInput)) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }

            int delimiterEndIndex = userInput.indexOf(CustomDelimiter.END.getDescription());

            // 5-1. "//"만 존재하는 경우
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }

            // 5-7. "\n"이 2번 이상 존재하는 경우
            if (hasTwoEndDelimiter(userInput, delimiterEndIndex)) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }

            customDelimiter = userInput.substring(2, delimiterEndIndex);
            // 5-4. 커스텀 구분자가 1개가 아닌 경우
            if (hasMultipleCustomDelimiters(customDelimiter)) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            delimiters = baseDelimiter + "|" + escapeSpecialCharacters(customDelimiter);
            userInput = userInput.substring(delimiterEndIndex + CustomDelimiter.END.getDescription().length());
        } else {
            delimiters = baseDelimiter;
        }

        // 4. 문자열이 구분자로 시작하거나 끝나는 경우
        if (startsOrEndsWithDelimiter(userInput, delimiters)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        // 3. 구분자가 연속으로 2번 이상 나온 경우
        if (containsRepeatedDelimiters(userInput)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return userInput;
    }

    // 구분자를 가지고 있을 때
    public boolean hasDelimiter(String userInput, String delimiters) {
        return Pattern.compile(delimiters).matcher(userInput).find();
    }

    // 구분자가 2번 이상 나오는 경우
    private boolean containsRepeatedDelimiters(String userInput) {
        String regex = "(" + delimiters + "){2,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userInput);
        return matcher.find();
    }

    // 커스텀 구분자가 2개 이상일 때
    private boolean hasMultipleCustomDelimiters(String customDelimiter) {
        return customDelimiter.length() >= 2;
    }

    // "\n"이 2번 이상 존재할 때
    private boolean hasTwoEndDelimiter(String userInput, int delimiterEndIndex) {
        return userInput.indexOf(CustomDelimiter.END.getDescription(), delimiterEndIndex + 1) != -1;
    }

    // "//"가 2번 이상 존재할 때
    private boolean hasTwoStartDelimiter(String userInput) {
        return userInput.indexOf(CustomDelimiter.START.getDescription(), 2) != -1;
    }

    // "//"로 시작할 때
    private boolean isStartWithStartDelimiter(String userInput) {
        return userInput.startsWith(CustomDelimiter.START.getDescription());
    }

    // "//"로 시작하지 않을 때
    private boolean isNotStartWithStartDelimiter(String userInput) {
        return !isStartWithStartDelimiter(userInput);
    }

    // 구분자로 시작하거나 끝날 경우
    private boolean startsOrEndsWithDelimiter(String userInput, String delimiters) {
        String[] delimiterArray = delimiters.split("\\|");
        for (String delimiter : delimiterArray) {
            String escapedDelimiter = unescapeSpecialCharacters(delimiter);
            if (userInput.startsWith(escapedDelimiter) || userInput.endsWith(escapedDelimiter)) {
                return true;
            }
        }
        return false;
    }

    // "//"를 갖고 있을 때
    private boolean hasStartDelimiter(String userInput) {
        return userInput.contains(CustomDelimiter.START.getDescription());
    }

    // "\n"을 갖고 있을 때
    private boolean hasEndDelimiter(String userInput) {
        return userInput.contains(CustomDelimiter.END.getDescription());
    }

    // "//"를 갖고 있지 않을 때
    private boolean hasNotStartDelimiter(String userInput) {
        return !hasStartDelimiter(userInput);
    }

    // "\n"이 "//"보다 더 앞에 있는지 판단
    private boolean isEndDelimiterBeforStartDelimiter(String userInput) {
        return userInput.indexOf(CustomDelimiter.END.getDescription()) < userInput.indexOf(
                CustomDelimiter.START.getDescription());
    }

    // 특수 문자인 구분자를 이스케이프 쳐리
    private String escapeSpecialCharacters(String delimiter) {
        return Pattern.quote(delimiter);
    }

    // 원래 구분자로 복원
    private String unescapeSpecialCharacters(String delimiter) {
        if (delimiter.startsWith("\\Q") && delimiter.endsWith("\\E")) {
            return delimiter.substring(2, delimiter.length() - 2);
        }
        return delimiter;
    }
}
