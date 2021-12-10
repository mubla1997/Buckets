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

<c:if test="${not empty 'message'}">
<h4><div> ${message}</div></h4>
</c:if>
    <div class="header">
    <nav class="navbar navbar-dark justify-content-between" style="background-color: #000000";>
      <a id="ColorHome" class="navbar-brand navbar-light">Home of ${username}</a>
      <form class="form-inline">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0 mr-2" type="submit">Search</button>
        <a href="/settings" > <button type="button" class="btn btn-success mr-2">Settings</button> </a>
        <a href="/logout" > <button type="button" class="btn btn-danger mr-2">Logout</button> </a>
      </form>
    </nav>
    </div>
       <div id="bucket">
            <div class="container">
                <div id="bucket-row" class="row justify-content-center align-items-center">
                    <div id="bucket-column" class="col-md-6">
                        <div id="bucket-box" class="col-md-12">
                            <form id="bucket-form" class="form" action="" method="post">
                             <input type= "hidden" name ="csrftoken" value="${csrftoken}">
                                <h3 class="text-center text-info">Bucket</h3>
                                <div class="form-group">
                                    <label for="bucket" class="text-info">Name bucket: </label>
                                    <input type="text" class="form-control" id="bucket" name="bucket" placeholder="Enter name for bucket">
                                </div>

                                <input type="submit" name="bucket" class="btn btn-info btn-md" value="Create">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</body>
</html>