package login.submit.registration;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "loginRegister", urlPatterns = {"/LoginRegister"})
public class LoginRegister extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        userDAO cd = new userDAOimpl();
        String userName=request.getParameter("username");
        String password=request.getParameter("password1");
        String submitType=request.getParameter("submit");
       // User c = new User();
        User c =cd.getUser(userName, password);
        if(submitType.equals("Login") && c!=null && c.getName()!=null){
            request.setAttribute("message",c.getName());
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        
        
        }else if(submitType.equals("register")){
            c.setName(request.getParameter("name"));
            c.setPassword(password);
            c.setUsername(userName);
            cd.insertUser(c);
            request.setAttribute("sucessMessage","Registration done, please login to continue");
            request.getRequestDispatcher("login.jsp").forward(request, response);

        
        
        }else{
            request.setAttribute("message","Data Not Found , click on Register");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        
        
        
    }

}
