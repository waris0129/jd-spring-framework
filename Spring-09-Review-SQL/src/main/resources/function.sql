--create function

CREATE or REPLACE FUNCTION get_department_count_by_name(dep_name varchar)
RETURNS int
LANGUAGE plpgsql
as
$$
DECLARE
-- variable
    department_count integer;

BEGIN
-- Logic
    SELECT count(*)
    into department_count
    from employees
    where department = dep_name;

    return department_count;

end;
$$;


-- run method

SELECT get_department_count_by_name('Sports');



-- second function
CREATE or REPLACE FUNCTION get_department(p_pattern varchar)
returns table(
    employee_name varchar,
    employee_email varchar
)
language plpgsql
as
    $$
    begin
        return query
        select first_name,email
        from employees
        where department like p_pattern;
    end;
    $$;

SELECT * FROM get_department('%th%');


Drop function get_department(p_pattern varchar);

