<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${sessionUser != null}"> 
	<c:redirect url="index.jsp"/>
</c:if>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>CIBTF | Iniciar Sesión</title>
    <link rel="stylesheet" href="css/bootstrap.min2.css">
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
    <div class="container">
        <div class="row">
          <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
            <div class="card card-signin my-5">
              <div class="card-body">
                <a href="index.jsp" class="scrollto"><img src="img/logo.png" alt="" class="img-fluid"></a>
                <br/><br/><br/>
                <h5 class="card-title text-center">Iniciar Sesión</h5>
                <br/>
                <form class="form-signin" action="ValidarConexionServlet" method="POST">
                  <div class="form-label-group">
                    <input type="email" id="correoUsuario" name="correoUsuario" class="form-control" placeholder="Correo" required>
                    <label for="correoUsuario">Correo</label>
                  </div>
    
                  <div class="form-label-group">
                    <input type="password" id="passUsuario" name="passUsuario" class="form-control" placeholder="Contraseña" required>
                    <label for="passUsuario">Contraseña</label>
                  </div>
                  <hr>
                  <br/>
                  <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Sign in</button>
                </form>
              </div>
            </div>
          </div>
        </div>
    </div>
    <script src="scripts/jquery-3.3.1.min.js"></script>
    <script src="scripts/bootstrap.min.js"></script>
    <script src="scripts/scripts.js"></script>
</body>
</html>