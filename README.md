# 🖥️ java-calculator-precourse
<hr>

 - 우아한테크코스 웹 백엔드 7기 프리코스
 - 1주차

### 🗒️ 구현할 기능 목록 

<hr>

1. 입력 받기
   > 문제에서 제공하는 readLine()함수 사용

2. custom 구분자 확인
   - 옳은 입력 vs 잘못된 입력
      > 추가적으로 고려할 custom 구분자가 있는지 확인하기
      > 
      > 옳은 양식이라면 "//"과 "\n"의 위치는 고정
      > 
      > 문자열의 0~4번 index 확인 후 입력 양식 판단
      > 
      > [yes] -> custom 구분자 할당 후 return
      >
      > [no] -> 그냥 return
      > (이때 custom 구분자는 디폴트 구분자로 초기화되어 있음)
      > 
      > (error판단 하지않음) 

3. 문자열 tokenizing
   - custom 구분자 양식 자르기
     > custom구분자 == default구분자면 자를필요 없음
     >
     > custom구분자 != default구분자면 5칸 자르기
   - 잘못된 입력 검사
     > 옳은 입력에는 3가지 조건 존재
     >
     > - 시작은 숫자
     > - 구분자는 ',' or ':' or '{customDelimiter}'
     > - 끝은 숫자
     >
     > 이 조건을 벗어나는 입력은 IllegalArgumentException
   - expression 자르기
     > delimiter에 따라 문자열을 자름
     >
     > 숫자들은 배열에 모아서 반환
     
4. 덧셈
    > 숫자 배열에 있는 숫자를 모두 합하여 결과를 계산함

5. 결과 출력
   > 결과를 옳은 형식으로 출력

