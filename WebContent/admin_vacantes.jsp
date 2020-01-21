<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${sessionUser == null}"> 
	<c:redirect url="errorLogin.jsp"/>
</c:if>
<c:if test="${sessionUser.getRolUsuario() != 'empresa' && sessionUser.getRolUsuario() != 'admin'}">
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

  <title>CIBTF | Administrar Vacantes</title>

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
            <h3 class="page-header"><i class="icon_pencil-edit"></i> Vacantes</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i><a href="index.jsp">Inicio</a></li>
              <li><i class="fa fa-book"></i>Vacantes</li>
              <li><i class="fa fa-table"></i>Administrar</li>
          </div>
        </div>
        <!-- page start-->
        
        <div class="row">
          <div class="col-lg-12">
            <section class="panel">
              <header class="panel-heading">
                Administrar Vacantes
              </header>

              <div class="table-responsive" style="overflow-x:auto;" >
                <table class="table table-striped table-advance table-hover" >
                  <thead>
                      <c:if test="${sessionUser.getRolUsuario() == 'admin'}">
                        <th><i class="icon_profile"></i> Nombre</th>
                        <th><i class="icon_building"></i> Empresa</th>
                        <th><i class="icon_mail_alt"></i> Correo de Empresa</th>
                        <th><i class="icon_phone"></i> Teléfono</th>
                      </c:if>
                      <th><i class="icon_book"></i> Vacante</th>
                      <th><i class="icon_pencil"></i> Función</th>
                      <th><i class="icon_pencil"></i> Plazas</th>
                      <th><i class="icon_calendar"></i> Días Laborales</th>
                      <th><i class="icon_calendar"></i> Horarios</th>
                      <th><i class="icon_wallet"></i> Sueldo</th>
                      <th><i class="icon_download"></i> Descargar</th>
                      <th><i class="icon_check"></i> Status</th>
                      <c:if test="${sessionUser.getRolUsuario() == 'admin'}">
                        <th><i class="icon_tools"></i> Acción</th>
                      </c:if>
                  </thead>
                  <tbody>
                    <c:forEach items="${adminVacantes}" var="vacante">
                      <tr>
                        <c:if test="${sessionUser.getRolUsuario() == 'admin'}">
                          <td>${vacante.getNombreUsuario()}</td>
                          <td>${vacante.getNombreEmpresa()}</td>
                          <td>${vacante.getCorreoEmpresa()}</td>
                          <td>${vacante.getTelefonoEmpresa()}</td>
                        </c:if>
                        <td>${vacante.getNombreVacante()}</td>
                        <td>${vacante.getFuncionVacante()}</td>
                        <td>${vacante.getPlazasVacante()}</td>
                        <td>${vacante.getDiasLaboralesVacante()}</td>
                        <td>${vacante.getHorariosVacante()}</td>
                        <td>${vacante.getSueldoVacante()}</td>
                        <td><a href="GetPdfServlet?idVacante=${vacante.getIdVacante()}"><i class="icon_download"></i></a></td>
                        <td>
                          <c:if test="${vacante.getStatusVacante() == 0}">Sin Publicar</c:if>
                          <c:if test="${vacante.getStatusVacante() == 1}">Publicado</c:if>
                        </td>
                        <c:if test="${sessionUser.getRolUsuario() == 'admin'}">
                          <td>
                            <div class="btn-group">
                              <c:if test="${vacante.getStatusVacante() == 0}">
                                <a class="btn btn-danger" href="CambiarStatusVacanteServlet?idVacante=${vacante.getIdVacante()}&statusVacante=${vacante.getStatusVacante()}"><i class="icon_close_alt2"></i></a>
                              </c:if>
                              <c:if test="${vacante.getStatusVacante() == 1}">
                                <a class="btn btn-success" href="CambiarStatusVacanteServlet?idVacante=${vacante.getIdVacante()}&statusVacante=${vacante.getStatusVacante()}"><i class="icon_check_alt2"></i></a>
                              </c:if>
                            </div>
                          </td>
                        </c:if>
                      </tr>
                    </c:forEach>
  
                  </tbody>
                </table>
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
