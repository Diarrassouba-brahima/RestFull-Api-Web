package resources;

import Dao.StudentDao;
import entity.Student;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/stud")
public class StudResource {
    @Inject
    StudentDao studentDao;



    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World! Dibrahimes cest propre";
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") int id) {
        System.out.println("Received request for student ID: " + id);
        Student stud = studentDao.getUser(id);
        if (stud == null) {
            System.out.println("Student not found: " + id);
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\":\"Student not found\"}").build();
        }
        System.out.println("Student found: " + stud);
        return Response.ok(stud).build();
    }




    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getALL(){

        return Response.ok(studentDao.getALLUsers()).build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Student student) {
        studentDao.create(student);
        return Response.status(Response.Status.CREATED)
                .entity("{\"message\":\"Registration successful!\"}")
                .build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        Student getuser = studentDao.getUser(id);
        if (getuser == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\":\"Student not found\"}").build();
        }
        studentDao.delete(getuser);
        return Response.noContent().build();
    }


    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Student student) {
        Student existingStudent = studentDao.getUser(id);
        if (existingStudent == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"message\":\"Student not found\"}")
                    .build();
        }

        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setDob(student.getDob());
        existingStudent.setPhone(student.getPhone());
        existingStudent.setCity(student.getCity());
        existingStudent.setDepartment(student.getDepartment());

        studentDao.update(existingStudent);

        return Response.ok(existingStudent).build();
    }

}
