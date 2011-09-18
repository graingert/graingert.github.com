<?php
include_once('./inc/common_functions.inc.php');

printHead();

try {
	$student = new Student();
$student->name = htmlentities($_POST['name']);
$student->dateOfBirth = $_POST['year'].'-'.$_POST['month'].'-'.$_POST['day'];
$email = $_POST['email'];
$email2 = $_POST['email2'];
if($email != $email2){
	throw new InvalidUserInputException('<p>Email and Repeat Email do not match</p>');
}
$student->email = $email;
$student->gender = $_POST['gender'];
$student->status = Student::CURRENT;
	$student->validate();
	
	$student->insert();

	?>
	<p>Added Student:</p>
	<table>
	<?php
	Student::printHeader();
	$student->printRow();
	?>
	</table>
	<?php
} catch (InvalidUserInputException $e) {
	echo $e->getMessage();
}
printFoot();
