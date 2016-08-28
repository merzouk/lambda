
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

import com.org.services.OperationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OperationServiceTest
{
   
   @Autowired
   private OperationService    operationService;
   
   private static final Logger logger = LoggerFactory.getLogger( OperationServiceTest.class );
   
   @Before
   public void init()
   {
      try
      {
         assertNotNull( operationService );
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
         operationService = null;
         assertNull( operationService );
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
         
         int somme = operationService.somme( 11, 12 );
         assertEquals( 23, somme );
         logger.info( "" + somme );
         //
         int produit = operationService.produit( 12, 12 );
         assertEquals( 144, produit );
         logger.info( "" + produit );
         //
         int length = operationService.lengthString( "toto" );
         assertEquals( 4, length );
         logger.info( "" + length );
         //
         length = operationService.lengthString( "" );
         assertEquals( 0, length );
         length = operationService.lengthString( null );
         assertEquals( 0, length );
      }
      catch( Exception e )
      {
         logger.error( "Error ", e );
      }
   }
}
