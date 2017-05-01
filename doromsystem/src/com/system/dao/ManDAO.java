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

import com.system.pojos.Man;

/**
 * A data access object (DAO) providing persistence and search support for Man
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.system.pojos.Man
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ManDAO {
	private static final Logger log = LoggerFactory.getLogger(ManDAO.class);
	// property constants
	public static final String MAN_NICK = "manNick";
	public static final String MAN_SEX = "manSex";
	public static final String MAN_TEL = "manTel";
	public static final String MAN_ID_CARD = "manIdCard";
	public static final String MANSHEN = "manshen";
	public static final String SHI = "shi";
	public static final String XIAN = "xian";
	public static final String XIANGZHENG = "xiangzheng";

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

	public void save(Man transientInstance) {
		log.debug("saving Man instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Man persistentInstance) {
		log.debug("deleting Man instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Man findById(java.lang.Integer id) {
		log.debug("getting Man instance with id: " + id);
		try {
			Man instance = (Man) getCurrentSession().get(
					"com.system.pojos.Man", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Man instance) {
		log.debug("finding Man instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.system.pojos.Man")
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
		log.debug("finding Man instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Man as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByManNick(Object manNick) {
		return findByProperty(MAN_NICK, manNick);
	}

	public List findByManSex(Object manSex) {
		return findByProperty(MAN_SEX, manSex);
	}

	public List findByManTel(Object manTel) {
		return findByProperty(MAN_TEL, manTel);
	}

	public List findByManIdCard(Object manIdCard) {
		return findByProperty(MAN_ID_CARD, manIdCard);
	}

	public List findByManshen(Object manshen) {
		return findByProperty(MANSHEN, manshen);
	}

	public List findByShi(Object shi) {
		return findByProperty(SHI, shi);
	}

	public List findByXian(Object xian) {
		return findByProperty(XIAN, xian);
	}

	public List findByXiangzheng(Object xiangzheng) {
		return findByProperty(XIANGZHENG, xiangzheng);
	}

	public List findAll() {
		log.debug("finding all Man instances");
		try {
			String queryString = "from Man";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Man merge(Man detachedInstance) {
		log.debug("merging Man instance");
		try {
			Man result = (Man) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Man instance) {
		log.debug("attaching dirty Man instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Man instance) {
		log.debug("attaching clean Man instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ManDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ManDAO) ctx.getBean("ManDAO");
	}
}