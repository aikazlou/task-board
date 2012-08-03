connect 'jdbc:derby://localhost:1527/Tables;create=true';

create table USERS (
	ID integer not null
	generated always as identity (start with 1, increment by 1),
<<<<<<< HEAD

	name varchar(255) not null,
	primary key (id)connect 'jdbc:derby:Tables;create=true';
=======
	NAME varchar(255) not null,
	primary key (ID)
>>>>>>> branch 'dev' of https://github.com/aikazlou/task-board.git
);

<<<<<<< HEAD

=======
>>>>>>> branch 'dev' of https://github.com/aikazlou/task-board.git
create table LISTS (
	ID integer not null
	generated always as identity (start with 1, increment by 1),
	TITLE varchar(255) not null,
	AUTHOR_ID integer not null,
	primary key (ID),
	foreign key (AUTHOR_ID) references USERS(ID)
);

create table CARDS (
	ID integer not null
	generated always as identity (start with 1, increment by 1),
	TITLE varchar(255) not null,
	TYPE varchar(255) not null,
	CONTENT long varchar not null,
	LIST_ID integer not null,
	AUTHOR_ID integer not null,
	primary key (ID),
	foreign key (LIST_ID) references LISTS(ID),
	foreign key (AUTHOR_ID) references USERS(ID)
);

create table COMMENTS (
	ID integer not null
	generated always as identity (start with 1, increment by 1),
	CONTENT long varchar not null,
	CARD_ID integer not null,
	AUTHOR_ID integer not null,
	primary key (ID),
	foreign key (CARD_ID) references CARDS(ID),
	foreign key (AUTHOR_ID) references USERS(ID)
<<<<<<< HEAD
);
=======
);
>>>>>>> branch 'dev' of https://github.com/aikazlou/task-board.git
