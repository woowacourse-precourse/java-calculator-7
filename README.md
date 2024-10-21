# java-calculator-precourse

# 기능 구현 목록

## 1. CalculatorApplication
- [ ] 사용자 입출력 처리 - Input/OutputView
- [ ] 입력값 검증 - Validator
- [ ] 커스텀 Delimiter 추출 - DelimiterExtractor
- [ ] Calculator 생성 - Calculator
    - [ ] 연산 호출

## 2. Calculator
- [ ] Delimiter 받아서 생성
- [ ] 덧셈 수행

## 3. Validator
- [ ] 사용자 입력 검증
    - [ ] 빈 문자열, null 검사
    - [ ] 커스텀 구분자 O
        - [ ] 새로운 구분자 전달
        - [ ] ','과 ';' + 새로운 구분자와 + 숫자를 제외한 문자 입력 검증
    - [ ] 커스텀 구분자 X
        - [ ] ','과 ';' + 숫자를 제외한 문자 입력 검증
    - [ ] 예외처리
        - [ ] 지원하지 않는 연산자
        - [ ] 잘못된 식 입력
    - [ ] 구분자와 양수로 구성된 문자열

## 4. DelimiterExtractor
- [ ] Custom Delimiter?
    - [ ] if no -> {',', ';'} 반환
    - [ ] if yes -> Custom Delimiter 포함한 char 배열 반환

## 5. Input/OutputView
- [ ] 사용자 입력
- [ ] 결과 출력
- [ ] 예외 메시지 출력
  
