<?php

function printHead(){
	?>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
	<html><head>
	<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
	</head><body>
	<?php
}

function printFoot(){
	?>
		</body></html>
	<?php
}

function validateDate($date){
	if (preg_match('/^\d{4}-(0?[0-9]|1[0,1,2])-([0,1,2]?[0-9]|3[0,1])$/', $date)){
		return $date;
	} else {
		return false;
	}
}

function validateEmail($email){
	$email = strtolower( trim($email));
	$pattern = <<<PATTERN
	/^[a-z0-9!#$%&'*+\/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+\/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$/
PATTERN;
	if (preg_match($pattern, $email)){
		return $email;
	} else {
		return false;
	}
}

function validateMark($mark){
	if (is_numeric($mark)){
		$mark = (int)$mark;
		if (($mark <= 100) && ($mark >=0)){
			return $mark;
		} else {
			return false;
		}
	} else {
		return false;
	}
}

function validateAmount($amount){
	if (is_numeric($amount)){
		return $amount;
	} else {
		return false;
	}
}

class InvalidUserInputException extends Exception{ }

class DataBaseAccess{
	private static $dbh;
	public static function getDBH(){
		if (is_null(self::$dbh)){
			try {
				self::$dbh = new PDO('mysql:dbname=db_tag1g09;host=localhost','tag1g09','oX05CS3WNrKzOGgDZx7CFhVv5HRzSP');
				self::$dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
			} catch (PDOException $e){
				echo $e->getMessage();
			}
		}
		return self::$dbh;
	}
}

class Student{
	public $id;
	public $name;
	public $dateOfBirth;
	public $email;
	public $gender;
	public $status;
	const MALE = 'male';
	const FEMALE = 'female';
	const CURRENT = 'current';
	const SUSPENDED = 'suspended';
	CONST LEFT = 'left';
	
	public static function getByStatus($status){
		$stmt = NULL;
		switch($status){
			case Student::CURRENT:
				$stmt = DataBaseAccess::getDBH()->prepare('SELECT * FROM currentstudents');
				break;
			case Student::LEFT:
				$stmt = DataBaseAccess::getDBH()->prepare('SELECT * FROM leftstudents');
				break;
			case Student::SUSPENDED:
				$stmt = DataBaseAccess::getDBH()->prepare('SELECT * FROM suspendedstudents');
				break;
		}
		$stmt->execute();
		return $stmt->fetchALL(PDO::FETCH_CLASS,'Student');
	}
	
	public static function getByEmail($email){
		if (!($email = validateEmail($email))){
			throw new InvalidUserInputException('<p class="invalid">invalid email</p>');
		}
		
		$stmt = DataBaseAccess::getDBH()->prepare('SELECT * FROM ds_students WHERE email = :email');
		$stmt->execute(array(':email' => $email));
		$stmt->setFetchMode(PDO::FETCH_CLASS, 'Student'); 
		return ($stmt->fetch());
	}
	
	public static function getByID($id){
		$stmt = DataBaseAccess::getDBH()->prepare('SELECT * FROM ds_students WHERE id = :id');
		$stmt->execute(array(':id' => $id));
		$stmt->setFetchMode(PDO::FETCH_CLASS, 'Student'); 
		return ($stmt->fetch());
	}
	
	public function __toString(){
		return "$this->name $this->email $this->gender $this->status";
	}
	
	public function update(){
		$stmt = DataBaseAccess::getDBH()->prepare('UPDATE ds_students SET name = :name, dateOfBirth = :dob, email = :email, gender = :gender,  status = :status WHERE id = :id');
		$stmt->execute(array(':name'  => $this->name,
							':dob'    => $this->dateOfBirth,
							':email'  => $this->email,
							':gender' => $this->gender,
							':status' => $this->status,
							':id'     => $this->id));
		}
	
	public function insert(){
		$stmt = DataBaseAccess::getDBH()->prepare('INSERT INTO ds_students (name,dateOfBirth,email,gender,status) VALUES (:name, :dob, :email, :gender, :status)');
		$stmt->execute(array(':name'  => $this->name,
							':dob'    => $this->dateOfBirth,
							':email'  => $this->email,
							':gender' => $this->gender,
							':status' => $this->status));
	}
	
	public function validate(){
		$valid = true;
		$errorString = '';
		if (is_null($this->name)){
			$valid = false;
			$errorString .= '<p class="invalid">required field &#8220;name&#8221; missing</p>';
		}
		if (!($this->dateOfBirth = validateDate($this->dateOfBirth))){
			$valid = false;
			$errorString .= '<p class="invalid">invalid Date of Birth</p>';
		}
		if (!($this->email = validateEmail($this->email))){
			$valid = false;
			$errorString .= '<p class="invalid">invalid email</p>';
		}
		if (!$valid){
			throw new InvalidUserInputException($errorString);
		}
	}
	
	public function getExams(){
		$stmt = DataBaseAccess::getDBH()->prepare('SELECT * FROM ds_exams WHERE malestudentid = :student1 OR femalestudentid = :student2');
		$stmt->execute(array(':student1' => $this->id, ':student2' => $this->id));
		return $stmt->fetchALL(PDO::FETCH_CLASS,'Exam');
	}
	

	function getGravatar($s = 80, $d = 'mm', $r = 'g', $img = true, $atts = array() ) {
		$email = $this->email;
		$url = 'http://www.gravatar.com/avatar/';
		$url .= md5( strtolower( trim( $email ) ) );
		$url .= "?s=$s&d=$d&r=$r";
		if ( $img ) {
			$url = '<img src="' . $url . '"';
			foreach ( $atts as $key => $val )
				$url .= ' ' . $key . '="' . $val . '"';
			$url .= ' />';
		}
		return $url;
}

	
	public function printRow(){
		?>
		<tr>
			<td><?=$this->name?></td>
			<td><?=$this->dateOfBirth?></td>
			<td><?=$this->email?></td>
			<td><?=$this->gender?></td>
			<td><?=$this->status?></td>
			<td><?=$this->getGravatar();?></td>
		</tr>
		<?php
	}
	
	public static function printHeader(){
		?>
		<tr>
			<th>Name</th>
			<th>Date of Birth</th>
			<th>Email</th>
			<th>Gender</th>
			<th>Status</th>
			<th>Avatar</th>
		</tr>
		<?php
	}
}

class Exam{
	public $id;
	public $malestudentid;
	public $femalestudentid;
	public $date;
	public $mark;
	public $level;
	public $kind;
	
	private $malestudent;
	private $femalestudent;
	
	public static function getByID($id){
			$examByID = DataBaseAccess::getDBH()->prepare('SELECT * FROM ds_exams WHERE id = :exam');
			$examByID->setFetchMode(PDO::FETCH_CLASS, 'Exam');
			$examByID->execute(array(':exam' => $id));
			return $examByID->fetch();
	}
	
	public function getMaleStudent(){
		if (is_null($this->malestudent)){
			$this->malestudent = Student::getByID($this->malestudentid);
		}
		return $this->malestudent;
	}
	
	public function getFemaleStudent(){
		if (is_null($this->femalestudent)){
			$this->femalestudent = Student::getByID($this->femalestudentid);
		}
		return $this->femalestudent;
	}
	
	public function oldinsert(){
		$stmt = DataBaseAccess::getDBH()->prepare('INSERT INTO ds_exams (malestudentid,femalestudentid,date,mark,level,kind) VALUES (:malestudentid,:femalestudentid,:date,:mark,:level,:kind)');
		$stmt->execute(array(':malestudentid'   => $this->malestudentid,
							':femalestudentid' => $this->femalestudentid,
							':date'            => $this->date,
							':mark'            => $this->mark,
							':level'           => $this->level,
							':kind'            => $this->kind));
	}
	
	public function insert(){
		$stmt = DataBaseAccess::getDBH()->prepare('CALL addExam(:malestudentid,:femalestudentid,:date,:mark,:level,:kind)');
		$stmt->execute(array(':malestudentid'   => $this->malestudentid,
							':femalestudentid' => $this->femalestudentid,
							':date'            => $this->date,
							':mark'            => $this->mark,
							':level'           => $this->level,
							':kind'            => $this->kind));
		$out = $stmt->fetch(PDO::FETCH_ASSOC);
		if (!$out['success']){
			throw new SameSexException();
		}
	}
	
	public function validate(){
		$valid = true;
		$errorString = '';
		if (!($this->date = validateDate($this->date))){
			$valid = false;
			$errorString .= '<p class="invalid">invalid Date</p>';
		}
		if (!($this->mark = validateMark($this->mark))){
			$valid = false;
			$errorString .= '<p class="invalid">invalid mark</p>';
		}
		if (!$valid){
			throw new InvalidUserInputException($errorString);
		}
	}
	
	public function __toString(){
		return "$this->date $this->kind $this->mark";
	}
	
	public static function printHeader(){
		?>
		<tr>
			<th>Date</th>
			<th>Mark</th>
			<th>Level</th>
			<th>Kind</th>
			<th>Male student</th>
			<th>Female student</th>
		</tr>
		<?php
	}
	
	public function printRow(){
		?>
		<tr>
			<td><?=$this->date?></td>
			<td><?=$this->mark?></td>
			<td><?=$this->level?></td>
			<td><?=$this->kind?></td>
			<td><?=$this->getMaleStudent()->name?></td>
			<td><?=$this->getFemaleStudent()->name?></td>
		</tr>
		<?php
	}
	
}

class SameSexException extends Exception{
	function __construct(){
		parent::__construct('<p>Same sex examinations are frowned upon</p>');
	}
}

class Payment{
	public $id;
	public $student;
	public $amount;
	public $type;
	private $studentInstance;
	const VISA = 'visa';
	const CASH = 'cash';
	const MASTERCARD = 'mastercard';
	
	public static function getPayments(){
		$stmt = DataBaseAccess::getDBH()->prepare('SELECT * FROM ds_payments');
		$stmt->execute();
		return $stmt->fetchALL(PDO::FETCH_CLASS,'Payment');
	}
	
	public function getStudent(){
		if (is_null($this->studentInstance)){
			$this->studentInstance = Student::getByID($this->student);
		}
		return $this->studentInstance;
	}
	
	public function insert(){
		$stmt = DataBaseAccess::getDBH()->prepare('INSERT INTO ds_payments (student,amount,type) VALUES (:student, :amount, :type)');
		$stmt->execute(array(':student'  => $this->student,
							':type'    => $this->type,
							':amount'  => $this->amount));
	}
	
	public function validate(){
		$valid = true;
		$errorString = '';
		if (is_null($this->student)){
			$valid = false;
			$errorString .= '<p class="invalid">required field &#8220;student&#8221; missing</p>';
		}
		if (!($this->amount = validateAmount($this->amount))){
			$valid = false;
			$errorString .= '<p class="invalid">invalid amount</p>';
		}
		if (!$valid){
			throw new InvalidUserInputException($errorString);
		}
	}
	
	public function __toString(){
		return "$this->type £$this->amount";
	}
	
	public static function printHeader(){
		?>
		<tr>
			<th>Type</th>
			<th>Amount</th>
			<th>Student</th>
		</tr>
		<?php
	}
	
	public function printRow(){
		?>
		<tr>
			<td><?=$this->type?></td>
			<td><?=$this->amount?></td>
			<td><?=$this->getStudent()->name?></td>
		</tr>
		<?php
	}
}
	
	
?>
