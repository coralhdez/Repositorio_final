<div class="modal fade" id="agregarEmpleadoModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-primary text-white">
                <h5 class="modal-title">Agregar Empleados</h5>
                <button class="btn-close" data-dismiss="modal">
                   <span>&times;</span>
                </button>
            </div>
            <form action="ServletControlador?accion=insertar"
                  method="POST" class="was-validated">
                <!--was-validated HACE QUE SE PONGAN LOS INPUT EN ROJO HASTA QUE SE VALIDAN-->
                <div class="modal-body">
                    <div class="form group">
                        <label for="nombre" class="form-label">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required/>
                    </div>
                    <div class="form group">
                        <label for="apellido1" class="form-label">Apellido 1</label>
                        <input type="text" class="form-control" name="apellido1" required/>
                    </div>
                    <div class="form group">
                        <label for="apellido2" class="form-label">Apellido 2</label>
                        <input type="text" class="form-control" name="apellido2" required/>
                    </div>
                    <div class="form group">
                        <label for="dni" class="form-label">DNI</label>
                        <input type="text" class="form-control" name="dni" >
                    </div>
                    <div class="form group">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" name="email" required/>
                    </div>                   
                    <div class="form group">
                        <label for="cat" class="form-label">Categoria</label>
                        <input type="number" class="form-control" name="cat"  required/>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
            </form>

        </div>
    </div>
</div>

