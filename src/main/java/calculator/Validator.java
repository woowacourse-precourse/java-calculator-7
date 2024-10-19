package calculator;

public class Validator {
    public void validate(String input) {
        if (input.contains("-")) {
            throw new IllegalArgumentException("ㅁㅊ음? 음수를 넣는다고?");
        }
    }
}
