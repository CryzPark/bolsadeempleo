<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>CIBTF | Registrar Empresa</title>
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
                <h5 class="card-title text-center">Registra tu Empresa</h5>
                <br/>
                <form class="form-signin" action="RegistrarEmpresaServlet" method="POST">



                  <div class="form-label-group">
                    <input type="email" id="correoUsuario" name="correoUsuario" class="form-control" placeholder="Correo" required>
                    <label for="correoUsuario">Tu Correo</label>
                  </div>
    
                  <div class="form-label-group">
                    <input type="password" id="passUsuario" name="passUsuario" class="form-control" placeholder="Contraseña" required>
                    <label for="passUsuario">Contraseña</label>
                  </div>

                  <div class="form-label-group">
                    <input type="text" id="nombreUsuario" name="nombreUsuario" class="form-control" placeholder="Nombre" required>
                    <label for="nombreUsuario">Tu Nombre</label>
                  </div>

                  <div class="form-label-group">
                    <input type="text" id="apellidosUsuario" name="apellidosUsuario" class="form-control" placeholder="Apellidos" required>
                    <label for="apellidosUsuario">Apellidos</label>
                  </div>

                  <hr>
                  
                  <div class="form-label-group">
                    <input type="text" id="nombreEmpresa" name="nombreEmpresa" class="form-control" placeholder="Nombre de la Empresa" required>
                    <label for="nombreEmpresa">Nombre de la Empresa</label>
                  </div>
                  
                  <div class="form-label-group">
                    <input type="text" id="telefonoEmpresa" name="telefonoEmpresa" class="form-control" placeholder="Télefono de la Empresa" required>
                    <label for="telefonoEmpresa">Télefono de la Empresa</label>
                  </div>

                  <div class="form-label-group">
                    <input type="email" id="correoEmpresa" name="correoEmpresa" class="form-control" placeholder="Correo de Empresa" required>
                    <label for="correoEmpresa">Correo de Empresa</label>
                  </div>

                  <div class="form-label-group">
                    <input type="text" id="calleEmpresa" name="calleEmpresa" class="form-control" placeholder="Calle" required>
                    <label for="calleEmpresa">Calle</label>
                  </div>
                  
                  <div class="form-label-group">
                    <input type="text" id="noCalleEmpresa" name="noCalleEmpresa" class="form-control" placeholder="No. Calle" required>
                    <label for="noCalleEmpresa">No. Calle</label>
                  </div>
                  
                  <div class="form-label-group">
                    <input type="text" id="coloniaEmpresa" name="coloniaEmpresa" class="form-control" placeholder="Colonia" required>
                    <label for="coloniaEmpresa">Colonia</label>
                  </div>
                  
                  <div class="form-label-group">
                    <input type="text" id="cpEmpresa" name="cpEmpresa" class="form-control" placeholder="Código Postal" required>
                    <label for="cpEmpresa">Código Postal</label>
                  </div>

                  <div class="form-label-group">
                    <input type="text" id="paisEmpresa" name="paisEmpresa" class="form-control" placeholder="País" required>
                    <label for="paisEmpresa">País</label>
                  </div>

                  <div class="form-label-group">
                    <input type="text" id="estadoEmpresa" name="estadoEmpresa" class="form-control" placeholder="Estado" required>
                    <label for="estadoEmpresa">Estado</label>
                  </div>

                  <div class="form-label-group">
                    <input type="text" id="ciudadEmpresa" name="ciudadEmpresa" class="form-control" placeholder="Ciudad" >
                    <label for="ciudadEmpresa">Ciudad</label>
                  </div>

                  <div class="form-label-group">
                    <input type="text" id="municipioEmpresa" name="municipioEmpresa" class="form-control" placeholder="Municipio" >
                    <label for="municipioEmpresa">Municipio</label>
                  </div>

                  <div class="form-label-group">
                    <input type="text" id="paginaEmpresa" name="paginaEmpresa" class="form-control" placeholder="Página Web" >
                    <label for="paginaEmpresa">Página Web</label>
                  </div>

                  <div class="form-label-group">
                    <input type="text" id="razonSocialEmpresa" name="razonSocialEmpresa" class="form-control" placeholder="Razón Social" required>
                    <label for="razonSocialEmpresa">Razón Social</label>
                  </div>

                  <div class="form-label-group">
                    <input type="text" id="rfcEmpresa" name="rfcEmpresa" class="form-control" placeholder="RFC de Empresa" required>
                    <label for="rfcEmpresa">RFC de Empresa</label>
                  </div>



                  <hr>
                  <br/>
                  <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Registrar</button>
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