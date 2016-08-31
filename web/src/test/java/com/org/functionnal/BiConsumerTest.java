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
 * Fichier 		:	BiConsumerTest.java
 * Cree le 		: 	27 août 2016 à 22:42:13
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.functionnal;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.org.entity.Person;
import com.org.entity.Users;
import com.org.exception.FunctionnalException;
import com.org.functionnal.BiConsumer;

/**
 * A Renseigner.
 * @author  : mmenhour
 * @project : web
 * @package : com
 * @date    : 27 août 2016 22:42:13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BiConsumerTest
{
   
   private static final Logger      logger = LoggerFactory.getLogger( BiConsumerTest.class );
   
   private Users                     user   = null;
   
   private Person                   person = null;
   
   @Autowired
   private BiConsumer<Users, Person> biConsumer;
   
   @Before
   public void init()
   {
      try
      {
         assertNotNull( biConsumer );
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
   
   @org.junit.Test(expected = FunctionnalException.class)
   public void test1() throws FunctionnalException
   {
      
      biConsumer.accept( null, null );
   }
   
   @Test(expected = FunctionnalException.class)
   public void test2() throws FunctionnalException
   {
      
      biConsumer.accept( new Users(), new Person() );
   }
   
   @Test(expected = FunctionnalException.class)
   public void test3() throws FunctionnalException
   {
      
      biConsumer.accept( new Users(), null );
   }
   
   @Test(expected = FunctionnalException.class)
   public void test4() throws FunctionnalException
   {
      
      biConsumer.accept( null, new Person() );
   }
   
   @Test
   public void test5() throws FunctionnalException
   {
      user = new Users();
      user.setId( 1 );
      person = new Person();
      person.setId( 1 );
      biConsumer.accept( user, person );
   }
   
   @Test(expected = FunctionnalException.class)
   public void test6() throws FunctionnalException
   {
      user = new Users();
      user.setId( 1 );
      person = new Person();
      person.setId( null );
      biConsumer.accept( user, person );
   }
   
   @Test(expected = FunctionnalException.class)
   public void test7() throws FunctionnalException
   {
      user = new Users();
      user.setId( null );
      person = new Person();
      person.setId( 1 );
      biConsumer.accept( user, person );
   }
   
   @Test(expected = FunctionnalException.class)
   public void test8() throws FunctionnalException
   {
      user = new Users();
      user.setId( null );
      person = new Person();
      person.setId( null );
      biConsumer.accept( user, person );
   }
}
