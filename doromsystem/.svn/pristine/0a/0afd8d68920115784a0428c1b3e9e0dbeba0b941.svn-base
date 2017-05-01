package com.system.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.system.pojos.Mark;

/**
 * A data access object (DAO) providing persistence and search support for Mark
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.system.pojos.Mark
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class MarkDAO {
	private static final Logger log = LoggerFactory.getLogger(MarkDAO.class);
	// property constants
	public static final String MARK_NUMBER = "markNumber";
	public static final String MARK_DESC = "markDesc";

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

	public void save(Mark transientInstance) {
		log.debug("saving Mark instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Mark persistentInstance) {
		log.debug("deleting Mark instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Mark findById(java.lang.Integer id) {
		log.debug("getting Mark instance with id: " + id);
		try {
			Mark instance = (Mark) getCurrentSession().get(
					"com.system.pojos.Mark", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Mark instance) {
		log.debug("finding Mark instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.system.pojos.Mark")
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
		log.debug("finding Mark instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Mark as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMarkNumber(Object markNumber) {
		return findByProperty(MARK_NUMBER, markNumber);
	}

	public List findByMarkDesc(Object markDesc) {
		return findByProperty(MARK_DESC, markDesc);
	}

	public List findAll() {
		log.debug("finding all Mark instances");
		try {
			String queryString = "from Mark";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Mark merge(Mark detachedInstance) {
		log.debug("merging Mark instance");
		try {
			Mark result = (Mark) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Mark instance) {
		log.debug("attaching dirty Mark instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Mark instance) {
		log.debug("attaching clean Mark instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MarkDAO getFromApplicationContext(ApplicationContext ctx) {
		return (MarkDAO) ctx.getBean("MarkDAO");
	}
}