/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guest1Day
 */
public class Test8 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    String main() {
        String profile2 = "";
        for (int ID =0; ID < 3;ID++){
            if(ID == 0){
                String profile[] = {"田中","1999年","4月","3日",null};
            for (int i = 0;i <5;i++){
                if(profile[i] == null){
                    continue;
                }
                profile2 =  profile2 + profile[i];
            }
            }else if(ID == 1){
                String profile[] = {"鈴木","1983年","6月","22日","青森"};
            for (int i = 0;i <5;i++){
                if(i == 0){
                    profile2 = profile2 + "<br>";
                } else if(profile[i] == null){
                    continue;
                }
                profile2 =  profile2 + profile[i];
            }
            }else{
                String profile[] = {"スティーブ","1976年","3月","8日","沖縄"};
            for (int i = 0;i <5;i++){
                if(i == 0){
                    profile2 = profile2 + "<br>";
                } else if(profile[i] == null){
                    continue;
                }
                profile2 =  profile2 + profile[i];
            }
            }
        }
        return profile2;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(main());
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
