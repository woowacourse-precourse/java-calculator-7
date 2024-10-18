package calculator.model;

public class Expression {
    private final String expression;

    public Expression(String expression) {
        // 로직 들어갈 예정
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

//    /**
//     *
//     * @param expression 검증된 input
//     * @return 정제된 계산식
//     */
//    private String encoding(String expression) {
//        String pattern = "^\\d.*";
//
//        // 커스텀 구분자가 있는 경우
//        if (!expression.matches(pattern)) {
//            String[]
//        }
//
//        // 커스텀 구분자가 없는 경우
    }
}
