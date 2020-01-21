<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>CIBTF | Error al Registrar tu Empresa</title>
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
                <h5 class="card-title text-center">Error al Registrar tu Empresa</h5>
                <br/>

                <c:if test="${status != 'done'}">
                  <form class="form-signin" action="nueva_empresa.jsp">
                    <label class="btn btn-lg btn-outline-warning btn-block">Error al Registrar la Empresa</label>
                    <br>
                      <span class="badge badge-secondary">Favor de Revisar los Datos</span>
                    <br/>
                    <hr>
                    <br/>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Intentar de Nuevo</button>
                  </form>
                </c:if>
                <c:if test="${status == 'done'}">
                  <form class="form-signin" action="index.jsp">
                    <label class="btn btn-lg btn-outline-success btn-block">¡Registro Exitoso!</label>
                    <br>
                      <span class="badge badge-info">Se te notificará por correo cuando tu cuenta quede activada</span>
                  
                    <br/>
                    <hr>
                    <br/>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Volver</button>
                  </form>

                </c:if>

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