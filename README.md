# java-calculator-precourse

# 구현할 기능 목록

## 1. Input, Output

```
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```

1. 콘솔에 문자열을 입력하라는 메시지 출력하기
2. camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 사용자의 입력 받기
3. PlusCalculator 클래스 안의 함수에 input을 넘겨주고 리턴 결과 출력

## 2. InputValidator

1. 문자열의 시작이 "//", 숫자 이거나, 전체 문자열이 빈 문자열어어야 한다
2. 숫자는 양수여야 한다
3. 만약 문자열의 시작이 "//"로 시작할 경우 "\n"이 있어야 한다. 그리고 "\\"와 "\n" 사이에 커스텀 구분자가 있어야 한다 
4. 커스텀 구분자는 길이가 1이고 숫자가 아니어야 한다

## 3. PlusCalculator

1. public int static calculate 함수 구현
