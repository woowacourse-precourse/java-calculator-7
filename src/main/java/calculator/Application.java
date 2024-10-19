package calculator;

/*
테스트 입력
"1,2,3"
"1,2,3,"
"1,2:3@4"
"1,;2:3"
"1, 2;3"
"//;\n1;2;3"
"//;\n1;2; 3"
"//;\n1,2;3:4"
"//;\n1:2@3;4"
"//7\n172,3"
*/

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Calculator calculator = new Calculator();
        calculator.run(); //프로그램 실행
        calculator.end(); //프로그램 종료
    }
}
