package com.cc2022111694.service;

import com.cc2022111694.dao.StudentDao;
import com.cc2022111694.entity.JdbcStudent;

import java.util.List;

public class StudentService {

    private final StudentDao studentDao = new StudentDao();

    // 查询所有学生
    public List<JdbcStudent> findAll() throws Exception {
        return studentDao.findAll();
    }

    // 根据学号查询学生
    public JdbcStudent findById(String id) throws Exception {
        return studentDao.findById(id);
    }

    // 新增学生
    public boolean add(JdbcStudent student) throws Exception {
        JdbcStudent existStudent = studentDao.findById(student.getId());

        if (existStudent != null) {
            return false;
        }

        int rows = studentDao.add(student);
        return rows > 0;
    }

    // 修改学生
    public boolean update(JdbcStudent student) throws Exception {
        JdbcStudent existStudent = studentDao.findById(student.getId());

        if (existStudent == null) {
            return false;
        }

        int rows = studentDao.update(student);
        return rows > 0;
    }

    // 删除学生
    public boolean delete(String id) throws Exception {
        JdbcStudent existStudent = studentDao.findById(id);

        if (existStudent == null) {
            return false;
        }

        int rows = studentDao.delete(id);
        return rows > 0;
    }
}