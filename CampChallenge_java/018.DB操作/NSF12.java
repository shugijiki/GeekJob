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
public class NSF12 extends HttpServlet {

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
            int count = 0;
            
            request.setCharacterEncoding("UTF-8");
            String name = request.getParameter("01name");
            String age = request.getParameter("01age");
            String birth1 = request.getParameter("01birth");
            String birth2 = request.getParameter("02birth");
            out.print("<form method=\"post\" action=\"\">");
            out.print("名前：<input type=\"text\" name=\"01name\"><br>");
            out.print("年齢：<input type=\"text\" size=\"3\" name=\"01age\"><br>");
            out.print("誕生日：<input type=\"text\" size=\"2\" name=\"01birth\">月");
            out.print("<input type=\"text\" size=\"2\" name=\"02birth\">日");
            out.print("<input type=\"submit\" value=\"検索\">");
            out.print("</form>");
            
            if(name == null||name.isEmpty()){
                name = null;
            }else{
            }
            if(age == null||age.isEmpty()){
                age = null;
            }else{
            }
            if(birth1 == null||birth1.isEmpty()){
                birth1 ="";
            }
            if(birth2 == null||birth2.isEmpty()){
                birth2 = "";
            }
            
                        
            
                    String sql = "select * from profiles where name like ? or age like ? or birthday like ?;";
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con=DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","shugiziki","s19132");
                db_st = db_con.prepareStatement(sql);
                db_st.setString(1, '%' +name+ '%');
                db_st.setString(2, '%' +age+ '%' );
                db_st.setString(3, '%'+"-"+birth1+"-"+ '%' + birth2 + '%' );
                
                db_data = db_st.executeQuery();
                while(db_data.next()){
                    out.print("ID："+db_data.getString("profilesID")+
                            "　名前："+db_data.getString("name")+
                            "　Tell："+db_data.getString("tell")+
                            "　年齢："+db_data.getString("age")+
                            "　生年月日："+db_data.getString("birthday")+"<br>");
                    
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
