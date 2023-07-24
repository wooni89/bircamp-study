insert into myapp_member(member_no, name, email, password, gender) 
values(1, 'aaa', 'test@test.com', sha1('1111'), 'W');
insert into myapp_member(member_no,name, email, password, gender) 
values(2,'bbb', 'test2@test.com', sha1('1111'), 'M');
insert into myapp_member(member_no,name, email, password, gender) 
values(3,'ccc', 'test3@test.com', sha1('1111'), 'W');
insert into myapp_member(member_no,name, email, password, gender) 
values(4,'ddd', 'test4@test.com', sha1('1111'), 'M');
insert into myapp_member(member_no,name, email, password, gender) 
values(5,'eee', 'test5@test.com', sha1('1111'), 'W');
insert into myapp_member(member_no,name, email, password, gender) 
values(6,'fff', 'fffff@test.com', sha1('1111'), 'M');

-- myapp_board 데이터

insert into myapp_board(board_no, title, content, writer, password, category)
values(11, '제목1', '테스트', 1, sha1('1111'), 1);
insert into myapp_board(board_no, title, content, writer, password, category)
values(12, '제목2', '테스트1', 1, sha1('1111'), 1);
insert into myapp_board(board_no, title, content, writer, password, category)
values(13, '제목3', '테스트2', 3, sha1('1111'), 1);
insert into myapp_board(board_no, title, content, writer, password, category)
values(14, '제목4', '테스트3', 4, sha1('1111'), 1);
insert into myapp_board(board_no, title, content, writer, password, category)
values(15, '제목5', '테스트4', 5, sha1('1111'), 2);
insert into myapp_board(board_no, title, content, writer, password, category)
values(16, '제목6', '테스트5', 5, sha1('1111'), 2);
insert into myapp_board(board_no, title, content, writer, password, category)
values(17, '제목7', '테스트6', 5, sha1('1111'), 2);