--==============================
-- mybatis
--==============================
create table student(
    no number,
    name varchar2(50) not null,
    tel char(11) not null,
    created_at date default sysdate,
    updated_at date,
    deleted_at date, -- 학생정보 제거시 deleted_at컬럼 sysdate로 작성.
    constraint pk_student_no primary key(no)
);

create sequence seq_student_no;

insert into student(no, name, tel)
values( seq_student_no.nextval, '홍길동', '01012341234');

insert into student(no, name, tel)
values( seq_student_no.nextval, '신사임당', '01044445555');

insert into student(no, name, tel)
values( seq_student_no.nextval, '세종대왕', '01033334444');

select * from student where deleted_at is null;

select * from student where deleted_at is null and no =1;

--수정시 수정날짜 컬럼 같이 업데이트
update student 
set tel  = '01088889999',
updated_at = sysdate
where no =2;

--학생 삭제시 삭제일짜 업데이트
update student 
set tel  = '01088889999',
deleted_at = sysdate
where no =3;

commit;

-- kh계정의 데이터 사용하기
select * from web.student;--원래는 테이블 풀네임 이렇게 적어주는데 계정에 생성된 테이블은 생략가능.
select * from kh.employee;
select * from kh.department;
select * from kh.job;

-- kh계정으로 select 권한 부여
grant select on kh.employee to web;
grant select on kh.department to web;
grant select on kh.job to web;

--관리자 계정에서 create synonym권한 부여하기
grant create synonym to web;
-- synonym(동의어 객체) 생성하기
create synonym emp for kh.employee;
create synonym dept for kh.department;
create synonym job for kh.job;

select * from emp;
select * from dept;
select * from job;
