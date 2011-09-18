<?php
include_once('./inc/common_functions.inc.php');


printHead();
try{
	$student = Student::getByEmail($_POST['email']);
	$student->status = Student::LEFT;
	$student->update();
	?>
	<p>Student:</p>
	<table>
	<?php
	Student::printHeader();
	$student->printRow();
	?>
	</table>
	<p>Has been marked as left</p>
	<?php
} catch (InvalidUserInputException $e) {
	echo $e->getMessage();
}
printFoot();
