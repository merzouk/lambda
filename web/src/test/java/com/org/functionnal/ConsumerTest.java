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
 * Fichier 		:	ConsumerTest.java
 * Cree le 		: 	28 août 2016 à 17:58:20
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.functionnal;

import static org.junit.Assert.assertNotNull;

import java.util.UUID;

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
import com.org.functionnal.Consumer;

/**
 * A Renseigner.
 * @author  : admin
 * @project : web
 * @package : com.org
 * @date    : 28 août 2016 17:58:20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConsumerTest
{
   
   private static final Logger logger = LoggerFactory.getLogger( ConsumerTest.class );
   
   private Person              person = null;
   
   @Autowired
   private Consumer<Person>    consumer;
   
   @Before
   public void init()
   {
      try
      {
         assertNotNull( consumer );
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
   
   @org.junit.Test(expected = Exception.class)
   public void test1() throws Exception
   {
      
      consumer.accept( null );
   }
   
   @Test(expected = Exception.class)
   public void test2() throws Exception
   {
      
      consumer.accept( new Person() );
   }
   
   @Test(expected = Exception.class)
   public void test3() throws Exception
   {
      
      consumer.accept( new Person() );
   }
   
   @Test(expected = Exception.class)
   public void test4() throws Exception
   {
      person = new Person();
      person.setId( 1 );
      consumer.accept( person );
   }
   
   @Test(expected = Exception.class)
   public void test5() throws Exception
   {    
      person = new Person();
      person.setId( 1 );
      consumer.accept( person);
   }
   
   @Test(expected = Exception.class)
   public void test6() throws Exception
   {
      
      person = new Person();
      person.setId( null );
      consumer.accept( person);
   }
   
   @Test(expected = Exception.class)
   public void test7() throws Exception
   {
      person = new Person();
      person.setId( 1 );
      consumer.accept( person);
   }
   
   @Test(expected = Exception.class)
   public void test8() throws Exception
   {
      person = new Person();
      person.setId( 1 );
      person.setEmail( generateString( 11 ) );
      person.setNom( generateString( 11 )  );
      consumer.accept( person);
   }
   
   
   private String generateString( int length )
   {
      final String uuid = UUID.randomUUID().toString().replaceAll( "-", "" );
      return uuid.substring( 0, 11 ).toUpperCase();
   }
}
