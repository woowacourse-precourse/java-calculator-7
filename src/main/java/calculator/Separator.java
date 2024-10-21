package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Separator {
    private final String target;
    private final DelimiterManager delimiterManager;
    private int startOffset = 0;

    Separator(String target, DelimiterManager delimiterManager) {
        this.target = target;
        this.delimiterManager = delimiterManager;
    }

    public Optional<Character> addCustomDelimiter(String prefix, String suffix) {
        int prefixPosition = target.indexOf(prefix);
        int suffixPosition = target.indexOf(suffix);
        int customDelimiterPosition = prefixPosition + prefix.length();

        if (prefixPosition != 0 || customDelimiterPosition + 1 != suffixPosition) {
            return Optional.empty();
        } else {
            startOffset = suffixPosition + suffix.length();
            char customDelimiter = target.charAt(customDelimiterPosition);
            delimiterManager.add(customDelimiter);
            return Optional.of(customDelimiter);
        }
    }

    public List<String> separate() {
        String pureTarget = target.substring(startOffset);
        List<String> separatedResult = new ArrayList<>();
        StringBuilder separated = new StringBuilder();
        for (char ch : pureTarget.toCharArray()) {
            if (delimiterManager.exists(ch)) {
                separatedResult.add(separated.toString());
                separated = new StringBuilder();
            } else {
                separated.append(ch);
            }
        }
        if (!separated.isEmpty()) {
            separatedResult.add(separated.toString());
        }
        return separatedResult;
    }

    public static int getSum(List<String> separatedList) {
        int total = 0;
        for (String separated : separatedList) {
            int separatedValue = -1;
            try {
                separatedValue = Integer.parseInt(separated);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자로 변환할 수 없습니다!");
            }
            if (separatedValue < 0) {
                throw new IllegalArgumentException("양수가 아닙니다!");
            }
            total += separatedValue;
        }
        return total;
    }
}
