package com.student.resource;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

import org.hibernate.cfg.annotations.SetBinder;

import com.student.db.StudentDetails;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.student.service.*;

@Singleton
@Path("StudentDetails")
public class StudentDetailsResource {

	@Inject
	StudentDetailsService StudentDetailsService;

	@POST
	@Path("/insert")
	public void insert(@Context HttpServletRequest request, @Context HttpServletResponse response)
			throws IOException, ServletException {
		StudentDetails s = new StudentDetails();
		s.setUsn(Integer.parseInt(request.getParameter("usn")));
		s.setSname(request.getParameter("name"));
		s.setSem(Integer.parseInt(request.getParameter("sem")));
		s.setYear(Integer.parseInt(request.getParameter("year")));
		s.setBranch(request.getParameter("branch"));
		/*
		 * System.out.println(Integer.parseInt(request.getParameter("usn"))+" "+request.
		 * getParameter("name")+" "+Integer.parseInt(request.getParameter("sem"))+" "
		 * +Integer.parseInt(request.getParameter("year"))+" "
		 * +request.getParameter("branch"));
		 */
		StudentDetailsService.insert(s);
		response.sendRedirect("show");
	}

	@Path("/in")
	public void in(@Context HttpServletRequest request, @Context HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher("../InsertStudentDetails.jsp").forward(request, response);
	}

	@POST
	@Path("/search")
	public void search(@Context HttpServletRequest request, @Context HttpServletResponse response)
			throws IOException, ServletException {

		String findusn = request.getParameter("findusn");
		String order= request.getParameter("opt");
		request.setAttribute("allStudentDetails", StudentDetailsService.search(findusn,order));
		request.getRequestDispatcher("../SearchStudentDetails.jsp").forward(request, response);
	}

	@GET
	@Path("/show")
	public void show(@Context HttpServletRequest request, @Context HttpServletResponse response)
			throws IOException, ServletException {

		request.setAttribute("allStudentDetails", StudentDetailsService.show());
		request.getRequestDispatcher("../home.jsp").forward(request, response);
	}

	@GET
	@Path("/delete/{usn}")
	public void delete(@PathParam("usn") Integer usn, @Context HttpServletRequest request,
			@Context HttpServletResponse response) throws IOException, ServletException {

		StudentDetailsService.delete(usn);
		response.sendRedirect("../show");
	}

	@GET
	@Path("/fetch/{usn}")
	public void fetchdata(@PathParam("usn") Integer usn, @Context HttpServletRequest request,
			@Context HttpServletResponse response) throws IOException, ServletException {
		// System.out.println(StudentDetailsService.fetchData(usn).get(0).getUsn()+"
		// "+StudentDetailsService.fetchData(usn).get(0).getSname()+"
		// "+StudentDetailsService.fetchData(usn).get(0).getSem());
		request.setAttribute("usn", StudentDetailsService.fetchData(usn).get(0).getUsn());
		request.setAttribute("name", StudentDetailsService.fetchData(usn).get(0).getSname());
		request.setAttribute("sem", StudentDetailsService.fetchData(usn).get(0).getSem());
		request.setAttribute("year", StudentDetailsService.fetchData(usn).get(0).getYear());
		request.setAttribute("branch", StudentDetailsService.fetchData(usn).get(0).getBranch());
		request.getRequestDispatcher("../../UpdateStudentDetails.jsp").forward(request, response);
	}

	@POST
	@Path("/update/{usn}")
	public void update(@PathParam("usn") Integer usn, @Context HttpServletRequest request,
			@Context HttpServletResponse response) throws IOException, ServletException {
		StudentDetails s = new StudentDetails();
		s.setUsn(usn);
		s.setSname(request.getParameter("name_u"));
		s.setSem(Integer.parseInt(request.getParameter("sem_u")));
		s.setYear(Integer.parseInt(request.getParameter("year_u")));
		s.setBranch(request.getParameter("branch_u"));
		/*String name = request.getParameter("name_u");
		Integer sem = Integer.parseInt(request.getParameter("sem_u"));
		Integer year = Integer.parseInt(request.getParameter("year_u"));
		String branch = request.getParameter("branch_u");*/
        //System.out.println("data:"+name+" "+sem+" "+year+" "+branch);
		//StudentDetailsService.update(usn,name,sem,year,branch);
		StudentDetailsService.update(s);
		response.sendRedirect("../show");
	}
}