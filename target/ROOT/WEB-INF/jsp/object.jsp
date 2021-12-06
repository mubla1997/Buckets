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
    <div id="header">
        <a href="/settings" > Settings </a>
    </div>
       <div id="bucket">
            <div class="container">
                <div id="bucket-row" class="row justify-content-center align-items-center">
                    <div id="bucket-column" class="col-md-6">
                        <div id="bucket-box" class="col-md-12">
                            <form id="bucket-form" class="form" action="" method="post">
                             <input type= "hidden" name ="csrftoken" value="${csrftoken}">
                                <h3 class="text-center text-info">Register</h3>
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