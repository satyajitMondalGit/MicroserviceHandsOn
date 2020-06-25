DROP TABLE IF EXISTS Credentials;
 
CREATE TABLE Credentials (
    id   INTEGER      NOT NULL ,
    uname VARCHAR(100) NOT NULL,
    pass VARCHAR(200) NOT NULL,
    roll VARCHAR(100) NOT NULL
);


INSERT INTO Credentials (id, uname, pass, roll) VALUES (1, 'satya', '$2b$10$SaIGxXCjHv4ZBW4GWMqIkekGIq.CTmNrWVBumHBco/qGbSw.uoFlC',  'ADMIN');
INSERT INTO Credentials (id, uname, pass, roll) VALUES (2, 'samsung', '$2b$10$SaIGxXCjHv4ZBW4GWMqIkekGIq.CTmNrWVBumHBco/qGbSw.uoFlC', 'ADMIN' );
  