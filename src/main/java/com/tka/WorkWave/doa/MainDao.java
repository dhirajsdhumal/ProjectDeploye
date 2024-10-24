package com.tka.WorkWave.doa;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.WorkWave.entity.Country;

@Repository
public class MainDao {

	@Autowired
	SessionFactory factory;

	public String addrecord(Country c) {

		Session session = null;
		Transaction tx = null;

		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(c);
			tx.commit();
			msg = "Country is added successfully";
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

	public String updateCountry(Country c, int id) {
		Session session = null;
		Transaction tx = null;

		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Country country = session.get(Country.class, id);
			country.setcName(c.getcName());
			session.merge(country);
			tx.commit();
			msg = "Country is Update successfully";
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

	public String deleteCountry(int id) {
		Session session = null;
		Transaction tx = null;

		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Country country = session.get(Country.class, id);

			session.remove(country);
			tx.commit();
			msg = "Country is Deleted";
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

	public List<Country> getallCountry() {

		Session session = null;
		Transaction tx = null;

		List<Country> list = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hql = "from Country";
			Query<Country> query = session.createQuery(hql, Country.class);
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

	public Country getallParticularCountrybyID(int id) {
		Session session = null;
		Transaction tx = null;
		Country country=null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			country = session.get(Country.class, id);
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
		return country;
	}

	public Country getallParticularCountrybyName(String name) {
		Session session = null;
		Transaction tx = null;

		Country c=null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hql = "from Country where cName=: myname";
			Query<Country> query = session.createQuery(hql, Country.class);
			query.setParameter("myname", name);
			c=query.uniqueResult();
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
		return c;
		
	}

}
