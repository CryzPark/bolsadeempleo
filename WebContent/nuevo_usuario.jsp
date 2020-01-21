<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${sessionUser == null}"> 
	<c:redirect url="errorLogin.jsp"/>
</c:if>
<c:if test="${sessionUser.getRolUsuario() != 'admin'}">
	<c:redirect url="404.jsp"/>
</c:if>


<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Bolsa de Trabajo de Universidades de Jalisco">
  <meta name="author" content="Tecnológico Mario Molina Campus Zapopan">
  <link rel="shortcut icon" href="img/favicon.png">

  <title>CIBTF | Registrar Usuario</title>

  <!-- Bootstrap CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- bootstrap theme -->
  <link href="css/bootstrap-theme.css" rel="stylesheet">
  <!--external css-->
  <!-- font icon -->
  <link href="css/elegant-icons-style.css" rel="stylesheet" />
  <link href="css/font-awesome.min.css" rel="stylesheet" />
  <!-- Custom styles -->
  <link href="css/style.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet" />

</head>

<body>
  <!-- container section start -->
  <section id="container" class="">
    <!--header start-->

    <header class="header dark-bg">
      <div class="toggle-nav">
        <div class="icon-reorder tooltips" data-original-title="Barra de Menú" data-placement="bottom"><i class="icon_menu"></i></div>
      </div>

      <!--logo start-->
      <a href="PanelServlet" class="logo"><img src="img/favicon.png" class="img-fluid logo"></a>
      <a href="PanelServlet" class="logo">&nbsp;&nbsp; CI<span class="lite">BTF</span></a>
      
      <!--logo end-->


      <div class="top-nav notification-row">
        <!-- notificatoin dropdown start-->
        <ul class="nav pull-right top-menu">
          <!-- user login dropdown start-->
          <li class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="profile-ava">
                                <img alt="" src="img/avatar1_small.jpg">
                            </span>
                            <span class="username"><c:out value="${sessionUser.getNombreUsuario()}"></c:out></span>
                            <b class="caret"></b>
                        </a>
            <ul class="dropdown-menu extended logout">
              <div class="log-arrow-up"></div>
              <li class="eborder-top">
                <a href="MiPerfilServlet"><i class="icon_profile"></i> Mi Perfil</a>
              </li>
              <li>
                <a href="index.jsp"><i class="icon_house"></i> Página de Inicio</a>
              </li>
              <li>
                <a href="LogoutServlet"><i class="icon_key_alt"></i> Cerrar Sesión</a>
              </li>
            </ul>
          </li>
          <!-- user login dropdown end -->
        </ul>
        <!-- notificatoin dropdown end-->
      </div>
    </header>
    <!--header end-->
    <!--sidebar start-->
    <aside>
      <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start  fa-user-md-->
        <ul class="sidebar-menu">
          <!-- panel-->
          <li class="">
            <a class="" href="PanelServlet">
                          <i class="icon_desktop"></i>
                          <span>Panel</span>
                      </a>
          </li>

          <!-- Mi Perfil-->
          <li>
            <a class="" href="MiPerfilServlet">
                          <i class="icon_profile"></i>
                          <span>Mi Perfil</span>
                      </a>
          </li>

          <!-- Noticias/Eventos-->
          <c:if test="${sessionUser.getRolUsuario() == 'admin' || sessionUser.getRolUsuario() == 'universidad' }">
            <li class="sub-menu">
              <a href="javascript:;" class="">
                            <i class="icon_documents_alt"></i>
                            <span>Publicaciones</span>
                            <span class="menu-arrow arrow_carrot-right"></span>
                        </a>
              <ul class="sub">
                <li><a class="" href="nueva_publicacion.jsp">Publicar Nuevo</a></li>
                <li><a class="" href="ListarPublicacionesServlet">Administrar</a></li>
              </ul>
            </li>
          </c:if>

          <!-- Nuevos Usuarios-->
          <c:if test="${sessionUser.getRolUsuario() == 'admin'}">
            <li class="sub-menu">
              <a href="javascript:;" class="">
                            <i class="icon_group"></i>
                            <span>Usuarios</span>
                            <span class="menu-arrow arrow_carrot-right"></span>
                        </a>
              <ul class="sub">
                <li><a class="" href="nuevo_usuario.jsp">Nuevo Usuario</a></li>
                <li><a class="" href="ListarUsuariosServlet">Administrar</a></li>
              </ul>
            </li>
          </c:if>

          <!-- Vacantes Subir/Administrar-->
          <c:if test="${sessionUser.getRolUsuario() == 'admin' || sessionUser.getRolUsuario() == 'empresa'}">
            <li class="sub-menu">
              <a href="javascript:;" class="">
                            <i class="icon_pencil-edit"></i>
                            <span>Vacantes</span>
                            <span class="menu-arrow arrow_carrot-right"></span>
                        </a>
              <ul class="sub">
                <c:if test="${sessionUser.getRolUsuario() == 'empresa'}">
                  <li><a class="" href="GoRegistrarVacanteServlet">Subir Vacante</a></li>
                </c:if>
                <li><a class="" href="ListarVacantesServlet">Administrar</a></li>
              </ul>
            </li>
          </c:if>

          <!-- Contacto-->
          <c:if test="${sessionUser.getRolUsuario() == 'empresa' || sessionUser.getRolUsuario() == 'universidad'}">
            <li>
              <a class="" href="contacto.jsp">
                            <i class="icon_mail"></i>
                            <span>Contacto</span>
  
                        </a>
  
            </li>
          </c:if>
        </ul>
        <!-- sidebar menu end-->
      </div>
    </aside>
    <!--sidebar end-->

    <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <div class="row">
          <div class="col-lg-12">
            <h3 class="page-header"><i class="fa fa-user-md"></i> Usuarios</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i><a href="index.jsp">Inicio</a></li>
              <li><i class="fa fa-user-md"></i>Usuarios</li>
              <li><i class="fa fa-user-md"></i>Nuevo</li>
          </div>
        </div>
        <!-- page start-->
                <!-- Form validations -->
                <div class="row">
                  <div class="col-lg-12">
                    <section class="panel">
                      <header class="panel-heading">
                        Nuevo Usuario 

                        <!-- Alertas Done/Error -->
                        <c:if test="${not empty status}">
                          <c:if test="${status == 'done'}">
                            <div class="alert alert-success fade in">
                              <button data-dismiss="alert" class="close close-sm" type="button">
                                                  <i class="icon-remove"></i>
                                              </button>
                              <strong>Hecho!</strong> El Usuario se ha registrado correctamente
                            </div>
                          </c:if>
                          <c:if test="${status == 'error'}">
                            <div class="alert alert-block alert-danger fade in">
                              <button data-dismiss="alert" class="close close-sm" type="button">
                                                  <i class="icon-remove"></i>
                                              </button>
                              <strong>Ups!</strong> No se pudo registrar al usuario
                            </div>
                          </c:if>
                        </c:if>

                      </header>
                      <div class="panel-body">
                        <div class="form">
                          <form class="form-validate form-horizontal" id="feedback_form" method="POST" action="RegistrarUsuarioServlet">

                            <div class="form-group ">
                              <label for="nombreUsuario" class="control-label col-lg-2">Nombre <span class="required">*</span></label>
                              <div class="col-lg-10">
                                <input class="form-control" id="nombreUsuario" name="nombreUsuario" minlength="5" type="text" required />
                              </div>
                            </div>

                            <div class="form-group ">
                              <label for="apellidosUsuario" class="control-label col-lg-2">Apellidos <span class="required">*</span></label>
                              <div class="col-lg-10">
                                <input class="form-control" id="apellidosUsuario" name="apellidosUsuario" minlength="5" type="text" required />
                              </div>
                            </div>

                            <div class="form-group ">
                              <label for="correoUsuario" class="control-label col-lg-2">Correo <span class="required">*</span></label>
                              <div class="col-lg-10">
                                <input class="form-control " id="correoUsuario" type="email" name="correoUsuario" required />
                              </div>
                            </div>

                            <div class="form-group ">
                              <label for="passUsuario" class="control-label col-lg-2">Contraseña <span class="required">*</span></label>
                              <div class="col-lg-10">
                                <input class="form-control " id="passUsuario" type="password" name="passUsuario" required />
                              </div>
                            </div>

                            <div class="form-group ">
                              <label for="rolUsuario" class="control-label col-lg-2">Rol <span class="required">*</span></label>
                              <div class="col-lg-10">
                                <select class="form-control m-bot15" id="rolUsuario" name="rolUsuario">
                                  <option value="admin">Administrador</option>
                                  <option value="universidad">Universidad</option>
                                  <option value="empresa">Empresa</option>
                              </select>
                              </div>
                            </div>

                            <input type="hidden" id="statusUsuario" name="statusUsuario" value="0">

                            <div class="form-group ">
                              <label for="idUniversidad" class="control-label col-lg-2">ID Universidad</label>
                              <div class="col-lg-10">
                                <input class="form-control" id="idUniversidad" name="idUniversidad" type="text" value="0" />
                              </div>
                            </div>

                            <div class="form-group ">
                              <label for="idEmpresa" class="control-label col-lg-2">ID Empresa</label>
                              <div class="col-lg-10">
                                <input class="form-control" id="idEmpresa" name="idEmpresa" type="text" value="0" />
                              </div>
                            </div>

                            <div class="form-group">
                              <div class="col-lg-offset-2 col-lg-10">
                                <button class="btn btn-primary" type="submit">Registrar</button>
                                <button class="btn btn-default" type="reset">Limpiar</button>
                              </div>
                            </div>
                          </form>
                        </div>
        
                      </div>
                    </section>
                  </div>
                </div>
        <!-- page end-->
      </section>
    </section>
    <!--main content end-->
  </section>
  <!-- container section end -->
  <!-- javascripts -->
  <script src="js/jquery.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <!-- nice scroll -->
  <script src="js/jquery.scrollTo.min.js"></script>
  <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
  <!--custome script for all page-->
  <script src="js/scripts.js"></script>


</body>

</html>
