<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Robinson
  Date: 27/04/2021
  Time: 4:27 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Next Level - Contact</title>
    <!--
    Next Level CSS Template
    https://templatemo.com/tm-532-next-level
    -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:400,600"/>
    <link rel="stylesheet" href="css/all.min.css"/>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/templatemo-style.css"/>
</head>
<body>
<div class="container-fluid">
    <div class="row tm-brand-row">
        <div class="col-lg-4 col-10">
            <div class="tm-brand-container">
                <div class="tm-brand-texts">
                    <%
                        String nombre = request.getParameter("user");
                        out.println("<h1 class=\"text-uppercase tm-brand-name\"> User: " + nombre + "</h1>");
                        try {
                            Cookie c1 = new Cookie("user", nombre);
                            response.addCookie(c1);
                        } catch (Exception e) {

                        }


                    %>
                </div>
            </div>
        </div>
        <div class="col-lg-8 col-2 tm-nav-col">
            <div class="tm-nav">
                <nav class="navbar navbar-expand-lg navbar-light tm-navbar">
                    <button
                            class="navbar-toggler"
                            type="button"
                            data-toggle="collapse"
                            data-target="#navbarNav"
                            aria-controls="navbarNav"
                            aria-expanded="false"
                            aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav ml-auto mr-0">
                            <li class="nav-item">
                                <div class="tm-nav-link-highlight"></div>
                                <a class="nav-link" href="index.html">Home</a>
                            </li>
                            <li class="nav-item active">
                                <div class="tm-nav-link-highlight"></div>
                                <a class="nav-link" href="#addPhoto">Add photo<span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item">
                                <div class="tm-nav-link-highlight"></div>
                                <a class="nav-link" href="#mostrarAgregar"> Information</a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
    </div>

    <div class="row tm-welcome-row">
        <div class="col-12 tm-page-cols-container">
            <div class="tm-page-col-left tm-welcome-box tm-bg-gradient">
                <p class="tm-welcome-text">
                    <e
                    >Pet Citizens es el entorno ideal para la información de tu mascota. En esta versión encontrarás una
                        opción para poder añadir una imagen y descripción de tu animal.
                    </e>
                </p>
            </div>
            <div class="tm-page-col-right">
                <div>
                    <a href="#"><img src="img/pets.jpg" class="tm-welcome-parallax" width="500" height="341"
                                     align="right"/></a>
                </div>
            </div>
        </div>
    </div>

    <section class="row tm-pt-4 tm-mb-3">
        <div class="col-12 tm-page-cols-container">
            <div class="tm-page-col-left">
                <div class="tm-contact-container tm-mb-6">
                    <div class="tm-location-container">
                        <a href="#"><img src="img/map.png" alt="Map image" class="img-fluid"/></a>
                    </div>
                </div>
            </div>
            <div class="tm-page-col-right tm-form-container">
                <h2 class="tm-text-secondary mb-4" id="addPhoto">Agrega la imagen de tu mascota</h2>
                <form action="informacion" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <input
                                type="text"
                                id="nombreMascota"
                                name="nombreMascota"
                                class="form-control rounded-0 border-top-0 border-right-0 border-left-0"
                                placeholder="Nombre de la mascota"
                                required=""/>
                    </div>
                    <div class="tm-mb-5">
                <textarea
                        rows="10"
                        id="descripcion"
                        name="descripcion"
                        class="form-control rounded-0"
                        placeholder="Descripción de la mascota"
                        required=""></textarea>
                    </div>
                    <div class="tm-mb-6 file-upload-container">
                        <input
                                id="file_name_label"
                                type="text"
                                class="border-top-0 border-right-0 border-left-0"
                                placeholder="Inserta la imagen de tu mascota"
                                disabled/>
                        <label class="btn btn-outline btn-file">
                            Browse...
                            <input
                                    type="file"
                                    name="foto"
                                    id="foto"
                                    style="display: none;"/>
                        </label>
                    </div>

                    <div class="">
                        <input type="submit" name="accion" value="Guardar"
                               class="btn btn-secondary tm-btn-submit rounded-0"><br>
                    </div>
                </form>
            </div>
        </div>
    </section>
    <input name="ver" type="button" value="Ver Informacion" id="ver" onclick="mostrarMascota()"/>
    <div >
        <table id = "table" class="table table-striped table-bordered">
            <thead>
            <tr>
                <td>Nombre</td>
                <td>Descripcion</td>
                <td>Foto</td>
            </tr>
            </thead>
            <tbody id = "crearTabla">

            </tbody>
        </table>
    </div>

</div>

<script src="js/jquery.min.js"></script>
<script src="js/parallax.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<script>
    function mostrarMascota( ) {

        var contenido = document.querySelector('#crearTabla');
        var datos = ${json};
        var datos2 = JSON.stringify(datos);
        console.log(datos2)
        var datosJson = JSON.parse(datos2);
        console.log(JSON.parse(datos2))
        contenido.innerHTML = ``
        for (var i = 0; i < datosJson.length; i++) {
            contenido.innerHTML +=`
      <tr>
      <td>${datosJson["nombre"]}</td>
      <td>${datosJson["descripcion"]}</td>
      <td>${datosJson["foto"]}</td>
      </tr>
      `
        }
    }
</script>
</body>

</html>
