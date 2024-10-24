package com.tka.WorkWave.doa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.WorkWave.entity.Country;
import com.tka.WorkWave.entity.Employe;

@Repository
public class EmployeDoa {

	@Autowired
	SessionFactory factory;

	public String addEmploye(Employe emp) {

		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(emp);
			tx.commit();
			msg = "Employe is added successfully";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}
	
	public String updateEmploye(Employe emp, int id) {
		Session session = null;
		Transaction tx = null;

		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Employe employe = session.get(Employe.class, id);
//			employe.setName(emp.getName());
			employe.setSalary(emp.getSalary());
			employe.setStatus(emp.getStatus());

			session.merge(employe);
			tx.commit();
			msg = "Employe is Update successfully";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public String deleteEmploye(int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		Employe emp=null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			emp=session.get(Employe.class, id);
			session.remove(emp);
			tx.commit();
			msg = "Employe is Deleted successfully";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public Employe getemployebyID(int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		Employe emp=null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			emp=session.get(Employe.class, id);
			tx.commit();
			msg = "Employe is Deleted successfully";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return emp;
	}

	public List<Employe> getallEmploye() {
		Session session = null;
		Transaction tx = null;

		List<Employe> list = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hql = "from Employe";
			Query<Employe> query = session.createQuery(hql, Employe.class);
			list = query.list();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	public Employe getemployebyName(String name) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		Employe emp=null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			String hql = "from Employe where name=:myname";
			Query<Employe>query=session.createQuery(hql,Employe.class);
			query.setParameter("myname", name);
			emp=query.uniqueResult();
	
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return emp;
	}

	public Employe Login(Employe emp1) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		Employe emp=null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			String hql = "from Employe where emailid=:myemail and mobileno=:myno ";
			Query<Employe>query=session.createQuery(hql,Employe.class);
			query.setParameter("myemail", emp1.getEmailid());
			query.setParameter("myno", emp1.getMobileno());
			emp=query.uniqueResult();
	
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
			 
		}
		return emp;
	}

	public List<Employe> maxminiSalary(int max, int min) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		List<Employe>list=null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			String hql = "from Employe where salary between :mymini and :mymax";
			Query<Employe>query=session.createQuery(hql,Employe.class);
			query.setParameter("mymax", max);
			query.setParameter("mymini",min);
			list=query.list();
	
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	public List<Employe> EmployeStatus(String status) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		List<Employe> emp=null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			String hql = "from Employe where status=:mystatus ";
			Query<Employe>query=session.createQuery(hql,Employe.class);
			query.setParameter("mystatus", status);
			emp=query.list();
	
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
			 
		}
		return emp;
	}

	public String ChangeEmployeStatus(int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		Employe emp=null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			emp=session.get(Employe.class, id);
			
			if(emp.getStatus().equals("Active"))
			{
				msg = "Employe is Status change to Active to Inactive";
				emp.setStatus("Inactive");
			}
			else if(emp.getStatus().equals("Inactive"))
			{
				msg = "Employe is Status change to Inactive to Active";
				emp.setStatus("Active");
			}
			else {
				msg = "Employe is Status change to Suspend to Suspend";
				emp.setStatus("Suspend");
				
			}
			
			session.merge(emp);
			tx.commit();
			
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
		
	}

	public List<Employe> GetEmployesameCountry(int country) {
//		FROM Employee e 
//		WHERE e.country.id = :countryId
		
		Session session = null;
		Transaction tx = null;
		String msg = null;
		List<Employe> emp=null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			String hql = "FROM Employe e WHERE e.Country.cId = :countryId ";
			Query<Employe>query=session.createQuery(hql,Employe.class);
			query.setParameter("countryId", country);
			emp=query.list();
	
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
			 
		}
		return emp;
	}
	
//	get all employe of same country

}
