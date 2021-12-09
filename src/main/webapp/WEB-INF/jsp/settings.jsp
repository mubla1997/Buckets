<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<html>
<head>
<title>Settings</title>
<style> <%@include file="/css/settings.css"%> </style>
</head>
<body>

<c:if test="${not empty 'message'}">
<h4><div> ${message}</div></h4>
</c:if>
    <nav class="navbar navbar-dark justify-content-between" style="background-color: #000000";>
      <a id="ColorHome" class="navbar-brand navbar-light">Settings of ${username}</a>
      <form class="form-inline">
        <a href="/logout" > <button type="button" class="btn btn-danger mr-2">Logout</button> </a>
      </form>
    </nav>
       <div id="settings">
            <div class="container">
                <div id="settings-row" class="row justify-content-center align-items-center">
                    <div id="settings-column" class="col-md-6">
                        <div id="settings-box" class="col-md-12">
                            <form id="settings-form" class="form" action="" method="post">
                             <input type= "hidden" name ="csrftoken" value="${csrftoken}">
                                <h3 class="text-center text-info">Settings</h3>
                                <div class="form-group">
                                    <label for="username" class="text-info">Username</label>
                                    <input type="text" class="form-control" id="username" name="username" placeholder="Enter username">
                                </div>
                                <div class="form-group">
                                    <label for="password" class="text-info">Password</label>
                                    <input type="password" class="form-control" id="password" name="password" placeholder="Enter password">
                                </div>
                                <div class="form-group">
                                    <label for="passwordR" class="text-info">Password</label>
                                    <input type="password" class="form-control" id="passwordR" name="repPass" placeholder="Repit password">
                                </div>
                                <div class="form-group">
                                    <label for="realname" class="text-info">Realname</label>
                                    <input type="text" class="form-control" id="realname" name="realname" placeholder="Enter realname">
                                </div>
                                  <div class="form-group">
                                    <label for="age" class="text-info">Age</label>
                                    <input type="number" class="form-control" id="age" name="age" placeholder="Enter age">
                                  </div>

                                <input type="submit" name="submit" class="btn btn-info btn-md" value="Save">

                                <a href="/object" > Go back </a>

                                <a href="/removeUser" > <button type="button" class="btn btn-danger justify-content-between">Delete User</button> </a>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</body>
</html>