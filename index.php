<?php
	function My_login($username, $password)
    {	
        $con_db = mysqli_connect("localhost", "root", "root", "final_db");
        if (mysqli_connect_errno($con_db))
        {
            echo "Failed to connect to MySQL: " . mysqli_connect_error();
        }
        $sql_command = "SELECT user_name FROM tb_Users WHERE user_name='$username' and password='$password'";
        $result = mysqli_query($con_db, $sql_command);
        $num_rows = mysqli_num_rows($result);
        if($num_rows > 0)
        {
            $row = mysqli_fetch_array($result);
            $username = $row[0];
            echo 'Success;' . $username ;
        }
        else
        {
            echo 'Failed. User does not exist. Try again.';
        }
        mysqli_close($con_db);
    }

    function My_register($username, $password, $password2)
	{
		$con_db = mysqli_connect("localhost", "root", "root", "final_db");
		if (mysqli_connect_errno($con_db))
		{
			echo "Failed to connect to MySQL: " . mysqli_connect_error();
		}
		else
		{
			try
			{
				$sql_command = "Select * FROM tb_Users WHERE user_name = '$username'";
				$result = mysqli_query($con_db, $sql_command);
				$num_rows = mysqli_num_rows($result);
				if($num_rows > 0)
				{
					echo 'Failed. Username exists already. Try again.';
				}
				else
				{
					if($password != $password2)
					{
						echo 'Failed. Passwords do not match. Try again.';
					}
					else
					{	
						$sql_command = "INSERT INTO tb_Users(user_name, password) VALUES('$username', '$password')";
						$result = mysqli_query($con_db, $sql_command);
						$row = mysqli_fetch_array($result);
						echo 'Success';
					}
				}
			}
			catch(exception $e)
			{
				echo 'Failed;' . $e;
			}	
		}
		mysqli_close($con_db);
	}
	
	function My_quiz($type, $meat, $time)
	{
		$con_db = mysqli_connect("localhost", "root", "root", "final_db");
		if (mysqli_connect_errno($con_db))
		{
			echo "Failed to connect to MySQL: " . mysqli_connect_error();
		}
		else {
			try
			{
				$sql_command = "SELECT link, title, time, ingredients FROM tb_Recipes WHERE type = '$type' and meat = '$meat' and time <= '$time' ORDER BY RAND() LIMIT 1";
				$result = mysqli_query($con_db, $sql_command);
				$num_rows = mysqli_num_rows($result);
				if($num_rows > 0)
				{
					$row = mysqli_fetch_array($result);
					$link = $row[0];
					$title = $row[1];
					$time = $row[2];
					$ingredients = $row[3];
					echo 'Success;' . $link . ';' . $title . ';' . $time . ';' . $ingredients;
				}
				else
				{	
					echo 'Sorry. No recipes match this criteria.';
				}
			}
			catch(exception $e)
			{
				echo 'Failed;' . $e;
			}	
		}
		mysqli_close($con_db);
	}
	function My_schedule($username, $link, $day)
	{
		$con_db = mysqli_connect("localhost", "root", "root", "final_db");
		if (mysqli_connect_errno($con_db))
		{
			echo "Failed to connect to MySQL: " . mysqli_connect_error();
		}
		else {
			try
			{
				$sql_command = "UPDATE tb_Users SET $day = '$link' WHERE user_name = '$username'";
				$result = mysqli_query($con_db, $sql_command);
				echo 'Success';
			}
			catch(exception $e)
			{
				echo 'Failed;' . $e;
			}	
		}
		mysqli_close($con_db);
	}
	function My_get_schedule($username, $day)
	{
		$con_db = mysqli_connect("localhost", "root", "root", "final_db");
		if (mysqli_connect_errno($con_db))
		{
			echo "Failed to connect to MySQL: " . mysqli_connect_error();
		}
		else {
			try
			{
				$sql_command = "SELECT $day FROM tb_Users WHERE user_name = '$username'";
				$result = mysqli_query($con_db, $sql_command);
				$row = mysqli_fetch_array($result);
				$link = $row[0];
				echo $link;
			}
			catch(exception $e)
			{
				echo 'Failed;' . $e;
			}	
		}
		mysqli_close($con_db);
	}
	function My_clear_favorites($username)
	{
		$con_db = mysqli_connect("localhost", "root", "root", "final_db");
		if (mysqli_connect_errno($con_db))
		{
			echo "Failed to connect to MySQL: " . mysqli_connect_error();
		}
		else {
			try
			{
				$sql_command = "UPDATE tb_Users SET favorites = '' WHERE user_name = '$username'";
				$result = mysqli_query($con_db, $sql_command);
				echo 'Success';
			}
			catch(exception $e)
			{
				echo 'Failed;' . $e;
			}	
		}
		mysqli_close($con_db);
	}
	function My_get_favorites($username)
	{
		$con_db = mysqli_connect("localhost", "root", "root", "final_db");
		if (mysqli_connect_errno($con_db))
		{
			echo "Failed to connect to MySQL: " . mysqli_connect_error();
		}
		else {
			try
			{
				$sql_command = "SELECT favorites FROM tb_Users WHERE user_name = '$username'";
				$result = mysqli_query($con_db, $sql_command);
				$row = mysqli_fetch_array($result);
				$favorites = $row[0];
				echo $favorites;
			}
			catch(exception $e)
			{
				echo 'Failed;' . $e;
			}	
		}
		mysqli_close($con_db);
	}
	function My_clear_schedule($username)
	{
		$con_db = mysqli_connect("localhost", "root", "root", "final_db");
		if (mysqli_connect_errno($con_db))
		{
			echo "Failed to connect to MySQL: " . mysqli_connect_error();
		}
		else {
			try
			{
				$sql_command = "UPDATE tb_Users SET monday = '', tuesday = '', wednesday = '', thursday = '', friday = '', saturday = '', sunday = '' WHERE user_name = '$username'";
				$result = mysqli_query($con_db, $sql_command);
				echo 'Sucess';
			}
			catch(exception $e)
			{
				echo 'Failed;' . $e;
			}	
		}
		mysqli_close($con_db);
	}
	function My_clear_day($username, $day)
	{
		$con_db = mysqli_connect("localhost", "root", "root", "final_db");
		if (mysqli_connect_errno($con_db))
		{
			echo "Failed to connect to MySQL: " . mysqli_connect_error();
		}
		else {
			try
			{
				$sql_command = "UPDATE tb_Users SET $day = '' WHERE user_name = '$username'";
				$result = mysqli_query($con_db, $sql_command);
				echo 'Success';
			}
			catch(exception $e)
			{
				echo 'Failed;' . $e;
			}	
		}
		mysqli_close($con_db);
	}
	function My_advice($username, $key)
	{
		$witRoot = "https://api.wit.ai/message?";
		$witVersion = '20211126';
		
		$witURL = $witRoot . "v=" . $witVersion . "&q=" . urlencode($key);
		
		try{
			$ch = curl_init();
			$header = array();
			$header[] = 'Authorization: Bearer 3LVL72TPIH4ESWH7L3T3BG3RHWC3227N';
			
			curl_setopt($ch, CURLOPT_URL, $witURL);
			curl_setopt($ch, CURLOPT_HTTPHEADER, $header);
			curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
			curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
			
			$server_output = curl_exec($ch);
			
			$status_code = curl_getinfo($ch, CURLINFO_HTTP_CODE);

			if (curl_errno($ch)) {
				echo 'CURL Error: ' . curl_error($ch);
			}
			
			curl_close($ch);
			$server_decoded_rsp = json_decode($server_output)->entities->{"advice:advice"};
			for ($i = 0; $i < count($server_decoded_rsp); $i++){
				$repeats = 0;
				$keyword = $server_decoded_rsp[$i]->value;
				if($i > 0){
					for ($y = $i - 1; $y >= 0; $y--){
						if ($keyword == $server_decoded_rsp[$y]->value){
							$repeats++;
						}
					}
				}
				if($repeats == 0){
					$con_db = mysqli_connect("localhost", "root", "root", "final_db");
					if (mysqli_connect_errno($con_db)){
						echo "Failed to connect to MYSql:" . mysqli_connect_error();
					}
					$sql_command = "SELECT response FROM tb_Advice WHERE keyword = '{$keyword}'";
					$result = mysqli_query($con_db, $sql_command);
					$num_rows = mysqli_num_rows ($result);
					if($num_rows > 0){
						$row = mysqli_fetch_array($result);
						$response = $row[0];
						echo $response;
					}
					else {
						echo "There currently is no information on this food. Sorry.";
					}
					mysqli_close($con_db);
				}
			}
			if(count($server_decoded_rsp)== 0 && $response != ""){
				echo "There currently is no information on this food. Sorry.";
			}
		}
		catch(exception $e)
		{
			echo 'Failed;' . $e;
		}
	}
	function My_favorite($username, $link)
	{
		$con_db = mysqli_connect("localhost", "root", "root", "final_db");
		if (mysqli_connect_errno($con_db))
		{
			echo "Failed to connect to MySQL: " . mysqli_connect_error();
		}
		else {
			try
			{
				$sql_command = "UPDATE tb_Users SET favorites = '$link' WHERE user_name = '$username'";
				$result = mysqli_query($con_db, $sql_command);
				echo 'Success';
			}
			catch(exception $e)
			{
				echo 'Failed;' . $e;
			}	
		}
		mysqli_close($con_db);
	}
	
    $method = $_POST['method'];
	$username = $_POST['username'];
    switch ($method) {
        case 'login':
			$password = $_POST['password'];
            My_login($username, $password);
			break;
		case 'register':
			$password = $_POST['password'];
			$password2 = $_POST['password2'];
            My_register($username, $password, $password2);
            break;
		case 'quiz':
			$type = $_POST['type'];
			$meat = $_POST['meat'];
			$time = $_POST['time'];
            My_quiz($type, $meat, $time);
            break;
		case 'schedule':
			$link = $_POST['link'];
			$day = $_POST['day'];
            My_schedule($username, $link, $day);
            break;
		case 'get_schedule':
			$day = $_POST['day'];
            My_get_schedule($username, $day);
            break;
		case 'clear_favorites':
            My_clear_favorites($username);
            break;
		case 'get_favorites':
            My_get_favorites($username);
            break;
		case 'clear_schedule':
            My_clear_schedule($username);
            break;
		case 'clear_day':
			$day = $_POST['day'];
            My_clear_day($username, $day);
            break;
		case 'advice':
			$key = $_POST['key'];
            My_advice($username, $key);
            break;
		case 'favorite':
			$link = $_POST['link'];
            My_favorite($username, $link);
            break;
        default:
            break;
    }
?>