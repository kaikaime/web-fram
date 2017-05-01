package com.system.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.system.pojos.Violation;

/**
 * A data access object (DAO) providing persistence and search support for
 * Violation entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.system.pojos.Violation
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ViolationDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ViolationDAO.class);
	// property constants
	public static final String VIOLATION_DESC = "violationDesc";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Violation transientInstance) {
		log.debug("saving Violation instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Violation persistentInstance) {
		log.debug("deleting Violation instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Violation findById(java.lang.Integer id) {
		log.debug("getting Violation instance with id: " + id);
		try {
			Violation instance = (Violation) getCurrentSession().get(
					"com.system.pojos.Violation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Violation instance) {
		log.debug("finding Violation instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.system.pojos.Violation")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Violation instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Violation as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByViolationDesc(Object violationDesc) {
		return findByProperty(VIOLATION_DESC, violationDesc);
	}

	public List findAll() {
		log.debug("finding all Violation instances");
		try {
			String queryString = "from Violation";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Violation merge(Violation detachedInstance) {
		log.debug("merging Violation instance");
		try {
			Violation result = (Violation) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Violation instance) {
		log.debug("attaching dirty Violation instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Violation instance) {
		log.debug("attaching clean Violation instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ViolationDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ViolationDAO) ctx.getBean("ViolationDAO");
	}
}