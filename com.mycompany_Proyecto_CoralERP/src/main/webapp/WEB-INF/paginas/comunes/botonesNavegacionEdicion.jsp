<section id="actions" class="py-4 mb-4 bg-light">
    <div class="container">
        <div class="row">

            <div class="col-md-3">
                <a href="index.jsp" class="btn btn-light btn-block">
                    <i class="fas fa-arrow-left"></i> Ir a Inicio
                </a>
            </div>

            <div class="col-md-3">
                <button type="sumbit" class="btn btn-success btn-block">
                    <i class="fas fa-check"></i> Actualizar Datos
                </button>
            </div>

            <div class="col-md-3">
                <a href="ServletControlador?accion=eliminar&idEmpleado=${empleado.idEmpleado}" class="btn btn-danger btn-block">
                    <i class="fas fa-trash"></i> Eliminar Empleado
                </a>
            </div>
        </div>
    </div>
</section> 