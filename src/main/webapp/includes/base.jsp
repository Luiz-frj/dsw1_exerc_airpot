<%--
  Created by IntelliJ IDEA.
  User: junior
  Date: 21/11/24
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Aeroporto DSW1</title>
  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
</head>
<body>

<div class="container">
  <nav class="navbar navbar-expand-lg bg-secondary-subtle">
    <div class="container-fluid">
      <a class="navbar-brand" href="index.jsp">Airport DSW1</a>
      <button class="navbar-toggler" type="button"
              data-bs-toggle="collapse" data-bs-target="#navbarNav"
              aria-controls="navbarNav" aria-expanded="false"
              aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item"><a class="nav-link" href="adm.jsp">
            Administração</a></li>
          <li class="nav-item"><a class="nav-link" href="TabelaVoosEmbarque.jsp" action="adm.do?tabelaEmbarque"> Sala
            de Embarque</a></li>
          <li class="nav-item"><a class="nav-link" href="TabelaVoosDesembarque.jsp" action="adm.do?tabelaDesembarque"> Sala
            de Desembarque</a></li>
        </ul>
      </div>
    </div>
  </nav>
</div>


<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>