insert into address(id, country, city, county, streetAddress)
values('1','Romania','Cluj-Napoca','Cluj','str. Lalelelor, nr. 22'),
      ('2','Romania','Cluj-Napoca','Cluj','str. 1 Decembrie, nr. 5'),
      ('3','Germany','Koln','District1','str. Edingbour, nr. 68'),
      ('4','Italy','Milano','District2','str. Central, nr. 7');

insert into customer(id, firstName, lastName, username, password, emailAddress)
values('1','Ovidiu','Duda','ovidiududa','$2a$10$5YGHmVVZOMx4qeNbjO25kenFNfGjiu5zykRMJUL3/k8acWct67Njy', 'ovidiududa@yahoo.com'),
      ('2','Dan','Furtha','danfurtha','$2a$10$5YGHmVVZOMx4qeNbjO25kenFNfGjiu5zykRMJUL3/k8acWct67Njy', 'danfurtha@yahoo.com'),
      ('3','Mihaela','State','mihaelastate','$2a$10$5YGHmVVZOMx4qeNbjO25kenFNfGjiu5zykRMJUL3/k8acWct67Njy', 'mihaelastate@yahoo.com');

insert into location(id, name, address)
values('1','Depo1','2'),
      ('2','Depo2','3'),
      ('3','Depo3','4');

insert into productCategory(id, name, description)
values('1','Household','This is the household category'),
      ('2','Garden','This is the garden category'),
      ('3','Fruit','This is the fruit category');

insert into supplier(id, name)
values('1','AsiaSupplier'),
      ('2','AustraliaSupplier'),
      ('3','AmericaSupplier');

insert into product(id, name, description, price, weight, idCategory, idSupplier, imageUrl)
values('1','Patio','This is a Patio', '300', '25', '2', '3', 'url1'),
      ('2','Toaster','This is a Toaster', '40', '1.5', '1', '1', 'url2'),
      ('3','Banana','This is a Banana', '0.5', '0.3', '3', '1', 'url3'),
      ('4','Grape','This is a Grape', '0.1', '0.1', '3', '2', 'url4');

insert into stock(idProduct, idLocation, quantity)
values('1','1','100'),
      ('2','1','3'),
      ('3','2','5'),
      ('4','3','10'),
      ('1','2','1'),
      ('2','2','5'),
      ('3','3','300'),
      ('4','1','1000');