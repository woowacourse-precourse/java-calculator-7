package calculator;

public class TokenSplitter {
    public String[] split(String input) {
        return input.split("[,|:]"); // 쉼표와 콜론을 기준으로 분리
    }
}
