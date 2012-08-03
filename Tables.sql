connect 'jdbc:derby:Tables;create=true';

create table "User" (
	id integer not null
	generated always as identity (start with 1, increment by 1),
	name varchar(255) not null,
	primary key (id)connect 'jdbc:derby:Tables;create=true';
create table "User" (
	id integer not null
	generated always as identity (start with 1, increment by 1),
	name varchar(255) not null,
	primary key (id)
);

create table "CardList" (
	id integer not null
	generated always as identity (start with 1, increment by 1),
	title varchar(255) not null,
	authorId integer not null,
	primary key (id),
	foreign key (authorId) references "User"(id)
);

create table "Card" (
	id integer not null
	generated always as identity (start with 1, increment by 1),
	title varchar(255) not null,
	type varchar(255) not null,
	content long varchar not null,
	listId integer not null,
	authorId integer not null,
	primary key (id),
	foreign key (listId) references "CardList"(id),
	foreign key (authorId) references "User"(id)
);

create table "Comment" (
	id integer not null
	generated always as identity (start with 1, increment by 1),
	content long varchar not null,
	cardId integer not null,
	authorId integer not null,
	primary key (id),
	foreign key (cardId) references "Card"(id),
	foreign key (authorId) references "User"(id)
);
);

create table "List" (
	id integer not null
	generated always as identity (start with 1, increment by 1),
	title varchar(255) not null,
	authorId integer not null,
	primary key (id),
	foreign key (authorId) references "User"(id)
);

create table "Card" (
	id integer not null
	generated always as identity (start with 1, increment by 1),
	title varchar(255) not null,
	type varchar(255) not null,
	content long varchar not null,
	listId integer not null,
	authorId integer not null,
	primary key (id),
	foreign key (listId) references "List"(id),
	foreign key (authorId) references "User"(id)
);

create table "Comment" (
	id integer not null
	generated always as identity (start with 1, increment by 1),
	content long varchar not null,
	cardId integer not null,
	authorId integer not null,
	primary key (id),
	foreign key (cardId) references "Card"(id),
	foreign key (authorId) references "User"(id)
);