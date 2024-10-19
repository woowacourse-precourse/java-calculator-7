#!/bin/bash

# CHANGELOG.md 파일 생성 및 초기 내용 작성
echo "# Changelog" > CHANGELOG.md
echo "" >> CHANGELOG.md

# 버전 정보 확인
latest_tag=$(git describe --tags --abbrev=0)
if [ -z "$latest_tag" ]; then
  version="[Unreleased]"
else
  version="[$latest_tag] - $(git log -1 --format=%ad --date=short)"
fi
echo "## $version" >> CHANGELOG.md
echo "" >> CHANGELOG.md

# 변경사항 유형별 섹션 생성
echo "### 새로운 기능" >> CHANGELOG.md
# 'feat'으로 시작하는 커밋 메시지를 가져오고, Merge 커밋은 제외합니다.
git log --pretty=format:"- %s ([%h](https://github.com/Jaewon94/java-calculator-7/commit/%H))" --grep="^feat" --no-merges >> CHANGELOG.md
echo "" >> CHANGELOG.md

echo "### 버그 수정" >> CHANGELOG.md
# 'fix'로 시작하는 커밋 메시지를 가져오고, Merge 커밋은 제외합니다.
git log --pretty=format:"- %s ([%h](https://github.com/Jaewon94/java-calculator-7/commit/%H))" --grep="^fix" --no-merges >> CHANGELOG.md
echo "" >> CHANGELOG.md

echo "### 문서" >> CHANGELOG.md
# 'docs'로 시작하는 커밋 메시지를 가져오고, Merge 커밋은 제외합니다.
git log --pretty=format:"- %s ([%h](https://github.com/Jaewon94/java-calculator-7/commit/%H))" --grep="^docs" --no-merges >> CHANGELOG.md
echo "" >> CHANGELOG.md

echo "### 변경사항" >> CHANGELOG.md
# 'refactor', 'style', 'chore'로 시작하는 커밋 메시지를 가져오고, Merge 커밋은 제외합니다.
git log --pretty=format:"- %s ([%h](https://github.com/Jaewon94/java-calculator-7/commit/%H))" --grep="^refactor\|^style\|^chore" --no-merges >> CHANGELOG.md
echo "" >> CHANGELOG.md

echo "### 주요 변경사항" >> CHANGELOG.md
# 'BREAKING CHANGE'로 시작하는 커밋 메시지를 가져오고, Merge 커밋은 제외합니다.
git log --pretty=format:"- %s ([%h](https://github.com/Jaewon94/java-calculator-7/commit/%H))" --grep="^BREAKING CHANGE" --no-merges >> CHANGELOG.md
echo "" >> CHANGELOG.md

echo "### 기타 변경사항" >> CHANGELOG.md
# 'feat', 'fix', 'docs', 'refactor', 'style', 'chore', 'BREAKING CHANGE'로 시작하지 않는 커밋 메시지를 가져옵니다.
# Merge 커밋도 제외합니다.
git log --pretty=format:"- %s ([%h](https://github.com/Jaewon94/java-calculator-7/commit/%H))" --grep="^feat\|^fix\|^docs\|^refactor\|^style\|^chore\|^BREAKING CHANGE" --invert-grep --no-merges >> CHANGELOG.md

# 주요 git log 옵션 설명:
# --pretty=format:"- %s (%h)": 커밋 메시지와 커밋 해시코드를 불릿 포인트로 출력합니다.
# --grep="^pattern": 지정된 패턴으로 시작하는 커밋 메시지를 필터링합니다.
# --invert-grep: grep 패턴과 일치하지 않는 커밋을 선택합니다.
# --no-merges: Merge 커밋을 제외합니다.
# 여러 --grep 옵션을 사용하면 OR 조건으로 작동합니다.