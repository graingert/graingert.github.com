<?php
include_once('./inc/common_functions.inc.php');
printHead();
try{
	$student = Student::getByEmail($_POST['email']);
	
	?>
	<table>
	<?php
	Student::printHeader();
	$student->printRow();
	?>
	</table>
	<table>
	<?php
	Exam::printHeader();
	foreach ($student->getExams() as $exam){
		$exam->printRow();
	}
	?>
	</table>
	<?php
} catch (InvalidUserInputException $e) {
	echo $e->getMessage();
}
printFoot();
