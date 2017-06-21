/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.test;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guest1Day
 */
public class Login2 extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
            request.setCharacterEncoding("UTF-8");
            String name = request.getParameter("01name");
            String pass = request.getParameter("01pass");
            HttpSession session=request.getSession(true);
            
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con=DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","shugiziki","s19132");
                String sql = "select * from stockuser where name = ? and pass = ?;";
                db_st = db_con.prepareStatement(sql);
                db_st.setString(1, name);
                db_st.setString(2, pass);

                db_data = db_st.executeQuery();
                String url = "";
                if (db_data.next() == true){
                    url = "NSF14";
                    }else {
                    url = "NSF13";
                    }
                out.print(name + pass);
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request,response);
                
                db_con.close();
                db_st.close();
                db_data.close();
            }catch(SQLException sqle){
                out.print("接続時にエラーが発生しました:"+sqle.toString());
            }catch(Exception e){
                out.print("接続時にエラーが発生しました:"+e.toString());
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
