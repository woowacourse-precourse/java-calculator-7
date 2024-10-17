package calculator;

//연산 클래스 생성
public class Calculation {

    //덧셈의 결과를 출력
    public int Add(String str){

        int sum = 0;

        // ","로 구분되는 숫자들을 배열에 저장
        String[] numbs = str.split(",");

        for(String num : numbs){
            // 문자열 형태의 숫자를 int형으로 변경 후 sum에 더함
            sum += Integer.parseInt(num);
        }

        return sum;
    }

    //연산 종류가 추가될경우, 아래에 메소드 추가
}
