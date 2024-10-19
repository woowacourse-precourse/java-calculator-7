package calculator;
public class Calculator {

    public int convert(String str){
        if(str.startsWith("//")){
            return customConvert(str);
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

    private int customConvert(String str) {
        String custom;
        int result = 0;
        int idx = str.indexOf("\n");

        if(idx == -1) {
            throw new IllegalArgumentException("잘못된 형식입니다, 커스텀 구분자를 \"\\\" \"\n\" 사이에 넣으세요");
        }
        // 커스텀이 하나일경우
        custom = str.substring(2, idx);
        // 커스텀이 여러개일경우
        if(custom.length() > 1){
            String[] tmp = custom.split("");
            custom = tmp[0];
            for(int i=1; i<tmp.length; i++){
                custom += "|" + tmp[i];
            }
        }
        String substring = str.substring(str.lastIndexOf("\n") + 1);
        String[] split = substring.split(custom);

        for (String s : split) {
            try {
                result += Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다, 설정한 구분자를 사용하세요");
            }
        }
        return result;
    }
}
