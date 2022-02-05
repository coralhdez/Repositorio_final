<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/5c465338f1.js" crossorigin="anonymous"></script> 
        <title>Editar Empleado</title>
    </head>
    <body>

        <jsp:include page="/WEB-INF/paginas/comunes/header.jsp" />

        <form action="ServletControlador?accion=modificar&idEmpleado=${empleado.idEmpleado}""
              method="POST" class="was-validated">
            <!--was-validated HACE QUE SE PONGAN LOS INPUT EN ROJO HASTA QUE SE VALIDAN-->
            <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacionEdicion.jsp" />


            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Empleado</h4>
                                </div>
                                <div class="card-body">
                                    <form-group>
                                        <label for="nombre">Nombre</label>
                                        <input type="text" class="form-control" name="nombre" required value="${empleado.nombre}">
                                    </form-group>

                                    <form-group>
                                        <label for="apellido1">Apellido 1</label>
                                        <input type="text" class="form-control" name="apellido1" required value="${empleado.apellido1}">
                                    </form-group>
                                    
                                    <form-group>
                                        <label for="apellido2">Apellido 2</label>
                                        <input type="text" class="form-control" name="apellido2" required value="${empleado.apellido2}">
                                    </form-group>

                                    <form-group>
                                        <label for="dni">DNI</label>
                                        <input type="text" class="form-control" name="dni" required value="${empleado.dni}">
                                    </form-group>

                                    <form-group>
                                        <label for="email">Email</label>
                                        <input type="email" class="form-control" name="email"  value="${empleado.email}">
                                    </form-group>
                                    
                                    <form-group>
                                        <label for="cat">Categoria</label>
                                        <input type="number" class="form-control" name="cat" value="${empleado.cat}">
                                    </form-group>
                                    
                                   

                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </section>   

        </form>



        <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp" />


        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>
