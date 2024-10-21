# 우테코 7기 프리코스 1주차 미션 - 문자열 덧셈 계산기

## 기능 구현 목록

### 1. 입력값 처리 및 숫자 분리

- **기본 구분자 사용**  
  쉼표(,)와 콜론(:)을 기본 구분자로 하여 입력받은 문자열을 처리함.
    - 입력 문자열을 처리하여 구분자에 따라 숫자를 분리하는 **'parserNumbers'** 메서드 구현.
        - 입력 문자열이 커스텀 구분자를 포함하는지 확인하는 **'hasCustomDelimiter'** 메서드 구현.
        - 커스텀 구분자가 포함된 경우, '//'와 '\n' 사이의 문자열을 구분자로 추출하는 **'extractCustomDelimiter'** 메서드 구현.
        - 커스텀 구분자가 포함된 경우 숫자 부분만을 추출하는 **'extractNumbersSection'** 메서드 구현.
        - 기본 구분자(쉼표, 콜론)와 커스텀 구분자로 문자열을 나누어 숫자를 분리하는 **'splitNumbers'** 메서드 구현.

- **커스텀 구분자 처리**  
  입력값이 "//"로 시작하고 "\n" 이전까지 커스텀 구분자가 정의된 경우 이를 적용하여 구분함.
    - 커스텀 구분자에 특수 문자가 포함된 경우 정규식에서 사용할 수 있도록 이스케이프 처리함.
        - 정규식에서 사용할 수 있게 특수 문자를 이스케이프 처리하는 **escapeSpecialCharacters** 메서드 구현.

- **빈 문자열 처리**  
  입력값이 빈 문자열인 경우 결과는 0을 반환.

### 2. 입력 값 검증

- **숫자 형식 검증**  
  입력값에 숫자가 아닌 값이 포함된 경우 IllegalArgumentException을 발생시킴.

- **음수 처리**  
  입력값에 음수가 포함된 경우, 예외를 발생 시킴.
    - 분리된 숫자 배열을 합산하며 음수 값이 있는지 확인함. 음수가 발견되면 예외를 발생시킴.

- **올바른 커스텀 구분자 형식 검증**  
  커스텀 구분자가 잘못된 형식("//구분자\n")으로 입력된 경우, 예외를 발생시킴.

### 3. 숫자 더하기

- **숫자 더하기 로직**  
  분리된 숫자들을 각각 더한 후 결과를 반환함.
    - 문자열 배열을 숫자로 변환하고 합산합니다. 음수가 포함된 경우 예외를 발생시키는 **sum** 메서드 구현.
    - **예외 처리**: 음수가 있는 경우 예외를 발생시킴.

### 4. 출력

- **최종 결과 출력**  
  계산된 결과를 "결과 : " 메시지와 함께 출력.

- **오류 메시지 출력**  
  입력값에 오류가 있을 경우, 해당 오류 메시지를 출력하고 프로그램을 종료.

## 클래스 설명

### 1. Application 클래스

- 프로그램의 시작점으로, 입력을 받아서 처리하고 최종 결과를 출력함.
- DelimiterParser 객체로 입력값을 처리하고, StringCalculator 객체를 이용해 계산함.

### 2. DelimiterParser 클래스

- 입력값을 처리하고 구분자 및 숫자를 분리함.
    - **parseNumbers** 메서드 : 기본 구분자와 커스텀 구분자를 사용해 문자열에서 숫자를 분리함.
    - **hasCustomDelimiter** 메서드 : 커스텀 구분자가 있는지 확인함.
    - **extractCustomDelimiter** 메서드 : 커스텀 구분자를 추출함.
    - **extractNumberSection** 메서드 : 숫자 부분을 추출함.
    - **escapeSpecialCharacters** 메서드 : 특수 문자를 이스케이프 처리함.

### 3. NumberExtractor 클래스

- 입력된 문자열을 구분자에 따라 숫자로 분리하는 기능을 담당함.
    - **splitNumbers** 메서드 : 주어진 구분자로 입력 문자열을 분리함.

### 4. StringCalculator 클래스

- 분리된 숫자를 합산함.
    - **sum** 메서드 : 주어진 숫자 배열을 합치고, 음수인 경우 예외를 발생시킴.

##테스트 케이스

- **커스텀 구분자로 문자열 분리** : 커스텀 구분자를 사용한 입력 문자열을 처리하는 테스트.
- **기본 구분자로 문자열 분리** : 쉼표와 콜론을 기본 구분자로 처리하는 테스트.
- **잘못된 구분자 형식 예외 처리** : 잘못된 구분자가 입력되었을 때 예외를 처리하는 테스트.
- **음수 입력 예외 처리** : 음수가 입력되었을 때 예외가 발생하는지 확인하는 테스트.
- **빈 문자열 처리** : 빈 문자열이 입력되었을 때 0을 반환하는지 확인하는 테스트.
