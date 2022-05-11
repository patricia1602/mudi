create database mudi;

use mudi;

create table pedidos(
id bigint auto_increment primary key,
nome_produto varchar(250),
valor_negociado decimal(19,2),
data_da_entrega date,
url_produto varchar(250),
url_imagem varchar(250),
descricao varchar(250)
);

select * from pedidos;

insert into pedidos (nome_produto, url_produto, url_imagem, descricao)
 values('Xiaomi Redmi Note 8',
 'https://images-na.ssl-images-amazon.com/images/I/81UgYuadkpL._AC_SL1500_.jpg',
 'https://www.amazon.com.br/Smartphone-Xiaomi-Redmi-Note-64GB/dp/B07Y8YWTFL/ref=sr_1_6?__mk_pt_BR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=Xiaomi+Redmi+Note+8&qid=1600346040&sr=8-6',
 'uma descrição qualquer para esse pedido');

create table users(
username varchar(50) not null primary key,
password varchar(200) not null,
enable boolean not null
);

select * from authorities;

select * from pedido;

insert into pedidos (nome_produto, url_produto, url_imagem, descricao)
 values('boneca',
 'boneca',
 'boneca',
 'bonita'
);

insert into users ( username, password, enable)
values('Joao', 'Joao', '1'); 

select * from users;