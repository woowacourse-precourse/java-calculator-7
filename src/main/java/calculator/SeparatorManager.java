package calculator;

import java.util.HashSet;
import java.util.Set;

public class SeparatorManager {
    private final Set<String> separators;

    public SeparatorManager() {
        this.separators = new HashSet<>();
        this.separators.add(",");
        this.separators.add(":");
    }

    public Set<String> getSeparators() {
        return this.separators;
    }

    public void save(String separatorCandidates) {
        separators.add(separatorCandidates);
    }

    public void validate(String separatorCandidate) {
        if (separatorCandidate == null || separatorCandidate.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자는 빈 문자열이어서는 안 됩니다.");
        }

        if (separatorCandidate.length() != 1) {
            throw new IllegalArgumentException("커스텀 구분자는 한자리여야 합니다.");
        }

        char separator = separatorCandidate.charAt(0);
        if ((int) separator > 127) {
            throw new IllegalArgumentException("커스텀 구분자는 아스키 문자여야 합니다.");
        }

        if ((int) separator <= 31 || (int) separator == 127) {
            throw new IllegalArgumentException("커스텀 구분자는 아스키 제어 문자가 될 수 없습니다.");
        }

        if (Character.isWhitespace(separator) && (int) separator != 32) {
            throw new IllegalArgumentException("커스텀 구분자의 공백은 스페이스(Space)만 허용합니다.");
        }

        if (separator >= '1' && separator <= '9') {
            throw new IllegalArgumentException("커스텀 구분자는 숫자 1~9가 될 수 없습니다.");
        }
    }
}
