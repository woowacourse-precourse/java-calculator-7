package calculator;

public class OutputHandler {
    public void guideComment() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public void printSum(int sum) {
        System.out.println("결과 : " + 6);
    }

    // 구분자와 숫자 배열을 출력하는 함수
    public void printExtractedValues(String delimiter, String[] numbers) {
        System.out.println("추출된 구분자: " + delimiter);
        System.out.print("숫자 배열: ");
        for (String number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
