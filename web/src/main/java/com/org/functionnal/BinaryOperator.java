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
 * Fichier 		:	BinaryOperator.java
 * Cree le 		: 	27 août 2016 à 18:26:17
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.functionnal;

import com.org.exception.FunctionnalException;

/**
 * BinaryOperator
 * 
 * To represent a function that takes two arguments of type T and returns a result of the same type.
 * 
 * @author  : admin
 * @project : web
 * @package : com.org
 * @date    : 27 août 2016 18:26:17
 */
@FunctionalInterface
public interface BinaryOperator<T>
{
   /**
    * 
    * @param t1
    * @param t2
    * @return
    * @throws FunctionnalException : exception generate by runtime service
    */
   public T apply( T t1, T t2 ) throws FunctionnalException;
}
