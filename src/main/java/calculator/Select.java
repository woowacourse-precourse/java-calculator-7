package calculator;

public class Select {
    String input;

    public Select(String input) {
        this.input = input;
        zero();
    }

    Basic basic = new Basic();  // Basic 객체 생성
    PrintSum printSum = new PrintSum();

    public void zero() {
        if (input.isEmpty())  // 문자열이 공백이면 결과 0
        {
            printSum.printS(0);
        } else if (input.charAt(0) == ',' || input.charAt(0) == ':')  //  처음 글자가 ',' 나 ':' 일 때
        {
            throw new IllegalArgumentException("첫 글자는 숫자여야 합니다.");
        } else {
            char ch = input.charAt(input.length() - 1);
            if (!Character.isDigit(ch)) // 마지막이 숫자가 아니면
            {
                throw new IllegalArgumentException("마지막 글자는 숫자여야 합니다.");

            } else {  // 마지막이 숫자면
                basic.bc(input);
            }

        }
    }
}



