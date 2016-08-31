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
 * Fichier 		:	UnaryOperator.java
 * Cree le 		: 	27 août 2016 à 18:25:58
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.functionnal;

/**
 * UnaryOperator
 * 
 * To represent a function that takes an argument and returns a result of the same type.
 * @author  : mmenhour
 * @project : web
 * @package : com.org
 * @date    : 27 août 2016 18:25:58
 */
@FunctionalInterface
public interface UnaryOperator<T>
{
   public T apply( T t );
}
