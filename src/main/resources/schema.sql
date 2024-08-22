--バイクマスタ
drop table if exists m_motorcycle;

create table m_motorcycle (
    moto_no int not null,
    moto_name varchar(100),
    seat_height int,
    cylinder int,
    cooling varchar(20),
    price int,
    comment varchar(200),
    brand_id varchar(2),
    version int,
    ins_dt datetime,
    upd_dt datetime
) comment 'バイクマスタ';

--バイクブランドマスタ
drop table if exists m_brand;

create table m_brand (
    brand_id varchar(2) not null primary key comment 'ブランドID',
    brand_name varchar(20) comment 'ブランド名'
) comment 'ブランドマスタ';

--ユーザーマスタのテーブル作成
drop table if exists m_user;

create table m_user (
    username varchar(20) not null primary key comment 'ユーザー名',
    password varchar(100) comment 'パスワード'
) comment 'ユーザーマスタ';