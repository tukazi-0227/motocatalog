--バイク情報--
insert into m_motorcycle(moto_no, moto_name, seat_height, cylinder, cooling, price, comment, brand_id, version, ins_dt, upd_dt) values (1, 'GB350', 800, 1, '空冷', 550000, '音がいい', '01', 1, now(), null);
insert into m_motorcycle(moto_no, moto_name, seat_height, cylinder, cooling, price, comment, brand_id, version, ins_dt, upd_dt) values (2, 'Z900RS', 800, 4, '空冷', 550000, 'かこいい', '02', 1, now(), null);
insert into m_motorcycle(moto_no, moto_name, seat_height, cylinder, cooling, price, comment, brand_id, version, ins_dt, upd_dt) values (3, 'W800 CAFE', 800, 2, '空冷', 750000, 'カフェ', '01', 1, now(), null);
insert into m_motorcycle(moto_no, moto_name, seat_height, cylinder, cooling, price, comment, brand_id, version, ins_dt, upd_dt) values (4, 'YZF-R1', 800, 4, '空冷', 650000, '見た目がいい', '03', 1, now(), null);
insert into m_motorcycle(moto_no, moto_name, seat_height, cylinder, cooling, price, comment, brand_id, version, ins_dt, upd_dt) values (5, 'Rebel250', 800, 1, '水冷', 150000, '一番人気', '01', 1, now(), null);
insert into m_motorcycle(moto_no, moto_name, seat_height, cylinder, cooling, price, comment, brand_id, version, ins_dt, upd_dt) values (6, 'Rebel500', 800, 1, '水冷', 1500000, 'アメリカン', '01', 1, now(), null);
insert into m_motorcycle(moto_no, moto_name, seat_height, cylinder, cooling, price, comment, brand_id, version, ins_dt, upd_dt) values (7, 'SR400', 800, 2, '水冷', 1250000, 'ネイキッド', '04', 1, now(), null);
insert into m_motorcycle(moto_no, moto_name, seat_height, cylinder, cooling, price, comment, brand_id, version, ins_dt, upd_dt) values (8, 'Z1', 800, 1, '水冷', 150000, 'バイクの王様', '02', 1, now(), null);
insert into m_motorcycle(moto_no, moto_name, seat_height, cylinder, cooling, price, comment, brand_id, version, ins_dt, upd_dt) values (9, 'V7', 800, 4, '水冷', 15000000, 'いいね', '05', 1, now(), null);

--ブランド名
insert into
    m_brand (brand_id, brand_name)
values
    ('01', 'Honda');

insert into
    m_brand (brand_id, brand_name)
values
    ('02', 'Kawasaki');

insert into
    m_brand (brand_id, brand_name)
values
    ('03', 'Yamaha');

insert into
    m_brand (brand_id, brand_name)
values
    ('04', 'Suzuki');

insert into
    m_brand (brand_id, brand_name)
values
    ('05', 'moto guzzi');

--ユーザーのデータ
insert into m_user (username, password) values ('test', '$2a$10$UqAR/2TqQuXxkLm2Sk6lTOV4sUOjaVe.Z8e4RekQpiq4n33DYvo36');
insert into m_user (username, password) values ('admin', '$2a$10$UqAR/2TqQuXxkLm2Sk6lTOV4sUOjaVe.Z8e4RekQpiq4n33DYvo36');
