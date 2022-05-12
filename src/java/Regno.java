import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
*
* @author Jahnavi Thondepu
*/
public class Regno extends HttpServlet {
 /**
 * Processes requests for both HTTP <code>GET</code> and 
<code>POST</code>
 * methods.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
 protected void processRequest(HttpServletRequest request, HttpServletResponse 
response)
 throws ServletException, IOException {
 response.setContentType("text/html;charset=UTF-8");
 response.setContentType("text/html;charset=UTF-8");
 
 final String JDBC_DRIVER="org.apache.derby.jdbc.ClientDriver";
 final String DB_URL="jdbc:derby://localhost:1527/student";
 final String USER="root";
 final String PASS="root";
 try (PrintWriter out = response.getWriter()) {
 String s1=request.getParameter("registration_number");
 //Dont mess with this
 try {
 Class.forName("org.apache.derby.jdbc.ClientDriver"); 
 } catch (ClassNotFoundException ex) {
 out.println("Class Not found Exception");
 }
 
 
 /* TODO output your page here. You may use following sample code. */
 try {
 Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
 Statement stmt=conn.createStatement();
 ResultSet rs = stmt.executeQuery("select * from root.student_login where registration_number='"+s1+"'");
 out.println("<!DOCTYPE html>");
 out.println("<html>");
 out.println("<head>");
 out.println("<title>Data Display</title>"); 
 out.println("</head>");
 out.println("<body>");
 out.println("<table border=1>");
 out.println("<tr>");
 out.println("<td>Name</td><td>RegistrationNo</td><td>Grade</td>");
 while(rs.next())
 {
 out.println("<tr>");
 out.println ("<td>"+rs.getString (1) + "</td><td>" + rs.getString (2)+ "</td><td>" + rs.getString (3)+"</td>");
 }
 out.println("</table>");
 out.println("</body>");
 out.println("</html>");
 } catch (SQLException ex) {
 out.println("SQL Exception");
 }
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
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 processRequest(request, response);
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
 protected void doPost(HttpServletRequest request, HttpServletResponse 
response)
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