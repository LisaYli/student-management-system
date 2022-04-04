package se.iths.rest;

import se.iths.entity.Student;
import se.iths.service.StudentService;
import se.iths.validations.StudentValidation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    @Inject
    StudentService studentService;


    @Path("new")
    @POST
    public Response createStudent(Student student) {
        var students = studentService.getAllStudents();
        StudentValidation.checkEmailValidity(students, student.getEmail());
        StudentValidation.nullValidation(student);
        studentService.createStudent(student);
        return Response.ok(student).build();
    }


    @Path("getall")
    @GET
    public Response getStudents() {
        List<Student> students = studentService.getAllStudents();
        return Response.ok(students).build();
    }

    @Path("{lastname}")
    @GET
    public Response getStudentsByLastName(@PathParam("lastname") String lastname) {
        var students = studentService.findStudentByLastname(lastname);

        return Response.ok(students).build();

    }

    @Path("findbyid/{id}")
    @GET
    public Response findStudentById(@PathParam("id") Long id) {
        Student studentToFind = studentService.findStudentById(id);
        StudentValidation.checkIfStudentExist(id, studentToFind);
        return Response.ok(studentToFind).build();
    }


    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id) {
        studentService.deleteStudent(id);
        return Response.ok().build();
    }



    @Path("firstname/{id}")
    @PATCH
    public Response updateStudentFirstname(@PathParam("id") Long id, Student student) {
        var studentToUpdate = studentService.updateStudentFirstname(id, student.getFirstname());
        return Response.ok(studentToUpdate).build();
    }

    @Path("lastname/{id}")
    @PATCH
    public Response updateStudentLastname(@PathParam("id") Long id, Student student) {
        var studentToUpdate = studentService.updateStudentLastname(id, student.getLastname());
        return Response.ok(studentToUpdate).build();
    }
    @Path("email/{id}")
    @PATCH
    public Response updateStudentEmail(@PathParam("id") Long id, Student student) {
        var studentToUpdate = studentService.updateStudentEmail(id, student.getEmail());
        return Response.ok(studentToUpdate).build();
    }


}
