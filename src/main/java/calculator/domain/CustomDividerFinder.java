package calculator.domain;

/**
 * 커스텀 문자는 문자열 맨 앞에 입력된다.
 * 커스텀 문자만 찾아낸다.
 * 문자열 아님 문자임
 */
public class CustomDividerFinder {
    private final static String OPENER = "//";
    private final static String CLOSER = "\\n"; //note : 줄바꿈 문자를 구분해줘야하는 거기 때문에 역슬래시를 2번 사용한다.(만약 1개면 줄바꿈)
    private final static Integer OPENER_INDEX = 0;
    private final static Integer CLOSER_INDEX = 3;
    private final static Integer CUSTOM_DIVIDER_INDEX = 2;

    public void findCustomDividers(CalculatedValue calculatedValue, Divider divider) { //todo 인수를 생성자로?
        String inputValue = calculatedValue.getValue();
        int openerIndex = inputValue.indexOf(OPENER);
        int closerIndex = inputValue.indexOf(CLOSER);

        System.out.println(calculatedValue.getValue());
        System.out.println(openerIndex);
        System.out.println(closerIndex);


        if (openerIndex == OPENER_INDEX && closerIndex == CLOSER_INDEX) {
            char charCustomDivider = inputValue.charAt(CUSTOM_DIVIDER_INDEX);
            String newValue = inputValue.substring(5);
            System.out.println("vuswlqehls"+newValue);
            calculatedValue.setValue(newValue);
            //todo 계산값 조정
            divider.setCustomDivider(String.valueOf(charCustomDivider));
        }
    }

}
