package edu.uga.mist5740.controller.json;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import edu.uga.mist5740.model.Instructor;
import edu.uga.mist5740.model.InstructorManager;

/**
 * Servlet implementation class InstructorServlet
 */
@WebServlet(description = "Returns information about the educator who is signed in", urlPatterns = { "/InstructorServlet", "/Instructor" })
public class InstructorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InstructorServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try{
	        ArrayList<Instructor> instructors = InstructorManager.getEducators();
	        
	        ObjectMapper om = new ObjectMapper();
	        ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
	        
	        String json = ow.writeValueAsString(instructors);
	        
	        response.setCharacterEncoding("UTF-8");
	        response.setContentType("application/json");
	        response.getWriter().write(json);
	    }catch(Exception e){
	        response.sendError(400);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
