<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${sessionUser == null}"> 
	<c:redirect url="errorLogin.jsp"/>
</c:if>
<c:if test="${sessionUser.getRolUsuario() != 'empresa'}">
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

  <title>CIBTF | Nueva Vacante</title>

  <!--Bootstrap Select-->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/css/bootstrap-select.min.css">
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
              <li><i class="fa fa-pencil"></i>Nueva</li>
          </div>
        </div>
        <!-- page start-->
                <!-- Form validations -->
                <div class="row">
                  <div class="col-lg-12">
                    <section class="panel">
                      <header class="panel-heading">
                        Nueva Vacante

                        <!-- Alertas Done/Error -->
                        <c:if test="${not empty status}">
                          <c:if test="${status == 'done'}">
                            <div class="alert alert-success fade in">
                              <button data-dismiss="alert" class="close close-sm" type="button">
                                                  <i class="icon-remove"></i>
                                              </button>
                              <strong>Hecho!</strong> La vacante se ha subido correctamente, se te notificará por correo cuando tu vacante sea aprobada.
                            </div>
                          </c:if>
                          <c:if test="${status == 'error'}">
                            <div class="alert alert-block alert-danger fade in">
                              <button data-dismiss="alert" class="close close-sm" type="button">
                                                  <i class="icon-remove"></i>
                                              </button>
                              <strong>Ups!</strong> La no vacante pudo ser registrada, por favor revisa los datos.
                            </div>
                          </c:if>
                        </c:if>


                      </header>
                      <div class="panel-body">
                        <div class="alert alert-info fade in">
                          <button data-dismiss="alert" class="close close-sm" type="button">
                                              <i class="icon-remove"></i>
                                          </button>
                          <strong>¡Nota!</strong> Todos los campos son cuadros de texto libre y no son necesariamente obligatorios.
                        </div>
                        <div class="form">
                          <form class="form-validate form-horizontal" id="feedback_form" method="POST" action="RegistrarVacanteServlet">
                            
                            <input type="hidden" id="idUsuario" name="idUsuario" value="${sessionUser.getIdUsuario()}">
                            <input type="hidden" id="statusVacante" name="statusVacante" value="0">

                            <div class="form-group ">
                              <label for="nombreVacante" class="control-label col-lg-2">Nombre de la Vacante <span class="required">*</span></label>
                              <div class="col-lg-10">
                                <input class="form-control" id="nombreVacante" name="nombreVacante" minlength="5" type="text" required />
                              </div>
                            </div>

                            <div class="form-group ">
                              <label for="funcionVacante" class="control-label col-lg-2">Función que Desempeña <span class="required">*</span></label>
                              <div class="col-lg-10">
                                <input class="form-control" id="funcionVacante" name="funcionVacante" minlength="5" type="text" required />
                              </div>
                            </div>

                            <div class="form-group ">
                              <label for="descripcionVacante" class="control-label col-lg-2">Descripción <span class="required">*</span></label>
                              <div class="col-lg-10">
                                <textarea class="form-control " id="descripcionVacante" name="descripcionVacante" rows="5" required></textarea>
                              </div>
                            </div>

                            <div class="form-group ">
                              <label for="plazasVacante" class="control-label col-lg-2">Plazas Disponibles <span class="required">*</span></label>
                              <div class="col-lg-10">
                                <input class="form-control" id="plazasVacante" name="plazasVacante" type="text" required />
                              </div>
                            </div>

                            <div class="form-group ">
                              <label for="habilidadesVacante" class="control-label col-lg-2">Habilidades Necesarias</label>
                              <div class="col-lg-10">
                                <textarea class="form-control" id="habilidadesVacante" name="habilidadesVacante" rows="3" type="text"></textarea>
                              </div>
                            </div>

                            <div class="form-group ">
                              <label for="experienciaVacante" class="control-label col-lg-2">Experiencia</label>
                              <div class="col-lg-10">
                                <input class="form-control" id="experienciaVacante" name="experienciaVacante" type="text"/>
                              </div>
                            </div>

                            <div class="form-group ">
                              <label for="escolaridadVacante" class="control-label col-lg-2">Escolaridad</label>
                              <div class="col-lg-10">
                                <input class="form-control" id="escolaridadVacante" name="escolaridadVacante" type="text"/>
                              </div>
                            </div>

                            <div class="form-group ">
                              <label for="conocimientosVacante" class="control-label col-lg-2">Conocimientos</label>
                              <div class="col-lg-10">
                                <textarea class="form-control" id="conocimientosVacante" name="conocimientosVacante" rows="3" type="text"></textarea>
                              </div>
                            </div>

                            <div class="form-group">
                              <label for="listaCarrerasVacantes" class="control-label col-lg-2">Carreas de Interés<span class="required">*</span></label>
                              <div class="col-lg-10">
                                <select class="selectpicker show-tick form-control" title="Ninguna Seleccionada" multiple data-live-search="true" data-style="btn-info" id="listaCarrerasVacantes" name="listaCarrerasVacantes" required>
                                  <c:forEach items="${listaCarreras}" var="carrera">
                                    <option value="${carrera.getIdCarrera()}">${carrera.getNombreCarrera()}</option>
                                  </c:forEach>
                                </select>
                                <span class="help-block">Selecciona todas las carreras que correspondan a tu vacante. Puedes ayudarte del buscador.</span>
                              </div>
                            </div>

                            <div class="form-group ">
                              <label for="diasLaboralesVacante" class="control-label col-lg-2">Días Laborales</label>
                              <div class="col-lg-10">
                                <textarea class="form-control" id="diasLaboralesVacante" name="diasLaboralesVacante" rows="3" type="text"></textarea>
                              </div>
                            </div>

                            <div class="form-group ">
                              <label for="idiomasVacante" class="control-label col-lg-2">Idiomas</label>
                              <div class="col-lg-10">
                                <input class="form-control" id="idiomasVacante" name="idiomasVacante" type="text"/>
                              </div>
                            </div>

                            <div class="form-group ">
                              <label for="edadesVacante" class="control-label col-lg-2">Rango de Edades</label>
                              <div class="col-lg-10">
                                <textarea class="form-control" id="edadesVacante" name="edadesVacante" rows="2" type="text"></textarea>
                              </div>
                            </div>

                            <div class="form-group ">
                              <label for="sexoVacante" class="control-label col-lg-2">Sexo <span class="required">*</span></label>
                              <div class="col-lg-10">
                                <select class="form-control m-bot15" id="sexoVacante" name="sexoVacante">
                                  <option value="hombre">Hombre</option>
                                  <option value="mujer">Mujer</option>
                                  <option value="indistinto" selected>Indistinto</option>
                              </select>
                              </div>
                            </div>

                            <div class="form-group ">
                              <label for="sueldoVacante" class="control-label col-lg-2">Sueldo</label>
                              <div class="col-lg-10">
                                <textarea class="form-control" id="sueldoVacante" name="sueldoVacante" rows="2" type="text"></textarea>
                              </div>
                            </div>

                            <div class="form-group ">
                              <label for="prestacionesVacante" class="control-label col-lg-2">Prestaciones</label>
                              <div class="col-lg-10">
                                <textarea class="form-control" id="prestacionesVacante" name="prestacionesVacante" rows="4" type="text"></textarea>
                              </div>
                            </div>

                            <div class="form-group ">
                              <label for="comisionesVacante" class="control-label col-lg-2">Comisiones</label>
                              <div class="col-lg-10">
                                <textarea class="form-control" id="comisionesVacante" name="comisionesVacante" rows="2" type="text"></textarea>
                              </div>
                            </div>

                            <div class="form-group ">
                              <label for="dispViajeVacante" class="control-label col-lg-2">Disponibilidad de Viaje <span class="required">*</span></label>
                              <div class="col-lg-10">
                                <select class="form-control m-bot15" id="dispViajeVacante" name="dispViajeVacante">
                                  <option value="no">No</option>
                                  <option value="si">Si</option>
                              </select>
                              </div>
                            </div>

                            <div class="form-group ">
                              <label for="turnosVacante" class="control-label col-lg-2">Turno(s)</label>
                              <div class="col-lg-10">
                                <input class="form-control" id="turnosVacante" name="turnosVacante" type="text"/>
                              </div>
                            </div>

                            <div class="form-group ">
                              <label for="horariosVacante" class="control-label col-lg-2">Horario(s)</label>
                              <div class="col-lg-10">
                                <textarea class="form-control" id="horariosVacante" name="horariosVacante" rows="3" type="text"></textarea>
                              </div>
                            </div>

                            <div class="form-group ">
                              <label for="estadoCivilVacante" class="control-label col-lg-2">Estado Civil <span class="required">*</span></label>
                              <div class="col-lg-10">
                                <select class="form-control m-bot15" id="estadoCivilVacante" name="estadoCivilVacante">
                                  <option value="indiferente">Indiferente</option>
                                  <option value="soltero">Soltero/a</option>
                                  <option value="casado">Casado/a</option>
                              </select>
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
  <!--Bootstrap Select-->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/js/bootstrap-select.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/js/i18n/defaults-*.min.js"></script>

</body>

</html>
