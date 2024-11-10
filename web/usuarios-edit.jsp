
<%@page import="BusinessEntity.UsuarioEntity"%>
<%@page import="BusinessLogic.UsuarioBL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    UsuarioBL BL = new UsuarioBL(); //llamamos a la lista
    UsuarioEntity usuario = new UsuarioEntity();

    String miId = request.getParameter("id");
    String miAccion = request.getParameter("accion");

    if ("UPDATE".equalsIgnoreCase(miAccion)) {

        usuario = BL.bucarPorId(miId); //buscar al usuario en la base de datos

    }

    if ("CREATE".equalsIgnoreCase(miAccion)) {

    //este objeto esta blanqueado
        usuario.setUsu_codigo("");
        usuario.setUsu_descri("");

    }


%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includecss.jsp" %>
        <title>JSP Page</title>
    </head>

    <body>

        <h1>Usuario</h1>

        <form method="post" action="usuarios-list.jsp" >

            <input type="hidden"  name="accion" value="<%=miAccion%>" >

            <label> codigo:</label>
            <input type="text" class="form-control" name="id" value="<%=usuario.getUsu_codigo()%>">

            <label> Name:</label>
            <input type="text" class="form-control" name="name" value="<%=usuario.getUsu_descri()%>" >

            <label> password:</label>
            <input type="text" class="form-control" name="contrasena" >

            <button type="submit" value="guardar"   class='btn btn-primary'>
                <i class='fa-solid fa-save'></i> Guardar
            </button>
            <button type="reset" value="limpiar" class='btn btn-danger'>
                <i class="fa-regular fa-circle-check"></i>Limpiar
            </button>
        </form>

        <%@include file="includejs.jsp" %>
    </body>
</html>
