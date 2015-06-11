package flota_klasy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author michal.krupiarz
 */
public class KalendarzJsonServlet extends HttpServlet {

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

}


