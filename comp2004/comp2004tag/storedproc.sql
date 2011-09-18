DROP PROCEDURE addExam;
DELIMITER $$
CREATE PROCEDURE addExam(IN p_studenta int(10), IN p_studentb int(10), IN p_date date, IN p_mark tinyint(3), IN p_level enum('gold', 'silver', 'bronze'), IN p_kind enum('ballroom', 'latin'))
BEGIN
DECLARE studentagender enum('male','female');
DECLARE studentbgender enum('male','female');
DECLARE success BOOL;

SET studentagender = (SELECT gender FROM ds_students WHERE id = p_studenta);
SET studentbgender = (SELECT gender FROM ds_students WHERE id = p_studentb);
SET success = 1;

IF ((studentagender = 'female') AND (studentbgender = 'male')) THEN
	INSERT INTO ds_exams
	(
			`malestudentid`,
			`femalestudentid`,
			`date`,
			`mark`,
			`level`,
			`kind`
	)
	VALUES 
	(
		p_studentb,
		p_studenta,
		p_date,
		p_mark,
		p_level,
		p_kind
	);
	ELSEIF ((studentagender = 'male') AND (studentbgender = 'female')) THEN 
	INSERT INTO ds_exams
	(
			`malestudentid`,
			`femalestudentid`,
			`date`,
			`mark`,
			`level`,
			`kind`
	)
	VALUES 
	(
		p_studenta,
		p_studentb,
		p_date,
		p_mark,
		p_level,
		p_kind
	);
	ELSE SET success = 0;
END IF;
SELECT success;
END
$$
DELIMTER ;
