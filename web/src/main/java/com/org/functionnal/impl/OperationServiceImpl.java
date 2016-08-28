/**
 * 
 */

package com.org.functionnal.impl;

import org.springframework.stereotype.Service;

import com.org.service.functionnal.Operation;
import com.org.service.functionnal.Processor;
import com.org.services.OperationService;

/**
 * @author mmenhour
 *
 */
@Service
public class OperationServiceImpl implements OperationService
{
   
   private Operation ope     = null;
   
   private Processor process = null;
   
   /**
    * 
    * @see com.org.services.OperationService#somme(int, int)
    */
   public int somme( int a, int b )
   {
      ope = ( x, y ) -> ( x + y );
      return ope.somme( a, b );
   }
   
   /**
    * 
    * @see com.org.services.OperationService#produit(int, int)
    */
   public int produit( int a, int b )
   {
      ope = ( x, y ) -> ( x + y );
      return ope.produit( a, b );
   }
   
   /**
   * 
   * @see com.org.services.OperationService#lengthString(java.lang.String)
   */
   public int lengthString( String str )
   {
      process = ( x ) -> {
         if( x == null ) return 0;
         return x.length();
      };
      return process.getStringLength( str );
   }
}
