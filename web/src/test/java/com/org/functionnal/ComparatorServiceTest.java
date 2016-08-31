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
 * Fichier 		:	ComparatorTest.java
 * Cree le 		: 	27 août 2016 à 18:02:24
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.functionnal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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

/**
 * A Renseigner.
 * @author  : mmenhour
 * @project : web
 * @package : com
 * @date    : 27 août 2016 18:02:24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ComparatorServiceTest
{
   
   @Autowired
   private Comparator<Person>  comparatorService;
   
   private static final Logger logger = LoggerFactory.getLogger( OperationServiceTest.class );
   
   @Before
   public void init()
   {
      try
      {
         assertNotNull( comparatorService );
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
         comparatorService = null;
         assertNull( comparatorService );
      }
      catch( Exception e )
      {
         logger.error( "Error ", e );
      }
   }
   
   @org.junit.Test
   public void test()
   {
      try
      {
         Person pA = new Person();
         pA.setId( 1 );
         pA.setNom( "nom1" );
         pA.setPrenom( "prenom1" );
         pA.setEmail( "email1@gmail.com" );
         //
         Person pB = new Person();
         pB.setId( 2 );
         pB.setNom( "nom2" );
         pB.setPrenom( "prenom2" );
         pB.setEmail( "emai2@gmail.com" );
         //
         int compare = comparatorService.compare( pA, pB );
         assertEquals( -1, compare );
         logger.info( "" + compare );
         //
         compare = comparatorService.compare( pB, pA );
         assertEquals( 1, compare );
         logger.info( "" + compare );
         //
         pB.setId( 1 );
         //
         compare = comparatorService.compare( pA, pB );
         assertEquals( 0, compare );
         logger.info( "" + compare );
         //
         compare = comparatorService.compare( pB, pA );
         assertEquals( 0, compare );
         logger.info( "" + compare );
         //
         pB.setId( null );
         //
         compare = comparatorService.compare( pA, pB );
         assertEquals( 1, compare );
         logger.info( "" + compare );
         //
         compare = comparatorService.compare( pB, pA );
         assertEquals( -1, compare );
         logger.info( "" + compare );
      }
      catch( Exception e )
      {
         logger.error( "Error ", e );
      }
   }
}
