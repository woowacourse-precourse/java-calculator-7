# 프리코스 1주차 기능 구현 목록 정리

## main

- 덧셈을 수행할 문자열을 입력받는다.
- 입력이 없는 경우 프로그램을 종료한다.
- 커스텀 문자와 입력 유효사항을 확인하기 위한 전체적인 제어 역할의 DelimiterService를 호출하여 input을 전달한다.
- 모든 검사와 연산이 종료된 후 숫자의 합을 출력한다.

--

## DelimiterService
- 3단계의 정상흐름으로 분류하여 검사와 연산을 수행한다.
  1. checkCustomDelimiter 메서드로 커스텀 구분자를 확인한다.
    1-1. 커스텀 구분자가 문자열의 형태나 숫자로 입력되면 CustomDelimiterException 발생시킨다.
  2. CheckedStandardDelimiter 메서드로 입력의 유효성을 확인한다.
    2-1. 커스텀 구분자의 유효성을 판단한 후 입력 자체의 유효성을 판단 -> 잘못된 값일 경우 IllegalArgumentException 발생시킨다.
  3. try 구문을 이용해 모든 유효성 검사가 끝나고 sumInput 메서드로 구분자로 구별된 숫자를 합하여 main에 반환한다.

--

## InputValidation
- Service의 3단게 메서드를 수행한다.
    1. checkCustomDelimiter -> 구분자가 "//", "\n"로 첫부분에 둘러싸여 있는지 확인하고 그것이
        숫자인지, 문자열인지 판단하여 커스텀 구분자를 추출하고 남은 input을 업데이트 한다.
    2. CheckInput 커스텀 구분자(존재할 시) + 기본 구분자를 바탕으로 StringTokenizer을 통해 올바른 구분자를
        바탕으로 입력이 이뤄지는지 확인한다. 공백은 모두 제거하며 CheckNumber을 호출하여 양수가 구분자를 바탕으로 구별돼
        이뤄진 식인지 판단한다.
    3. 토큰으로 분리되어 넘어온 파라미터를 정수로 변환을 try하고 실패 시 NumberFormatException을 터뜨린다.
        정상적으로 수행된다면 유효한 구분자가 CheckInput을 통해 서비스로 복귀한다.


## 추가로 고려할 사항 
1. 구분자가 중복입력 -> 1::,2,,3 일때의 경우
2. 단순히 공백으로만 구분되는 경우.
3. 숫자 integer 형을 초과하는 경우.