package camt.se234.lab11.service;

import camt.se234.lab11.Exceptions.NoDataException;
import camt.se234.lab11.dao.StudentDao;
import camt.se234.lab11.dao.StudentDaoImpl;
import camt.se234.lab11.entity.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StudentServiceImplTest {
    StudentDao studentDao;
    StudentServiceImpl studentService;

    @Before
    public void setup(){
        studentDao = mock(StudentDao.class);
        studentService = new StudentServiceImpl();
        studentService.setStudentDao(studentDao);
    }
    @Test
    public void testFindById(){
        StudentDaoImpl studentDao = new StudentDaoImpl();
        StudentServiceImpl studentService = new StudentServiceImpl();
        studentService.setStudentDao(studentDao);
        assertThat(studentService.findStudentById("123"),
                is(new Student("123","A","temp",2.33)));
    }

    @Test
    public void testGetAverageGPA(){
        StudentDaoImpl studentDao = new StudentDaoImpl();
        StudentServiceImpl studentService = new StudentServiceImpl();
        studentService.setStudentDao(studentDao);
        assertThat(studentService.getAverageGpa(),
                is(2.33));
    }

    @Test
    public void testWithMock(){
//        StudentDao studentDao = mock(StudentDao.class);
        List<Student> mockStudents = new ArrayList<>();
//        StudentServiceImpl studentService = new StudentServiceImpl();
//        studentService.setStudentDao(studentDao);
        mockStudents.add(new Student("123","A","temp",2.33));
        mockStudents.add(new Student("124","B","temp",2.33));
        mockStudents.add(new Student("223","C","temp",2.33));
        mockStudents.add(new Student("224","D","temp",2.33));
        when(studentDao.findAll()).thenReturn(mockStudents);
        assertThat(studentService.findStudentById("123"),
                is(new Student("123","A","temp",2.33)));
    }

    @Test
    public void testFindByPartOfId(){
//        StudentDao studentDao = mock(StudentDao.class);
        List<Student> mockStudents = new ArrayList<>();
//        StudentServiceImpl studentService = new StudentServiceImpl();
//        studentService.setStudentDao(studentDao);
        mockStudents.add(new Student("123","A","temp",2.33));
        mockStudents.add(new Student("124","B","temp",2.33));
        mockStudents.add(new Student("223","C","temp",2.33));
        mockStudents.add(new Student("224","D","temp",2.33));
        when(studentDao.findAll()).thenReturn(mockStudents);
        assertThat(studentService.findStudentByPartOfId("12"),
                hasItem(new Student("123","A","temp",2.33)));
        assertThat(studentService.findStudentByPartOfId("12"),
                hasItems(new Student("123","A","temp",2.33),
                        new Student("124","B","temp",2.33)));
    }

    @Test(expected = NoDataException.class)
    public void testNoDataException(){
        List<Student> mockStudents = new ArrayList<>();
        mockStudents.add(new Student("123","A","temp",2.33));

        when(studentDao.findAll()).thenReturn(mockStudents);
        assertThat(studentService.findStudentById("55"),nullValue());
    }
}
