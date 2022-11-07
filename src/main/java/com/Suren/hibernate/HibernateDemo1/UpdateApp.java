package com.Suren.hibernate.HibernateDemo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Suren.hibernate.entity.Song;

public class UpdateApp 
{
    public static void main( String[] args )
    {
    	Configuration configuration = new Configuration();
    	configuration.addAnnotatedClass(Song.class);
    	configuration.configure();
    	
    	SessionFactory sessionFactory = configuration.buildSessionFactory();
    	
    	Session session = sessionFactory.openSession();
    	// id=2 -> EX BITCH want to update
    	// id=3 -> AS IT WAS
    	
    	Song song = new Song();
    	
    	//song.setId(3);//to update,want to mention primary key, so we set id
    	//song.setSongName("EX BITCH");
    	
    	/*in above we not use the get method, in that case, the data was updated what we mention
    	 * but not mentioned column of the record data was become null.
    	 * 
    	 * for that we use get method to particular data without affecting the other data of the records
    	 * */
    	
    	song = session.get(Song.class,3);
    	// id=3 -> AS IT WAS
    	song.setSongName("EX BITCH");
    	// update means try to change a data in db. so in that case use transaction
    	session.beginTransaction();
    	session.update(song);
    	session.getTransaction().commit();
    	System.out.println(song);
    	session.close();

    }
    
}
