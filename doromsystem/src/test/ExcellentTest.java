package test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.system.bean.ExcellentBean;
import com.system.bean.HealthBean;
import com.system.pojos.Room;
import com.system.pojos.Student;
import com.system.utils.StringUtils;


public class ExcellentTest {
	/**
	 * 使用inner join left join right join时候，返回的是Object[]
	 * @param args
	 * @throws Exception
	 */

	// 宿舍评比String
	// hqL="select new "+StringUtils.formatPack(ExcellentBean.class)+"(rid.ridgNick,rid.ridgId,room.roomId,room.roomNick,exce.excellentId,exce.excellentState,exce.excellentTime,exce.excellentDesc) from  Room as room, Excellent as exce,Ridgepole as rid where exce.room.roomId=room.roomId and room.ridgepole.ridgId=rid.ridgId ";

	public static void main(String[] args) throws Exception {

		Configuration cr = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory buildSessionFactory = cr.buildSessionFactory();

		Session session = buildSessionFactory.openSession();
		

		// String hql
		// ="select new "+StringUtils.formatPack(ExcellentBean.class)+"( exce.excellentId,  room.roomNick,exce.excellentTime,exce.excellentDesc,state.stateDesc) from Room as room ,"
		// +
		// "Healthstate as state,Excellent as exce where room.roomId =state.room.roomId and room.roomId=exce.room.roomId";

		// String HQL =
		// "select new ExcellentBean(room.roomNick as roomNick,exce.excellentState as excellentTime) from Room as room , Excellent as exce where room.roomId=exce.room.roomId"
		// ;

		/*
		 * String ridgNick, String ridgId, String roomId, String roomNick,
		 * String excellentId, String excellentState, String excellentTime,
		 * String excellentDesc
		 */

		/*
		 * String roomId, String roomNick, String excellentId, String
		 * excellentState, String excellentTime, String excellentDesc
		 */
		// String Hql =
		// "select new "+StringUtils.formatPack(ExcellentBean.class)+"(room.roomId,room.roomNick,exce.excellentId,exce.excellentState,exce.excellentTime,exce.excellentDesc) from  Room as room, Excellent as exce where room.roomId=exce.room.roomId";

		// String roomNick, String excellentDesc

		// String
		// hqL="select new "+StringUtils.formatPack(ExcellentBean.class)+"(rid.ridgNick,rid.ridgId,room.roomId,room.roomNick,exce.excellentId,exce.excellentState,exce.excellentTime,exce.excellentDesc) from  Room as room, Excellent as exce,Ridgepole as rid where exce.room.roomId=room.roomId and room.ridgepole.ridgId=rid.ridgId";

		// simpleDateFormat.parse("");

		// String
		// hqL="select new "+StringUtils.formatPack(ExcellentBean.class)+"(rid.ridgNick,rid.ridgId,room.roomId,room.roomNick,exce.excellentId,exce.excellentState,exce.excellentTime,exce.excellentDesc) from  Room as room, Excellent as exce,Ridgepole as rid where exce.room.roomId=room.roomId and room.ridgepole.ridgId=rid.ridgId and exce.excellentTime>"+new
		// Date()+"";

		// to_char(to_date( tc.endDate ,'yyyy-MM-dd HH24:mi:ss'),'yyyy-MM-dd
		// HH24:mi:ss')>' 2014-07-31 17:18:06'

		// String s = " select violationTime from Violation";
		/*
		 * String hQl=
		 * "select room.roomNick,exce.excellentDesc from Room as room, Excellent as exce where exce.room.roomId=room.roomId"
		 * ; List<Object[]> list = session.createQuery(hQl).list(); for
		 * (Object[] objects : list) { for (Object object : objects) {
		 * System.out.print(object); } System.out.println(""); }
		 */

		/*
		 * String countHql =
		 * " SELECT COUNT(*) FROM Excellent as exce where exce.excellentTime>:currentTime"
		 * ; Query query = session.createQuery(countHql);
		 * query.setParameter("currentTime", StringUtils.getLastMonth()); long l
		 * = (Long) query.uniqueResult(); System.out.println("============="+l);
		 */

		/*
		 * String sql = "select new Room(roomNick) from Room";
		 * 
		 * 
		 * 
		 * System.out.println("============="+session.createQuery(countHql).list(
		 * ).size());
		 */

		// String
		// hqL="select new "+StringUtils.formatPack(ExcellentBean.class)+"(rid.ridgNick,rid.ridgId,room.roomId,room.roomNick,exce.excellentId,exce.excellentState,exce.excellentTime,exce.excellentDesc,exce.excellentLack) from  Room as room, Excellent as exce,Ridgepole as rid where exce.room.roomId=room.roomId and room.ridgepole.ridgId=rid.ridgId and  exce.room.roomId=:roomId";
		// String hql =
		// "SELECT roomId as rId FROM Room as room WHERE room.roomNick like :nick";

		// String hql =
		// "select new com.system.bean.HealthBean( rid.ridgId,room.roomId,hl.healthId,hls.stateId) from Ridgepole as rid ,Room as room,Healthstate as hls,Health as hl where rid.ridgId=room.ridgepole.ridgId and room.roomId=hls.room.roomId and hl.room.roomId=room.roomId";

		// String
		// l="select new com.system.bean.HealthBean( rid.ridgNick,  rid.ridgId,  room.roomId,room.roomNick,  hl.healthId,  hl.healthDesc,hl.healthTime, hls.stateId,  hls.state,hls.stateDesc,  hls.stateTime) from Ridgepole as rid ,Room as room,Healthstate as hls,Health as hl where rid.ridgId=room.ridgepole.ridgId and room.roomId=hls.room.roomId and hl.room.roomId=room.roomId";

		/*
		 * String hql = "select new "+StringUtils.formatPack(HealthBean.class)+
		 * "( rid.ridgNick,  rid.ridgId, " +
		 * " room.roomId,room.roomNick,  hl.healthId,  hl.healthDesc,hl.healthTime, hls.stateId, "
		 * +
		 * " hls.state,hls.stateDesc,  hls.stateTime,mark.markId,mark.markNumber,mark.markDesc) "
		 * +
		 * "from Ridgepole as rid ,Room as room,Healthstate as hls,Health as hl,Mark as mark where "
		 * +
		 * "rid.ridgId=room.ridgepole.ridgId and room.roomId = hls.room.roomId and hl.room.roomId="
		 * +
		 * "room.roomId and mark.room.roomId=room.roomId and hls.stateTime>:stateTime"
		 * ;
		 * 
		 * String hqls = "select new "+StringUtils.formatPack(HealthBean.class)+
		 * "( rid.ridgNick,  rid.ridgId, " +
		 * " room.roomId,room.roomNick,  hl.healthId,  hl.healthDesc,hl.healthTime, hls.stateId, "
		 * +
		 * " hls.state,hls.stateDesc,  hls.stateTime,mark.markId,mark.markNumber,mark.markDesc) "
		 * +
		 * "from Ridgepole as rid ,Room as room,Healthstate as hls,Health as hl,Mark as mark where "
		 * +
		 * "rid.ridgId=room.ridgepole.ridgId and room.roomId = hls.room.roomId and hl.room.roomId="
		 * + "room.roomId";
		 * 
		 * 
		 * //and hls.stateTime>:stateTimehql Query s = session.createQuery(hql);
		 * s.setParameter("stateTime",FormatUtils.getLastMonth());
		 * List<HealthBean> list = s.list(); for (HealthBean objects : list) {
		 * System.out.println("---"+objects.toString()); }
		 * 
		 * String countHql ="SELECT COUNT(*) FROM Healthstate ";
		 * 
		 * Query q = session.createQuery(countHql); List list2 = q.list();
		 * System.out.println(list2.size());
		 */
		String hqL = "select new "
				+ StringUtils.formatPack(ExcellentBean.class)
				+ "(rid.ridgNick,rid.ridgId,room.roomId,room.roomNick,exce.excellentId,exce.excellentState,exce.excellentDesc) from  Room as room, Excellent as exce,Ridgepole as rid where exce.room.roomId=room.roomId and room.ridgepole.ridgId=rid.ridgId";
		String hql = "FROM Acct as acct  WHERE acct.accNumber=? and acct.accPass=?";

		String healthHql = "from com.system.bean.HealthBean(rid.ridgId, rid.ridgNick,room.roomId,room.roomNick,hls.stateId,hls.state,hls.stateDesc ,hls.stateTime,hl.healthId,hl.healthDesc,hl.healthTime,mk.rmId,mark.markId,mark.markNumber,mark.markDesc,mark.markTime) from Mark as mark,Ridgepole as rid,Room as room ,Healthstate as hls,Roommark as rm where rid.ridgId = room.ridgepole.ridgIdand room.roomId=hls.room.roomId room.roomId=rm.room.roomId and mark.markId=rm.markId";
		// Query createQuery = session.createQuery(healthHql);

		String l = "select new "
				+ StringUtils.formatPack(HealthBean.class)
				+ "(rid.ridgId, rid.ridgNick,"
				+ "room.roomId,room.roomNick,hls.stateId,hls.state,hls.stateDesc ,"
				+ "hls.stateTime,hl.healthId,hl.healthDesc,hl.healthTime,mk.rmId,"
				+ "mark.markId,mark.markNumber,mark.markDesc,mark.markTime) from "
				+ "Ridgepole as rid,Room as room ,Healthstate as hls,Health as hl,"
				+ "Roommark as mk,Mark as mark where rid.ridgId=room.ridgepole.ridgId "
				+ "and room.roomId=hls.room.roomId and room.roomId = hl.room.roomId "
				+ "and mk.room.roomId=room.roomId and mk.mark.markId=mark.markId and hls.stateTime>:stateTime";
		/*
		 * Query createQuery2 = session.createQuery("FROM Healthstate");
		 * List<Healthstate> list = createQuery2.list();
		 * 
		 * for (Healthstate healthstate : list) {
		 * System.out.println("========="+healthstate.getStateDesc()); }
		 */
		/*
		 * Query createQuery2 = session.createQuery(l);
		 * createQuery2.setParameter("stateTime",FormatUtils.getLastMonth());
		 * List<HealthBean> healthBeans = createQuery2.list();
		 * System.out.println("========"+healthBeans.size());
		 */
/*
	String hl = " FROM Violation as vi join fetch vi.student as stu join fetch stu.classt as cla join fetch cla.yarddept join fetch stu.room as rm join fetch rm.ridgepole as rid where vi.violationTime>:lastTime";
	
	Query query = session.createQuery(hl);
	query.setParameter("lastTime",FormatUtils.getLastMonth());
	
	List<Violation> list = query.list();
	for (Violation object : list) {
		System.out.println(object.getStudent().getStudentNick());
	}
	String h = "SELECT COUNT(*) FROM Violation";*/
	/*Query createQuery = session.createQuery(h);
	Long longs = (Long) createQuery.uniqueResult();
	System.out.println("========="+longs);*/
	/*//String hl = " FROM Violation as vi left join vi.student";

		Query createQuery = session.createQuery(hl);
		
		List<Object[]> list = createQuery.list();
		
		for (Object[] objects : list) {
			for(int i=0;i<objects.length;i++){
				System.out.println(objects[i]);
			}
		}*/
		/*for (Violation violation : list) {
			System.out.println(violation.getStudent().getStudentNick());
		}
*/
		/*
		 * String hql1 =
		 * "FROM Acct as acct  WHERE acct.accNumber=? and acct.accPass=?"; Query
		 * query =session.createQuery(hql1); query.setParameter(0,
		 * "1355654919"); query.setParameter(1,
		 * "25F9E794323B453885F5181F1B624D0B"); Acct acct = (Acct)
		 * query.uniqueResult();
		 * System.out.println("============="+acct.getAccNumber());
		 */
	
		/*String str = "SELECT COUNT(*) FROM Violation as vi WHERE vi.violationTime>:lastMonthTime";
		
		Query quesry = session.createQuery(str);
		quesry.setParameter("lastMonthTime", FormatUtils.getLastMonth());
		Long ls = (Long) quesry.uniqueResult();
		int intValue = ls.intValue();
		System.out.println("======="+intValue);*/
		/*String str = "From Vaction as vt join fetch vt.student as stu join fetch stu.classt as ct join fetch ct.yarddept join fetch stu.room as room join fetch room.ridgepole";
		Query querys = session.createQuery(str);
	//	quesry.setParameter("lastMonthTime", FormatUtils.getLastMonth());
		//Long ls = (Long) quesry.uniqueResult();
		List<Vaction> lisst = querys.list();
		for (Vaction vaction : lisst) {
			System.out.println("==========="+vaction.toString());
		}*/
		/*String hqlS = "From Excellent as exce join fetch exce.room as rooms join fetch rooms.ridgepole where exce.excellentTime>:excellentTime";
		Query query = session.createQuery(hqlS);
		query.setParameter("excellentTime", FormatUtils.getLastMonth());
		List<Excellent> list = query.list();
		System.out.println("=========="+list.size());
		for (Excellent excellent : list) {
			System.out.println("============"+excellent.toString());
		}join fetch room.student as stu
		*/
	String hqlw = "From Room as room ";
		Query query = session.createQuery(hqlw);
		List<Room> room = query.list();
		for (Room room2 : room) {
			String ls ="From Student as student where student.room.roomId=:roomId";
			Query querys = session.createQuery(ls);
			querys.setParameter("roomId", room2.getRoomId());
			List<Student> lss = querys.list();
			for (Student student : lss) {
				System.out.println(student.getStudentNick());
			}
			
		}
		/*String countHql="select count(*) from Room ";
		Query querys = session.createQuery(countHql);
		int i = ((Long) querys.uniqueResult()).intValue();
		System.out.println(i);*/
		session.close();

	}

}
