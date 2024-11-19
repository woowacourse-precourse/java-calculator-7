package calculator.service.domain;

public class Delimiter {
    private final char delimiter;

    public Delimiter(char delimiter) {
        this.delimiter = delimiter;
    }

    /**
     * 두 객체가 값이 동일한지 비교하도록 재정의.
     *
     * @param obj 비교 대상 객체
     * @return 값이 동일하다면 true, 동일하지 않다면 false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // 같은 객체라면 값을 비교할 이유가 없기 때문에 바로 true를 반환하여 성능을 최적화한다.
        if (obj == null || getClass() != obj.getClass()) return false; // Null Handling, Class Consistency
        Delimiter other = (Delimiter) obj; // 다운캐스팅
        return this.delimiter == other.delimiter; // 값 비교
    }

    public boolean hasSameValueAs(Delimiter other) {
        if (this == other) return true; // 객체 동등성 체크
        if (other == null) return false; // Null Handling
        return this.delimiter == other.delimiter; // 값 비교
    }

    @Override
    public int hashCode() {
        return Character.hashCode(delimiter);
    }
}
