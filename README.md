# java-calculator-precourse
## 기능
1. 파서 구현
   1. 생성자로 기본 구분자 주입
   2. 추가 구분자를 위한 구별자 설정
   3. 주어진 입력값에서 구분자 추가
      1. 잘못된 입력값에 대해서는 구분자 추가 없이 무시됨
   4. 주어진 입력값에서 주입된 피연산자 정책에 따라 피연산자 추출
      1. 정수로 변환이 되는지, 주어진 정책을 따르는지 2가지 종류의 에러를 캐치

2. 계산기 구현
   1. 계산 함수를 생성자를 통해 주입
   2. 주어진 피연산자(정수이며, 정책을 따름이 보장됨)와 연산을 통해 최종 결과값을 반환

## 리팩토링
~~### exception 처리  
단순 IllegalArgumentException + msg 조합으로 새로운 exceptions 정의~~  
기존의 방식대로 IllegalArgumentException에 msg를 적는것으로 대체

## 문서 작성
1. input
2. parser
3. calculator
