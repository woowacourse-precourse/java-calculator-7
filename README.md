# java-calculator-precourse

## 요구사항 분석
기능 요구 사항을 분석하면 아래와 같다.  
- 문자열을 전달받으면 구분자를 기준으로 숫자를 분리, 각 숫자의 합을 반환(출력)한다.
- 기본 구분자는 각각 **: ,** 가 있고 **//**와 **\n** 사이의 문자를 커스텀 구분자로 사용할 수 있다.
- 음수, 잘못된 커스텀 구분자 설정, 잘못된 구분자가 입력되는 경우 IllegalArgumentException 을 발생시기코 애플리케이션을 종료시킨다.

이에 대해서 프로그래밍 요구사항 중 구현과 관련되는 사항은 아래와 같았다.  
- build.gradle은 수정이 불가능하고, 제공된 라이브러리만을 사용해서 구현해야한다.
- 프로그램 종료 시 System.exit()을 호출하지 않는다.
- 요구사항에서 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 코드 컨벤션을 지키면서 프로그래밍 한다.(사실 제일 중요한 부분이다.)

## 구현할 기능 목록
요구사항에 대해서 기능을 나누면 아래와 같이 나눠볼 수 있다.
- 문자열 입력
- 커스텀 구분자 찾기
- 커스텀 구분자 + 기본 구분자를 이용해서 숫자 분리
- 구분한 숫자들 기반으로 음수 혹은 잘못된 입력인 경우 IllegalArgumentException을 발생시키고 애플리케이션을 종료
- 올바른 입력인 경우 구분자를 기준으로 나눈 숫자들의 합을 반환(출력)

