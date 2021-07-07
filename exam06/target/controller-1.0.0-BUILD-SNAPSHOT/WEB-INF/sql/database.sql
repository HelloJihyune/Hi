create table tbl_board (
	bno int primary key auto_increment,
	title varchar(200) not null,
	content text,
	writer varchar(50) not null,
	regdate datetime default current_timestamp,
	updatedate datetime default current_timestamp on update current_timestamp
);