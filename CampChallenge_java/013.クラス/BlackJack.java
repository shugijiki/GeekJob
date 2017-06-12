/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guest1Day
 */
public class BlackJack extends HttpServlet {

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
            
            Dealer dealer = new Dealer();
            User user = new User(); 
            
            dealer.setCard(dealer.deal());
            out.print("ディーラーの手札：" + dealer.myCards.get(0) + "と??<br>");
            user.setCard(dealer.deal());
            out.print("プレイヤーの手札：" + user.myCards.get(0) + "と" +  user.myCards.get(1) + "<br>");
            
            user.open();
            out.print("プレイヤーの合計は" + user.open() + "です<br>");
            
            int count =2;
            while(user.checkSum() == true){
                user.setCard(dealer.hit());
                out.print("引いたカードは" + user.myCards.get(count)+ "です<br>");
                count++;
            }
            out.print("プレイヤーの合計は" + user.open() + "です<br>");
            
            if(user.open() > 21){
            out.print("バストしました、プレイヤーの負けです");
            }else{
                count = 2;
                out.print("ディーラーの手札：" + dealer.myCards.get(0) + "と"+ dealer.myCards.get(1) +"<br>");
                while(dealer.checkSum() == true){
                      dealer.setCard(dealer.hit());
                      out.print("引いたカードは" + dealer.myCards.get(count) + "です<br>");
                      count++;
            }
            out.print("ディーラーの合計は" + dealer.open() + "です<br>");
                if(dealer.open() > 21){
                out.print("バストしました、プレイヤーの勝利です");
                }else if(dealer.open()==user.open()){
                out.print("引き分けになりました");
                }else if(dealer.open()>user.open()){
                out.print("プレイヤーの負けです");
                }else{
                out.print("プレイヤーの勝利です");
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
