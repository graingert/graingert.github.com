<?php
include_once('./inc/common_functions.inc.php');
printHead();
try{
	$exam = new Exam();
	$exam->malestudentid = Student::getByEmail($_POST['man'])->id;
	$exam->femalestudentid = Student::getByEmail($_POST['woman'])->id;
	$exam->date = $_POST['year'].'-'.$_POST['month'].'-'.$_POST['day'];
	$exam->kind = $_POST['style'];
	$exam->level = $_POST['level'];
	$exam->mark = $_POST['mark'];
	$exam->validate();
	$exam->insert();
	?>

	<p>Added examination:</p>
	<table>
	<?php
		Exam::printHeader();
		$exam->printRow();
	?>
	</table>
	<?php
} catch (InvalidUserInputException $e) {
	echo $e->getMessage();
} catch (SameSexException $e) {
	echo $e->getMessage();
}
printFoot();
