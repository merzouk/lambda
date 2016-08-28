
package com.org.service.functionnal;

/**
 * 
 * A Renseigner.
 * @author  : admin
 * @project : web
 * @package : com.org
 * @date    : 27 août 2016 14:48:50
 */
@FunctionalInterface
public interface Processor
{
   /**
    * 
    * @param str
    * @return
    */
   int getStringLength( final String str );
}
