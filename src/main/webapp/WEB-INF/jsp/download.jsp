<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<html>
<head>
<title>Information File</title>
<style> <%@include file="/css/download.css"%> </style>
</head>
<body>

    <div class="header">
    <nav class="navbar navbar-dark justify-content-between" style="background-color: #000000";>
      <a id="ColorHome" class="navbar-brand navbar-light">Home of ${username}</a>
      <form class="form-inline" action="/object">
       <input type= "hidden" name ="csrftoken" value="${csrftoken}">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0 mr-2" type="submit">Search</button>
        <a href="/logout" > <button type="button" class="btn btn-danger mr-2">Logout</button> </a>
      </form>
    </nav>
    </div>

    <c:if test="${not empty 'message'}">
    <h4><div> ${message}</div></h4>
    </c:if>

     <div id="download">
            <div class="container">
                <div id="download-row" class="row justify-content-center align-items-center">
                    <div id="download-column" class="col-md-6">
                        <div id="download-box" class="col-md-12">
                            <form id="download-form" class="form" action="/login" method="post">
                                <input type= "hidden" name ="csrftoken" value="${csrftoken}">
                                <h3 class="text-center text-secondary">Information</h3>
                                <div class="form-group">
                                    <label for="nameFile" >NameFile: ${object.nombre}</label><br>
                                </div>
                                <div class="form-group">
                                    <label for="owner">Owner: "${object.username_usuari}"</label><br>
                                </div>
                                <div class="form-group">

                                    <input type="submit" name="submit" class="btn btn-info btn-md" value="Download">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</body>
</html>