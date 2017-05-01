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

import com.system.pojos.Vaction;

/**
 * A data access object (DAO) providing persistence and search support for
 * Vaction entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.system.pojos.Vaction
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class VactionDAO {
	private static final Logger log = LoggerFactory.getLogger(VactionDAO.class);
	// property constants
	public static final String VACTION_DESC = "vactionDesc";

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

	public void save(Vaction transientInstance) {
		log.debug("saving Vaction instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Vaction persistentInstance) {
		log.debug("deleting Vaction instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Vaction findById(java.lang.Integer id) {
		log.debug("getting Vaction instance with id: " + id);
		try {
			Vaction instance = (Vaction) getCurrentSession().get(
					"com.system.pojos.Vaction", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Vaction instance) {
		log.debug("finding Vaction instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.system.pojos.Vaction")
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
		log.debug("finding Vaction instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Vaction as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByVactionDesc(Object vactionDesc) {
		return findByProperty(VACTION_DESC, vactionDesc);
	}

	public List findAll() {
		log.debug("finding all Vaction instances");
		try {
			String queryString = "from Vaction";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Vaction merge(Vaction detachedInstance) {
		log.debug("merging Vaction instance");
		try {
			Vaction result = (Vaction) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Vaction instance) {
		log.debug("attaching dirty Vaction instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Vaction instance) {
		log.debug("attaching clean Vaction instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static VactionDAO getFromApplicationContext(ApplicationContext ctx) {
		return (VactionDAO) ctx.getBean("VactionDAO");
	}
}