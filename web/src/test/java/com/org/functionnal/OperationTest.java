
package com.org.functionnal;

import static org.junit.Assert.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.org.service.functionnal.Operation;

public class OperationTest
{
   
   private static final Logger logger = LoggerFactory.getLogger( OperationTest.class );
   
   @org.junit.Test
   public void test()
   {
      try
      {
         
         Operation ope = ( x, y ) -> ( x + y );
         int somme = ope.somme( 11, 12 );
         assertEquals( 23, somme );
         logger.info( "" + somme );
         int produit = ope.produit( 12, 12 );
         assertEquals( 144, produit );
         logger.info( "" + produit );
      }
      catch( Exception e )
      {
         logger.error( "Error ", e );
      }
   }
}
