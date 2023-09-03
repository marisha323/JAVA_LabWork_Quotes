<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.09.2023
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Анкета</h1>
<form method="POST" action="anketa-servlet">
    <label for="full_name">ПІП:</label>
    <input type="text" id="full_name" name="full_name"><br><br>

    <label for="phone">Телефон:</label>
    <input type="text" id="phone" name="phone"><br><br>

    <label for="email">Email:</label>
    <input type="text" id="email" name="email"><br><br>

    <label for="age">Вік:</label>
    <input type="text" id="age" name="age"><br><br>

    <label>Стать:</label>
    <select name="gender">
        <option value="Чоловік">Чоловік</option>
        <option value="Жінка">Жінка</option>
        <option value="Інше">Інше</option>
    </select><br><br>

    <label>Хочете підписатися на нашу розсилку?</label>
    <input type="checkbox" id="subscribe" name="subscribe" value="yes"><br><br>

    <input type="submit" value="Відправити">
</form>
</body>
</html>
