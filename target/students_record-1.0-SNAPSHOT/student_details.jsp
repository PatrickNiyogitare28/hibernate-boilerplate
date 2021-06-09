<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
        <h2>Student details</h2>
        <label>First Name: </label>
        <c:out value='${student.firstName}'/><br/><br/>
        <label>Last Name: </label>
        <c:out value='${student.lastName}'/><br/><br/>
        <label>Gender: </label>
        <c:out value="${student.gender}" />
    </center>
</body>
</html>
