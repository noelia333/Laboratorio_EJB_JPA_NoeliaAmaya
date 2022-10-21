/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlet;

import co.edu.unipiloto.entitys.Curso;
import co.edu.unipiloto.session.CursoFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Noelia
 */
@WebServlet(name = "CursoServlet", urlPatterns = {"/CursoServlet"})
public class CursoServlet extends HttpServlet {

    @EJB
    private CursoFacadeLocal cursoFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8"); 
        String action = request.getParameter("action");

        String idStr = request.getParameter("cursoId");
        int curid = 0;
        if (idStr != null && !idStr.equals("")) {
            curid = Integer.parseInt(idStr);
        }

        String nombreCursoStr = request.getParameter("nombreCurso");

        String numCredStr = request.getParameter("numCreditos");
        int numCre = 0;
        if (numCredStr != null && !numCredStr.equals("")) {
            numCre = Integer.parseInt(numCredStr);
        }
        
        String semStr = request.getParameter("semestre");
        int semestre = 0;
        if (semStr != null && !semStr.equals("")) {
            semestre = Integer.parseInt(semStr);
        }
        
        String estAdmStr = request.getParameter("numEstudAdm");
        int estAdm = 0;
        if (estAdmStr != null && !estAdmStr.equals("")) {
            estAdm = Integer.parseInt(estAdmStr);
        }
        // request.getParameter("action");
        Curso curso = new Curso(curid, nombreCursoStr, numCre, semestre, estAdm);
        //estudianteFacade.create(estudiante);
        if ("Add".equalsIgnoreCase(action)) {
            cursoFacade.create(curso);
        } else if ("Search".equalsIgnoreCase(action)) {
            cursoFacade.find(curid);
        } else if ("Edit".equalsIgnoreCase(action)) {
            cursoFacade.edit(curso);
        } else if ("Delete".equalsIgnoreCase(action)) {
            cursoFacade.remove(curso);
        }
        //string de conexion nos vamos a persistence.xml en data source jdbc/estudiante
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("curso", curso);
        request.setAttribute("allCursos", cursoFacade.findAll());
        request.getRequestDispatcher("cursoInfo.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
