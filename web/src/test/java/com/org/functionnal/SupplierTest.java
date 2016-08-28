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
 * Fichier 		:	SupplierTest.java
 * Cree le 		: 	28 août 2016 à 17:27:27
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.functionnal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

import com.org.entity.Person;
import com.org.exception.FunctionnalException;
import com.org.functionnal.Supplier;

/**
 * A Renseigner.
 * @author  : admin
 * @project : web
 * @package : com.org
 * @date    : 28 août 2016 17:27:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SupplierTest
{
   private static final Logger logger = LoggerFactory.getLogger( SupplierTest.class );
   
   @Autowired
   private Supplier<Person>    supplier;
   
   @Before
   public void init()
   {
      try
      {
         assertNotNull( supplier );
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
   public void test() throws FunctionnalException
   {
      List<Person> list = supplier.get();
      assertNotNull( list );
      assertEquals( 3, list.size() );
   }
}
