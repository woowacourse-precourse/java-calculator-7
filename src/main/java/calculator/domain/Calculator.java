package calculator.domain;

public class Calculator {

    private Input input;
    private Separator separator;

    public void start() {
        //!!추후에 이 기능은 다른 객체에서 실행 해야할까?
        System.out.println("덧셈할 문자열을 입력해주세요.");

        input = new Input();
        input.readFirstInput();

        separator = new Separator();
        try { //!!추후에 else문 분리해야함!!
            if (input.isDefaultInput()) {
                // 기본 구분자 기능 실행

                separator.validateSeparators(input.getFirstInput()); // 구분자 검증 메소드 호출

                //계산 문자열을 구분자로 구분한다.
                separator.splitCalculationString(input.getFirstInput()); //String[] 반환
            } else {
                // 커스텀 구분자 기능 실행
                input.readSecondInput();

                separator.validateCustomEmpty(input.getFirstInput()); // 커스텀 구분자가 비어있는지 확인
                separator.validateCustomSize(input.getFirstInput()); // 커스텀 구분자의 길이를 확인
                separator.validateNumberInCustom(input.getFirstInput()); // 커스텀 구분자 내에 숫자가 있는지 확인
                separator.validateDuplicateCustom(input.getFirstInput()); // 커스텀 구분자가 중복되었는지 확인

                //예외처리 없이 정상흐름이면 커스텀 구분자를 리스트에 넣어준다.
                separator.addCustomSeparator(input.getFirstInput());
                
                //계산 문자열을 구분자로 구분한다.
                separator.splitCalculationString(input.getSecondInput()); //String[] 반환
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


}
