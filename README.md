# java-calculator-precourse

# 기능 구현 목록

## 1. CalculatorApplication
- [x] 사용자 입출력 처리 - Input/OutputView
- [x] 입력값 검증 - Validator
- [x] 커스텀 Delimiter 추출 - DelimiterExtractor
- [x] Calculator 생성 - Calculator
    - [x] 연산 호출

## 2. Calculator
- [x] Delimiter 받아서 생성
- [x] 덧셈 수행

## 3. Validator
- [x] 사용자 입력 검증
    - [x] 빈 문자열, null 검사
    - [x] 커스텀 구분자 O
        - [x] ','과 ';' + 새로운 구분자와 + 숫자를 제외한 문자 입력 검증
    - [x] 커스텀 구분자 X
        - [x] ','과 ';' + 숫자를 제외한 문자 입력 검증
    - [x] 구분자와 양수로 구성된 문자열

## 4. DelimiterExtractor
- [x] Custom Delimiter?
    - [x] if no -> {',', ';'} 반환
    - [x] if yes -> Custom Delimiter 포함한 char 배열 반환

## 5. Input/OutputView
- [x] 사용자 입력
- [x] 결과 출력
- [x] 예외 메시지 출력
  
