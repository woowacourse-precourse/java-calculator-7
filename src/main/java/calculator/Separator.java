package calculator;

import java.util.HashSet;
import java.util.Set;

public class Separator {
    private Set<String> separators;

    public Separator() {
        this.separators = new HashSet<>();
        this.separators.add(",");
        this.separators.add(":");
    }

    public Set<String> getSeparators() {
        return this.separators;
    }

    public void save(String separatorCandidates) {
        validate(separatorCandidates);
        separators.add(separatorCandidates);
    }

    private void validate(String separatorCandidate) {
        if(!separatorCandidate.codePoints().allMatch(Character::isDefined)) {
            throw new IllegalArgumentException("커스텀 구분자에 유니코드가 아닌 문자가 포함되어 있습니다.");
        }
        if(!separatorCandidate.codePoints().allMatch(Character::isISOControl)) {
            throw new IllegalArgumentException("커스텀 구분자에 인쇄 문자가 아닌 문자가 포함되어 있습니다.");
        }
        if(separatorCandidate.matches(".*[1-9].*")) {
            throw new IllegalArgumentException("커스텀 구분자에 숫자(1~9)가 포함되어 있습니다.");
        }
        if(separatorCandidate.matches(".*(π|√|log).*")) {
            throw new IllegalArgumentException("커스텀 구분자에 무리수 기호가 포함되어 있습니다.");
        }
        if(separatorCandidate.matches("\\.*")) {
            throw new IllegalArgumentException("커스텀 구분자가 소수점 기호(.)만으로 이루어져 있습니다.");
        }
        if (separatorCandidate.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자가 빈 문자열로 이루어져 있습니다.");
        }
    }
}
