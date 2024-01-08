SELECT * FROM Homework;

SELECT * FROM Lesson as l
    JOIN Homework as h
    ON l.homework_id = h.id;

SELECT * FROM Lesson, Homework
    ORDER BY updateAt;

SELECT * FROM Schedule as s
    LEFT JOIN Lesson as l
    ON s.lessons = l.id;

SELECT COUNT(*) FROM Lesson AS l
    CROSS JOIN Schedule AS s
    WHERE l.id = s.lessons;