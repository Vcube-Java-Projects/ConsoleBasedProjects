<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.dao.UserDao, java.sql.*, javax.sql.*"%>
<%
String username = (String) session.getAttribute("username");
if (username == null) {
	response.sendRedirect("login.jsp");
	return;
}

double balance = 0;
try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root")) {
	UserDao dao = new UserDao();
	balance = dao.getBalance(username);
} catch (Exception e) {
	e.printStackTrace();
}
%>
<!DOCTYPE html>
<html>
<head>
<title>SURYA BANK - Dashboard</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	background: linear-gradient(to bottom right, #e6f0ff, #ffffff);
	font-family: 'Segoe UI', sans-serif;
}

.dashboard-container {
	max-width: 600px;
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
	font-size: 30px;
	margin-bottom: 30px;
}

.balance {
	text-align: center;
	font-size: 22px;
	margin-bottom: 25px;
	color: #006699;
}

.form-label {
	font-weight: bold;
}

.error-message {
	color: red;
	text-align: center;
}

.btn-custom {
	width: 100%;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">SURYA BANK</a>
			<form class="d-flex ms-auto" action="logout.jsp" method="post">
				<button class="btn btn-light" type="submit">Logout</button>
			</form>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="dashboard-container">
			<div class="bank-title">
				Welcome,
				<%=username%></div>
			<div class="balance">
				Current Balance: ₹<%=balance%></div>

			<form action="deposit" method="post" class="mb-4">
				<div class="mb-3">
					<label class="form-label">Deposit Amount</label> <input
						type="number" name="amount" class="form-control" required>
				</div>
				<button type="submit" class="btn btn-success btn-custom">Deposit</button>
			</form>

			<form action="withdraw" method="post">
				<div class="mb-3">
					<label class="form-label">Withdraw Amount</label> <input
						type="number" name="amount" class="form-control" required>
				</div>
				<button type="submit" class="btn btn-danger btn-custom">Withdraw</button>
			</form>
			<p>
				<a href="transactionHistory">View Transaction History</a>
			</p>


			<div class="error-message mt-3">${error}</div>
		</div>
	</div>
	<%
	String msg = request.getParameter("message");
	%>
	<script>
		
	<%if ("DepositSuccess".equals(msg)) {%>
		alert("Amount deposited successfully!");
	<%} else if ("WithdrawSuccess".equals(msg)) {%>
		alert("Amount withdrawn successfully!");
	<%}%>
		
	</script>

</body>
</html>
