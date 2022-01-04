package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetMutterListLogic;
import model.Mutter;
import model.PostMutterLogic;
import model.User;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// つぶやきリスト取得してリクエストスコープに保存
		GetMutterListLogic getMutterListLogic= new GetMutterListLogic();
		List<Mutter>mutterList= getMutterListLogic.execute();
		request.setAttribute("mutterList", mutterList);


		//ログインしているか確かめるため
		//セッションスコープからユーザー情報を取得
		HttpSession セッション = request.getSession();
		User loginUser = (User)セッション.getAttribute("loginUser");

		if(loginUser == null) {//ログインしていない場合
			//リダイレクト
			response.sendRedirect("/dokoTsubu/");
		}else {//ログイン済みの場合
			//フォワード
			RequestDispatcher ディスパッチャー = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			ディスパッチャー.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
		//request.setCharacterEncoding("UTF-8");
		String text=request.getParameter("text");

		//入力値チェック
		if(text!=null && text.length()!=0) {
			//セッションスコープに保存されたユーザー情報を取得
			HttpSession セッション= request.getSession();
			User loginUser= (User)セッション.getAttribute("loginUser");

			//つぶやきをつぶやきリストに追加
			Mutter mutter= new Mutter(loginUser.getName(),text);
			PostMutterLogic postMutterLogic= new PostMutterLogic();
			postMutterLogic.execute(mutter);

			}else {//エラーメッセージをリクエストスコープに保存
				request.setAttribute("errorMsg", "つぶやかないのかぃ？");
			}
			// つぶやきリスト取得してリクエストスコープに保存
				GetMutterListLogic getMutterListLogic= new GetMutterListLogic();
				List<Mutter>mutterList= getMutterListLogic.execute();
				request.setAttribute("mutterList", mutterList);


		//メイン画面へフォワード
		RequestDispatcher ディスパッチャー=request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		ディスパッチャー.forward(request, response);

	}

}
