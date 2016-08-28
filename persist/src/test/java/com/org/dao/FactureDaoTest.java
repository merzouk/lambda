
package com.org.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * A Renseigner.
 * @author  : menhour
 * @project : spring-jsf-jpa
 * @package : com.excelom.excelomweb.bean
 * @date    : 23 sept. 2012 15:52:15
 */
@ContextConfiguration("/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class FactureDaoTest
{
   private FactureDao factureDao;
   
   @Test
   public void shouldGetCorrectMessage()
   {
      assertNotNull( factureDao );
   }
}
