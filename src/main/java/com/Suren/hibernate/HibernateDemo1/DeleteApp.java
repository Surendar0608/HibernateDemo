package com.Suren.hibernate.HibernateDemo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Suren.hibernate.entity.Song;

public class DeleteApp 
{
    public static void main( String[] args )
    {
    	Configuration configuration = new Configuration();
    	configuration.addAnnotatedClass(Song.class);
    	configuration.configure();
    	
    	SessionFactory sessionFactory = configuration.buildSessionFactory();
    	
    	Session session = sessionFactory.openSession();
    	
    	// to delete we need to load or get records, so we need object pass the object inside the delete
    	Song song =  session.get(Song.class, 4);
    	//load object that wanna delete
    	
    	// update means try to change a data in db. so in that case use transaction
    	session.beginTransaction();
    	//load object that wanna delete
    	
    	session.delete(song);
    	
    	session.getTransaction().commit();// delete is the DML, so we wanna commit it. 
    	session.close();

    }
}
