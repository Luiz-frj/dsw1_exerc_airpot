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
  <title>Administração</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<form>
  <div class="row mb-3">
    <label for="inputportao">Portão</label>
    <input type="text" class="col-sm-2 col-form-label" id="inputportao">
  </div>
  </div>
  <div class="row mb-3">
    <label for="inputagencia">Agencia</label>
    <input type="text" class="col-sm-2 col-form-label" id="inputagencia">
  </div>
  </div>
  <div class="row mb-3">
    <label for="inputhorario">Horario</label>
    <input type="datetime" class="col-sm-2 col-form-label" id="inputhorario">
  </div>
  </div>
  <button type="submit" class="btn btn-primary">Cadastrar</button>
</form>
<a href="escolha.html">proxima pagina</a>
</body>
</html>