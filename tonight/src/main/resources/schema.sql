create table if not exists houses(
	id int not null auto_increment primary key,
	name varchar(50) not null,
	image_name varchar(50),
	description text not null,
	price int not null,
	capacity int not null,
	postal_code varchar(50) not null,
	address varchar(255) not null,
	phone_number varchar(50) not null,
	created_at datetime not null default current_timestamp,
	updated_at datetime not null default current_timestamp on update current_timestamp
	
);

create table if not exists roles (
	id int not null auto_increment primary key,
	name varchar(50) not null
);

create table if not exists users (
	id int not null auto_increment primary key,
	name varchar(50) not null,
	furigana varchar(50) not null,
	postal_code varchar(50) not null,
	address varchar(255) not null,
	phone_number varchar(50) not null,
	email varchar(50) not null,
	password varchar(255) not null,
	role_id int not null,
	enabled boolean not null,
	created_at datetime not null default current_timestamp,
	updated_at datetime not null default current_timestamp on update current_timestamp
	
);

create table if not exists verification_tokens(
	id int not null auto_increment primary key,
	user_id int not null unique,

	token varchar(255) not null unique,
	created_at datetime not null default current_timestamp,
	updated_at datetime not null default current_timestamp on update current_timestamp,
		foreign key (user_id) references users (id)
);

create table if not exists reservations (
	id int not null auto_increment primary key,
	house_id int not null,
	user_id int not null,
	checkin_date date not null,
	checkout_date date not null,
	number_of_people int not null,
	amount int not null,
	created_at datetime not null default current_timestamp,
	updated_at datetime not null default current_timestamp on update current_timestamp,
	foreign key (house_id) references houses (id),
	foreign key (user_id) references users (id)
);