package calculator.global.instance;

public class Messages {

    public static final String DESCRIPTION =
            """
                    문자열 덧셈 계산기입니다.
                    쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
                    앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
                    또한 커스텀 구분자를 여러 개 사용하고 싶으면 | 를 이용해서 구분해서 등록해주세요.
                    (단, | 는 커스텀 구분자로 사용이 불가능합니다.)
                    """;
    public static final String INPUT_PROMPT = "덧셈할 문자열을 입력해 주세요.";
    public static final String RESULT = "결과 : ";

    public static final String INVALID_DELIMITER_ERROR = "구분자가 적절하지 않습니다";
    public static final String INVALID_CHARACTER_ERROR = "글자는 들어올 수 없습니다";
    public static final String NEGATIVE_NUMBER_ERROR = "음수는 허용되지 않습니다";
    public static final String INVALID_STARTING_CHARACTER_ERROR = "잘못된 형식입니다. 숫자 또는 '//'로 시작해야 합니다.";
    public static final String MISSING_NEWLINE_AFTER_CUSTOM_DELIMITER_ERROR = "잘못된 형식입니다. 커스텀 구분자 뒤에 '\\n'이 있어야 합니다.";
    public static final String NUMBER_AS_CUSTOM_DELIMITER_ERROR = "숫자는 커스텀 구분자로 사용할 수 없습니다";
    public static final String PIPE_MISUSED_AS_DELIMITER_ERROR = "커스텀 구분자 등록의 형식이 잘못되었습니다. 파이프(`|`)는 커스텀 구분자를 구분하는 용도로만 사용할 수 있습니다";
}
