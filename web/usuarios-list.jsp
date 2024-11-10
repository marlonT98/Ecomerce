
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="BusinessLogic.UsuarioBL"   %>
<%@page import="BusinessEntity.UsuarioEntity"  %>

<%
    UsuarioBL BL = new UsuarioBL(); //llamamos a la lista

    String miId = request.getParameter("id");
    String miAccion = request.getParameter("accion");

    if ("DELETE".equalsIgnoreCase(miAccion)) {

        BL.delete(miId);

    }
    
    
    //creamos los usuarios 
    if("CREATE".equalsIgnoreCase(miAccion)){
      UsuarioEntity item = new UsuarioEntity();
      item.setUsu_codigo(miId);
      item.setUsu_descri(request.getParameter("name"));
      item.setUsu_apepat(request.getParameter("name"));
      item.setUsu_login(request.getParameter("name"));
      BL.insertar(item);
    }
      
    //actualizamos
 
    if ("UPDATE".equalsIgnoreCase(miAccion)) {
      UsuarioEntity item = new UsuarioEntity();
      item.setUsu_codigo(miId);
      item.setUsu_descri(request.getParameter("name"));
      item.setUsu_apepat(request.getParameter("name"));
      item.setUsu_login(request.getParameter("name"));
      BL.actualizar(item);
    }
    
    
    
    

    List<UsuarioEntity> lista = BL.listar(); //listamos en una list de tipo usuarioEntity
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includecss.jsp" %>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de usuarios <%=miAccion%> <%=miId%> </h1>
        <a class='btn btn-outline-success' href='usuarios-edit.jsp?accion=CREATE'><i class='fa-solid fa-plus'></i>Nuevo<a/>
            <a class='btn btn-outline-primary' href='usuarios-list.jsp?accion=REFRESH'><i class='fa-solid fa-refresh'></i>Actualizar<a/>
                <button type="button" class="btn btn-outline-warning"><i class="fa-solid fa-print"></i>&nbsp Imprimir</button>

                <table class="table table-hover" >

                    <thead>

                    <th>Acciones</th>
                    <th> Codigo</th>
                    <th> Descripcion</th>

                    </thead>

                    <tbody>
                        <%  for (int x = 0; x < lista.size(); x++) {
                                UsuarioEntity item = lista.get(x);
                                out.write("<tr>");
                                
                                out.write("<td>");
                                out.write("<a class='btn btn-info' href='usuarios-edit.jsp?accion=UPDATE&id=" + item.getUsu_codigo() + "'><i class='fa-solid fa-pencil'></i><a/>");
                                out.write(" ");
                                out.write("<a class='btn btn-danger' href='usuarios-list.jsp?accion=DELETE&id=" + item.getUsu_codigo() + "'><i class='fa-solid fa-trash'></i><a/>");
                                out.write("</td>");
                                
                                out.write("<td>" + item.getUsu_codigo() + "</td>");
                                out.write("<td>" + item.getUsu_descri() + "</td>");
                                
                                out.write("</tr>");
                            }
                        %>

                    </tbody>


                </table>



                <%@include file="includejs.jsp" %>
                </body>
                </html>
