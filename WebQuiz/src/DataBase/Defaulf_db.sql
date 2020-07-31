use QuizDatabase;

DROP TABLE IF EXISTS accounts, quizes, questions, answers, quizQuestionLinks;

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

CREATE TABLE quizes (
	quiz_id int(8) not null auto_increment,
    quiz_name varchar(64) not null,
    quiz_created datetime default now(),
    primary key (quiz_id),
	fulltext(quiz_name)
);

CREATE TABLE questions(
	question_id int(8) not null auto_increment,
    question_title text,
    question_answer text,
    primary key (question_id)
);

CREATE TABLE quizQuestionLinks (
	id int(8) not null auto_increment,
	quiz_id int(8) not null,
    question_id int(8) not null,
    primary key (id),
    foreign key (quiz_id) references quizes(quiz_id),
    foreign key (question_id) references questions(question_id)
);


INSERT INTO accounts (account_first_name, account_last_name, account_username, account_mail, account_password) VALUES
	("davit", "qveladze", "dkvel17", "dkvel17@freeuni.edu.ge", 'dato123'),
    ("leo", "messi", "messi", "dkvel1@freeuni.edu.ge", 'dato123'),
    ("jaba", "dvali", "dvali", "dkvel69@freeuni.edu.ge", 'dato123')
    ;
    
INSERT INTO quizes (quiz_name) VALUES
	("Quiz1"),
    ("Quiz2")
;

INSERT INTO questions (question_title, question_answer) VALUES
	("what is 2+2?", "4"),
    ("what is 3*9?", "27"),
    ("what is 9-1?", "8"),
    ("what is 10/2?", "5"),
    ("what is 5%2?", "1"),
    ("what is 7^2?", "49"),
    ("what is 9-0?", "9"),
    ("what is 190-99?", "91"),
    ("what is 22*10?", "220")
    ;

INSERT INTO quizQuestionLinks (quiz_id, question_id) VALUES
    (1, 1),
    (2, 2),
    (1, 2),
    (2, 1),
    (1, 3)
    ;