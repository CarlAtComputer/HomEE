package pt.caughtonnet.sso.test.one.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/test")
public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = -7388740014390625530L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter w = resp.getWriter();
		w.write("<html>");
		w.write("<body>");
		w.write("<h1>It works sso test one</h1>");
		w.write("</body>");
		w.write("</html>");
		w.close();
	}
}
