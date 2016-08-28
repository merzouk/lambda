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
 * Fichier 		:	BiPredicateTest.java
 * Cree le 		: 	28 août 2016 à 11:35:35
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

import com.org.entity.Facture;
import com.org.entity.Person;
import com.org.exception.FunctionnalException;
import com.org.functionnal.BiPredicate;

/**
 * A Renseigner.
 * @author  : admin
 * @project : web
 * @package : com
 * @date    : 28 août 2016 11:35:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BiPredicateTest
{
   private static final Logger          logger  = LoggerFactory.getLogger( BiPredicateTest.class );
   
   private Facture                      facture = null;
   
   private Person                       person  = null;
   
   @Autowired
   private BiPredicate<Person, Facture> biConsumer;
   
   @Before
   public void init()
   {
      try
      {
         assertNotNull( biConsumer );
         facture = null;
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
      
      biConsumer.test( null, null );
   }
   
   @Test(expected = FunctionnalException.class)
   public void test2() throws FunctionnalException
   {
      
      biConsumer.test( new Person(), new Facture() );
   }
   
   @Test(expected = FunctionnalException.class)
   public void test3() throws FunctionnalException
   {
      
      biConsumer.test( new Person(), null );
   }
   
   @Test(expected = FunctionnalException.class)
   public void test4() throws FunctionnalException
   {
      
      biConsumer.test( null, new Facture() );
   }
   
   @Test
   public void test5() throws FunctionnalException
   {
      facture = new Facture();
      facture.setId( 1 );
      person = new Person();
      person.setId( 1 );
      biConsumer.test( person, facture );
   }
   
   @Test(expected = FunctionnalException.class)
   public void test6() throws FunctionnalException
   {
      facture = new Facture();
      facture.setId( 1 );
      person = new Person();
      person.setId( null );
      biConsumer.test( person, facture );
   }
   
   @Test(expected = FunctionnalException.class)
   public void test7() throws FunctionnalException
   {
      facture = new Facture();
      facture.setId( null );
      person = new Person();
      person.setId( 1 );
      biConsumer.test( person, facture );
   }
   
   @Test(expected = FunctionnalException.class)
   public void test8() throws FunctionnalException
   {
      facture = new Facture();
      facture.setId( null );
      person = new Person();
      person.setId( null );
      biConsumer.test( person, facture );
   }
}
