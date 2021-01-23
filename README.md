Custom-WOL 개발 일지
=========================

###2021-01-17
- 프로젝트 생성
- Member / DataInfo Service O
- MemoryMemberRepository O
  - MemoryDataInfoRepository X

###2021-01-20
- Spring Security 적용(이거 어려움)
  - 스프링 시큐리티 적용하다가 위에 만든거 다 버림..
  
###2021-01-24
- Spring Security 메소드 이해
  - 로그인 서비스에 적용
  
- Thymleaf + Security 사용
  - Thymleaf Security 사용하니까 진짜 편함.
  
- MariaDB Wol Table 생성
  - 도메인에 Entity / Data 설정해주니 Getter Setter 無필요 해짐.
    - 이건 진짜 편한 것 같음.
  - 데이터 가져오기 까지 성공
    - 하지만 DB 부분에서 데이터를 가져올 때 테이블 부분을 조금 수정해야함. </br>
      <strong>select * from wol where xxx=bbb</strong> 처리가 필요할 것 같음.</br>
        - 이 부분에 대해서는 키값 매핑 해줄 때 USER Table에서 id 값으로(username 값 아님) 맵핑 해주면 될 것 같기도하고(is 여러개의 MAC Address는 한개의 아이디 값을 갖으니 ManyToOne ..??)
  - 맵핑(@ManyToMany 등...)에 대한 이해가 필요.