# 문자열 덧셈 계산기

## 입출력 요구 사항

### InputValidator
- 입력에 대해 유효성 검증을 실시한다. 크게 2가지 경우로 구분하여 예외처리를 진행
  - 기본 구분자를 사용하는 경우
  - 커스텀 구분자를 사용하는 경우


1. 음수를 입력한 경우
2. 기본 구분자를 사용할 때 기본 구분자와 양수를 제외한 문자를 입력한 경우
3. 커스텀 구분자 형식이 잘못된 경우
4. 커스텀 구분자로 양수가 오는 경우
5. 수식에서 커스텀 구분자 및 양수 외에 다른 문자를 사용한 경우
6. 커스텀 구분자로 "."을 사용한 경우

   ex) //.\n1.2.3.4 같은 경우 (1.2) + (3.4)인지, 1+2+3+4 인지 해석할 수 없다

+) 여기서 커스텀 구분자는 길이가 1인 문자만 허용하도록 했다. 문제에서 문자열, 문자들이 아닌 '문자'라고 쓰여 있었기 때문

## 기능 요구 사항

계산기의 기능을 크게 3가지 정도로만 생각했습니다.

### Calculator 인터페이스
- `insertValues(String input);`
- `extractNumber();`
- `sum();`

## 1. Validation을 통과한 입력에서 구분자, 수식을 분리해 저장

- 입력 문자열이 커스텀 구분자를 사용하는 경우인지 아닌지를 나눠 구분자, 수식을 저장

## 2. 입력 문자열에서 구분자 및 양수 추출

- 입력 문자열에서 구분자로 숫자를 분리해 List에 추가

## 3. 분리된 양수들의 덧셈

- List의 양수들을 전부 더함
