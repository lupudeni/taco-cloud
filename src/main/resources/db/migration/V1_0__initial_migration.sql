create table if not exists Taco_Order (
    id bigint identity,
    user_id bigint not null,
    delivery_Name varchar(50) not null,
    delivery_Street varchar(50) not null,
    delivery_City varchar(50) not null,
    delivery_State varchar(50) not null,
    delivery_Zip varchar(10) not null,
    cc_number varchar(16) not null,
    cc_expiration varchar(5) not null,
    cc_cvv varchar(3) not null,
    placed_at timestamp not null
    );

create table if not exists Taco (
    id bigint identity,
    name varchar(50) not null,
    taco_order bigint not null,
    taco_order_key bigint not null,
    created_at timestamp not null
    );

create table if not exists Ingredient_Ref (
    ingredient varchar(4) not null,
    taco bigint not null,
    taco_key bigint not null
    );

create table if not exists Ingredient (
    id varchar(4) not null,
    name varchar(25) not null,
    type varchar(10) not null
    );

create table if not exists User (
    id bigint identity,
    username varchar(50) not null,
    password varchar(255) not null,
    fullname varchar(50) not null,
    street varchar(50) not null,
    city varchar(50) not null,
    state varchar(50) not null,
    zip varchar(10) not null,
    phone_number varchar(50) not null
    );

alter table Taco
    add foreign key (taco_order) references Taco_Order(id);

alter table Taco_Order
    add foreign key (user_id) references User(id);

alter table Ingredient_Ref
    add foreign key (ingredient) references Ingredient(id);