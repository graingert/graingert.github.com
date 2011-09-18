<?php
include_once('./inc/common_functions.inc.php');
printHead();
?>
<table>
<?php
Student::printHeader();
foreach (Student::getByStatus($_POST['status']) as $student){
  $student->printRow();
}
?>
</table>
<?php
printFoot();
?>
