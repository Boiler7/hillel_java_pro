SELECT * FROM Homework;

SELECT * FROM Lesson, Homework;

SELECT * FROM Lesson, Homework
    ORDER BY updateAt;

SELECT * FROM Schedule as s
    LEFT JOIN Lesson as l
    ON s.lessons = l.id;

SELECT * FROM lesson AS l
    CROSS JOIN Schedule AS s
    WHERE l.id = s.lessons;