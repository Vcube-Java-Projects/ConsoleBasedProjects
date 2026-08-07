<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login - SURYA BANK</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style>
body {
	background-color: #ffffff;
	font-family: 'Segoe UI', sans-serif;
}

.login-container {
	max-width: 400px;
	margin: 80px auto;
	padding: 30px;
	background-color: #ffffff;
	border-radius: 15px;
	box-shadow: 0 8px 20px rgba(0, 86, 179, 0.1);
	transition: box-shadow 0.3s ease-in-out;
}

.login-container:hover {
	box-shadow: 0 12px 24px rgba(0, 86, 179, 0.2);
}

.bank-title {
	text-align: center;
	color: #0056b3;
	font-weight: bold;
	font-size: 30px;
	margin-bottom: 30px;
}

.form-label {
	color: #0056b3;
	font-weight: 500;
}

.form-control:focus {
	border-color: #0056b3;
	box-shadow: 0 0 5px rgba(0, 86, 179, 0.4);
}

.btn-primary {
	background-color: #0056b3;
	border: none;
	width: 100%;
	transition: background-color 0.3s ease;
}

.btn-primary:hover {
	background-color: #004494;
}

.form-check-label {
	color: #555;
}

.error-message {
	color: red;
	text-align: center;
	margin-top: 15px;
	font-weight: bold;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="login-container">
			<div class="bank-title">SURYA BANK - Login</div>
			<form action="login" method="post">
				<div class="mb-3">
					<label class="form-label" for="username">Username:</label> <input
						type="text" name="username" id="username" class="form-control"
						required>
				</div>
				<div class="mb-3">
					<label class="form-label" for="password">Password:</label> <input
						type="password" name="password" id="password" class="form-control"
						autocomplete="off" required>
				</div>
				<div class="mb-3 form-check">
					<input type="checkbox" class="form-check-input" id="showPassword"
						onclick="togglePassword()"> <label
						class="form-check-label" for="showPassword">Show Password</label>
				</div>
				<input type="submit" value="Login" class="btn btn-primary">
			</form>
			<p class="text-center mt-3">
				<a href="registration.jsp" style="color: #0056b3;">Don't have an
					account? Register</a>
			</p>
			<div class="error-message">${error}</div>
		</div>
	</div>

	<script>
		function togglePassword() {
			var x = document.getElementById("password");
			x.type = x.type === "password" ? "text" : "password";
		}
	</script>
</body>
</html>
