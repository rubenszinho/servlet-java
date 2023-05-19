import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtenha os detalhes de login do usuário da solicitação
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Valide os detalhes de login (você precisará implementar este método)
        // EmployeeDao pode ser uma classe que interage com seu banco de dados
        EmployeeDao dao = new EmployeeDao();
        boolean isValid = dao.validateUser(username, password);

        if (isValid) {
            // Se os detalhes de login forem válidos, redirecione para a página de detalhes
            // do funcionário
            resp.sendRedirect("/employeeDetails");
        } else {
            // Se os detalhes de login forem inválidos, redirecione de volta para a página de login
            resp.sendRedirect("/login");
        }
    }
}
