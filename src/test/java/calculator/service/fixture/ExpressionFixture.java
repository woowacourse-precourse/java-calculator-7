package calculator.service.fixture;

public class ExpressionFixture {
    public final static String EXPRESSION_WITHOUT_CUSTOM_IDENTIFIER = "1:22.333";
    public final static String EXPRESSION_WITH_CUSTOM_IDENTIFIER = "//{\n1:22.333";

    // 1.
    public final static String EXPRESSION_STARTS_WITH_ONE_SLASH = "/{\n1:22.333";
    public final static String EXPRESSION_STARTS_WITHOUT_NUMBER = "{\n1:22.333";

    // 2.
    public final static String EXPRESSION_DOUBLE_CUSTOM_IDENTIFIER = "//{{\n1:22.333";

    // 3.
    public final static String EXPRESSION_CUSTOM_WITHOUT_SLASH_N = "//{1:22.333";

    // 4.
    public final static String EXPRESSION_BLANK_CUSTOM_IDENTIFIER = "//\n1:22.333";

    // 5.
    public final static String EXPRESSION_INVALID_IDENTIFIER = "1:22{333";

}
