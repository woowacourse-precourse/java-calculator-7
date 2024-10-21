package calculator.domain;

public class UserExpressionDivide {
    private static UserExpression userExpression;
    private static String rawExpression;
    private static final int CUSTOM_DELIM_LENGTH = 5;

    private static void setting(UserExpression expression) {
        userExpression = expression;
        rawExpression = userExpression.getRawExpression();
        userExpression.setCustomDelimExpressionCandidate(rawExpression);
        userExpression.setEssentialExpression(rawExpression);
    }

    public static void dividePart(UserExpression expression) {
        setting(expression);
        if(enoughLengthToDivide(rawExpression)) {
            assignCandidate(rawExpression);
            assignRemainingPart(rawExpression);
        }
    }

    private static Boolean enoughLengthToDivide(String rawExpression) {
        return rawExpression.length() >= CUSTOM_DELIM_LENGTH;
    }

    private static void assignCandidate(String rawExpression) {
        userExpression.setCustomDelimExpressionCandidate(rawExpression.substring(0,CUSTOM_DELIM_LENGTH));
    }

    private static void assignRemainingPart(String rawExpression) {
        userExpression.setEssentialExpression(rawExpression
                .replace(userExpression.getCustomDelimExpressionCandidate(),""));
        onlyCustomDelimExistInRawExpression();
    }

    private static void onlyCustomDelimExistInRawExpression() {
        if(userExpression.getEssentialExpression().isEmpty()) {
            userExpression.setEssentialExpression("0");
        }
    }

    public static UserExpression setDivideCustomDelimDisappear() {
        userExpression.setEssentialExpression(userExpression.getRawExpression());
        return userExpression;
    }

}
