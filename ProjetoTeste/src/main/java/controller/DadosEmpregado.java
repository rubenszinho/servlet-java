import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employeeDetails")
public class DadosEmpregado extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Aqui, você deve obter os detalhes do usuário do banco de dados (usando o
        // EmployeeDao, por exemplo)
        // e definir os atributos de solicitação, para que você possa exibí-los na
        // página JSP
        // Como ainda não se tem um gerenciamento adequado de sessão, o
        // nome de usuário será "testUser"
        EmployeeDao dao = new EmployeeDao();
        Employee employee = dao.getEmployee("testUser");

        req.setAttribute("employee", employee);
        req.getRequestDispatcher("/WEB-INF/views/employeedetails.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Por enquanto, não é preciso fazer nada aqui
    }
}
