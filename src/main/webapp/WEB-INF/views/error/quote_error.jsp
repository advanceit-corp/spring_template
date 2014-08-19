<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Error page</title>
</head>
<body>
<h1>
	Hello from error!  
</h1>
	Error code:<p> ${errCode}</p>
	Error message:<p> ${errMsg}</p>
</body>
</html>
