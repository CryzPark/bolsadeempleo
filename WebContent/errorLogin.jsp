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
    <title>CIBTF | Error de Inicio de Sesión</title>
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
                <h5 class="card-title text-center">Error al Iniciar Sesión</h5>
                <br/>
                <form class="form-signin" action="login.jsp">
                  <c:if test="${error == 'contraseña'}">
                    <label class="btn btn-lg btn-outline-warning btn-block">Contraseña Incorrecta</label>
                  </c:if>
                  <c:if test="${error == 'correo'}">
                    <label class="btn btn-lg btn-outline-danger btn-block">El Usuario No Existe</label>
                    <br/>
                    <code>
                      Si eres nuevo, se te notificará por correo cuando tu cuenta esté activa
                    </code>
                  </c:if>
                  <c:if test="${error == 'noLogin' || error != 'contraseña' && error != 'correo' && error != 'desconocido'}">
                    <label class="btn btn-lg btn-outline-info btn-block">No Has Iniciado Sesión</label>
                    <br/>
                  </c:if>
                  <c:if test="${error == 'desconocido'}">
                    <label class="btn btn-lg btn-outline-dark btn-block">Error Desconocido</label>
                    <br/>
                  </c:if>
                  <br/>
                  <hr>
                  <br/>
                  <button class="btn btn-lg btn-primary btn-block" type="submit">Intentar de Nuevo</button>
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