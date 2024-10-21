package calculator;

public class Delimiter {

    private final String delimiter;

    public Delimiter(String delimiter) {
        validate(delimiter);
        this.delimiter = delimiter;
    }

    private void validate(String delimiter) {
        if (delimiter == null || delimiter.isEmpty()) {
            throw new IllegalArgumentException("구분자 값을 입력하지 않았습니다.");
        }
        if (delimiter.equals("\\n")) {
            throw new IllegalArgumentException("구분자가 구분자 입력 종료 문법 '\\n'과 동일해서는 안됩니다.");
        }
        if (containsDigit(delimiter)) {
            throw new IllegalArgumentException("구분자에 아라비아 숫자가 포함되면 안됩니다.");
        }
    }
    
    private boolean containsDigit(String delimiter) {
        for (char c : delimiter.toCharArray()) {
            if ('0'<=c && c<='9') {
                return true;
            }
        }
        return false;        
    }
}
