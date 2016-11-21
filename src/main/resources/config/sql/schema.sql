/*
 * 스키마
 */

create table locations (
	location_id		numeric,
    street_address	varchar(40),
    postal_code		varchar(12),
    city			varchar(30)	not null,
    state_province	varchar(25),
    country_id		char(2)
);

create table i18n (
	code	varchar(100) not null,
	desc	varchar(200),
	def_msg	varchar(200) not null
);

alter table i18n add constraint i18n_pk primary key (code);

create table i18n_lang (
	lang varchar(5) not null,
	name varchar(50) not null
);

alter table i18n_lang add constraint i18n_lang_pk primary key (lang);

create table i18n_dtl (
	code	varchar(100) not null,
	lang	varchar(5) not null,
	msg		varchar(200) not null
);

alter table i18n_dtl add constraint i18n_dtl_pk primary key (code, lang);

alter table i18n_dtl add constraint rel_i18n_dtl foreign key (code) references i18n (code) on delete cascade on update cascade;

alter table i18n_dtl add constraint rel_i18n_lang_dtl foreign key (lang) references i18n_lang (lang) on delete cascade on update cascade;