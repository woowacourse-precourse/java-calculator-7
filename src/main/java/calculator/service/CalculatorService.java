package calculator.service;

public class CalculatorService {
    private String s;
    private String plusSeparator;

    /**
     * 덧셈 로직을 순차적으로 진행한다.
     */
    public int sum(String s) {
        this.s = s;
        boolean hasPlusSeparator = checkPlusSeparator();
        String[] separatedString = separate(hasPlusSeparator);
        hasNaN(separatedString);
        return sumSeparatedStringArr(separatedString);
    }

    /**
     * 커스텀 구분자가 있는지 확인한다.
     *
     * @return 만약 커스텀 구분자가 있다면 true, 없다면 false 를 반환한다.
     */
    private boolean checkPlusSeparator() {
        if (s.length() >= 5 && s.startsWith("//") && s.startsWith("\\n", 3)) {
            plusSeparator = String.valueOf(s.charAt(2));
            s = s.substring(5);
            return true;
        }
        return false;
    }

    /**
     * 받은 문자열을 구분자를 기준으로 나눈다. 만약 커스텀 구분자에 역슬래시가 있다면 문제가 생기지 않도록 한다.
     *
     * @param hasPlusSeparator 커스텀 구분자가 있다면 true, 없다면 false 를 입력한다.
     * @return 분리된 문자열을 반환한다. 이 문자열에는 반드시 숫자만 있는 것은 아니다.
     */
    private String[] separate(boolean hasPlusSeparator) {
        if (!hasPlusSeparator) {
            return s.split("[:,]");
        } else { //else 문 삭제해도 됨. ####################################################
            if (plusSeparator.equals("\\")) {
                return s.split("[:," + plusSeparator.repeat(2) + "]");
            }
            return s.split("[:," + plusSeparator + "]");
        }
    }

    /**
     * 숫자가 아닌 문자열이 있는지 확인한다. 만약 있다면 IllegalArgumentException 으로 처리한다.
     *
     * @param separatedStringArr 숫자 외의 문자가 있는지 확인하고 싶은 문자열을 입력한다.
     */
    private void hasNaN(String[] separatedStringArr) {
        for (String s : separatedStringArr) {
            for (char c : s.toCharArray()) {
                if (c < 48 || c > 57) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    /**
     * 문자열을 int 형으로 바꾼 뒤 합한다.
     *
     * @param separatedStringArr 숫자로만 이루어진 문자열 배열을 입력한다.
     * @return 합한다.
     */
    private int sumSeparatedStringArr(String[] separatedStringArr) {
        int sum = 0;
        for (String separatedString : separatedStringArr) {
            if (!separatedString.isEmpty()) {
                sum += Integer.parseInt(separatedString);
            }
        }
        return sum;
    }
}
