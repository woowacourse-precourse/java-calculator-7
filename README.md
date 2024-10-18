# java-calculator-precourse

기능 요구 사항

# 프리코스 1주차 - 문자열 덧셈 계산기

## 개요
    -입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

## 기능 목록

1. 기본 구분자로 문자열을 입력 받아 계산기를 구현한다.
    - camp.nextstep.edu.missionutils.Console의 readLine()을 통해 입력 받는다.
    - 기본 구분자(쉼표, 콜론)로 문자열 분리 및 숫자를 구분한다.
    - 분리된 숫자 리스트를 생성한 후 더한다.
    - 빈 문자열이 들어올 경우 결과가 0이 된다.

2. 커스텀 구분자 지정
    - 입력된 문자열에서 커스텀 구분자를 사용하는지 판단한다. (//로 시작하는지 확인)
    - 커스텀 구분자가 있을 경우 기본 구분자를 대체한다.


3. 예외 처리 
    -사용자가 잘못된 값을 입력할 경우, `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료한다.
        - 커스텀 구분자가 숫자일 경우
        - 구분자와 숫자를 제외한 문자가 포함된 경우