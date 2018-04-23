package camt.se234.lab11.service;

import camt.se234.lab11.Exceptions.NoDataException;
import camt.se234.lab11.dao.StudentDao;
import camt.se234.lab11.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student findStudentById(String id) {
        for (Student student: this.studentDao.findAll()
             ) {
            if (student.getStudentId().equals(id)){
                return student;
            }
        }
//        return null;
        throw new NoDataException();
    }

    @Override
    public List<Student> findStudentByPartOfId(String id) {
        List<Student> output = new ArrayList<>();
        for (Student student: this.studentDao.findAll()
                ) {
            if (student.getStudentId().indexOf(id) != -1){
                output.add(student);
            }
        }
        return output;
    }

    
    @Override
    public double getAverageGpa() {
        double total = 0;
        for (Student student: this.studentDao.findAll()
                ) {
            total += student.getGpa();

        }
        return total/this.studentDao.findAll().size();
    }
}
