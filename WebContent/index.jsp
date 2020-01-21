<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Comité Interuniversitario de Bolsas de Trabajo y Formación</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta content="author" name="Tecnológico Mario Molina Campus Zapopan">
  <meta name="description" content="Bolsa de Trabajo de Universidades de Jalisco">

  <!-- Favicons -->
  <link href="img/favicon.png" rel="icon">
  <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Montserrat:300,400,500,700" rel="stylesheet">

  <!-- Bootstrap CSS File -->
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Libraries CSS Files -->
  <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="lib/animate/animate.min.css" rel="stylesheet">
  <link href="lib/ionicons/css/ionicons.min.css" rel="stylesheet">
  <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">

  <!-- Main Stylesheet File -->
  <link href="css/style_home.css" rel="stylesheet">

</head>

<body>

  <header id="header" class="fixed-top">
    <div class="container">

      <div class="logo float-left">
        <!-- Uncomment below if you prefer to use an image logo -->
        <!-- <h1 class="text-light"><a href="#header"><span>NewBiz</span></a></h1> -->
        <a href="#intro" class="scrollto"><img src="img/logo.png" alt="" class="img-fluid"></a>
      </div>

      <nav class="main-nav float-right d-none d-lg-block">
        <ul>
          <li class="active"><a href="#intro">Inicio</a></li>
          <li><a href="#about">Nosotros</a></li>
          <li><a href="#services">Servicios</a></li>
          <li><a href="#why-us">¿Por qué nosotros?</a></li>
          <li><a href="#portfolio">Universidades</a></li>
          <li class="drop-down"><a href="">Sesión</a>
            <ul>
              <c:if test="${sessionUser != null}">
                <li><a href="PanelServlet"><c:out value="${sessionUser.getNombreUsuario()}"></c:out></a></li>
                <li><a href="LogoutServlet">Cerrar Sesión</a></li>
              </c:if>
              <c:if test="${sessionUser == null}">
                <li><a href="login.jsp">Iniciar Sesión</a></li>
              </c:if>
              <li><a href="nueva_empresa.jsp">Registrar Empresa</a></li>
            </ul>
          </li>
          <li><a href="#contact">Contacto</a></li>
        </ul>
      </nav><!-- .main-nav -->
      
    </div>
  </header><!-- #header -->

  <!--==========================
    Intro Section
  ============================-->
  <section id="intro" class="clearfix">
    <div class="container">

      <div class="intro-img">
        <img src="img/CIBTF-intro.png" alt="" class="img-fluid">
      </div>

      <div class="intro-info">
        <h2>¡Trabajando para un<br>Futuro Mejor!<br></h2>
        <div>
          <c:if test="${sessionUser != null}">
              <a href="PanelServlet" class="btn-get-started scrollto">Ir al Panel</a>
          </c:if>
          <c:if test="${sessionUser == null}">
                <a href="login.jsp" class="btn-get-started scrollto">Iniciar Sesión</a>
          </c:if>
          <a href="nueva_empresa.jsp" class="btn-services scrollto">Registrar Empresa</a>
        </div>
      </div>

    </div>
  </section><!-- #intro -->

  <main id="main">

    <!--==========================
      About Us Section
    ============================-->
    <section id="about">
      <div class="container">

        <header class="section-header">
          <h3>Nosotros</h3>
          <p>Nuestro objetivo es proporcionar información oportuna para la formación continua de nuestros egresados y alumnos así como difundir las oportunidades laborales para ellos.</p>
        </header>

        <div class="row about-container">

          <div class="col-lg-6 content order-lg-1 order-2">
            <p>
              El comité está integrado por instituciones de educación superior para realizar trabajos conjuntos para el fortalecimiento de sus funciones referentes a una Bolsa de Trabajo y el seguimiento de los egresados.
            </p>

            <div class="icon-box wow fadeInUp">
              <div class="icon"><i class="fa fa-handshake-o"></i></div>
              <h4 class="title"><a href="">Trabajando Juntos</a></h4>
              <p class="description">Las universidades que conforman este comité están comprometidos para promover el crecimiento del empleo ayudando a sus egresados a vincularse con las empresas afiliadas al grupo de forma eficiente</p>
            </div>

            <div class="icon-box wow fadeInUp" data-wow-delay="0.2s">
              <div class="icon"><i class="fa fa-binoculars"></i></div>
              <h4 class="title"><a href="">Encuentra a tus trabajadores</a></h4>
              <p class="description">Como empresa, una vez registrada en la plataforma, sube tus vacantes y nosotros proporcionaremos el presonal para tu equipo de trabajo que cumpla con el perfil deseado</p>
            </div>

            <div class="icon-box wow fadeInUp" data-wow-delay="0.4s">
              <div class="icon"><i class="fa fa-bar-chart"></i></div>
              <h4 class="title"><a href="">Mejora continua</a></h4>
              <p class="description">Conforme a los acuerdos, toda la información recaudada se utiliza únicamente para la mejora de la plataforma y tener una mejor estructura, así como brindar un servicio más eficaz</p>
            </div>

          </div>

          <div class="col-lg-6 background order-lg-2 order-1 wow fadeInUp">
            <img src="img/about-img.svg" class="img-fluid" alt="">
          </div>
        </div>

        <div class="row about-extra">
          <div class="col-lg-6 wow fadeInUp">
            <img src="img/about-extra-1.svg" class="img-fluid" alt="">
          </div>
          <div class="col-lg-6 wow fadeInUp pt-5 pt-lg-0">
            <h4>Antecedentes</h4>
            <p>
              El Comité Interuniversitario de Bolsas de Trabajo y Formación, está integrado por Universidades e Instituciones Educativas de Nivel Superior, en beneficio de la Comunidad Universitaria Jalisciense, desde el 26 de enero del 2012.
            </p>
            <p>
              Su finalidad es incrementar la vinculación entre las Universidades y Sector productivo en el Estado de Jalisco, detectando así las necesidades de capacitación y especialización que requiere el mercado laboral actual. Intercambiar las mejores prácticas de las Bolsas de Trabajos entre las Universidades e Instituciones Educativas de Nivel Superior, han permitido actualizar los procesos de atención y mejorar servicio a la Comunidad Universitaria. Vincular la Universidad con el Sector Productivo, es una de las principales actividades dentro del Comité Interuniversitario de Bolsas de Trabajo y Formación, la inserción de los alumnos y egresados al mundo laboral.
            </p>
          </div>
        </div>

        <div class="row about-extra">
          <div class="col-lg-6 wow fadeInUp order-1 order-lg-2">
            <img src="img/about-extra-2.svg" class="img-fluid" alt="">
          </div>

          <div class="col-lg-6 wow fadeInUp pt-4 pt-lg-0 order-2 order-lg-1">
            <h4>Estructura</h4>
            <p>
              El Comité está compuesto por diez Universidades e Instituciones tanto públicas como privadas, que están representadas por coordinadores de bolsa de trabajo o vinculación académica.
            </p>
            <p>
              A continuación, se mencionan las instituciones participantes: Centro Universitario UTEG ITESO, Instituto Tecnológico y de Estudios Superiores de Occidente ITJMMPyH, TecMM, Campus Zapopan UDG, Universidad de Guadalajara UMG, Universidad Marista de Guadalajara UNIVA, Universidad del Valle de Atemajac UAG, Universidad Autónoma de Guadalajara UP, Universidad Panamericana UVM, Universidad del Valle de México
            </p>
            <p>
              Los integrantes que conforman este orgulloso Comité, tienen la firme convicción de que solo trabajando y entendiendo las necesidades de Empresa-Gobierno, se puede brindar un mejor mañana a nuestros jóvenes universitarios Jaliscienses.
            </p>
          </div>
          
        </div>

      </div>
    </section><!-- #about -->

    <!--==========================
      Services Section
    ============================-->
    <section id="services" class="section-bg">
      <div class="container">

        <header class="section-header">
          <h3>¿Qué Brindamos?</h3>
          <p>Estamos comprometidos con el servicio que queremos brindar</p>
        </header>

        <div class="row">

          <div class="col-md-6 col-lg-5 wow bounceInUp" data-wow-delay="0.2s" data-wow-duration="1.4s">
            <div class="box">
              <div class="icon"><i class="ion-ios-clock-outline" style="color: #4680ff;"></i></div>
              <h4 class="title"><a>Tiempo</a></h4>
              <p class="description">Cada universidad está comprometida con el comité para responder lo antes posible a las empresas con el personal capaz de desempeñar el trabajo</p>
            </div>
          </div>

          <div class="col-md-6 col-lg-5 offset-lg-1 wow bounceInUp" data-wow-delay="0.2s" data-wow-duration="1.4s">
            <div class="box">
              <div class="icon"><i class="ion-ios-world-outline" style="color: #d6ff22;"></i></div>
              <h4 class="title"><a>Accesible</a></h4>
              <p class="description">Como empresa asociada al comité, tienes la oportunidad de iniciar sesión, subir tus vacantes y dependiendo del perfil que buscas, la universidad buscará al mejor candidato</p>
            </div>
          </div>

          <div class="col-md-6 col-lg-5 wow bounceInUp" data-wow-duration="1.4s">
            <div class="box">
              <div class="icon"><i class="ion-ios-bookmarks-outline" style="color: #e9bf06;"></i></div>
              <h4 class="title"><a>Egresados</a></h4>
              <p class="description">Todas las universidades asociadas cuentan con una gran cantidad de egresados y becarios competentes listos para cubrir tu vacante</p>
            </div>
          </div>

          <div class="col-md-6 col-lg-5 offset-lg-1 wow bounceInUp" data-wow-delay="0.1s" data-wow-duration="1.4s">
            <div class="box">
              <div class="icon"><i class="ion-ios-paper-outline" style="color: #3fcdc7;"></i></div>
              <h4 class="title"><a>Requisitos</a></h4>
              <p class="description">Una vez afiliado al comité podrás subir las vacantes necesitadas, solo se te pide que contestes las solicitudes y al año participes en la recaudación de datos del comité</p>
            </div>
          </div>



        </div>

      </div>
    </section><!-- #services -->

    <!--==========================
      Why Us Section
    ============================-->
    <section id="why-us" class="wow fadeIn">
      <div class="container">
        <header class="section-header">
          <h3>¿Por qué nosotros?</h3>
          <p>Nuestro comité conformado por más de veinte planteles te garantiza que contamos con los candidatos suficientes para cubrir las vacantes en todas las áreas</p>
        </header>

        <div class="row row-eq-height justify-content-center">

          <div class="col-lg-4 mb-4">
            <div class="card wow bounceInUp">
                <i class="fa fa-address-book"></i>
              <div class="card-body">
                <h5 class="card-title">Candidatos</h5>
                <p class="card-text">Cada universidad proporcionará el candidato correspondiente al área solicitada.</p>
              </div>
            </div>
          </div>

          <div class="col-lg-4 mb-4">
            <div class="card wow bounceInUp">
                <i class="fa fa-calendar"></i>
              <div class="card-body">
                <h5 class="card-title">Respuestas</h5>
                <p class="card-text">Las vacantes son propuestas por medio de la plataforma y las universidades responderán con los currículums de todos sus candidatos.</p>
              </div>
            </div>
          </div>

          <div class="col-lg-4 mb-4">
            <div class="card wow bounceInUp">
                <i class="fa fa-check"></i>
              <div class="card-body">
                <h5 class="card-title">Eficiente</h5>
                <p class="card-text">La iniciativa de esta plataforma es para fomentar el crecimiento laboral de nuestros egresados agilizando el proceso de contacto empresa/candidato.</p>
              </div>
            </div>
          </div>

        </div>

        <div class="row counters">

          <div class="col-lg-3 col-6 text-center">
            <span data-toggle="counter-up">10</span>
            <p>Universidades</p>
          </div>

          <div class="col-lg-3 col-6 text-center">
            <span data-toggle="counter-up">30</span>
            <p>Planteles</p>
          </div>

          <div class="col-lg-3 col-6 text-center">
            <span data-toggle="counter-up">166</span>
            <p>Carreras</p>
          </div>

          <div class="col-lg-3 col-6 text-center">
            <span data-toggle="counter-up">999</span>
            <p>Empresas</p>
          </div>
  
        </div>

      </div>
    </section>

    <!--==========================
      Portfolio Section
    ============================-->
    <section id="portfolio" class="clearfix">
      <div class="container">

        <header class="section-header">
          <h3 class="section-title">Universidades</h3>
        </header>

        <div class="row">
          <div class="col-lg-12">
            <ul id="portfolio-flters">
              <li data-filter="*" class="filter-active">All</li>
              <li data-filter=".filter-app">App</li>
              <li data-filter=".filter-card">Card</li>
              <li data-filter=".filter-web">Web</li>
            </ul>
          </div>
        </div>

        <div class="row portfolio-container">

          <div class="col-lg-4 col-md-6 portfolio-item filter-app">
            <div class="portfolio-wrap">
              <img src="img/portfolio/uteg.jpg" class="img-fluid" alt="">
              <div class="portfolio-info">
                <h4><a>UTEG</a></h4>
                <p>Centro Universitario</p>
                <div>
                  <a href="img/portfolio/app1.jpg" data-lightbox="portfolio" data-title="UTEG Centro Universitario" class="link-preview" title="Información"><i class="ion ion-eye"></i></a>
                  <a target="_blank" href="https://www.uteg.edu.mx/" class="link-details" title="Página Web"><i class="ion ion-android-open"></i></a>
                </div>
              </div>
            </div>
          </div>

          <div class="col-lg-4 col-md-6 portfolio-item filter-web" data-wow-delay="0.1s">
            <div class="portfolio-wrap">
              <img src="img/portfolio/uvm.jpg" class="img-fluid" alt="">
              <div class="portfolio-info">
                <h4><a>UVM</a></h4>
                <p>Laureate International Universities</p>
                <div>
                  <a href="img/portfolio/web3.jpg" class="link-preview" data-lightbox="portfolio" data-title="UVM Laureate International Universities" title="Información"><i class="ion ion-eye"></i></a>
                  <a target="_blank" href="https://uvm.mx/" class="link-details" title="Página Web"><i class="ion ion-android-open"></i></a>
                </div>
              </div>
            </div>
          </div>

          <div class="col-lg-4 col-md-6 portfolio-item filter-app" data-wow-delay="0.2s">
            <div class="portfolio-wrap">
              <img src="img/portfolio/upgdl.jpg" class="img-fluid" alt="">
              <div class="portfolio-info">
                <h4><a>Universidad Panamericana</a></h4>
                <p>Guadalajara</p>
                <div>
                  <a href="img/portfolio/app2.jpg" class="link-preview" data-lightbox="portfolio" data-title="Universidad Panamericana Guadalajara" title="Información"><i class="ion ion-eye"></i></a>
                  <a target="_blank" href="https://www.up.edu.mx/es/guadalajara" class="link-details" title="Página Web"><i class="ion ion-android-open"></i></a>
                </div>
              </div>
            </div>
          </div>

          <div class="col-lg-4 col-md-6 portfolio-item filter-card">
            <div class="portfolio-wrap">
              <img src="img/portfolio/univa.jpg" class="img-fluid" alt="">
              <div class="portfolio-info">
                <h4><a>UNIVA</a></h4>
                <p>La Universidad Católica</p>
                <div>
                  <a href="img/portfolio/card2.jpg" class="link-preview" data-lightbox="portfolio" data-title="UNIVA La Universidad Católica" title="Información"><i class="ion ion-eye"></i></a>
                  <a target="_blank" href="https://www.univa.mx/" class="link-details" title="Página Web"><i class="ion ion-android-open"></i></a>
                </div>
              </div>
            </div>
          </div>

          <div class="col-lg-4 col-md-6 portfolio-item filter-web" data-wow-delay="0.1s">
            <div class="portfolio-wrap">
              <img src="img/portfolio/udg.jpg" class="img-fluid" alt="">
              <div class="portfolio-info">
                <h4><a>UDG</a></h4>
                <p>Universidad de Guadalajara</p>
                <div>
                  <a href="img/portfolio/web2.jpg" class="link-preview" data-lightbox="portfolio" data-title="Universidad de Guadalajara" title="Información"><i class="ion ion-eye"></i></a>
                  <a target="_blank" href="http://www.udg.mx/" class="link-details" title="Página Web"><i class="ion ion-android-open"></i></a>
                </div>
              </div>
            </div>
          </div>

          <div class="col-lg-4 col-md-6 portfolio-item filter-app" data-wow-delay="0.2s">
            <div class="portfolio-wrap">
              <img src="img/portfolio/udge.jpg" class="img-fluid" alt="">
              <div class="portfolio-info">
                <h4><a>Egresados</a></h4>
                <p>Universidad de Guadalajara</p>
                <div>
                  <a href="img/portfolio/app3.jpg" class="link-preview" data-lightbox="portfolio" data-title="Universidad de Guadalajara: Egresados" title="Información"><i class="ion ion-eye"></i></a>
                  <a target="_blank" href="http://www.escolar.udg.mx/egresados" class="link-details" title="Página Web"><i class="ion ion-android-open"></i></a>
                </div>
              </div>
            </div>
          </div>

          <div class="col-lg-4 col-md-6 portfolio-item filter-card">
            <div class="portfolio-wrap">
              <img src="img/portfolio/uag.jpg" class="img-fluid" alt="">
              <div class="portfolio-info">
                <h4><a>Universidad Autónoma</a></h4>
                <p>de Guadalajara</p>
                <div>
                  <a href="img/portfolio/card1.jpg" class="link-preview" data-lightbox="portfolio" data-title="UAG Universidad Autónoma de Guadalajara" title="Información"><i class="ion ion-eye"></i></a>
                  <a target="_blank" href="http://www.uag.mx/" class="link-details" title="Página Web"><i class="ion ion-android-open"></i></a>
                </div>
              </div>
            </div>
          </div>

          <div class="col-lg-4 col-md-6 portfolio-item filter-card" data-wow-delay="0.1s">
            <div class="portfolio-wrap">
              <img src="img/portfolio/tecmm.jpg" class="img-fluid" alt="">
              <div class="portfolio-info">
                <h4><a>Instituto Tecnológico</a></h4>
                <p>Mario Molina</p>
                <div>
                  <a href="img/portfolio/card3.jpg" class="link-preview" data-lightbox="portfolio" data-title="Instituto Tecnológico José Mario Molina Pasquel y Henríquez: Campus Zapopan" title="Información"><i class="ion ion-eye"></i></a>
                  <a target="_blank" href="http://itszapopan.edu.mx/" class="link-details" title="Página Web"><i class="ion ion-android-open"></i></a>
                </div>
              </div>
            </div>
          </div>

          <div class="col-lg-4 col-md-6 portfolio-item filter-web" data-wow-delay="0.2s">
            <div class="portfolio-wrap">
              <img src="img/portfolio/marista.jpg" class="img-fluid" alt="">
              <div class="portfolio-info">
                <h4><a>Universidad Marista</a></h4>
                <p>de Guadalajara</p>
                <div>
                  <a href="img/portfolio/web1.jpg" class="link-preview" data-lightbox="portfolio" data-title="Universidad Marista de Guadalajara" title="Información"><i class="ion ion-eye"></i></a>
                  <a target="_blank" href="https://umg.edu.mx/portal/" class="link-details" title="Página Web"><i class="ion ion-android-open"></i></a>
                </div>
              </div>
            </div>
          </div>

          <div class="col-lg-4 col-md-6 portfolio-item filter-web" data-wow-delay="0.2s">
            <div class="portfolio-wrap">
              <img src="img/portfolio/iteso.jpg" class="img-fluid" alt="">
              <div class="portfolio-info">
                <h4><a>ITESO Universidad</a></h4>
                <p>Jesuita de Guadalajara</p>
                <div>
                  <a href="img/portfolio/web1.jpg" class="link-preview" data-lightbox="portfolio" data-title="ITESO Universidad Jesuita de Guadalajara" title="Información"><i class="ion ion-eye"></i></a>
                  <a target="_blank" href="https://www.iteso.mx/" class="link-details" title="Página Web"><i class="ion ion-android-open"></i></a>
                </div>
              </div>
            </div>
          </div>

        </div>

      </div>
    </section><!-- #portfolio -->

    <!--==========================
      Clients Section

    <section id="testimonials" class="section-bg">
      <div class="container">

        <header class="section-header">
          <h3>Eventos</h3>
        </header>

        <div class="row justify-content-center">
          <div class="col-lg-8">

            <div class="owl-carousel testimonials-carousel wow fadeInUp">
    
              <div class="testimonial-item">
                <img src="img/testimonial-1.jpg" class="testimonial-img" alt="">
                <h3>Nombre Universidad</h3>
                <h4>Campus Universidad</h4>
                <p>
                  Proin iaculis purus consequat sem cure digni ssim donec porttitora entum suscipit rhoncus. Accusantium quam, ultricies eget id, aliquam eget nibh et. Maecen aliquam, risus at semper.
                </p>
              </div>
    
              <div class="testimonial-item">
                <img src="img/testimonial-2.jpg" class="testimonial-img" alt="">
                <h3>Sara Wilsson</h3>
                <h4>Designer</h4>
                <p>
                  Export tempor illum tamen malis malis eram quae irure esse labore quem cillum quid cillum eram malis quorum velit fore eram velit sunt aliqua noster fugiat irure amet legam anim culpa.
                </p>
              </div>
    
              <div class="testimonial-item">
                <img src="img/testimonial-3.jpg" class="testimonial-img" alt="">
                <h3>Jena Karlis</h3>
                <h4>Store Owner</h4>
                <p>
                  Enim nisi quem export duis labore cillum quae magna enim sint quorum nulla quem veniam duis minim tempor labore quem eram duis noster aute amet eram fore quis sint minim.
                </p>
              </div>
    
              <div class="testimonial-item">
                <img src="img/testimonial-4.jpg" class="testimonial-img" alt="">
                <h3>Matt Brandon</h3>
                <h4>Freelancer</h4>
                <p>
                  Fugiat enim eram quae cillum dolore dolor amet nulla culpa multos export minim fugiat minim velit minim dolor enim duis veniam ipsum anim magna sunt elit fore quem dolore labore illum veniam.
                </p>
              </div>
    
              <div class="testimonial-item">
                <img src="img/testimonial-5.jpg" class="testimonial-img" alt="">
                <h3>John Larson</h3>
                <h4>Entrepreneur</h4>
                <p>
                  Quis quorum aliqua sint quem legam fore sunt eram irure aliqua veniam tempor noster veniam enim culpa labore duis sunt culpa nulla illum cillum fugiat legam esse veniam culpa fore nisi cillum quid.
                </p>
              </div>

            </div>

          </div>
        </div>


      </div>
    </section><!-- #testimonials -->

    <!--==========================
      Clients Section
    ============================-->
    <section id="clients">

      <div class="container">

        <div class="section-header">
          <h3>Empresas Afiliadas</h3>
        </div>

        <div class="row no-gutters clients-wrap clearfix wow fadeInUp">

          <div class="col-lg-3 col-md-4 col-xs-6">
            <div class="client-logo">
              <img src="img/clients/client-1.png" class="img-fluid" alt="">
            </div>
          </div>
          
          <div class="col-lg-3 col-md-4 col-xs-6">
            <div class="client-logo">
              <img src="img/clients/client-2.png" class="img-fluid" alt="">
            </div>
          </div>
        
          <div class="col-lg-3 col-md-4 col-xs-6">
            <div class="client-logo">
              <img src="img/clients/client-3.png" class="img-fluid" alt="">
            </div>
          </div>
          
          <div class="col-lg-3 col-md-4 col-xs-6">
            <div class="client-logo">
              <img src="img/clients/client-4.png" class="img-fluid" alt="">
            </div>
          </div>
          
          <div class="col-lg-3 col-md-4 col-xs-6">
            <div class="client-logo">
              <img src="img/clients/client-5.png" class="img-fluid" alt="">
            </div>
          </div>
        
          <div class="col-lg-3 col-md-4 col-xs-6">
            <div class="client-logo">
              <img src="img/clients/client-6.png" class="img-fluid" alt="">
            </div>
          </div>
          
          <div class="col-lg-3 col-md-4 col-xs-6">
            <div class="client-logo">
              <img src="img/clients/client-7.png" class="img-fluid" alt="">
            </div>
          </div>
          
          <div class="col-lg-3 col-md-4 col-xs-6">
            <div class="client-logo">
              <img src="img/clients/client-8.png" class="img-fluid" alt="">
            </div>
          </div>

        </div>

      </div>

    </section>

    <!--==========================
      Contact Section
    ============================-->
    <section id="contact">
      <div class="container-fluid">

        <div class="section-header">
          <h3>Contáctanos</h3>
        </div>

        <div class="row wow fadeInUp">

          <div class="col-lg-6">
            <div class="map mb-4 mb-lg-0">
              <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3732.2027616481782!2d-103.47495758460089!3d20.70198940422803!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8428a92008505ae3%3A0xac0da90d95e836af!2sTecMM%20Unidad%20Academica%20Zapopan!5e0!3m2!1ses-419!2smx!4v1578991158826!5m2!1ses-419!2smx" frameborder="0" style="border:0; width: 100%; height: 312px;" allowfullscreen></iframe>
            </div>
          </div>

          <div class="col-lg-6">
            <div class="row">
              <div class="col-md-5 info">
                <i class="ion-ios-location-outline"></i>
                <p>Camino Arenero 1101, 45019 Zapopan, Jal.</p>
              </div>
              <div class="col-md-4 info">
                <i class="ion-ios-email-outline"></i>
                <p>bolsaempleo.ad@gmail.com</p>
              </div>
              <div class="col-md-3 info">
                <i class="ion-ios-telephone-outline"></i>
                <p>+52 33 3479 2657</p>
              </div>
            </div>

            <div class="form">
              <div id="sendmessage">Tu mensaje ha sido enviado y será respondido a la brevedad, ¡Gracias!</div>
              <div id="errormessage"></div>
              <form action="" method="post" role="form" class="contactForm">
                <div class="form-row">
                  <div class="form-group col-lg-6">
                    <input type="text" name="name" class="form-control" id="name" placeholder="Tu Nombre" data-rule="minlen:4" data-msg="Por favor ingresa al menos cuatro caracteres" />
                    <div class="validation"></div>
                  </div>
                  <div class="form-group col-lg-6">
                    <input type="email" class="form-control" name="email" id="email" placeholder="Tu Correo" data-rule="email" data-msg="Por favor ingresa un correo válido" />
                    <div class="validation"></div>
                  </div>
                </div>
                <div class="form-group">
                  <input type="text" class="form-control" name="subject" id="subject" placeholder="Asunto" data-rule="minlen:4" data-msg="Ingresa al menos 8 caracteres" />
                  <div class="validation"></div>
                </div>
                <div class="form-group">
                  <textarea class="form-control" name="message" rows="5" data-rule="required" data-msg="¿Cómo podemos ayudarte?" placeholder="Mensaje"></textarea>
                  <div class="validation"></div>
                </div>
                <div class="text-center"><button type="submit" title="Send Message">Enviar Mensaje</button></div>
              </form>
            </div>
          </div>

        </div>

      </div>
    </section><!-- #contact -->

  </main>

  <!--==========================
    Footer
  ============================-->
  <footer id="footer">
    <div class="footer-top">
      <div class="container">
        <div class="row">

          <div class="col-lg-4 col-md-6 footer-info">
            <h3>CIBTF</h3>
            <p>Si eres empresa nueva y tienes dudas o para reporte de problemas en usuarios existentes, favor de enviar un mensaje en el apartado de arriba y nos contactaremos con usted lo antes posible.</p>
          </div>

          <div class="col-lg-2 col-md-6 footer-links">
            <h4>Menú</h4>
            <ul>
              <li><a href="#intro">Inicio</a></li>
              <li><a href="#about">Nosotros</a></li>
              <li><a href="#services">Servicios</a></li>
              <li><a href="#why-us">¿Por qué Nosotros?</a></li>
              <li><a href="#portfolio">Universidades</a></li>
            </ul>
          </div>

          <div class="col-lg-3 col-md-6 footer-contact">
            <h4>Contáctanos</h4>
            <p>
              Camino Arenero 1101<br>
              45019 Zapopan, Jal.<br>
              <strong>Teléfono:</strong> +52 33 3479 2657<br>
              <strong>Correo:</strong> bolsaempleo.ad@gmail.com<br>
            </p>

          </div>

          <div class="col-lg-3 col-md-6 footer-newsletter">
            <h4>Comité Interuniversitario de Bolsas de Trabajo y Formación</h4>
          </div>

        </div>
      </div>
    </div>

    <div class="container">
      <div class="copyright">
        &copy; Copyright <strong>CIBTF</strong>. All Rights Reserved
      </div>
      <div class="credits">
        <!--
          All the links in the footer should remain intact.
          You can delete the links only if you purchased the pro version.
          Licensing information: https://bootstrapmade.com/license/
          Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=NewBiz
        -->
        Designed by <a href="http://itszapopan.edu.mx/">TEC MM Zapopan</a>
      </div>
    </div>
  </footer><!-- #footer -->

  <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
  <!-- Uncomment below i you want to use a preloader -->
  <!-- <div id="preloader"></div> -->

  <!-- JavaScript Libraries -->
  <script src="lib/jquery/jquery.min.js"></script>
  <script src="lib/jquery/jquery-migrate.min.js"></script>
  <script src="lib/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="lib/easing/easing.min.js"></script>
  <script src="lib/mobile-nav/mobile-nav.js"></script>
  <script src="lib/wow/wow.min.js"></script>
  <script src="lib/waypoints/waypoints.min.js"></script>
  <script src="lib/counterup/counterup.min.js"></script>
  <script src="lib/owlcarousel/owl.carousel.min.js"></script>
  <script src="lib/isotope/isotope.pkgd.min.js"></script>
  <script src="lib/lightbox/js/lightbox.min.js"></script>
  <!-- Contact Form JavaScript File -->
  <script src="contactform/contactform.js"></script>

  <!-- Template Main Javascript File -->
  <script src="js/main.js"></script>

</body>
</html>
