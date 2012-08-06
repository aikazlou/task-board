connect 'jdbc:derby://localhost:1527/Tables;create=true';

create table USERS (
	ID integer not null
	generated always as identity (start with 1, increment by 1),
	LOGIN varchar(255) not null,
	NAME varchar(255) not null,
	primary key (ID),
	unique (NAME),
	unique (LOGIN)
);

create table LISTS (
	ID integer not null
	generated always as identity (start with 1, increment by 1),
	TITLE varchar(255) not null,
	AUTHOR_ID integer not null,
	TIME_STAMP bigint not null,
	primary key (ID),
	foreign key (AUTHOR_ID) references USERS(ID),
	unique(AUTHOR_ID),
	unique(TIME_STAMP)
);

create table CARDS (
	ID integer not null
	generated always as identity (start with 1, increment by 1),
	TITLE varchar(255) not null,
	TYPE varchar(255) not null,
	CONTENT long varchar not null,
	LIST_ID integer not null,
	AUTHOR_ID integer not null,
	TIME_STAMP bigint not null,
	primary key (ID),
	foreign key (LIST_ID) references LISTS(ID),
	foreign key (AUTHOR_ID) references USERS(ID),
	unique (AUTHOR_ID),
	unique (TIME_STAMP)
);

create table COMMENTS (
	ID integer not null
	generated always as identity (start with 1, increment by 1),
	CONTENT long varchar not null,
	CARD_ID integer not null,
	AUTHOR_ID integer not null,
	TIME_STAMP bigint not null,
	primary key (ID),
	foreign key (CARD_ID) references CARDS(ID),
	foreign key (AUTHOR_ID) references USERS(ID),
	unique(AUTHOR_ID),
	unique(TIME_STAMP)
);
