# java-calculator-precourse
## Class 다이어그램
![class 다이어그램](https://github.com/user-attachments/assets/80b759ed-8398-44bb-b040-b34a6ef527ed)

## 동작 과정
![Working Process](https://github.com/user-attachments/assets/d8435f0a-e42f-442c-bfa4-c5c1aade570a)

## 프로그램 구현 사항
### 입력
- [X] 사용자에게 문자열 입력받기
- [X] 예외 케이스 처리하기
  - [X] 공백이나 null를 입력한 경우
  - [X] 잘못된 구분자를 입력한 경우
  - [X] 올바르지 않은 형식으로 구분자를 등록하는 경우
  - [X] 피연산자에 숫자가 아닌 경우
  - [X] 피연산자에 양수가 아닌 경우
  - [X] 처음부터 영어를 입력한 경우
- [X] 커스텀 구분자 있는지 확인하기
- [X] 구분자로 parsing 하기
- [X] parsing한 숫자를 메모리에 저장하기

### 계산기 로직
- [X] 문자를 정수로 변환
- [X] 숫자 합 계산

### 출력
- [X] 계산된 값 보여주기
- [X] 종료 로직 구현

## 구현하면서 생각했던 것들
- 올바른 입력이 주어졌을 때 프로그램 종료 조건이 제시되어있지 않음
  - 우선 1번의 실행만 되도록 구현할 예정
- 커스텀 구분자의 길이가 제시되어있지 않음
  - 길이가 가변적일 수 있게 구현할 예정
- 예외처리과정에서 사용자의 입력에 따라 그에 맞는 피드백을 주기 위해 세분화하여 예외처리를 했는데, 과연 하나의 메소드로 여러 예외처리를 하는게 좋은건지 구체화할 수록 좋은건지 고민이 됨.

## 라이브러리 제한사항 정리
- ```camp.nextstep.edu.missionutils```에서 제공하는 ```Console``` API를 사용하여 구현해야 한다.
  - 사용자가 입력하는 값은 ```camp.nextstep.edu.missionutils.Console```의 ```readLine()```을 활용한다.
