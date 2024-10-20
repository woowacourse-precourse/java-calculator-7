package calculator;

public class InputRulePrinter {

    public void printInputRules() {
        System.out.println("### 문자열 덧셈 계산기 규칙 ###");
        System.out.println("1. 기본 구분자는 쉼표(,)와 콜론(:)입니다.");
        System.out.println("2. 커스텀 구분자를 사용하려면 문자열 앞부분에 ‘//’와 ‘\\n’ 사이에 구분자를 명시해야 합니다.");
        System.out.println("   예시: //;\\n1;2;3 => 결과는 6");
        System.out.println("3. 음수와 소수는 지원하지 않으며, 입력 시 예외가 발생합니다.");
        System.out.println("4. 입력된 문자열이 9자를 넘으면 예외가 발생합니다.");
        System.out.println();
    }
}
