package StudentService;

import StudentDao.StudentDao;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public String queryStudentById() {
       return studentDao.queryStudentById();

    }
}
