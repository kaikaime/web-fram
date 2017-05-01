package com.system.dao;

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

import com.system.pojos.Yarddept;

/**
 * A data access object (DAO) providing persistence and search support for
 * Yarddept entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.system.pojos.Yarddept
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class YarddeptDAO {
	private static final Logger log = LoggerFactory
			.getLogger(YarddeptDAO.class);
	// property constants
	public static final String YARD_NICK = "yardNick";

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

	public void save(Yarddept transientInstance) {
		log.debug("saving Yarddept instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Yarddept persistentInstance) {
		log.debug("deleting Yarddept instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Yarddept findById(java.lang.Integer id) {
		log.debug("getting Yarddept instance with id: " + id);
		try {
			Yarddept instance = (Yarddept) getCurrentSession().get(
					"com.system.pojos.Yarddept", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Yarddept instance) {
		log.debug("finding Yarddept instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.system.pojos.Yarddept")
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
		log.debug("finding Yarddept instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Yarddept as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByYardNick(Object yardNick) {
		return findByProperty(YARD_NICK, yardNick);
	}

	public List findAll() {
		log.debug("finding all Yarddept instances");
		try {
			String queryString = "from Yarddept";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Yarddept merge(Yarddept detachedInstance) {
		log.debug("merging Yarddept instance");
		try {
			Yarddept result = (Yarddept) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Yarddept instance) {
		log.debug("attaching dirty Yarddept instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Yarddept instance) {
		log.debug("attaching clean Yarddept instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static YarddeptDAO getFromApplicationContext(ApplicationContext ctx) {
		return (YarddeptDAO) ctx.getBean("YarddeptDAO");
	}
}