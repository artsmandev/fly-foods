insert into cuisine(name) values('Ireland');
insert into cuisine(name) values('Thailand');

insert into restaurant(name, delivery_fee) values('Ireland Gourmet', 10);
insert into restaurant(name, delivery_fee) values('Thailand Gourmet', 20);

insert into payment_method(name) values('PayPay');
insert into payment_method(name) values('Credit Card');

insert into permission(name, description) values('Read', 'It is allowed to read');
insert into permission(name, description) values('Write', 'It is allowed to write');

insert into state(name) values('Lisbon');
insert into state(name) values('Porto');

insert into city(name, state_id) values('Lisboa', 1);
insert into city(name, state_id) values('Algarve', 2);
