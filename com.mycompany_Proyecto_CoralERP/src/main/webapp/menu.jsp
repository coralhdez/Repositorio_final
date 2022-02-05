<!--meta: para refrescar la página -->
 <meta http-equiv="refresh" content="0;url=ServletControlador">  
 <!-- <meta http-equiv="refresh" content="0;url=LoginControlador"> -->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
        <link rel="stylesheet" href="css/estilos.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/5c465338f1.js" crossorigin="anonymous"></script> 

        <title>JSP Page</title>
    </head>
    <body style="background-image: url('img/fondo.jpg');" >
        <div>
            <div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">

                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="img/banner.jpg" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="..." class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="..." class="d-block w-100" alt="...">
                    </div>
                </div>
            </div>

        </div>


        <div class="container pt-5">
            <h3 class="text-center pb-3">GESTIÓN EMPRESARIAL</h3>
            <div class="row">
                <div class="col-sm-4">
                    <div class="card">                     
                        <img class="card-img-top" src="img/empleados.png" alt="the image alt text here">
                        <div class="card-body text-center">
                            <h5 class="card-title">EMPLEADOS</h5>
                            <p class="card-text text-left">Alta empleados, información empleados... </p>
                            <a href="empleados.jsp" class="btn btn-warning">ACCEDE</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="card">
                        <img class="card-img-top" src="img/inventario.png" alt="the image alt text here">
                        <div class="card-body text-center">
                            <h5 class="card-title">INVENTARIO</h5>
                            <p class="card-text text-left">Información de inventario, cantidad de stock ... </p>
                            <a href="#" class="btn btn-warning">ACCEDE</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="card">
                        <img class="card-img-top" src="images/donut.png" alt="the image alt text here">
                        <div class="card-body text-center">
                            <h5 class="card-title text-center">Services Title 3</h5>
                            <p class="card-text text-left">Place some text for the service 3 here. </p>
                            <a href="#" class="btn btn-warning text-right">More info</a>
                        </div>
                    </div>
                </div> 
            </div>
        </div>

    </body>
</html>
