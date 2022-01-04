package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String name= request.getParameter("name");
		String pass= request.getParameter("pass");

		//Userインスタンス（ユーザー情報）の生成
		User user= new User(name, pass);

		//ログイン処理
		LoginLogic ログイン= new LoginLogic();
		boolean isLogin= ログイン.execute(user);

		//ログイン成功時の処理
		if(isLogin) {
			//ユーザー情報をセッションスコープに保存
			HttpSession セッション= request.getSession();
			セッション.setAttribute("loginUser", user);
		}
		//ログイン結果画面にフォワード
		RequestDispatcher ディスパッチャー= request.getRequestDispatcher("/WEB-INF/jsp/loginResult.jsp");
		ディスパッチャー.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
