package calculator.model;

// 문자열에서 숫자가 적혀있는 부분을 담는 토큰 객체
public class NumbersToken {
    private final String token;

    public NumbersToken(String token) {
        this.token = token;
    }

    public boolean isEmpty() {
        return token.isEmpty();
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return token;
    }
}
