<%--
  Created by IntelliJ IDEA.
  User: junior
  Date: 19/11/24
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@page import="br.edu.ifsp.dsw1.model.entity.FlightData"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tabela de Voos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<table class="table table-dark table-bordered">
    <thead>
    <tr>
        <th scope="col">Numero do Voo</th>
        <th scope="col">Agencia</th>
        <th scope="col">Horario</th>
        <th scope="col">Status</th>
    </tr>
    </thead>

    <tbody>
    <%
        List<FlightData> lista = (List<FlightData>) request.getAttribute("flights");
        if(lista != null && !lista.isEmpty()){
            for(FlightData voo : lista){
    %>

    <tr>
        <td><%= voo.getFlightNumber()%></td>
        <td><%= voo.getCompany()%></td>
        <td><%= voo.getTime()%></td>
        <td><%= voo.getState().getClass().getSimpleName()%></td>
    </tr>

    <%
        }
    }else{
    %>
    <td colspan="5">Nenhum Voo encontrado</td>
    <%} %>

    </tbody>

</table>

<a href="index.jsp">Voltar para pagina anterior</a>
</body>
</html>
