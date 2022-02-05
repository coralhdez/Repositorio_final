<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!--para que salga en formato moneda-->
<fmt:setLocale value="es_ES"/>
<!--para que salga en formato moneda EURO-->

<section id="empleados">
    <div class="container">
        <div class="row">
            <div class="col-12 col-md-9">
                <div class="card-header bg-dark">
                    <h4 class="text-center text-white">Listado Empleados</h4>
                </div>

                <table class="table table-striped table-hover table-secondary">
                    <thead class="thead-dark">
                        <tr>
                            <th><i class="far fa-user-circle"></i></th>
                            <th>id</th>
                            <th>Nombre, Apellidos</th>
                            <th>Dni</th>
                            <th>Email</th>                          
                            <th></th><!-- btn editar -->
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="empleado" items="${empleados}" varStatus="status" >
                            <tr>
                                <td><i class="fas fa-user-check"></i></td><!-- contar el número de filas -->
                                <td>${empleado.idEmpleado}</td><!-- id -->
                                <td>${empleado.nombre} ${empleado.apellido1} ${empleado.apellido2}</td><!-- nombre y apellido -->
                                <td>${empleado.dni}</td>
                                <td>${empleado.email}</td>
                                
                                <td>
                                    <a href="ServletControlador?accion=editar&idEmpleado=${empleado.idEmpleado}" class="btn btn-danger">
                                        <i class="fas fa-angle-double-right"></i> Editar
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

        
                <div class="card text-center bg-dark text-white mb-3">
                    <div class="card-body">
                        <h3>Total Empleados</h3>
                        <h4 class="display-4">
                            <i class="fas fa-users"></i>${totalEmpleados}
                        </h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!--Agregamos el modal de agregar empleado-->
<jsp:include page="/WEB-INF/paginas/empleados/agregarEmpleado.jsp"/>


