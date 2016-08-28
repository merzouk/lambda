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
 * Fichier 		:	BinaryOperatorTest.java
 * Cree le 		: 	27 août 2016 à 23:07:51
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
import com.org.exception.FunctionnalException;
import com.org.functionnal.BinaryOperator;

/**
 * A Renseigner.
 * @author  : admin
 * @project : web
 * @package : com
 * @date    : 27 août 2016 23:07:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BinaryOperatorTest
{
   
   private static final Logger    logger = LoggerFactory.getLogger( BinaryOperatorTest.class );
   
   private Person                 user   = null;
   
   private Person                 person = null;
   
   @Autowired
   private BinaryOperator<Person> binaryOperator;
   
   @Before
   public void init()
   {
      try
      {
         assertNotNull( binaryOperator );
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
      
      binaryOperator.apply( null, null );
   }
   
   @Test(expected = FunctionnalException.class)
   public void test2() throws FunctionnalException
   {
      
      binaryOperator.apply( new Person(), new Person() );
   }
   
   @Test(expected = FunctionnalException.class)
   public void test3() throws FunctionnalException
   {
      
      binaryOperator.apply( new Person(), null );
   }
   
   @Test(expected = FunctionnalException.class)
   public void test4() throws FunctionnalException
   {
      
      binaryOperator.apply( null, new Person() );
   }
   
   @Test
   public void test5() throws FunctionnalException
   {
      user = new Person();
      user.setId( 1 );
      person = new Person();
      person.setId( 1 );
      binaryOperator.apply( user, person );
   }
   
   @Test(expected = FunctionnalException.class)
   public void test6() throws FunctionnalException
   {
      user = new Person();
      user.setId( 1 );
      person = new Person();
      person.setId( null );
      binaryOperator.apply( user, person );
   }
   
   @Test(expected = FunctionnalException.class)
   public void test7() throws FunctionnalException
   {
      user = new Person();
      user.setId( null );
      person = new Person();
      person.setId( 1 );
      binaryOperator.apply( user, person );
   }
   
   @Test(expected = FunctionnalException.class)
   public void test8() throws FunctionnalException
   {
      user = new Person();
      user.setId( null );
      person = new Person();
      person.setId( null );
      binaryOperator.apply( user, person );
   }
}
