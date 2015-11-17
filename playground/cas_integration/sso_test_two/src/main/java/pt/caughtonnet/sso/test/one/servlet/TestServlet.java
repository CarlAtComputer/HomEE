package pt.caughtonnet.sso.test.one.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jasig.cas.client.authentication.AttributePrincipal;

@WebServlet(urlPatterns="/test")
public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = -7388740014390625530L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter w = resp.getWriter();
		

		w.write("<html>");
		w.write("<body>");
		
		AttributePrincipal principal = (AttributePrincipal) req.getUserPrincipal();
		
		String userName = "";
		if (principal == null) {
			userName = "No principal";
		} else {
			userName = principal.getName();
		}

		w.write("<h1>It works sso test two: "+userName+"</h1>");
		w.write("<br />");
		w.write("<br />");

		Map<String, Object> attribs = principal.getAttributes();
		if (attribs.isEmpty()) {
			w.write("NO ATTRIBS<br />");
		} else {
			for (Entry<String, Object> entry : attribs.entrySet()) {
				w.write(entry.getKey() + " -> " + entry.getValue());
				w.write("<br />");
			}
		}
		
		if (req.isUserInRole("ADMINISTRATOR")) {
			w.write("ADMINISTRATOR ROLE<br />");
			
		} else {
			w.write("<strong>NOT</strong> ADMINISTRATOR<br />");
			
		}
		
		w.write("</body>");
		w.write("</html>");
	}
}
