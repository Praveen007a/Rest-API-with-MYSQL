package org.tp.restapi.Rest.Api.with.MYSQL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tp.restapi.Rest.Api.with.MYSQL.student.Student;

public interface Repository extends JpaRepository<Student, Integer>{

}
