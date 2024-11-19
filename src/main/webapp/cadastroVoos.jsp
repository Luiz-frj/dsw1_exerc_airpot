<%--
  Created by IntelliJ IDEA.
  User: junior
  Date: 18/11/24
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Cadastro de Voos</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
  <form action="adm.do?action=cadastro" method="post">

    <div class="row mb-3">
        <label for="inputnumero">Numero</label>
        <input type="number" class="col-sm-2 col-form-label" id="inputnumero" name="numero">
      </div>

      <div class="row mb-3">
        <label for="inputagencia">Agencia</label>
        <input type="text" class="col-sm-2 col-form-label" id="inputagencia" name="agencia">
      </div>

      <div class="row mb-3">
        <label for="inputhorario">Horario</label>
        <input type="time" class="col-sm-2 col-form-label" id="inputhorario" name="horario">
      </div>

      <button type="submit" class="btn btn-primary">Cadastrar</button>

  </form>

  <a href="escolhaadm.jsp.html">Voltar pagina</a>

</body>
</html>