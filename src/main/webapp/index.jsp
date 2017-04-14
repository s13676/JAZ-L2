<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form action="add" method="get">
	<label>Imię:<input type="text" name="name" /></label><br/>
	<label>Nazwisko:<input type="text" name="surname" /></label><br/>
	<label>Pracodawca:<input type="text" name="employment" /></label><br/>
	<label>Adres email:<input type="email" name="email" /></label><br/>
	<label>Potwierdź adres email:<input type="email" name="confirm_email" /></label><br/>
	<label>Skąd się dowiedziałeś o konferencji:</label><br/>
		<label>Ogłoszenie w pracy<input type="radio" name="info" value="work"/></label><br/>
		<label>Ogłoszenie na uczelni<input type="radio" name="info" value="school"/></label><br/>
		<label>Facebook<input type="radio" name="info" value="facebook"/></label><br/>
		<label>Znajomi<input type="radio" name="info" value="friends"/></label><br/>
	<input type="submit" value="wyslij" />
</form>
</body>
</html>
