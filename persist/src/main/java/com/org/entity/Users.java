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
 * Fichier 		:	User.java
 * Cree le 		: 	27 ao�t 2016 � 18:47:10
 * Auteur		: 	admin
 * 
 * Description 	:
 * 
 *---------------------------------------------------------
 */

package com.org.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A Renseigner.
 * @author  : admin
 * @project : web
 * @package : com.org.model
 * @date    : 27 ao�t 2016 18:47:10
 */
@Entity(name = "Users")
@Table(name = "Users")
public class Users implements Serializable
{
   
   /**
    * 
    */
   private static final long serialVersionUID = 8560751097316754577L;
   
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer           id;
   
   @Column(name = "login", length = 50, nullable = false, unique = true)
   private String            login;
   
   @Column(name = "password", length = 500, nullable = false, unique = false)
   private String            password;
   
   @Column(name = "email", length = 150, nullable = false, unique = true)
   private String            email;
   
   /**
    * @return the id
    */
   public Integer getId()
   {
      return id;
   }
   
   /**
    * @param id the id to set
    */
   public void setId( Integer id )
   {
      this.id = id;
   }
   
   /**
    * @return the login
    */
   public String getLogin()
   {
      return login;
   }
   
   /**
    * @param login the login to set
    */
   public void setLogin( String login )
   {
      this.login = login;
   }
   
   /**
    * @return the password
    */
   public String getPassword()
   {
      return password;
   }
   
   /**
    * @param password the password to set
    */
   public void setPassword( String password )
   {
      this.password = password;
   }
   
   /**
    * @return the email
    */
   public String getEmail()
   {
      return email;
   }
   
   /**
    * @param email the email to set
    */
   public void setEmail( String email )
   {
      this.email = email;
   }
   
   /**
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString()
   {
      return "Users [id=" + id + ", login=" + login + ", password=" + password + ", email=" + email + "]";
   }
   
   /**
    * @see java.lang.Object#hashCode()
    */
   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ( ( email == null ) ? 0 : email.hashCode() );
      result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
      result = prime * result + ( ( login == null ) ? 0 : login.hashCode() );
      result = prime * result + ( ( password == null ) ? 0 : password.hashCode() );
      return result;
   }
   
   /**
    * @see java.lang.Object#equals(java.lang.Object)
    */
   @Override
   public boolean equals( Object obj )
   {
      if( this == obj ) return true;
      if( obj == null ) return false;
      if( getClass() != obj.getClass() ) return false;
      Users other = (Users) obj;
      if( email == null )
      {
         if( other.email != null ) return false;
      }
      else if( !email.equals( other.email ) ) return false;
      if( id == null )
      {
         if( other.id != null ) return false;
      }
      else if( !id.equals( other.id ) ) return false;
      if( login == null )
      {
         if( other.login != null ) return false;
      }
      else if( !login.equals( other.login ) ) return false;
      if( password == null )
      {
         if( other.password != null ) return false;
      }
      else if( !password.equals( other.password ) ) return false;
      return true;
   }
}
