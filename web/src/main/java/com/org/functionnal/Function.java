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
 * Fichier 		:	Function.java
 * Cree le 		: 	27 août 2016 à 18:22:43
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.functionnal;

/**
 * Function
 * To represent a function that takes an argument of type T and returns a result of type R.
 * 
 * @author  : admin
 * @project : web
 * @package : com.org
 * @date    : 27 août 2016 18:22:43
 */
@FunctionalInterface
public interface Function<T, R>
{
   public R apply( T t );
}
