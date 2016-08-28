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
 * Fichier 		:	Comparator.java
 * Cree le 		: 	27 août 2016 à 17:30:29
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.service.functionnal;

/**
 * A Renseigner.
 * @author  : admin
 * @project : web
 * @package : com.org
 * @date    : 27 août 2016 17:30:29
 */
@FunctionalInterface
public interface Comparator<T>
{
   /**
    * An  abstract method  declared in the functional interface 
    * @param object1
    * @param object2
    * @return
    */
   int compare( T object1, T object2 );
   
   /**
    * 
    * Re-declaration of the equals() method in the Object class 
   * 
   * @param object
   * @return
   */
   boolean equals( Object T );
   
   /**
    * Re-declaration of the toString() method in the Object class 
    * @return
    */
   public String toString();
}
