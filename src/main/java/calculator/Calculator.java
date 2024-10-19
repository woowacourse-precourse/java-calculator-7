package calculator;
public class Calculator {

    public int convert(String str){
        if(str.startsWith("//")){
            //todo customConvert
            return 0;
        } else {
            return defaultConvert(str);
        }
    }
    private int defaultConvert(String str) {
        int result =0;
        String[] split = str.split(",|:");

        for (String s : split) {
            try {
                result += Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다, 구분자로 \",\" 나 \":\" 를 사용하세요");
            }
        }
        return result;
    }
}
