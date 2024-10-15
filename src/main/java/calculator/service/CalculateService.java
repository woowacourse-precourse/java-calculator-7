package calculator.service;

public class CalculateService {

    /***
     * 사용자의 문자열을 기반으로 덧셈을 수행하는 서비스 메서드
     * @param inputString : 사용자가 입력한 문자열
     * @return : 계산 결과를 리턴해줌
     */
    public int calculate(String inputString) {
        int sum = 0;

        if(inputString.startsWith("//") && inputString.contains("\\n")) {
            // 커스텀 구분자를 사용하는 경우
            System.out.println("커스텀 구분자 입력");

            int firstIdx = inputString.indexOf("//") + 2;
            int secondIdx = inputString.indexOf("\\n");
            String delim = inputString.substring(firstIdx, secondIdx);

            String[] split = inputString.substring(secondIdx + 2, inputString.length()).split(delim);
            for (String s : split) {
                sum += Integer.parseInt(s);
            }
        } else if (inputString.contains(",") || inputString.contains(":")){
            System.out.println("기본 구분자를 입력");
            String[] split = inputString.split("[,:]");

            for (String s : split) {
                sum += Integer.parseInt(s);
            }
        }
        System.out.println("sum = " + sum);
        return sum;
    }
}
