<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<html>
<head>
<title>Create Bucket</title>
<style> <%@include file="/css/bucket.css"%> </style>
</head>
<body>

    <div class="header">
    <nav class="navbar navbar-dark justify-content-between" style="background-color: #000000";>
      <a id="ColorHome" class="navbar-brand navbar-light">Home of ${username}</a>
      <form class="form-inline" action="/object">
       <input type= "hidden" name ="csrftoken" value="${csrftoken}">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0 mr-2" type="submit">Search</button>
        <a href="/settings" > <button type="button" class="btn btn-success mr-2">Settings</button> </a>
        <a href="/logout" > <button type="button" class="btn btn-danger mr-2">Logout</button> </a>
      </form>
    </nav>
    </div>

    <c:if test="${not empty 'message'}">
    <h4><div> ${message}</div></h4>
    </c:if>

       <div id="bucket">
            <div class="container">
                <div id="bucket-row" class="row justify-content-center align-items-center">
                    <div id="bucket-column" class="col-md-6">
                        <div id="bucket-box" class="col-md-12">
                            <form id="bucket-form" class="form" action="/bucket" method="post" >
                             <input type= "hidden" name ="csrftoken" value="${csrftoken}">
                                <h3 class="text-center text-info">Bucket</h3>
                                <div class="form-group">
                                    <label for="bucket" class="text-info"> Name bucket: </label>
                                    <input type="text" class="form-control" id="name" name="name" placeholder="Enter name for bucket">
                                </div>
                                <input type="submit" name="submit" class="btn btn-info btn-md" value="Create">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="containerList">
        <table class="table">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Name Bucket</th>
              <th scope="col">owner</th>
              <th scope="col">Date</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>
           <c:set var="count" value="1"/>
           <c:forEach var = "bucket" items="${listBucket}">
                <th scope="row">${count}</th>
                <td><a href="/object/${bucket.nombre}">/${bucket.nombre}</a></td>
                <td>${bucket.username_usuari}</td>
                <td>${bucket.fecha}</td>
                <td><form><input type="submit" class="btn btn-danger" value ="Delete"></form><td>
                </tr>
                <c:set var="count" value="${count + 1}"/>
           </c:forEach>
           </tbody>
        </table>
       </div>
</body>
</html>