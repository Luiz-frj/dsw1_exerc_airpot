<%--
  Created by IntelliJ IDEA.
  User: junior
  Date: 18/11/24
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Administração</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<body>

    <form action="adm.do?action=login" method="post">
        <div class="row mb-3">
            <label for="inputEmail">Email</label>
            <input type="email" class="col-sm-2 col-form-label" id="inputEmail" name="email">
        </div>

        <div class="row mb-3">
            <label for="inputPassword">Senha</label>
            <input type="password" class="col-sm-2 col-form-label" id="inputPassword" name="password">
        </div>

        <button type="submit" class="btn btn-primary">Entrar</button>

    </form>

    <p><a href="/index.jsp">Retornar ao menu</a></p>

</body>
</html>
