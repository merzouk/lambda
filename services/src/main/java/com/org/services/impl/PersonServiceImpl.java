/*
 *--------------------------------------------------------
 * Administrateur
 *--------------------------------------------------------
 * Project     : web
 *
 * Copyright Administrateur,  All Rights Reserved.
 *
 * This software is the confidential and proprietary
 * information of Administrateur.
 * You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms
 * of the license agreement you entered into with
 * Administrateur.
 *-------------------------------------------------------- 
 * 
 * Fichier 		:	PersonServiceImpl.java
 * Cree le 		: 	28 ao�t 2016 � 11:43:15
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.org.dao.PersonDao;
import com.org.dao.UserDao;
import com.org.dao.impl.PersonDaoImpl;
import com.org.dao.impl.UserDaoImpl;
import com.org.entity.Person;
import com.org.entity.Users;
import com.org.exception.DaoException;
import com.org.model.Persons;
import com.org.services.PersonService;

/**
 * A Renseigner.
 * @author  : admin
 * @project : web
 * @package : com.org.service.impl
 * @date    : 28 ao�t 2016 11:43:15
 */
@Service
public class PersonServiceImpl implements PersonService
{
   
   private static final Logger logger = LoggerFactory.getLogger( PersonServiceImpl.class );
   
   private PersonDao           personDao;
   
   private UserDao             userDao;
   
   private String              persistenceUnit;
   
   private String              dbName;
   
   /**
    * @param persistenceUnit the persistenceUnit to set
    */
   public void setPersistenceUnit( String persistenceUnit )
   {
      this.persistenceUnit = persistenceUnit;
   }
   
   /**
    * @param dbName the dbName to set
    */
   public void setDbName( String dbName )
   {
      this.dbName = dbName;
   }
   
   /**
    * 
    * @see com.org.services.PersonService#savePerson(com.org.entity.Person)
    */
   @Override
   public Persons savePerson( Person person ) throws DaoException
   {
      personDao = new PersonDaoImpl( persistenceUnit, dbName );
      String login = person.getPrenom().substring( 0, 1 ).toLowerCase() + person.getNom().toLowerCase();
      person.setEmail( login + "@gmail.com" );
      person = personDao.savePerson( person );
      Users user = null;
      personDao = null;
      if( person != null && person.getId() != null && person.getId().intValue() > 0 )
      {
         user = new Users();
         String password = "p" + login;
         user.setLogin( login );
         user.setPassword( password );
         user.setEmail( person.getEmail() );
         userDao = new UserDaoImpl( persistenceUnit, dbName );
         userDao.saveUser( user );
      }
      Persons persons = new Persons( person, user );
      return persons;
   }
   
   /**
    * 
    * @see com.org.services.PersonService#updatePerson(com.org.entity.Person)
    */
   @Override
   public Person updatePerson( Person person ) throws DaoException
   {
      
      return null;
   }
   
   /**
    * 
    * @see com.org.services.PersonService#deletePerson(com.org.entity.Person)
    */
   @Override
   public void deletePerson( Person person ) throws DaoException
   {
   }
   
   /**
    * 
    * @see com.org.services.PersonService#findById(java.lang.Integer)
    */
   @Override
   public Person findById( Integer id )
   {
      logger.debug( "find person dao" );
      if( id == null || id.intValue() <= 0 )
      {
         return null;
      }
      try
      {
         personDao = new PersonDaoImpl( persistenceUnit, dbName );
         return personDao.findById( id );
      }
      catch( DaoException e )
      {
         logger.error( "Error ", e );
         return null;
      }
   }
   
   /**
    * 
    * @see com.org.services.PersonService#listPerson()
    */
   @Override
   public List<Person> listPerson() throws DaoException
   {
      logger.debug( "list person dao" );
      try
      {
         personDao = new PersonDaoImpl( persistenceUnit, dbName );
         return personDao.listPerson();
      }
      catch( DaoException e )
      {
         logger.error( "Error ", e );
         return null;
      }
   }
}
