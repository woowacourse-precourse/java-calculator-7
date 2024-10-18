package calculator;

public class Calculator {

    CustomSeparator customSeparator = new CustomSeparator();

    public int calculate(String st) {
        // 입력값이 없는 경우에 대한 예외 처리
        if (st.isEmpty()) {
            return 0;
        }

        try {
            // 입력값이 1자리인 경우 그 숫자 그대로 반환
            if (st.length() == 1) {
                return Integer.parseInt(st);
            }

            // 입력값이 숫자가 아니라면 IllegalArgumentException 에러 발생
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력한 값 중 구분자를 제외한 값이 숫자가 아닙니다.");
        }

        // 구분자 생성
        String separator = customSeparator.separator(st);

        // 커스텀 구분자가 있을 경우 \n 이후의 문자열부터 슬라이싱
        if (st.startsWith("/")) {
            st = st.substring(st.indexOf("n") + 1);
        }

        // 구분자를 사용해 각 문자를 슬라이싱한다.
        String[] split = st.split(separator);

        // 더해진 값 리턴
        return intSum(split);
    }

    public int intSum(String[] st) {
        int answer = 0;
        try {
            for (String s : st) {
                if (Integer.parseInt(s) < 0) {
                    throw new IllegalArgumentException("입력한 값 중, 음수가 포함되어 있습니다.");
                }
                answer += Integer.parseInt(s);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력한 값 중 구분자를 제외한 값이 숫자가 아닙니다.");
        }
        return answer;
    }
}
