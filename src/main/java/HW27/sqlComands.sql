select avg(height) from heroes;

select max(height) from heroes;

select name, weight from heroes order by weight desc limit 1;

select gender, count(gender) from heroes group by gender;

select count(alignment) from heroes where alignment !='-';

select publisher, count(publisher) as frequency from heroes group by publisher order by frequency desc limit 5;

select  hair_color, count(hair_color) as frequency from heroes group by hair_color order by frequency desc limit 3;

select  eye_color, count(eye_color) as frequency from heroes group by eye_color order by frequency desc limit 1;