package calculator.message;

public abstract class Message {
    public static String 입력안내문 = "다음과 같이 입력해주세요\n//구분자 \\n 계산할 숫자들을 구분자로 구별해주세요.";
    public static String 구분자시작 = "//";
    public static String 입력끝구분자 = "\\\\n";
    public static String 결과안내문 = "결과 : ";
    public static Integer 구분자인덱스 = 1;
    public static Integer 음수확인 = 0;
    public static Integer 구분자크기 = 3;
}
