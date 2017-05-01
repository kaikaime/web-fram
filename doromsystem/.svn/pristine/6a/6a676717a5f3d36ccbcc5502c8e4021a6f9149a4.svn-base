package com.system.dao;

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

import com.system.pojos.Classt;

/**
 * A data access object (DAO) providing persistence and search support for
 * Classt entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.system.pojos.Classt
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ClasstDAO {
	private static final Logger log = LoggerFactory.getLogger(ClasstDAO.class);
	// property constants
	public static final String CLASS_NICK = "classNick";

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

	public void save(Classt transientInstance) {
		log.debug("saving Classt instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Classt persistentInstance) {
		log.debug("deleting Classt instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Classt findById(java.lang.Integer id) {
		log.debug("getting Classt instance with id: " + id);
		try {
			Classt instance = (Classt) getCurrentSession().get(
					"com.system.pojos.Classt", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Classt instance) {
		log.debug("finding Classt instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.system.pojos.Classt")
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
		log.debug("finding Classt instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Classt as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByClassNick(Object classNick) {
		return findByProperty(CLASS_NICK, classNick);
	}

	public List findAll() {
		log.debug("finding all Classt instances");
		try {
			String queryString = "from Classt";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Classt merge(Classt detachedInstance) {
		log.debug("merging Classt instance");
		try {
			Classt result = (Classt) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Classt instance) {
		log.debug("attaching dirty Classt instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Classt instance) {
		log.debug("attaching clean Classt instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ClasstDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ClasstDAO) ctx.getBean("ClasstDAO");
	}
}