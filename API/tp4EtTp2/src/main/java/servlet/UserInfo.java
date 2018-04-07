package servlet;
import java.io.IOException;



import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoPerson;
import domain.Person;
@WebServlet(name="userinfo",
urlPatterns={"/UserInfo"})
public class UserInfo extends HttpServlet {
	@Override
public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
     throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String nom= request.getParameter("name");
    String prenom= request.getParameter("firstname");
    long age=(long)Long.parseLong(request.getParameter("age"));
    List<Person> pers= new ArrayList<Person>();
    Person personne =new Person(nom,prenom,age);
    
    DaoPerson dao= new DaoPerson();
    dao.createPerson(personne);
    pers=dao.getPersons();
    
		
    out.println("<HTML>\n<BODY>\n" +
                "<H1>Recapitulatif des informations</H1>\n" +
                "<UL>\n" +            
        " <LI>Nom: "
                + nom+ "\n" +
                " <LI>Prenom: "
                + prenom + "\n" +
                " <LI>Age: "
                + age + "\n" +
                " <LI>List: "+
                pers+"\n"+
                "</UL>\n" +                
        "</BODY></HTML>");
    
   }
}

