# 🖥️ java-calculator-precourse
<hr>

 - 우아한테크코스 웹 백엔드 7기 프리코스
 - 1주차

### 🗒️ 구현할 기능 목록 

<hr>

1. 입력 받기
   > 문제에서 제공하는 readLine()함수 사용

2. custom 구분자 확인
   > 추가적으로 고려할 custom 구분자가 있는지 확인하기
   > 
   > 옳은 양식이라면 "//"과 "\n"의 위치는 고정
   > 
   > 문자열의 0~4번 index 확인 후 입력 양식 판단
   > 
   > [yes] -> 0~4번 index 잘라내고 5번 index부터 시작하도록 tokenize
   >
   > [no] -> 그냥 return (입력 Error는 3번 과정에서 한 번에 처리)

3. 덧셈
    - 문자열 tokenizing
      > 문자열의 index 1칸씩 검사 (엄밀히는 tokenizing 아님)
    - sum 연산
      > 숫자가 나오면 최종 반환 변수에 값 더하기
    - 잘못된 입력 검사
      > 옳은 입력에는 3가지 조건 존재
      >
      > - 시작은 숫자
      > - 구분자는 ',' or ':' or '{customDelimiter}'
      > - 끝은 숫자
      > 
      > 이 조건을 벗어나는 입력은 IllegalArgumentException

4. 결과 출력
   > 결과를 옳은 형식으로 출력

