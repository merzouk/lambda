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
 * Fichier 		:	BiConsumerException.java
 * Cree le 		: 	27 août 2016 à 22:35:50
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.exception;

/**
 * A Renseigner.
 * @author  : mmenhour
 * @project : web
 * @package : com.org.exception
 * @date    : 27 août 2016 22:35:50
 */
public class FunctionnalException extends Exception
{
   
   /**
    * 
    */
   private static final long serialVersionUID = 3378136643511617570L;

   /** Constructs a new runtime exception with {@code null} as its
    * detail message.  The cause is not initialized, and may subsequently be
    * initialized by a call to {@link #initCause}.
    */
   public FunctionnalException()
   {
      super();
   }
   
   /** Constructs a new runtime exception with the specified detail message.
    * The cause is not initialized, and may subsequently be initialized by a
    * call to {@link #initCause}.
    *
    * @param   message   the detail message. The detail message is saved for
    *          later retrieval by the {@link #getMessage()} method.
    */
   public FunctionnalException( String message )
   {
      super( message );
   }
   
   /**
    * Constructs a new runtime exception with the specified detail message and
    * cause.  <p>Note that the detail message associated with
    * {@code cause} is <i>not</i> automatically incorporated in
    * this runtime exception's detail message.
    *
    * @param  message the detail message (which is saved for later retrieval
    *         by the {@link #getMessage()} method).
    * @param  cause the cause (which is saved for later retrieval by the
    *         {@link #getCause()} method).  (A <tt>null</tt> value is
    *         permitted, and indicates that the cause is nonexistent or
    *         unknown.)
    * @since  1.4
    */
   public FunctionnalException( String message, Throwable cause )
   {
      super( message, cause );
   }
   
   /** Constructs a new runtime exception with the specified cause and a
    * detail message of <tt>(cause==null ? null : cause.toString())</tt>
    * (which typically contains the class and detail message of
    * <tt>cause</tt>).  This constructor is useful for runtime exceptions
    * that are little more than wrappers for other throwables.
    *
    * @param  cause the cause (which is saved for later retrieval by the
    *         {@link #getCause()} method).  (A <tt>null</tt> value is
    *         permitted, and indicates that the cause is nonexistent or
    *         unknown.)
    * @since  1.4
    */
   public FunctionnalException( Throwable cause )
   {
      super( cause );
   }
   
   /**
    * Constructs a new runtime exception with the specified detail
    * message, cause, suppression enabled or disabled, and writable
    * stack trace enabled or disabled.
    *
    * @param  message the detail message.
    * @param cause the cause.  (A {@code null} value is permitted,
    * and indicates that the cause is nonexistent or unknown.)
    * @param enableSuppression whether or not suppression is enabled
    *                          or disabled
    * @param writableStackTrace whether or not the stack trace should
    *                           be writable
    *
    * @since 1.7
    */
   protected FunctionnalException( String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace )
   {
      super( message, cause, enableSuppression, writableStackTrace );
   }
}
