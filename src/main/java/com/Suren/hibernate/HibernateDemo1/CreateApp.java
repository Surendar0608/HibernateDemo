package com.Suren.hibernate.HibernateDemo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Suren.hibernate.entity.Song;

public class CreateApp 
{
    public static void main( String[] args )
    {
    	
    	
    	Song song1 = new Song();
    	song1.setId(004);
    	song1.setSongName("as it was");
    	song1.setSongAuthor("harry");
    	
    	//create configuration, its a class. 
    	Configuration configuration =new Configuration(); // this is the starting point to bootstrap hibernate
    	configuration.addAnnotatedClass(Song.class);
    	configuration.configure("hibernate.cfg.xml");/* to do a hibernate configuration, we deal with a xml file,
    	                                                insde this, we have bunch configuration to connect with database*/
    	
    	//Create SessionFactory, we need a some configuration
    	SessionFactory sessionFactory = configuration.buildSessionFactory(); // SessionFactory = dataSource(it internally manage the connection btw JAVA Application and DB
    	
    	// initialize the Session object we need SessionFactory
    	Session session = sessionFactory.openSession();// this interface has save method (utility method)to save object in db
    	
    	//query is used to insert data in db. for that we need transaction, without this the hibernate stuff not work
    
    	session.beginTransaction();
        session.save(song1);//  by using save method we save the object(song1)
        session.getTransaction().commit();// i.e i begin the transaction in 31 ,the  save the object and then commit the transaction
        System.out.println("Song save");
        session.close(); 
        
    	
    	
    }
}
