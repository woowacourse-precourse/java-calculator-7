# java-calculator-precourse
## 프로그램 구현 사항
### 입력
- [X] 사용자에게 문자열 입력받기
- [X] 커스텀 구분자 있는지 확인하기
- [X] 새롭게 등록된 구분자나, 쉼표(,)와 콜론(:)을 제외한 구분자가 있으면 IllegalArgumentException 발생 및 종료
- [X] 구분자로 parsing 하기
- [X] 양수를 제외한 다른 문자가 있으면 IllegalArgumentException 발생 및 종료

### 계산기 로직
- [X] 문자를 정수로 변환
- [X] 숫자 합 계산

### 출력
- [X] 계산된 값 보여주기
- [X] 종료 로직 구현 

## 궁금한 점 및 판단
- 올바른 입력이 주어졌을 때 프로그램 종료 조건이 제시되어있지 않음
  - 우선 1번의 실행만 되도록 구현할 예정
- 커스텀 구분자의 길이가 제시되어있지 않음
  - 길이가 가변적일 수 있게 구현할 예정

## 라이브러리 제한사항 정리
- ```camp.nextstep.edu.missionutils```에서 제공하는 ```Console``` API를 사용하여 구현해야 한다.
  - 사용자가 입력하는 값은 ```camp.nextstep.edu.missionutils.Console```의 ```readLine()```을 활용한다.
