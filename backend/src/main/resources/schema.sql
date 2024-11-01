create table if not exists `user`
(
    id char(19) primary key ,
    dep_id char(19) not null ,
    name varchar(8) not null ,
    description   varchar(200)     null,
    account varchar(16) not null ,
    password varchar(70) not null ,
    role char(4) not null ,
    group_number  tinyint unsigned null,
    create_time datetime default current_timestamp,
    update_time datetime default current_timestamp on update current_timestamp,
    student       json        null comment '{"teacherId", "teacherName", "queueNumber", "projectTitle"}',
    teacher       json         null comment '{"A", "C", "total"}',
    unique (account)
);

create table if not exists `process`
(
    id          char(19) not null primary key,
    dep_id       char(19)not null ,
    name        varchar(20)not null,
    parts       json not null comment '[{"number":,"name:","weight:","description:"}]',
    weight      tinyint unsigned not null,
    add_part    json null comment '[{"number","name","description"}]',
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp,
    index (dep_id)
);

create table if not exists `process_score`
(
    id          char(19) not null primary key,
    student_id  char(19) not null,
    process_id  char(19) not null,
    teacher     json comment 'teacherId:,teacherName',
    process_name varchar(20)not null,
    detail      json comment '[{number:,name:,score:,weight:}]',
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp,
    unique (process_id, student_id, teacher)
);

create table if not exists `department`
(
    id          char(19) not null primary key,
    name        varchar(20),
    create_time datetime default current_timestamp,
    update_time datetime default current_timestamp on update current_timestamp,
);