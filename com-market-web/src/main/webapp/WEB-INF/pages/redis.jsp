<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Redis 操作</title>
</head>
<body>
<h2>Redis 字符串操作</h2>
<form action="/redis/add" method="post">
    <h3>key:<input type="text" name="redis_key"></h3>
    <h3>value:<input type="text" name="redis_value"></h3>
    <h3><input type="submit" value="插入"></h3>
</form>
</body>
</html>
