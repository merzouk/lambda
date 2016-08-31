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
 * Fichier 		:	Predicate.java
 * Cree le 		: 	27 août 2016 à 18:23:44
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.functionnal;

/**
 * Predicate
 * To represent a boolean function that returns true or false for the specified argument.
 * 
 * @author  : mmenhour
 * @project : web
 * @package : com.org
 * @date    : 27 août 2016 18:23:44
 */
@FunctionalInterface
public interface Predicate<T>
{
   public boolean test( T t );
}
