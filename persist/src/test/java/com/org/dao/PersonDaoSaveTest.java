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
 * Fichier 		:	PersonSave.java
 * Cree le 		: 	28 ao�t 2016 � 18:11:05
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.dao;

import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.org.dao.impl.PersonDaoImpl;
import com.org.dao.impl.UserDaoImpl;
import com.org.entity.Person;
import com.org.entity.Users;
import com.org.exception.DaoException;
import com.org.utils.Constantes;

/**
 * A Renseigner.
 * @author  : mmenhour
 * @project : web
 * @package : com.org.dao
 * @date    : 28 aout  2016 18:11:05
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonDaoSaveTest
{
   
   private static final Logger logger = LoggerFactory.getLogger( PersonDaoSaveTest.class );
   
   private Users               user   = null;
   
   private Person              person = null;
   
   private PersonDao           personDao;
   
   private UserDao             userDao;
   
   @Before
   public void init()
   {
      try
      {
         user = null;
         person = null;
      }
      catch( Exception e )
      {
         logger.error( "Error ", e );
      }
   }
   
   @After
   public void destroy()
   {
      try
      {
         
      }
      catch( Exception e )
      {
         logger.error( "Error ", e );
      }
   }
   
   @org.junit.Test
   public void test1() throws DaoException
   {
      personDao = new PersonDaoImpl( Constantes.PERSISTENCE_UNIT, Constantes.DB_NAME_TEST );
      person = new Person();
      String nom = generateString( 12 );
      person.setNom( nom );
      String prenom = generateString( 12 );
      person.setPrenom( prenom );
      String login = person.getPrenom().substring( 0, 1 ).toLowerCase() + person.getNom().toLowerCase();
      person.setEmail( login+"@email.com" );
      
      /**
       * 
       */
      person = personDao.savePerson( person );
      assertNotNull( person );
      assertNotNull( person.getId() );
      if( person != null && person.getId() != null && person.getId().intValue() > 0 )
      {
         user = new Users();
         String password = "p" + person.getNom();
         
         user.setLogin( login );
         user.setPassword( password );
         user.setEmail( person.getEmail() );
         userDao = new UserDaoImpl( Constantes.PERSISTENCE_UNIT, Constantes.DB_NAME_TEST );
         userDao.saveUser( user );
      }
      assertNotNull( user );
      assertNotNull( user.getId() );
   }
   
   private String generateString( int length )
   {
      final String uuid = UUID.randomUUID().toString().replaceAll( "-", "" );
      return uuid.substring( 0, 11 ).toUpperCase();
   }
}
