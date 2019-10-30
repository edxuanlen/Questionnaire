# Questionnaire

## Database structure

**Note that coding = UTF- 8**

- Questionnaire
    - Questionnaire ID
        - Int unsigned not null auto increment primary key
    - Questionnaire name
        - Varchar (20) not null
    - Questionnaire description
        -  text
    - Creation "time
        - Datetime not null
    - Questionnaire status
        - Enum ('public ',' close ')
        - Comment "is the questionnaire currently open?"
- Question table
    - q_id
        - Int unsigned not null auto increment primary key
    - Problem description
        -  text
    - Questionnaire ID
        - Int not null foreign key
    - Question Type
        - Enum ('objective ','objective') not null

- Options table
    - Option ID
        - Int unsigned not null auto increment primary key
    - Option content description
        - Varchar (50)
    - q_id
        - Int not null foreign key

- Subjective question answer
    - Answer No.
        - Int unsigned not null auto increment primary key
    - Answer content
        -  text

- Objective question answer
    - Answer No. obj Q ID
        - Int unsigned not null auto increment primary key
    - Option ID
        - Int not null foreign key
        
##Onstage
- login.jsp
    - Log in and jump to the backstage interface
