package com.Suren.hibernate.HibernateDemo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Suren.hibernate.entity.Song;

public class ReadApp 
{
    public static void main( String[] args )
    {
    	Configuration configuration = new Configuration();
    	configuration.addAnnotatedClass(Song.class);
    	configuration.configure();
    	
    	SessionFactory sessionFactory = configuration.buildSessionFactory();
    	
    	Session session = sessionFactory.openSession();
    	//to read a data from db are fetch a data, we use a method called get in session interface
    	
    	Song song =  new Song();
    	
    song=	session.get(Song.class, 1);//(entity.class,primary key)
    	
    	System.out.println(song);
    	session.close();
    }
}
