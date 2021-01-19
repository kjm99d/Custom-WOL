create table user_info (
                           id varchar(15),
                           password varchar(500),
                           isAccountNonexpired int,
                           isAccountNonLocked int,
                           isCredentialsNonExpired int,
                           isEnabled int
);

create table authority (
                           username varchar(20),
                           authority_name varchar(20)
);

INSERT INTO USER_INFO VALUES ( 'TEST' , '1234' , '1','1','1','1' );
INSERT INTO AUTHORITY VALUES ( 'TEST' , 'ROLE_ADMIN' );
INSERT INTO AUTHORITY VALUES ( 'TEST' , 'ROLE_MEMBER' );