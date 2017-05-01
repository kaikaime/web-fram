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

import com.system.pojos.Excellent;

/**
 * A data access object (DAO) providing persistence and search support for
 * Excellent entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.system.pojos.Excellent
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ExcellentDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ExcellentDAO.class);
	// property constants
	public static final String EXCELLENT_STATE = "excellentState";
	public static final String EXCELLENT_DESC = "excellentDesc";
	public static final String EXCELLENT_LACK = "excellentLack";

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

	public void save(Excellent transientInstance) {
		log.debug("saving Excellent instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Excellent persistentInstance) {
		log.debug("deleting Excellent instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Excellent findById(java.lang.Integer id) {
		log.debug("getting Excellent instance with id: " + id);
		try {
			Excellent instance = (Excellent) getCurrentSession().get(
					"com.system.pojos.Excellent", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Excellent instance) {
		log.debug("finding Excellent instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.system.pojos.Excellent")
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
		log.debug("finding Excellent instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Excellent as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByExcellentState(Object excellentState) {
		return findByProperty(EXCELLENT_STATE, excellentState);
	}

	public List findByExcellentDesc(Object excellentDesc) {
		return findByProperty(EXCELLENT_DESC, excellentDesc);
	}

	public List findByExcellentLack(Object excellentLack) {
		return findByProperty(EXCELLENT_LACK, excellentLack);
	}

	public List findAll() {
		log.debug("finding all Excellent instances");
		try {
			String queryString = "from Excellent";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Excellent merge(Excellent detachedInstance) {
		log.debug("merging Excellent instance");
		try {
			Excellent result = (Excellent) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Excellent instance) {
		log.debug("attaching dirty Excellent instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Excellent instance) {
		log.debug("attaching clean Excellent instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ExcellentDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ExcellentDAO) ctx.getBean("ExcellentDAO");
	}
}