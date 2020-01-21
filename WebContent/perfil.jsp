<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${sessionUser == null}"> 
	<c:redirect url="errorLogin.jsp"/>
</c:if>
<c:if test="${sessionUser.getRolUsuario() != 'empresa' && sessionUser.getRolUsuario() != 'admin' && sessionUser.getRolUsuario() != 'universidad'}">
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

  <title>CIBTF | Mi Perfil</title>

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
            <h3 class="page-header"><i class="fa fa-user-md"></i> Mi Perfil</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i><a href="index.jsp">Inicio</a></li>
              <li><i class="fa fa-user-md"></i>Mi Perfil</li>
            </ol>
          </div>
        </div>

        <!-- page start-->
        <div class="row">
          <div class="col-lg-12">
            <section class="panel">
              <header class="panel-heading tab-bg-info">
                <ul class="nav nav-tabs">
                  <li class="active">
                    <a data-toggle="tab" href="#profile">
                    <i class="fa fa-user-md"></i>
                    Perfil
                    </a>
                  </li>
                  <li class="">
                    <a data-toggle="tab" href="#edit-profile">
                    <i class="fa fa-square-o"></i>
                    Cambiar Contraseña
                    </a>
                  </li>
                </ul>
              </header>
              <div class="panel-body">
                <div class="tab-content">
                  
                  <!-- profile -->
                  <div id="profile" class="tab-pane active">
                    <section class="panel">
                      <div class="bio-graph-heading">
                        Si tiene problemas con su información ó desea cambiar alguna dato erróneo, favor de ponserse en contacto con nosotros y atenderemos la solicitud a la brevedad.
                      </div>
                      <div class="panel-body bio-graph-info">
                        <h1>Mi Información</h1>
                        
                        <div class="row">
                          <div class="bio-row">
                            <p><span>Nombre </span>: ${usuario.getNombreUsuario()}</p>
                          </div>

                          <!--Columna 2 Instutucion-->
                          <c:if test="${usuario.getRolUsuario() == 'admin'}">
                            <div class="bio-row">
                              <p><span>Universidad </span>: Tecnológico Mario Molina</p>
                            </div>
                          </c:if>
                          <c:if test="${usuario.getRolUsuario() == 'empresa'}">
                            <div class="bio-row">
                              <p><span>Empresa </span>: ${usuario.getNombreEmpresaUsuario()}</p>
                            </div>
                          </c:if>
                          <c:if test="${usuario.getRolUsuario() == 'universidad'}">
                            <div class="bio-row">
                              <p><span>Universidad </span>: ${usuario.getNombreUniversidadUsuario()}</p>
                            </div>
                          </c:if>
                          <!---->


                          <div class="bio-row">
                            <p><span>Apellidos </span>: ${usuario.getApellidosUsuario()}</p>
                          </div>

                          <!--Telefono Institucion-->
                          <c:if test="${usuario.getRolUsuario() == 'admin'}">
                            <div class="bio-row">
                              <p><span>Teléfono Uni.</span>: 33 3682 1180</p>
                            </div>
                          </c:if>
                          <c:if test="${usuario.getRolUsuario() == 'empresa'}">
                            <div class="bio-row">
                              <p><span>Teléfono Emp.</span>: ${usuario.getTelefonoEmpresaUsuario()}</p>
                            </div>
                          </c:if>
                          <c:if test="${usuario.getRolUsuario() == 'universidad'}">
                            <div class="bio-row">
                              <p><span>Teléfono Uni.</span>: ${usuario.getTelefonoUniversidadUsuario()}</p>
                            </div>
                          </c:if>

                          <!---->

                          <div class="bio-row">
                            <p><span>Correo </span>: ${usuario.getCorreoUsuario()}</p>
                          </div>


                          <!--Correo Institucion-->
                          <c:if test="${usuario.getRolUsuario() == 'admin'}">
                            <div class="bio-row">
                              <p><span>Correo Uni.</span>: itsdz@zapopan.tecmm.edu.mx</p>
                            </div>
                          </c:if>
                          <c:if test="${usuario.getRolUsuario() == 'empresa'}">
                            <div class="bio-row">
                              <p><span>Correo Emp.</span>: ${usuario.getCorreoEmpresaUsuario()}</p>
                            </div>
                          </c:if>
                          <c:if test="${usuario.getRolUsuario() == 'universidad'}">
                            <div class="bio-row">
                              <p><span>Correo Uni.</span>: ${usuario.getCorreoUniversidadUsuario()}</p>
                            </div>
                          </c:if>

                          <!---->

                          <c:if test="${usuario.getRolUsuario() == 'admin'}">
                            <div class="bio-row">
                              <p><span>Tipo de Usuario </span>: Administrador</p>
                            </div>
                          </c:if>
                          <c:if test="${usuario.getRolUsuario() != 'admin'}">
                            <div class="bio-row">
                              <p><span>Tipo de Usuario </span>: ${usuario.getRolUsuario()}</p>
                            </div>
                          </c:if>
                        </div>
                      </div>
                    </section>
                    <section>
                      <div class="row">
                      </div>
                    </section>
                  </div>
                  <!-- edit-profile -->
                  <div id="edit-profile" class="tab-pane">
                    <section class="panel">
                      <div class="panel-body bio-graph-info">
                        <!-- Alertas Done/Error -->
                        <c:if test="${not empty status}">
                          <c:if test="${status == 'done'}">
                            <div class="alert alert-success fade in">
                              <button data-dismiss="alert" class="close close-sm" type="button">
                                                  <i class="icon-remove"></i>
                                              </button>
                              <strong>Hecho!</strong> Se ha actualizado la contraseña.
                            </div>
                          </c:if>
                          <c:if test="${status == 'error'}">
                            <div class="alert alert-block alert-danger fade in">
                              <button data-dismiss="alert" class="close close-sm" type="button">
                                                  <i class="icon-remove"></i>
                                              </button>
                              <strong>Ups!</strong> No se pudo actualizar la contraseña.
                            </div>
                          </c:if>
                        </c:if>


                        <h1> Actualizar mi Contraseña</h1>
                        <form class="form-horizontal" role="form" action="CambiarPasswordServlet" method="POST">
                          <input type="hidden" name="idUsuario" id="idUsuario" value="${sessionUser.getIdUsuario()}">
                          <div class="form-group">
                            <label class="col-lg-2 control-label">Contraseña Actual</label>
                            <div class="col-lg-6">
                              <input type="password" class="form-control" id="oldPass" name="oldPass" required>
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="col-lg-2 control-label">Nueva Contraseña</label>
                            <div class="col-lg-6">
                              <input type="password" class="form-control" id="newPass" name="newPass" required>
                            </div>
                          </div>
                          <div class="form-group">
                            <div class="col-lg-offset-2 col-lg-10">
                              <button type="submit" class="btn btn-primary">Actualizar</button>
                            </div>
                          </div>
                        </form>
                      </div>
                    </section>
                  </div>
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
