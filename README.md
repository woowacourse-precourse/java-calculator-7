# 프리코스 1주차 기능 구현 목록 정리

## main

- 덧셈을 수행할 문자열을 입력받는다.
- 입력이 없는 경우 0을 출력 후 프로그램을 종료한다.
- 커스텀 문자 사용과 입력 유효사항을 확인하기 위한 전체적인 제어 역할의 DelimiterService를 호출하여 input을 전달한다.
- 모든 검사와 연산이 종료된 후 숫자의 합을 출력한다.

## DelimiterService

- 3단계의 정상흐름으로 분류하여 검사와 연산을 수행한다.
    1. checkCustomDelimiter 메서드로 커스텀 구분자를 확인한다.
        - 커스텀 구분자의 입력 형식이 올바르지 않을 경우 IllegalArgumentException 발생시킨다.

    2. CheckInput 메서드로 입력의 유효성을 확인한다.
        - 커스텀 구분자의 유효성을 판단한 후 입력 자체의 유효성을 판단 -> 잘못된 값일 경우 IllegalArgumentException 발생시킨다.

    3. try 구문을 이용해 모든 유효성 검사가 끝나고 sumInput 메서드로 구분자로 구별된 숫자를 합하여 main에 반환한다.

## InputValidation

- Service에서 전달받은 입력 검사 요청을 수행한다.
    1. checkCustomDelimiter -> 구분자가 "//", "\n"로 첫부분에 둘러싸여 있는지 확인 후 구분자를
       커스텀 구분자을 추출한 뒤 남은 input의 뒷부분만 업데이트하여 반환한다.
    2. CheckInput 커스텀 구분자(존재할 시) + 기본 구분자를 바탕으로 input을 분리해 양수가 올바르게
       입력되었는지 CheckNumber()을 호출하여 판단한다.
    3. 토큰으로 분리되어 넘어온 파라미터를 정수로 변환을 try하고 실패 시 NumberFormatException을 터뜨린다.
       정상적으로 수행된다면 유효한 구분자가 CheckInput을 통해 서비스로 복귀한다.

## 추가로 고려할 예외사항

- 아래의 입력과 같은 경우가 나타나면 IllegalArgumentException을 발생시킨다.
    1. 구분자가 중복입력 -> 1::,2,,3 일때의 경우.
    2. 단순히 공백으로만 구분되는 경우.
    3. 숫자 integer 형을 초과하거나 음수가 입력되는 경우.
    4. 커스텀 문자를 지정할때 아무것도 입력하지 않을경우 -> "//\n"