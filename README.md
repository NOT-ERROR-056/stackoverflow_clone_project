# [PRE_PROJECT] Stack overflow 웹 clone 프로젝트

`목표 : CRUD 원리를 이해하고, 개발의 전체적인 프로세스를 이해하자`

<br>

> 프로젝트 기간 : 2022.08.23 ~ 9.6


<br>

## 🙋‍♂️ 팀원

### CLIENT
|[<img src="https://avatars.githubusercontent.com/u/61141988?v=4" width="230px;" alt=""/>](https://github.com/Hong-sk) |[<img src="https://avatars.githubusercontent.com/u/94218285?v=4" width="230px">](https://github.com/git-daun)|[<img src="https://avatars.githubusercontent.com/u/94212747?v=4" width="230px" >](https://github.com/NR0617)|
|:---:|:---:|:---:|
|[홍성권](https://github.com/Hong-sk) |[정다운](https://github.com/git-daun) |[오나래](https://github.com/NR0617)|
|FE_CTO|리마인더, 브랜치 관리|기록 및 노션 관리|

### SERVER
|[<img src="https://avatars.githubusercontent.com/u/79829085?v=4" width="230px;" alt=""/>](https://github.com/Si-Hyeak-KANG) |[<img src="https://avatars.githubusercontent.com/u/98000922?v=4" width="230px" >](https://github.com/Juniverse)|[<img src="https://avatars.githubusercontent.com/u/95335294?v=4" width="230px">](https://github.com/hongmj37)|[<img src="https://avatars.githubusercontent.com/u/98211110?v=4" width="230px" >](https://github.com/HYUNSUK331)|
|:---:|:---:|:---:|:---:|
|[강시혁](https://github.com/Si-Hyeak-KANG) |[황윤준](https://github.com/YunJuniverse)|[홍민정](https://github.com/hongmj37) |[이현석](https://github.com/HYUNSUK331)|
|🌟PM|BE_CTO|기록 및 GitHub 관리|부PM 및 디스코드 관리|

<br>

## 📝 프로젝트 핵심 기능
* 회원 간에 질문과 응답을 공유 및 관리하는 기능

<br>

## 협업 툴
1. 공지 및 이슈 공유 : Notion, Discord
2. 프로젝트 관리 : Github
3. 기술 및 이슈 기록 : Github issue
4. 비대면 회의 : Google meet
5. 기타 문서 작업 : 구글docs


<br>

## 배포&테스트 전략
* 8/29 ~ 9/1 : 공유 ip를 통해 서버 상시 실행 후, dev 브랜치의 커밋 내용을 기반으로 API 통신 단위 테스트 진행
* 9/2 : aws 3-Tier 아키텍처로 서비스 통합 테스트 진행
* 9/5 : main 브랜치 배포(3-Tier 아키텍처)

<br>

## WBS
![pre_wbs](https://user-images.githubusercontent.com/79829085/186574105-e465b415-05c6-4b48-b53d-02ab76cfac74.png)

## 브랜치 전략 & 커밋 메시지 규칙

### 1) 브랜치 전략
`Coz' Git flow`
* main : 사용자에게 언제든 제품으로 출시할 수 있는 브랜치
* dev : 다음 버전 배포를 위한 "개발 중" 브랜치
* fix : 기능 개발, 리팩토링, 문서 작업 등 단위별 작업 관리를 위한 브랜치

(1) 각 개발자 분들은 본 repository를 fork합니다.

(2) 본인 계정에 생성된 repo에서 로컬로 clone합니다.

(3) clone 프로젝트에서 코드를 치기전에 'fix'로 새로운 브랜치를 생성합니다.

(4) 작업이 완료되면, 새로운 브랜치(fix)에 push합니다.

(5) 팀원 모두가 계획한 작업을 수행하면 팀 코드리뷰를 진행합니다.

(6) 모두 완료하면, 본 repository의 dev 브랜치로 pull request합니다. - (pull request시 설명을 자세하게 기록해주세요.)

<br>

### 2) 커밋 메시지 규칙

`(1) 작업명은 한글로 통일`

`(2) 영어 단어로 시작하는 경우, 첫 글자는 대문자`

`(3) 작업명은 자세하게 작성`

`(4) 메시지 마지막에 .(마침표) 금지`

`(5) 브랜치명/작업명 형식으로 작성 `

ex)
* fix 브랜치 커밋시 : [FE_fix]글 작성 버튼 구현 , [BE_fix]Question 컨트롤러 생성, [BE_issue]Question 컨틀로러 예외처리 오류 수정 등



