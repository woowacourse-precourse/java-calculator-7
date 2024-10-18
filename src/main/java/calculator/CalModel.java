package calculator;

public class CalModel {
    public String s;

    public CalModel(String s){

        this.s = s;

    }

    public String check1(String s) {


        int index1 = s.indexOf("//");
        int index2 = s.indexOf("\\n");

        s = s.replace("//", ",");
        s = s.replace("\\n", ",");

        if (index1 != -1 && index1 < index2) {
            return check2(s, s.charAt(1)); //위에서 //을 ,으로 바꿨기에 인덱스도 그에 맞춤
        }
        else {
            return check2(s, ','); //오버로딩을 이용하는 대신 기본 구분자를 넘겨 중복 코드를 줄일 수 있음
        }
    }

    public String check2(String s, char c) {
        s = s.replace(',', ':');
        s = s.replace(c, ':'); // 모든 구분자를 :로 통일

        for(int i = 0;i < s.length();i++) {

            if((s.charAt(i)-'0' > 10 || s.charAt(i)-'0' < 1) && (s.charAt(i) != ':')) { //숫자도, :도 아닌 문자가 나오면 에러 발생
                throw new IllegalArgumentException();
            }
        }

        //문자열 앞뒤 및 사이사이의 다수의 공백을 하나의 공백으로 치환(이 과정이 없으면 split 메소드 사용 시에 번거로워짐)
        return s.replace(':', ' ').strip().replaceAll(" +"," ");
    }

    public int intSum(String s) {

        int result = 0;

        String[] temp = s.split(" ");

        for(String var : temp) {
            result += Integer.parseInt(var);
        }

        return result;
    }

}
