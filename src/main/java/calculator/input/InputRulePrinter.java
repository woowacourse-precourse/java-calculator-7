package calculator.input;

public class InputRulePrinter {

    public void printInputRules() {
        System.out.println("### 문자열 덧셈 계산기 규칙 ###");
        System.out.println("1. 기본 구분자는 쉼표(,)와 콜론(:)입니다.");
        System.out.println("2. 커스텀 구분자를 사용하려면 문자열 앞부분에 ‘//’를 입력하고, 다음 줄에 숫자를 입력해야 합니다.");
        System.out.println("   예시: //; 를 입력한 후 Enter를 누르고, 다음 줄에 1;2;3을 입력 => 결과는 6");
        System.out.println("3. 음수와 소수는 지원하지 않으며, 입력 시 예외가 발생합니다.");
        System.out.println("4. 계산 대상 문자열이 9자를 넘으면 예외가 발생합니다.");
        System.out.println();
    }
}
