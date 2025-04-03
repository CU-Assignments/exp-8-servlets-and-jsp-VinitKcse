import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/AttendanceServlet")
public class AttendanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String studentName = request.getParameter("studentName");
        String date = request.getParameter("date");
        String status = request.getParameter("status");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "password");
            PreparedStatement ps = con.prepareStatement("INSERT INTO attendance (name, date, status) VALUES (?, ?, ?)");
            ps.setString(1, studentName);
            ps.setString(2, date);
            ps.setString(3, status);
            ps.executeUpdate();
            
            out.println("<h2>Attendance Recorded for " + studentName + "</h2>");
            con.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
