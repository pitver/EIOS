package ru.stc23.eios.repos;

import ru.stc23.eios.model.Teacher;
import ru.stc23.eios.model.User;

import javax.transaction.Transactional;

/**
 * UserRepo
 *
 * @author Вершинин Пётр
 */

@Transactional
public interface TeacherRepository extends UserRepo<Teacher> { }


