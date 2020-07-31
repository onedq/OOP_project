use QuizDatabase;

DROP TABLE IF EXISTS accounts;

CREATE TABLE accounts (
	account_id int(8) not null auto_increment,
    account_first_name varchar(64),
    account_last_name varchar(64),
    account_username varchar(64) not null,
    account_mail varchar(64) not null,
    account_password char(128) not null,
   
    primary key (account_id),
	fulltext(account_first_name, account_last_name, account_username, account_mail)
);


INSERT INTO accounts (account_first_name, account_last_name, account_username, account_mail, account_password) VALUES
	("davit", "qveladze", "dkvel17", "dkvel17@freeuni.edu.ge", 'dato123'),
    ("leo", "messi", "messi", "dkvel1@freeuni.edu.ge", 'dato123'),
    ("jaba", "dvali", "dvali", "dkvel69@freeuni.edu.ge", 'dato123')
    ;