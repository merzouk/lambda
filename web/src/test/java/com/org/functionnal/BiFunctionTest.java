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
 * Fichier 		:	BiFunctionTest.java
 * Cree le 		: 	27 août 2016 à 18:47:01
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

import java.util.List;

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

import com.org.entity.Facture;
import com.org.entity.Person;
import com.org.entity.Users;
import com.org.functionnal.BiFunction;

/**
 * A Renseigner.
 * @author  : admin
 * @project : web
 * @package : com
 * @date    : 27 août 2016 18:47:01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BiFunctionTest
{
   
   private static final Logger                      logger = LoggerFactory.getLogger( BiFunctionTest.class );
   
   @Autowired
   private BiFunction<Person, Users, Facture> biFunctionService;
   
   @Before
   public void init()
   {
      try
      {
         assertNotNull( biFunctionService );
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
   public void test()
   {
      try
      {
         List<Facture> factures = biFunctionService.apply( new Person(), null );
         assertNull( factures );
         //
         factures = biFunctionService.apply( new Person(), new Users() );
         assertNull( factures );
         //
         factures = biFunctionService.apply( null, null );
         assertNull( factures );
         //
         Users user = new Users();
         user.setId( 1 );
         Person person = new Person();
         person.setId( 1 );
         factures = biFunctionService.apply( person, user );
         assertNotNull( factures );
         assertEquals( 1, factures.size() );
         Facture facture = factures.get( 0 );
         assertEquals( "emailtrouve@gmail.com", facture.getEmail() );
         assertEquals( new Integer( 1 ), facture.getId() );
      }
      catch( Exception e )
      {
         logger.error( "Error ", e );
      }
   }
}
