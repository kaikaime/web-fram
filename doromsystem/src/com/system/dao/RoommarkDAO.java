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

import com.system.pojos.Roommark;

/**
 * A data access object (DAO) providing persistence and search support for
 * Roommark entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.system.pojos.Roommark
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class RoommarkDAO {
	private static final Logger log = LoggerFactory
			.getLogger(RoommarkDAO.class);
	// property constants

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

	public void save(Roommark transientInstance) {
		log.debug("saving Roommark instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Roommark persistentInstance) {
		log.debug("deleting Roommark instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Roommark findById(java.lang.Integer id) {
		log.debug("getting Roommark instance with id: " + id);
		try {
			Roommark instance = (Roommark) getCurrentSession().get(
					"com.system.pojos.Roommark", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Roommark instance) {
		log.debug("finding Roommark instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.system.pojos.Roommark")
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
		log.debug("finding Roommark instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Roommark as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Roommark instances");
		try {
			String queryString = "from Roommark";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Roommark merge(Roommark detachedInstance) {
		log.debug("merging Roommark instance");
		try {
			Roommark result = (Roommark) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Roommark instance) {
		log.debug("attaching dirty Roommark instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Roommark instance) {
		log.debug("attaching clean Roommark instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RoommarkDAO getFromApplicationContext(ApplicationContext ctx) {
		return (RoommarkDAO) ctx.getBean("RoommarkDAO");
	}
}