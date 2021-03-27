create database Assigment1_TranTuanMinh_SE140690
go
use Assigment1_TranTuanMinh_SE140690
go

create table tblRole (
	roleID varchar(10) primary key not null,
	roleName nvarchar(50),
	status bit 
)
create table tblUsers (
	userID varchar(30) primary key not null,
	fullName nvarchar(50),
	password varchar(30),
	address nvarchar(50),
	roleID varchar(10) foreign key references tblRole(roleID),
	status bit 
)
create table tblCategory (
	categoryID varchar(30) primary key not null,
	categoryName nvarchar(50),
	status bit 
)
create table tblFoods (
	foodID varchar(30) primary key not null,
	foodName nvarchar(50),
	foodPrice float check(foodPrice>0),
	quantity int check(quantity>=0),
	description nvarchar(100) ,
	createDate date,
	expirationDate date,
	linkImg varchar(150),
	categoryID varchar(30) foreign key references tblCategory(categoryID),
	status bit 
)
create table tblOrders (
	orderID varchar(30) primary key not null,
	userID varchar(30) foreign key references tblUsers(userID),
	totalPrice float check(totalPrice >0),
	orderDate date,
	orderAddress nvarchar(50),
	status bit
)
create table tblOrderDetail (
	detailID varchar(30) primary key not null,
	orderID varchar(30) foreign key references tblOrders(orderID),
	foodID varchar(30) foreign key references tblFoods(foodID),
	amount int check(amount>0),
	price float check(price >0) ,
	status bit 
)

create table tblUpdateRecord (
	recordID varchar(30) primary key not null,
	userID varchar(30) foreign key references tblUsers(userID),
	foodID varchar(30) foreign key references tblFoods(foodID),
	recordDate date,
	status bit
)

INSERT INTO tblRole
values('AD','Admin',1)
INSERT INTO tblRole
values('US','User',1)
INSERT INTO tblRole
values('EMAIL','Gmail user',1)

INSERT INTO tblUsers
values('admin',N'admin name','123456','FPT HCM','AD',1)
INSERT INTO tblUsers
values('test',N'Tester','123456','FPT HCM','US',1)
INSERT INTO tblUsers
values('minh',N'Minh nè','1','Binh Duong','US',1)

INSERT INTO tblCategory
values('PI','Pizza',1)
INSERT INTO tblCategory
values('DI','Drink',1)
INSERT INTO tblCategory
values('FF','Fast Food',1)
INSERT INTO tblCategory
values('CA','Cake',1)

INSERT INTO tblFoods
values('F1',N'Neapolitan Pizza',150000,50,N'Features tomatoes, sliced mozzarella, basil, and extra virgin olive oil.','1/9/2021','2/16/2021','Images/pizzatypes-margherita-.jpg','PI',1)
INSERT INTO tblFoods
values('F2',N'Chicago Pizza',150000,50,N'Vegetables, and then topped with a can of crushed tomatoes','1/9/2021','2/16/2021','Images/pizzatypes-deepdish.jpg','PI',1)
INSERT INTO tblFoods
values('F3',N'New York-Style Pizza',150000,50,N'Oregano, red pepper flakes, Parmesan cheese, and garlic powder.','1/9/2021','2/16/2021','Images/newyork-stylepizza.jpg','PI',1)
INSERT INTO tblFoods
values('F4',N'Sicilian Pizza',150000,50,N'Sicilian pizzas are often topped with bits of tomato, onion, anchovies, and herbs.','1/9/2021','2/16/2021','Images/sicilianpizza.jpg','PI',1)
INSERT INTO tblFoods
values('F5',N'Greek Pizza',150000,50,N'Feta cheese, black olives, and red onion.','1/9/2021','2/16/2021','Images/greekpizza.jpg','PI',1)
INSERT INTO tblFoods
values('F6',N'California Pizza',150000,50,N'Chicken and artichokes to goat cheese and egg.','1/9/2021','2/16/2021','Images/pizzatypes-gourmet.jpg','PI',1)
INSERT INTO tblFoods
values('F7',N'Detroit Pizza',150000,50,N'This pizza features a thick, extra crispy crust that is tender and airy on the inside.','1/9/2021','2/16/2021','Images/detroitpizza.jpg','PI',1)
INSERT INTO tblFoods
values('F8',N'Louis Pizza',150000,50,N'Sprinkle of Parmesan cheese across the tomato sauce.','1/6/2021','2/16/2021','Images/louispizza.jpg','PI',1)

INSERT INTO tblFoods
values('F9',N'Coca',15000,50,N'Ngon,giải khát','1/6/2021','1/6/2022','Images/coca.jpg','DI',1)
INSERT INTO tblFoods
values('F10',N'Pepsi',15000,50,N'Ngon,giải khát','1/6/2021','1/6/2022','Images/pepsi.jpg','DI',1)
INSERT INTO tblFoods
values('F11',N'7up',15000,50,N'Ngon,giải khát','1/6/2021','1/6/2022','Images/7up.jpg','DI',1)
INSERT INTO tblFoods
values('F12',N'Mirinda soda',15000,50,N'Ngon,giải khát','1/6/2021','1/6/2022','Images/mirindasoda.jpg','DI',1)
INSERT INTO tblFoods
values('F13',N'Mirinda cam',15000,50,N'Ngon,giải khát','1/6/2021','1/6/2022','Images/mirindacam.jpg','DI',1)
INSERT INTO tblFoods
values('F14',N'Mirinda đá me',15000,50,N'Ngon,giải khát','1/6/2021','1/6/2022','Images/mirindadame.jpg','DI',1)
INSERT INTO tblFoods
values('F15',N'Cafe đen',15000,50,N'Ngon,giải khát','1/6/2021','2/7/2021','Images/cafeden.jpg','DI',1)
INSERT INTO tblFoods
values('F16',N'Cafe sữa',15000,50,N'Ngon,giải khát','1/6/2021','2/7/2021','Images/cafesua.jpg','DI',1)
INSERT INTO tblFoods
values('F17',N'Trà sữa',15000,50,'Ngon,giải khát','1/6/2021','2/7/2021','Images/trasua.jpg','DI',1)
INSERT INTO tblFoods
values('F18',N'Sinh tố bơ',15000,50,N'Ngon,giải khát','1/6/2021','2/7/2021','Images/sinhtobo.jpg','DI',1)
INSERT INTO tblFoods
values('F19',N'Sinh tố xoài',15000,50,N'Ngon,giải khát','1/6/2021','2/7/2021','Images/sinhtoxoai.jpg','DI',1)
INSERT INTO tblFoods
values('F20',N'Sinh tố dâu',15000,50,N'Ngon,giải khát','1/6/2021','2/7/2021','Images/sinhtodau.jpg','DI',1)

INSERT INTO tblFoods
values('F21',N'Hamberger',40000,50,N'Meat, usually beef, placed inside a sliced bread roll or bun','1/6/2021','2/10/2021','Images/hamberger.jpg','FF',1)
INSERT INTO tblFoods
values('F22',N'KFC',50000,50,N'Fried Chicken','1/6/2021','2/10/2021','Images/KFC.jpg','FF',1)
INSERT INTO tblFoods
values('F23',N'Donut',50000,50,N'Ngon','1/6/2021','2/10/2021','Images/donut.jpg','FF',1)
INSERT INTO tblFoods
values('F24',N'Mcdonald',50000,50,'Ngon','1/6/2021','2/10/2021','Images/mcdonald.jpg','FF',1)

INSERT INTO tblFoods
values('F25',N'Pound Cake',70000,50,N'Ngon','1/6/2021','2/10/2021','Images/poundcake.jpg','CA',1)
INSERT INTO tblFoods
values('F26',N'Sponge Cake',70000,50,N'Meyer lemon curd and served with lavender cream','1/6/2021','2/10/2021','Images/poundcake.jpg','CA',1)
INSERT INTO tblFoods
values('F27',N'Genoise Cake',70000,50,N'Light enough to stack with whipped cream and berries','1/6/2021','2/10/2021','Images/genoisecake.jpg','CA',1)
INSERT INTO tblFoods
values('F28',N'Angel Cake',70000,50,N'Sponge cake, cream, food colouring','1/6/2021','2/10/2021','Images/angelcake.jpg','CA',1)





