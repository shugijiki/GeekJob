package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hayashi-s
 */
public class UpdateResult extends HttpServlet {

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
                //セッションスタート
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        try {
            request.setCharacterEncoding("UTF-8");
            //アクセスルートチェック
            String accesschk = request.getParameter("ac");
            if(accesschk ==null || (Integer)session.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }
            UserDataDTO udd = (UserDataDTO)session.getAttribute("resultData");
            
            int a=Integer.parseInt(request.getParameter("year"));
            int b=Integer.parseInt(request.getParameter("month"))-1;
            int c=Integer.parseInt(request.getParameter("day"));
            
            Calendar birthday = Calendar.getInstance();
            birthday.set(a,b,c);
            
            udd.setName(request.getParameter("name"));
            udd.setBirthday(birthday.getTime());
            udd.setType(Integer.parseInt(request.getParameter("type")));
            udd.setTell(request.getParameter("tell"));
            udd.setComment(request.getParameter("comment"));
            
            //DTOオブジェクトにマッピング。DB専用のパラメータに変換
            UserDataDTO userdata = new UserDataDTO();
            userdata.setBirthday(birthday.getTime());
            userdata.setUserID(udd.getUserID());   
            ArrayList<String> chkList = udd.chkproperties();
            udd.UD2DTOMapping(userdata); 
            if(chkList.isEmpty()){
                UserDataDAO.getInstance().update(userdata);
            }
            
            //結果画面での表示用に入力パラメータ―をリクエストパラメータとして保持
            request.setAttribute("updateData", userdata);
            
            request.getRequestDispatcher("/updateresult.jsp").forward(request, response);  
        }catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
