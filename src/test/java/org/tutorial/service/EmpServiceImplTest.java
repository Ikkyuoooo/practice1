package org.tutorial.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.tutorial.dao.EmpDAO;
import org.tutorial.dao.impl.EmpDAOImpl;
import org.tutorial.model.EmpDO;

public class EmpServiceImplTest {

    private static EmpDAO dao;

    @BeforeClass
    public static void init() {
        dao = new EmpDAOImpl();
        System.out.println("=====Start=====");
    }

    @Before
    public void before() {
        System.out.println("=====Before=====");
    }

    @Test
    public void testAddEmp() {
        EmpDO entity = new EmpDO();

        entity.setEname("新人");
        entity.setJob("PG");
        entity.setHiredate(LocalDate.parse("2020-04-01"));
        entity.setSal(200.0);
        entity.setComm(0.0);
        entity.setDeptno(20);
        dao.insert(entity);
    }

    @Test
    public void testUpdateEmp() {
        EmpDO entity = new EmpDO();

        entity.setEmpno(15);
        entity.setEname("新人");
        entity.setJob("PG");
        entity.setHiredate(LocalDate.parse("2020-04-01"));
        entity.setSal(200.0);
        entity.setComm(0.0);
        entity.setDeptno(20);
        dao.update(entity);
        assertTrue(true);
    }

    @Test
    public void testDeleteEmp() {
        dao.delete(20);
        assertTrue(true);
    }

    @Test
    public void testGetOneEmp() {
        EmpDO entity = dao.findByPrimaryKey(10);
        assertEquals(Integer.valueOf(10), entity.getDeptno());
        assertEquals("ford", entity.getEname());
        assertEquals("analyst", entity.getJob());
        assertEquals(LocalDate.parse("1981-12-03"), entity.getHiredate());
        assertEquals(Double.valueOf(3000.0), entity.getSal());
        assertEquals(Double.valueOf(0.0), entity.getComm());
        assertEquals(Integer.valueOf(20), entity.getDeptno());
    }

    @Test
    public void getAll() {
        List<EmpDO> list = dao.getAll();
        for (EmpDO entity : list) {
            StringBuffer sb = new StringBuffer("[");
            sb.append(entity.getEmpno() + ",");
            sb.append(entity.getEname() + ",");
            sb.append(entity.getJob() + ",");
            sb.append(entity.getHiredate() + ",");
            sb.append(entity.getSal() + ",");
            sb.append(entity.getComm() + ",");
            sb.append(entity.getDeptno() + "]");
            System.out.println(sb);
        }
    }
}
