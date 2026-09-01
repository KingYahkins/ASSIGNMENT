package org.yltech.logindb.ManualInjection;

import org.yltech.logindb.DAO.StudentDao;
import org.yltech.logindb.DAO.UserDao;
import org.yltech.logindb.models.User;


public abstract class Tester {
    static void main() {

        UserDao dao = new UserDao();
        dao.Create();
        StudentDao std = new StudentDao();
        std.insert("yahkins","Tedua","computer","b0efdfa22",12,234303083);


    }
}
