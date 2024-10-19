# java-calculator-precourse

#구현할 기능 목록

1. null일 때 0 출력
2. 문자열에서 숫자 분리
3. ","와 ":"을 기본 구분자로 사용
4. 문자열 앞부분의 "//"와 "\\n" 사이에 위치하는 문자를 커스텀 구분자로 사용
5. 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션 종료
6. Main함수


고민한 점

1. 한글 인코딩 : utf-8로 모든 intellij 설정을 했지만 되지 않아서 gradle문제일것이라고 판단하고 빌드 도구를 gradle에서 intellij로 바꾸자 해결됨. (bulid.gradle)파일에 utf-8관련 설정을 추가하면 해결된다고 하였지만 프리코스 규칙상 바꾸지 않았음.
2. split을 사용했다가 StringTokenizer로 바꾼이유 :

   기존처럼 split을 사용하면 @나 ;는 잘 작동이 되었지만,

   ```
   //$\n1$2,3
   ```
   와 같이 입력시 $ 문자가 정규표현식때문에

   ```
   \\$
   ```
   와 같이 표현해야 split 되는 오류가 있었다. 찾아보니 StringTokenizer를 사용하면 특수기호가 문자화되어 안전하게 토큰 분리가 가능했다.
