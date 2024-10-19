package calculator.service;

import calculator.util.Constants;
import java.util.List;
import java.util.stream.Collectors;

public class Separators {

    private final List<Separator> separators;

    private Separators(List<Separator> separators) {
        this.separators = separators;
    }

    public static Separators init() {
        List<Separator> defaultSeparators = SeparatorType.getDefaults()
                .stream()
                .map(Separator::create)
                .collect(Collectors.toList());
        return new Separators(defaultSeparators);
    }

    public void add(Separator separator) {
        validateSeparator(separator);
        separators.add(separator);
    }

    private void validateSeparator(Separator separator) {
        if (isDefaultSeparator(separator.getRegex())) {
            throw new IllegalArgumentException("기본 구분자인 쉼표(,)와 콜론(:)은 커스텀 구분자로 사용할 수 없어요. 다른 구분자를 사용해주세요.");
        }
        if (separators.size() >= Constants.MAX_CUSTOM_SEPARATORS) {
            throw new IllegalArgumentException("한 번에 하나의 커스텀 구분자만 추가할 수 있어요.");
        }
    }

    private boolean isDefaultSeparator(String regex) {
        List<String> defaultSeparators = SeparatorType.getDefaults();
        return defaultSeparators.stream()
                .anyMatch(defaultSeparator -> defaultSeparator.equals(regex));
    }

    public List<String> getValues() {
        return separators.stream()
                .map(Separator::getRegex)
                .toList();
    }
}
