create table Homework(
	id			INTEGER generated by default as identity primary key,
	name		VARCHAR(50) not null,
	description	text	
)

create table Lesson(
	id			INTEGER generated by default as identity primary key,
	name		VARCHAR(50) not null,
	updateAt	TEXT,
	homework_id	INTEGER,
	foreign key (homework_id) references Homework(id)
)

create table Schedule(
	id			INTEGER generated by default as identity primary key,
	name		VARCHAR(50) not null,
	updatedAt	TEXT,
	lessons     INTEGER
)

create table Program(
    lessons_id  INTEGER,
    schedule_id INTEGER,
   	foreign key (lessons_id) references Lesson(id),
	foreign key (schedule_id) references Schedule(id)
)