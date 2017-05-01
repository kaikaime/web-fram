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

import com.system.pojos.Health;

/**
 * A data access object (DAO) providing persistence and search support for
 * Health entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.system.pojos.Health
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class HealthDAO {
	private static final Logger log = LoggerFactory.getLogger(HealthDAO.class);
	// property constants
	public static final String HEALTH_DESC = "healthDesc";

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

	public void save(Health transientInstance) {
		log.debug("saving Health instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Health persistentInstance) {
		log.debug("deleting Health instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Health findById(java.lang.Integer id) {
		log.debug("getting Health instance with id: " + id);
		try {
			Health instance = (Health) getCurrentSession().get(
					"com.system.pojos.Health", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Health instance) {
		log.debug("finding Health instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.system.pojos.Health")
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
		log.debug("finding Health instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Health as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByHealthDesc(Object healthDesc) {
		return findByProperty(HEALTH_DESC, healthDesc);
	}

	public List findAll() {
		log.debug("finding all Health instances");
		try {
			String queryString = "from Health";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Health merge(Health detachedInstance) {
		log.debug("merging Health instance");
		try {
			Health result = (Health) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Health instance) {
		log.debug("attaching dirty Health instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Health instance) {
		log.debug("attaching clean Health instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static HealthDAO getFromApplicationContext(ApplicationContext ctx) {
		return (HealthDAO) ctx.getBean("HealthDAO");
	}

	
}