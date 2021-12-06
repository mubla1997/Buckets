<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<html>
<head>
<title>Home</title>
<style> <%@include file="/css/home.css"%> </style>
</head>
<body>
    <h1 class="text-center text-info">Home Bucket</h1>
    <h2 class="text-center"> Welcome to oficial page from bucket <h2>
    <h3 class="text-center"> On this page you can upload your files with greater security</h3>
    <div class="container">
            <a  href="/login" class="text-info">login here</a>
            <a  href="/register" class="text-info">Register here</a>
    </div>
</body>
</html>