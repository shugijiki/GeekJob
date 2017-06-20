/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.test;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guest1Day
 */
public class NSF11 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
            
            request.setCharacterEncoding("UTF-8");
            String ID = request.getParameter("01ID");
            String name = request.getParameter("01name");
            String tell = request.getParameter("01tell");
            String age = request.getParameter("01age");
            String birth1 = request.getParameter("01birth");
            String birth2 = request.getParameter("02birth");
            String birth3 = request.getParameter("03birth");
            int a = 1;
            out.print("<form method=\"post\" action=\"\">");
            out.print("更新するID：<input type=\"text\" name=\"01ID\" size=\"3\"><br><br>");
            out.print("名前：<input type=\"text\" name=\"01name\"><br>");
            out.print("Tell：<input type=\"text\" name=\"01tell\"><br>");
            out.print("年齢：<input type=\"text\" size=\"3\" name=\"01age\"><br>");
            out.print("生年月日：<input type=\"text\" size=\"4\" name=\"01birth\">年");
            out.print("<select name=\"02birth\">"
                    + "<option value=\"01\">01</option>"
                    + "<option value=\"02\">02</option>"
                    + "<option value=\"03\">03</option>"
                    + "<option value=\"04\">04</option>"
                    + "<option value=\"05\">05</option>"
                    + "<option value=\"06\">06</option>"
                    + "<option value=\"07\">07</option>"
                    + "<option value=\"08\">08</option>"
                    + "<option value=\"09\">09</option>"
                    + "<option value=\"10\">10</option>"
                    + "<option value=\"11\">11</option>"
                    + "<option value=\"12\">12</option>"
                    +"</select>月");
            out.print("<select name=\"03birth\">"
                    + "<option value=\"01\">01</option>"
                    + "<option value=\"02\">02</option>"
                    + "<option value=\"03\">03</option>"
                    + "<option value=\"04\">04</option>"
                    + "<option value=\"05\">05</option>"
                    + "<option value=\"06\">06</option>"
                    + "<option value=\"07\">07</option>"
                    + "<option value=\"08\">08</option>"
                    + "<option value=\"09\">09</option>"
                    + "<option value=\"10\">10</option>"
                    + "<option value=\"11\">11</option>"
                    + "<option value=\"12\">12</option>"
                    + "<option value=\"13\">13</option>"
                    + "<option value=\"14\">14</option>"
                    + "<option value=\"15\">15</option>"
                    + "<option value=\"16\">16</option>"
                    + "<option value=\"17\">17</option>"
                    + "<option value=\"18\">18</option>"
                    + "<option value=\"19\">19</option>"
                    + "<option value=\"20\">20</option>"
                    + "<option value=\"21\">21</option>"
                    + "<option value=\"22\">22</option>"
                    + "<option value=\"23\">23</option>"
                    + "<option value=\"24\">24</option>"
                    + "<option value=\"25\">25</option>"
                    + "<option value=\"26\">26</option>"
                    + "<option value=\"27\">27</option>"
                    + "<option value=\"28\">28</option>"
                    + "<option value=\"29\">29</option>"
                    + "<option value=\"30\">30</option>"
                    + "<option value=\"31\">31</option>"
                    + "</select>日<br>");
            out.print("<input type=\"submit\" value=\"更新\">");
            out.print("</form>");
            
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con=DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","shugiziki","s19132");
                db_st = db_con.prepareStatement("select * from profiles;");
                if(ID == null){
                }else if(ID.isEmpty()) {
                }else{
                    if(name == null){
                    }else if(name.isEmpty()) {
                    }else{
                        String sql = "update profiles set name ='"+name+"' where profilesID = '"+ ID +"';";
                        db_st.executeUpdate(sql);
                    }
                    if(tell == null){
                    }else if(tell.isEmpty()) {
                    }else{
                        String sql = "update profiles set tell ='"+tell+"' where profilesID = '"+ ID +"';";
                        db_st.executeUpdate(sql);
                    }
                    if(age == null){
                    }else if(age.isEmpty()) {
                    }else{
                        String sql = "update profiles set age ='"+age+"' where profilesID = '"+ ID +"';";
                        db_st.executeUpdate(sql);
                    }
                    if(birth1 == null){
                    }else if(birth1.isEmpty()) {
                    }else{
                        int x = Integer.parseInt(birth1);
                        int y = Integer.parseInt(birth2);
                        int z = Integer.parseInt(birth3);
                        Calendar c = Calendar.getInstance();
                        c.set(x, y, z, 10, 0, 0);
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String sql = "update profiles set birthday ='"+sdf.format(c.getTime())+"' where profilesID = '"+ ID +"';";
                        db_st.executeUpdate(sql);
                    }
                }
                    
                db_data = db_st.executeQuery();
                db_con.close();
                db_st.close();
                db_data.close();
            }catch(SQLException sqle){
                out.println("接続時にエラーが発生しました:"+sqle.toString());
            }catch(Exception e){
                out.println("接続時にエラーが発生しました:"+e.toString());
            }finally{
                if(db_con!=null){
                    try{
                        db_con.close();
                    }catch(Exception e_con){
                        System.out.println(e_con.getMessage());
                    }
                }
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
