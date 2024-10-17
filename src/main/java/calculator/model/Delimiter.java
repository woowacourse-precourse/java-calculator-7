package calculator.model;

public class Delimiter {

    // final?? 써야한다는데 공부 필요 + static
    private String customStart ="//";
    private String customEnd ="\\n";

    // custom 구분자 문제 해결 필요
    // 디폴트구분자1과 2 랑 같은 값으로 지정해놓고 조건 만족하면 변경
    public char customDelimiter = ',';

    private boolean checkDelimiter(String expression) {
        if (expression.indexOf(customStart) == 0 && expression.indexOf(customEnd) == 3){
            return true;
        }
        return false;
    }

    // check를 내부에서 진행
    public char getDelimiter(String expression) {

            if (checkDelimiter(expression)) {
                // customDelimiter를 customEnd-1 로 받을 필요 없음 why? check 에서도 상수 사용했기 떄문
                customDelimiter = expression.charAt(2);

                // 그리고 앞 문자 5개 잘라내야함 -> 어떻게 main에 반영함?
                // 이방법 보다 잘라내는 클래스를 만드는게 좋은듯
            }

        // 리턴할 필요가 있나?
        // 문자열 검사 과정에서 이 class를 접근할 것인지? -> 퍼블릭으로 둔 구분자 3개를 접근하면 됨 -> 여기서는 디폴트구분자 2개 안쓰는데?
        // main에서 인자값으로 구분자를 줄것인지? -> 나중에 계산할때 커스텀 하나만 인자로 줌 (디폴트2개는 거기서 생성) 좋은듯
        // 결론은 리턴하는게 좋은듯
        return customDelimiter;
    }

}
