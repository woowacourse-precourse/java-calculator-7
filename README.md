# java-calculator-precourse

## 패키지 구조

# 기능 목록
## 입력
- [x] 입력 프롬프트를 출력한다.
- [x] 한 줄의 문자열을 입력 받는다.
- [x] 입력이 숫자 혹은 '/'로 시작하지 않는 경우에는  
IllegealArgumentException을 발생시신 후 애플리케이션을 종료한다.

## 빈 입력 처리
- [x] 입력이 비어 있을 경우 0을 반환한다.

## 숫자 추출
1. 입력이 숫자(0~9)로 시작하는 경우 </br>
   - [x] 입력 문자열을 쉼표(,) 또는 콜론(:)으로 분리하여 숫자만 추출한다.
2. 입력이 커스텀 구분자인 경우 ("//" + separator + "\n") </br>
   - [x] "//"와 "\n" 사이의 문자를 추출한다.
   - [x] 입력 문자열을 추출한 문자로 분리하여 숫자만 추출한다.

## 덧셈
- [x] 추출한 숫자들을 모두 더한다.

## 결과
- [x] 출력 프롬프트와 함께 더한 값을 출력한다.