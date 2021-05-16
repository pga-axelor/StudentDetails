package com.student.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;
import com.student.db.StudentDetails;

public class StudentDetailsServiceImpl implements StudentDetailsService {
	/*
	 * @Inject private EntityManager em;
	 */
	@Inject
	Provider<EntityManager> emp;

	@Override
	@Transactional
	public void insert(StudentDetails s) {
		try {
			EntityManager em = emp.get();
			em.persist(s);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	@Transactional
	public ArrayList<StudentDetails> fetchData(Integer usn) {

		ArrayList<StudentDetails> s = new ArrayList<>();
		try {
			EntityManager em = emp.get();
			s = (ArrayList<StudentDetails>) em
					.createQuery("select c from StudentDetails c where c.usn = :usn", StudentDetails.class)
					.setParameter("usn", usn).getResultList();
			// System.out.println(s.toString());
		} catch (Exception e) {
		}
		return s;
	}

	@Override
	@Transactional
	public void update(StudentDetails s) {
		try {
			EntityManager em = emp.get();
			/*
			 * em.
			 * createQuery("update StudentDetails set name = :name, sem = :sem, year= :year,branch=:branch where usn= :usn"
			 * ) .setParameter("usn", usn).setParameter("name", sname).setParameter("sem",
			 * sem) .setParameter("year", year).setParameter("branch",
			 * branch).executeUpdate();
			 */
			em.merge(s);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	@Transactional
	public void delete(Integer usn) throws IOException {
		EntityManager em = emp.get();
		StudentDetails s = em.find(StudentDetails.class, usn);
		// System.out.println(s.toString());
		em.remove(s);
	}

	@Override
	@Transactional
	public ArrayList<StudentDetails> show() {

		ArrayList<StudentDetails> StudentDetails = new ArrayList<>();
		try {
			EntityManager em = emp.get();
			// StudentDetails= (ArrayList<StudentDetails>)em.createNativeQuery("select s
			// from student s",StudentDetails.class).getResultList();
			StudentDetails = (ArrayList<StudentDetails>) em
					.createQuery("select s from StudentDetails s order by s.usn", StudentDetails.class).getResultList();
		} catch (Exception e) {
			System.out.println(e);
		}
		return StudentDetails;
	}

	@Override
	@Transactional
	public ArrayList<StudentDetails> search(String search, String order) {
		ArrayList<StudentDetails> StudentDetails = new ArrayList<>();
		System.out.println(order);
		try {
			if (order.equals("name")) {
				EntityManager em = emp.get();
				StudentDetails = (ArrayList<StudentDetails>) em
						.createQuery("select s from StudentDetails s where s.sname=:name", StudentDetails.class)
						.setParameter("name", search).getResultList();
				/*
				 * StudentDetails = (ArrayList<StudentDetails>) em
				 * .createQuery("select s from StudentDetails s where s.usn=:usn",
				 * StudentDetails.class) .setParameter("usn",usn).getResultList();
				 */
			} else {
				int usn = Integer.parseInt(search);
				EntityManager em = emp.get();
				StudentDetails = (ArrayList<StudentDetails>) em
						.createQuery("select s from StudentDetails s where s.usn=:usn", StudentDetails.class)
						.setParameter("usn", usn).getResultList();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return StudentDetails;
	}
}
