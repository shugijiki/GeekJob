
package jums;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hayashi-s
 */
public class SearchResult extends HttpServlet {

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
        try{
            request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更
            HttpSession session = request.getSession(); // セッション取得
            ArrayList<UserDataDTO> resultData = new ArrayList<UserDataDTO>(); // 検索結果一覧を格納するリスト
            UserDataBeans udb = new UserDataBeans(); // 検索条件格納用Beans
            //アクセスルートチェック(ブラウザバック等でsession内部のacがnullの場合にも対応)
            String accesschk = request.getParameter("ac");
            if(accesschk ==null || (Integer)session.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }
            
            if(session.getAttribute("searchUDB") != null && request.getParameter("previous") == null){
                udb = (UserDataBeans)session.getAttribute("searchUDB"); // 初回でなく、サーチからでなければセッションに入っている検索条件を入れる
            }else{
                //フォームからの入力を取得して、JavaBeansに格納
                udb.setName(request.getParameter("name"));
                udb.setYear(request.getParameter("year"));
                udb.setType(request.getParameter("type"));
                session.setAttribute("searchUDB",udb); // updateなどから戻ってきたときのためにUserDataBeansを格納
            }

            //DTOオブジェクトにマッピング。DB専用のパラメータに変換
            UserDataDTO searchData = new UserDataDTO();
            udb.UD2DTOMapping(searchData);
            resultData = UserDataDAO.getInstance().search(searchData);
            session.setAttribute("resultData", resultData);
            
            request.getRequestDispatcher("/searchresult.jsp").forward(request, response);  
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