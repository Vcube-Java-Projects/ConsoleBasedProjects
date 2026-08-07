<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Register - SURYA BANK</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	background: linear-gradient(to bottom right, #e6f0ff, #ffffff);
	font-family: 'Segoe UI', sans-serif;
}

.register-container {
	max-width: 400px;
	margin: auto;
	margin-top: 80px;
	padding: 30px;
	background-color: #ffffff;
	border-radius: 12px;
	box-shadow: 0 4px 15px rgba(0, 0, 255, 0.1);
}

.bank-title {
	text-align: center;
	color: #003366;
	font-weight: bold;
	font-size: 28px;
	margin-bottom: 30px;
}

.form-label {
	color: #003366;
}

.btn-primary {
	width: 100%;
}

.error-message {
	color: red;
	text-align: center;
	margin-top: 10px;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="register-container">
			<div class="bank-title">SURYA BANK - Register</div>
			<form action="RegistrationServlet" method="post">
				<div class="mb-3">
					<label class="form-label">Username:</label> <input type="text"
						name="username" class="form-control" required>
				</div>
				<div class="mb-3">
					<label class="form-label">Password:</label> <input type="password"
						name="password" class="form-control" required>
				</div>
				<input type="submit" value="Register" class="btn btn-primary">
			</form>
			<p class="text-center mt-3">
				<a href="login.jsp">Already have an account? Login</a>
			</p>
			<div class="error-message">${error}</div>
		</div>
	</div>
</body>
</html>
