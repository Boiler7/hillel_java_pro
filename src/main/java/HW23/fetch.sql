SELECT * FROM Homework;

SELECT * FROM Lesson AS l
    CROSS JOIN Schedule AS
    ON Lesson.id = homework.lesson_id

SELECT * FROM Lesson, Homework
    ORDER BY updateAt;

SELECT * FROM Schedule as s
    LEFT JOIN Lesson as l
    ON s.lessons = l.id;

SELECT COUNT(*) FROM lesson AS l
    CROSS JOIN Schedule AS s
    WHERE l.id = s.lessons;