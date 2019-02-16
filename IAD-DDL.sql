CREATE TABLE ЛИЧНОСТЬ
( 
	ИД_ЛИЧНОСТЬ SERIAL PRIMARY KEY,
	НИКНЕЙМ TEXT UNIQUE NOT NULL,
	ЭЛ_ПОЧТА TEXT UNIQUE NOT NULL,
	ХЕШ_ПАРОЛЬ TEXT NOT NULL
);

CREATE TABLE ИНФО
(
	ИД_ИНФО SERIAL PRIMARY KEY,
	ИД_ЛИЧНОСТЬ INT NOT NULL UNIQUE REFERENCES ЛИЧНОСТЬ(ИД_ЛИЧНОСТЬ),
	ИМЯ TEXT,
	ФАМИЛИЯ TEXT,
	СТРАНА TEXT,
	ГОРОД TEXT,
	ДАТА_РОЖДЕН DATE,
	ДАТА_РЕГИСТР DATE
);

CREATE TABLE ИГРА
(
	ИД_ИГРА SERIAL PRIMARY KEY,
	НАЗВАНИЕ TEXT,
	ГОД_ВЫХОДА INT,
	ОПИСАНИЕ TEXT
);

CREATE TABLE ЛИЧН_ИГРА
(
	ИД_ЛИЧН_ИГРА SERIAL PRIMARY KEY,
	ИД_ЛИЧНОСТЬ INT NOT NULL REFERENCES ЛИЧНОСТЬ(ИД_ЛИЧНОСТЬ),
	ИД_ИГРА INT NOT NULL REFERENCES ИГРА(ИД_ИГРА)
);

CREATE TABLE СОБЫТИЕ
(
	ИД_СОБЫТИЕ SERIAL PRIMARY KEY,
	ИД_ЛИЧНОСТЬ INT REFERENCES ЛИЧНОСТЬ(ИД_ЛИЧНОСТЬ),
	ОПИСАНИЕ TEXT NOT NULL,
	ДАТА DATE NOT NULL,
	ВРЕМЯ_НАЧ TIME NOT NULL,
	ВРЕМЯ_КОН TIME
);

CREATE TABLE ДНЕВНИК
(
	ИД_ДНЕВНИК SERIAL PRIMARY KEY,
	ИД_ЛИЧНОСТЬ INT REFERENCES ЛИЧНОСТЬ(ИД_ЛИЧНОСТЬ),
	ТЕМА TEXT NOT NULL,
	ЗАПИСЬ TEXT NOT NULL,
	ДАТА DATE NOT NULL
);

CREATE TABLE БЛЮДО
(
	ИД_БЛЮДО SERIAL PRIMARY KEY,
	ИД_ЛИЧНОСТЬ INT REFERENCES ЛИЧНОСТЬ(ИД_ЛИЧНОСТЬ),
	НАЗВАНИЕ TEXT NOT NULL,
	МЕСТО TEXT,
	ЦЕНА INT
);

CREATE TABLE РАЦИОН
(
	ИД_РАЦИОН SERIAL PRIMARY KEY,
	ИД_ЛИЧНОСТЬ INT REFERENCES ЛИЧНОСТЬ(ИД_ЛИЧНОСТЬ),
	ДАТА DATE NOT NULL,
	ИД_БЛЮДО INT REFERENCES БЛЮДО(ИД_БЛЮДО) NOT NULL
);

CREATE TABLE ЗАДАЧА
(
	ИД_ЗАДАЧА SERIAL PRIMARY KEY,
	ИД_ЛИЧНОСТЬ INT REFERENCES ЛИЧНОСТЬ(ИД_ЛИЧНОСТЬ),
	ДАТА DATE NOT NULL,
	СТАТУС BOOLEAN
);

CREATE TABLE СООБЩЕНИЕ
(
	ИД_СООБЩЕНИЕ SERIAL PRIMARY KEY,
	ОТ_ЛИЧНОСТЬ INT NOT NULL REFERENCES ЛИЧНОСТЬ(ИД_ЛИЧНОСТЬ),
	КОМУ_ЛИЧНОСТЬ INT NOT NULL REFERENCES ЛИЧНОСТЬ(ИД_ЛИЧНОСТЬ),
	ТЕМА TEXT NOT NULL,
	ТЕКСТ TEXT NOT NULL,
	ДАТА DATE NOT NULL
);


CREATE TABLE ГРУППА_ЛИЧН
(
  ИД_ГРУППА_ЛИЧН SERIAL PRIMARY KEY,
  НИКНЕЙМ TEXT,
  ГРУППА TEXT
);






CREATE TABLE PERSON
(
	ID_PERSON SERIAL PRIMARY KEY,
	NICKNAME TEXT UNIQUE NOT NULL,
	EMAIL TEXT UNIQUE NOT NULL,
	HASH_PASS TEXT NOT NULL
);

CREATE TABLE PERSONGROUP
(
	ID_PERSONGROUP SERIAL PRIMARY KEY,
	NICKNAME TEXT,
	GROUPNAME TEXT
);

INSERT INTO PERSON(NICKNAME, EMAIL, HASH_PASS) VALUES ('test', 'test', 'test');
INSERT INTO PERSONGROUP(NICKNAME, GROUPNAME) VALUES ('test', 'user');

