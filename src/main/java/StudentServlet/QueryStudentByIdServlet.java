package StudentServlet;

import StudentService.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "QueryStudentByIdServlet",urlPatterns = "/QueryStudentByIdServlet")
public class QueryStudentByIdServlet extends HttpServlet {
    private StudentService studentService;

    @Override
    public void init() throws ServletException {
        ApplicationContext context=WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
//        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        studentService=(StudentService) context.getBean("studentService");
    }


    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String name = studentService.queryStudentById();
            request.setAttribute("name",name);
            request.getRequestDispatcher("result.jsp").forward(request,response);
    }
}
