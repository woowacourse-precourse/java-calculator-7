package calculator;

//연산 클래스 생성
public class Calculation {

    //덧셈의 결과를 출력
    public int Add(String str){

        int sum = 0;

        // ","로 구분되는 숫자들을 배열에 저장
        String[] numbs = str.split(",");

        for(String num : numbs){

            //10억이 넘는 수를 입력하지 못하도록 예외처리
            if(num.length()>=10){
                throw new IllegalArgumentException("10억이 넘는 수를 입력할 수 없습니다.");
            }

            // 문자열 형태의 숫자를 int형으로 변경 후 sum에 더함
            sum += Integer.parseInt(num);

            if(sum>=1000000000){
                throw new IllegalArgumentException("덧셈의 결과가 10억을 넘을 수 없습니다.");
            }
        }

        return sum;
    }

    //연산 종류가 추가될경우, 아래에 메소드 추가
}
