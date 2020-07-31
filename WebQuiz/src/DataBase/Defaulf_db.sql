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
    question_detail text, /* if null - default questionType Task */
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

CREATE TABLE answers(
	answer_id int(8) not null auto_increment,
    question_id int(8) not null,
    answer_index int(8) default -1, /* determines if answers have order or not */
    answer_detail text not null,
    answer_correct boolean default false,
    primary key (answer_id),
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

INSERT INTO questions (question_detail) VALUES
	("what 2+2?"),
    ("what is 3*9?")
    ;

INSERT INTO quizQuestionLinks (quiz_id, question_id) VALUES
    (1, 1),
    (2, 2),
    (1, 2),
    (2, 1)
    ;

INSERT INTO answers (question_id, answer_index, answer_detail, answer_correct) VALUES
    (1, 1, "4", true),
    (1, 2, "3", false),
    (1, 3, "1", false),
    (1, 4, "2", false),
    (2, 1, "27", true),
    (2, 1, "9", false),
    (2, 1, "3", false),
    (2, 1, "4", false)
    ; 