# java-calculator-precourse

# 구현 내용

- [X]  입력을 받아오는 View에 해당하는 객체 정의
- [X]  View에서 유저의 입력을 받은 후 null인지 확인
  → 입력이 null인 경우 IllegalArgumentException를 발생
- [X]  입력이 null이 아닌 경우 Model에 해당하는 DTO를 이용하여 데이터를 Controller로 전달
  → DTO(request) 객체와 Controller 객체 생성
- [x]  이렇게 전달된 Controller에서 Service를 호출하여 핵심 비즈니스 로직(계산)을 실행
  → Service 객체 생성
- [x]  Service에서는 우선 문자열을 파싱하여 커스텀 연산자를 뽑아내고, 이를 Set or List에 담아둠
  → 커스텀 연산자 등록 부분을 제외한 String을 반환함.
  → 파싱과정에서 문제가 생기면 IllegalArgumentException을 발생
  → ex) "//;\n1;2;3" → “1;2;3”
- [x]  커스텀 연산자들은 따로 객체를 만들어 보관하고 커스텀 연산자 등록 부분을 제외한 String에 대해서 계산을 진행
  → 계산하는 방식은 StringTokenizer에서 기존의 연산자(, :)와 새로 등록된 연산자들을 기준으로 나누고, 숫자들을 덧셈하는 식으로 진행.
  → 이 과정에서 token이 숫자가 아니면 IllegalArgumentException을 발생 → 지정된 연산자가 아닌 연산자가 있는 경우 예외 발생
- [x]  위와 같이 계산된 결과는 Controller에 return되고 이 값은 Model(DTO - response)에 담겨 View로 다시 전달됨
  → response DTO 역할을 맞는 객체 필요
- [x]  이후 View의 역할을 맞는 객체는 해당 결과값을 출력하는 역할을 진행하고, 프로그램이 종료