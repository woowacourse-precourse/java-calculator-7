package calculator;

public class CalculationUtil {

    public CalculationUtil(String input) {
        this.input = input;
    }

    private String input;
    private char customDivider;
    private boolean isCustom = false;

    /**
     * 커스텀 구분자를 포맷을 체크하고 있다면 구분자를 추출
     *
     * @throws IllegalAccessException : 커스텀 구분자 선언부가 포맷이 부적절할 때
     */
    private void checkCustomDivider() {
        if (input.startsWith("/") && input.length() >= 5) {
            String customDividerString = input.substring(0, 5);
            if (customDividerString.startsWith("//") && customDividerString.endsWith("\\n")) {
                this.isCustom = true;
                this.customDivider = input.charAt(2);
                this.input = this.input.substring(5);
            } else {
                throw new IllegalArgumentException("Custom Divider format is wrong");
            }
        }
    }
}