package next.web;

import core.db.DataBase;
import next.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.IOException;

@WebServlet("/user/update")
public class UpdateUserFormServlet extends HttpServlet{
    private static final Logger log = LoggerFactory.getLogger(UpdateUserFormServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object value = session.getAttribute("user");
        User user = (User)value;
        String userId = req.getParameter("userId");
        if( value != null && userId.equals(user.getUserId())){
            req.setAttribute("user", DataBase.findUserById(user.getUserId()));
            RequestDispatcher rd = req.getRequestDispatcher("/user/update.jsp");
            rd.forward(req, resp);
        }else{
            resp.sendRedirect("/user/list");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User updateUser = new User(req.getParameter("userId") ,req.getParameter("name") ,req.getParameter("password") ,req.getParameter("email"));

        User user = DataBase.findUserById(updateUser.getUserId());
        if( user == null ){
            throw new NullPointerException("없는 사용자 입니다.");
        }
        user.update(updateUser);

        req.setAttribute("users",  DataBase.findAll());
        resp.sendRedirect("/");
    }
}
