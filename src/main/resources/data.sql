--�o�C�N�f�[�^--
insert into 
    m_motorcycle(
        moto_no,
        moto_name,
        seat_height,
        cylinder,
        cooling,
        price,
        comment,
        brand_id,
        version,
        ins_dt,
        upd_dt
    )
values
    (
        1,
        'GB350',
        800,
        1,
        '空冷',
        550000,
        '音がいい',
        '01',
        1,
        now(),
        null
    );

insert into
    m_motorcycle(
        moto_no,
        moto_name,
        seat_height,
        cylinder,
        cooling,
        price,
        comment,
        brand_id,
        version,
        ins_dt,
        upd_dt
    )
values
    (
        2,
        'Z900RS',
        800,
        4,
        '水冷',
        1000000,
        'かっこいい',
        '02',
        1,
        now(),
        null
    );

--�o�C�N���[�J�[�̃f�[�^
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