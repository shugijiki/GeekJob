/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guest1Day
 */
public class NSF14 extends HttpServlet {

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
            HttpSession session = request.getSession(false);
            String target = request.getRequestURI();
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
            int count = 0;
            int a = 1;
            
            
            request.setCharacterEncoding("UTF-8");
            String name = request.getParameter("01name");
            String price = request.getParameter("01price");
            String num = request.getParameter("01num");
            
            
            
            out.print("<form method=\"post\" action=\"NSF14\">");
            out.print("商品名：<input type=\"text\" name=\"01name\"><br>");
            out.print("値段：<input type=\"number\" size=\"4\" name=\"01price\"><br>");
            out.print("在庫数：<input type=\"number\" size=\"4\" name=\"01num\"><br>");
            out.print("<input type=\"submit\" value=\"登録\">");
            out.print("</form><br>");
            
            out.print("<form method=\"post\" action=\"Logout\">");
            out.print("<input type=\"submit\" value=\"ログアウト\"><br><br>");
            
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con=DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","shugiziki","s19132");
                db_st = db_con.prepareStatement("select * from stock;");
                
                if(name == null){
                }else if(name.isEmpty()) {
                }else{
                    count++;
                }
                if(price == null){
                }else if(price.isEmpty()) {
                }else{
                    count++;
                }
                if(num == null){
                }else if(num.isEmpty()) {
                }else{
                    count++;
                }
                
                
                db_data = db_st.executeQuery();
                while(db_data.next()){
                    a++;
                }
                    if(count == 3){
                        int price2 =Integer.parseInt(request.getParameter("01price"));
                        int num2 = Integer.parseInt(request.getParameter("01num"));
                        String sql = "insert into stock () values('" + a + "','" + name + "','" + price2 + "','" + num2 + "')";
                        db_st.executeUpdate(sql);
                        out.print("追加されました<br>");
                    }
                out.print("商品一覧<br>");
                db_data = db_st.executeQuery();
                while(db_data.next()){
                    out.print("ID："+db_data.getString("ID")+
                            "　名前："+db_data.getString("name")+
                            "　値段："+db_data.getString("price")+
                            "　在庫："+db_data.getString("num")+"<br>");
                }
                    
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
