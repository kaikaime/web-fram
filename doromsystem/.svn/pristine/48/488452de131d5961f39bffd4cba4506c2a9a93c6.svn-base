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

import com.system.pojos.Healthstate;

/**
 * A data access object (DAO) providing persistence and search support for
 * Healthstate entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.system.pojos.Healthstate
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class HealthstateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(HealthstateDAO.class);
	// property constants
	public static final String STATE = "state";
	public static final String STATE_DESC = "stateDesc";

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

	public void save(Healthstate transientInstance) {
		log.debug("saving Healthstate instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Healthstate persistentInstance) {
		log.debug("deleting Healthstate instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Healthstate findById(java.lang.Integer id) {
		log.debug("getting Healthstate instance with id: " + id);
		try {
			Healthstate instance = (Healthstate) getCurrentSession().get(
					"com.system.pojos.Healthstate", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Healthstate instance) {
		log.debug("finding Healthstate instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.system.pojos.Healthstate")
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
		log.debug("finding Healthstate instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Healthstate as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findByStateDesc(Object stateDesc) {
		return findByProperty(STATE_DESC, stateDesc);
	}

	public List findAll() {
		log.debug("finding all Healthstate instances");
		try {
			String queryString = "from Healthstate";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Healthstate merge(Healthstate detachedInstance) {
		log.debug("merging Healthstate instance");
		try {
			Healthstate result = (Healthstate) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Healthstate instance) {
		log.debug("attaching dirty Healthstate instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Healthstate instance) {
		log.debug("attaching clean Healthstate instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static HealthstateDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (HealthstateDAO) ctx.getBean("HealthstateDAO");
	}
}