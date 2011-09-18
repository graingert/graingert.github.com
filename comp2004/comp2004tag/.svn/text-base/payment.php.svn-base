<?php
include_once('./inc/common_functions.inc.php');
printHead();
try{
	$student = Student::getByEmail($_POST['email']);
	$payment = new Payment();
	$payment->type = strtolower($_POST['paymentType']);
	$payment->amount = $_POST['amount'];
	$payment->student = $student->id;
	$payment->validate();
	$payment->insert();
	?>
	<p>Payment:</p>
	<table>
	<?php
	Payment::printHeader();
	$payment->printRow();
	?>
	<table>
	<p>Added</p>
	<?php
} catch (InvalidUserInputException $e) {
	echo $e->getMessage();
	echo '<p>No payment added</p>';
}
if (isset($_POST['listPayments'])){
	?>
	<table>
	<?php
	Payment::printHeader();
	foreach (Payment::getPayments() as $payment){
		$payment->printRow();
	}
	?>
	</table>
	<?php
}
printFoot();
?>
