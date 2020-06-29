package com.car;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.*;

public class MainLogic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration cf=new Configuration();
		cf.configure("Configure.xml");
		SessionFactory sf = cf.buildSessionFactory();
		Session se = sf.openSession();
		Criteria c = se.createCriteria(Vehicle.class);
		Criterion cx = Restrictions.gt("Vprice",35000l);
		
		c.add(cx);
		
		
		
		//c.addOrder(Order.desc("Vprice"));
		
		//List l  = c.list();
		
		//Query qr = se.createQuery("from Vehicle v where v.Vprice between ? and ?");
		//qr.setParameter(0,10000l);
		//qr.setParameter(1,50000l);

		
		
		//Query qr = se.createQuery("insert into Cars(cid, cname, ccost) select  vid, Vname, Vprice from Vehicle where (vid=:value)");

		
		// Query qr = se.createQuery("delete from Vehicle v where v.vid=:value");
		
		//qr.setParameter("value", 1);
		
		//qr.setParameter("value2", 1);
		//qr.executeUpdate();
		
		

		//qr.setParameter("value", 17000);

		
		List l = c.list();
		Iterator li =l.iterator();
		
		while (li.hasNext()) {
			Object o = (Object)li.next();
			//System.out.println(o.intValue());

			
			Vehicle v =(Vehicle)o;
			System.out.println(v.getVid()+" "+v.getVname()+" "+v.getVprice());
		}
		
		
		
		
		/*
		 
		 
		//Vehicle v = new Vehicle();
		
		//v.setVid(01);
		//v.setVname("Camry");
		//v.setVcost(28000);

		
		//Transaction tx = se.beginTransaction();
		//se.save(v);
		//tx.commit();
		 
		*/
		
		Transaction tx = se.beginTransaction();

		tx.commit();
		
		se.close();
		sf.close();
	}

}
