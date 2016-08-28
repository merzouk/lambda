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
 * Cree le 		: 	28 août 2016 à 18:11:05
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.service;

import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.org.entity.Person;
import com.org.entity.Users;
import com.org.exception.DaoException;
import com.org.model.Persons;
import com.org.services.PersonService;
import com.org.utils.Constantes;

/**
 * A Renseigner.
 * @author  : admin
 * @project : web
 * @package : com.org.dao
 * @date    : 28 août 2016 18:11:05
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonServiceSaveTest
{
   
   private static final Logger logger = LoggerFactory.getLogger( PersonServiceSaveTest.class );
   
   private Users               user   = null;
   
   private Person              person = null;
   
   @Autowired
   private PersonService       personService;
   
   @Before
   public void init()
   {
      try
      {
         assertNotNull( personService );
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
      personService.setDbName( Constantes.DB_NAME_TEST );
      personService.setPersistenceUnit( Constantes.PERSISTENCE_UNIT );
      person = new Person();
      String nom = generateString( 12 );
      person.setNom( nom );
      String prenom = generateString( 12 );
      person.setPrenom( prenom );
      /**
       * 
       */
      Persons persons = personService.savePerson( person );
      assertNotNull( persons );
      person = persons.getPerson();
      user = persons.getUser();
      assertNotNull( user );
      assertNotNull( user.getId() );
      assertNotNull( person );
      assertNotNull( person.getId() );
   }
   
   private String generateString( int length )
   {
      final String uuid = UUID.randomUUID().toString().replaceAll( "-", "" );
      return uuid.substring( 0, 11 ).toUpperCase();
   }
}
