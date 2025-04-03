import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String empId = request.getParameter("empId");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "password");
            String query = "SELECT * FROM employees WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, empId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                out.println("<h2>Employee Details:</h2>");
                out.println("ID: " + rs.getInt("id") + "<br>");
                out.println("Name: " + rs.getString("name") + "<br>");
                out.println("Department: " + rs.getString("department") + "<br>");
            } else {
                out.println("<h2>No Employee Found</h2>");
            }

            con.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
