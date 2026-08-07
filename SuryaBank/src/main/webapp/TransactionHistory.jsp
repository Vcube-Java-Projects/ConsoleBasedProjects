<%@ page import="java.util.List"%>
<%@ page import="com.model.TransactionModel"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>Transaction History - SURYA BANK</title>
<style>
body {
	font-family: Arial, sans-serif;
	background: #e8f0fe;
	color: #333;
}

.container {
	width: 80%;
	margin: 30px auto;
	background: white;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0px 0px 10px #aaa;
}

table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	padding: 10px;
	border-bottom: 1px solid #ccc;
}

th {
	background: #1a73e8;
	color: white;
}
</style>
</head>
<body>
	<div class="container">
		<h2>SURYA BANK - Transaction History</h2>
		<table>
			<tr>
				<th>Type</th>
				<th>Amount</th>
				<th>Timestamp</th>
			</tr>
			<%
			List<TransactionModel> transactions = (List<TransactionModel>) request.getAttribute("transactions");
			if (transactions != null && !transactions.isEmpty()) {
				for (TransactionModel tx : transactions) {
			%>
			<tr>
				<td><%=tx.getType()%></td>
				<td>₹<%=tx.getAmount()%></td>
				<td><%=tx.getTimestamp()%></td>
			</tr>
			<%
			}
			} else {
			%>
			<tr>
				<td colspan="3">No transactions found.</td>
			</tr>
			<%
			}
			%>
		</table>
		<br> <a href="dashboard.jsp">Back to Dashboard</a>
	</div>
</body>
</html>
