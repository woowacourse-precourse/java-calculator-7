package calculator;

public class User {
    private final String user;

    public User(String user) {
        if (user.isBlank()) {
            throw new IllegalArgumentException("공백만 입력할수 없습니다");
        }

        if (Character.isWhitespace(user.charAt(0))) {
            throw new IllegalArgumentException("입력값은 공백으로 시작할 수 없습니다");
        }
        this.user = user;
    }

    public String getUser() {
        return user;
    }

}
