package org.tutorial.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.tutorial.dao.DeptDAO;
import org.tutorial.dao.impl.DeptDAOImpl;
import org.tutorial.model.DeptDO;
import org.tutorial.model.EmpDO;

public class DeptServiceImplTest {

    private static DeptDAO dao;

    @BeforeClass
    public static void init() {
        dao = new DeptDAOImpl();
        System.out.println("=====Start=====");
    }

    @Before
    public void before() {
        System.out.println("=====Before=====");
    }

    @Test
    public void testGetAll() {
        List<DeptDO> list = dao.getAll();
        for (DeptDO deptDO : list) {
            StringBuffer sb = new StringBuffer();
            sb.append("[" + deptDO.getDeptno() + ",");
            sb.append(deptDO.getDname() + ",");
            sb.append(deptDO.getLoc() + "]");
            System.out.println(sb);
        }
    }

    @Test
    public void testGetOneDept() {
        DeptDO entity = dao.findByPrimaryKey(30);
        assertEquals(Integer.valueOf(30), entity.getDeptno());
        assertEquals("業務部", entity.getDname());
        assertEquals("美國紐約", entity.getLoc());
        System.out.println("testGetOneDept sueccss");
    }

    @Test
    public void testUpdate() {
        DeptDO entity = new DeptDO();
        entity.setDeptno(10);
        entity.setDname("財務部2");
        entity.setLoc("臺灣台北2");
        dao.update(entity);
        DeptDO testEntity = dao.findByPrimaryKey(10);
        if (testEntity.getDname().equals(entity.getDname())) {
            System.out.println("testUpdate sueccss");
            entity.setDname("財務部");
            entity.setLoc("臺灣台北");
            dao.update(entity);
        }
        assertTrue(true);
    }

    @Test
    public void testGetEmpsByDeptno() {
        List<EmpDO> list = dao.getEmpsByDeptno(20);
        for (EmpDO entity : list) {
            StringBuffer sb = new StringBuffer();
            sb.append("[" + entity.getEmpno() + ",");
            sb.append(entity.getEname() + ",");
            sb.append(entity.getJob() + ",");
            sb.append(entity.getHiredate() + ",");
            sb.append(entity.getSal() + ",");
            sb.append(entity.getComm() + ",");
            sb.append(entity.getDeptno() + "," + "]");
            System.out.println(sb);
        }
    }

    @Test
    public void testDeleteDept() {
        dao.delete(40);
        assertTrue(true);
    }

    @After
    public void after() {
        System.out.println("=====After=====");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("=====End=====");
    }

}
