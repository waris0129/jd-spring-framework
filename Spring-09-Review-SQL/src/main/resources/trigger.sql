-- Trigger

DROP  TABLE  IF EXISTS mentors;
CREATE  TABLE mentors(
    id INT GENERATED ALWAYS AS IDENTITY ,
    first_name varchar(40) not null ,
    last_name varchar(40) not null ,
    primary key (id)
);


DROP  TABLE  IF EXISTS mentors_audit;
CREATE  TABLE mentors_audit(
    id INT GENERATED ALWAYS AS IDENTITY ,
    mentor_id INT NOT NULL ,
    last_name varchar(40) not null ,
    change_on timestamp(6) not null,
    primary key (id)
);



insert into mentors(first_name, last_name) values ('Mike','Smith');
insert into mentors(first_name, last_name) values ('Tom','Hanks');

-------------------------Trigger part --------------------
--create function

CREATE OR REPLACE FUNCTION log_last_name_changes()
returns trigger
language plpgsql
as
    $$
    begin
        -- put logic : when there is any update in Mentors table, it should be
        -- reflected in Mentors_audit table
        IF NEW.last_name<>OLD.last_name THEN
            INSERT INTO mentors_audit(mentor_id, last_name, change_on) values
            (OLD.id,OLD.last_name,now());
        end if;

        RETURN new;
    end;
    $$;


-- create trigger
CREATE TRIGGER last_name_change
    BEFORE update
    ON mentors
    FOR EACH ROW
    EXECUTE PROCEDURE log_last_name_changes();


-- practice TRIGGER
UPDATE mentors
SET last_name='ABC'
WHERE id = 2;


UPDATE mentors
SET last_name='XYZ'
WHERE id = 2;


SELECT * FROM pg_trigger;

drop trigger if exists last_name_change on mentors;