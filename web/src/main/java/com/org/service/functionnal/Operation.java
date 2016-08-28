
package com.org.service.functionnal;

/**
 * 
 * A Renseigner.
 * @author  : admin
 * @project : web
 * @package : com.org
 * @date    : 27 août 2016 14:48:33
 */
@FunctionalInterface
public interface Operation
{
   
   /**
    * 
    * @param a
    * @param b
    * @return
    */
   int somme( int a, int b );
   
   /**
    * 
    * @param a
    * @param b
    * @return
    */
   default int produit( int a, int b )
   {
      return a * b;
   }
}
