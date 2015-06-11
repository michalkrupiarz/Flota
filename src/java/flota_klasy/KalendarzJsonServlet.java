/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota_klasy;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author michal.krupiarz
 */
@WebServlet(name = "KalendarzJsonServlet", urlPatterns = {"/KalendarzJsonServlet"})
public class KalendarzJsonServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet KalendarzJsonServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet KalendarzJsonServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List l = new ArrayList();
        List <Wypozyczenie> listaWypozyczen = new ArrayList<Wypozyczenie>();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        
        listaWypozyczen = WypozyczenieZapytania.listaWypozyczen();
        
        KalendarzDTO c = new KalendarzDTO();
        c.setId(1);
        c.setStart("2015-05-28");
        c.setEnd("2015-05-29");
        c.setTitle("Task in Progress");

        KalendarzDTO d = new KalendarzDTO();
        d.setId(2);
        d.setStart("2015-05-26");
        d.setEnd("2015-06-28");
        d.setTitle("Task in Progress");

        l.add(c);
        l.add(d);
        
        int i = 2;
        
        for (Wypozyczenie wypozyczenie:listaWypozyczen){
            KalendarzDTO z = new KalendarzDTO();
            i=i+1;
            z.setId(i);
            
            z.setStart(df.format(wypozyczenie.getData_zlecenia()));
            z.setEnd(df.format(wypozyczenie.getData_zakonczenia_zlecenia()));
            z.setTitle(wypozyczenie.getTresc_zlecenia());
            z.setColor("lightblue");
            z.setTextColor("black");
            l.add(z);
        }
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.write(new Gson().toJson(l));
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
