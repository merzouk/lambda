
package com.org.functionnal;

import static org.junit.Assert.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.org.service.functionnal.Processor;

public class ProcessorTest
{
   
   private static final Logger logger = LoggerFactory.getLogger( ProcessorTest.class );
   
   @org.junit.Test
   public void test()
   {
      try
      {
         Processor ope = ( String str ) -> str.length();
         int length = ope.getStringLength( "name" );
         assertEquals( 4, length );
         logger.info( "" + length );/* w ww . java 2 s . c o m */
      }
      catch( Exception e )
      {
         logger.error( "Error ", e );
      }
   }
}
