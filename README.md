# java-calculator-precourse

## 문자열 덧셈 계산기
---
### 기능 요구 사항
#### 주요 클래스 구조:

0. StringAdder (메인 클래스)
1. InputValidator
2. DelimiterParser
3. NumberParser
4. Calculator

#### 단계별 구현:
0. Console API 라이브러리 추가 및 기본 구조 설정
   - 프로젝트에 Console API 라이브러리 추가
   - StringAdder 클래스 기본 구조 생성
1. InputValidator 구현
   - 입력값 null 체크
   - 빈 문자열 체크
   - 잘못된 입력에 대한 예외 처리
2. DelimiterParser 구현
   - 기본 구분자(쉼표, 콜론) 처리 
   - 커스텀 구분자 처리 ("//"로 시작하는 경우)
3. NumberParser 구현 
   - 구분자를 이용해 문자열을 숫자 배열로 변환
   - 숫자 파싱 중 발생할 수 있는 예외 처리
4. Calculator 구현
   - 숫자 배열의 합 계산
   - 음수 입력 시 IllegalArgumentException 발생 
5. StringAdder에서 통합 
   - 각 컴포넌트를 조합하여 전체 로직 구현
   - Console.readLine()을 사용한 입력 처리
   - 결과 출력 및 예외 처리