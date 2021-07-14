package ru.myproj.gateway.controller;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;
import ru.myproj.gateway.model.dto.UserDTO;
import ru.myproj.gateway.service.UserServiceClient;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigInteger;
import java.util.List;

@Path("/api/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    @RestClient
    UserServiceClient userServiceClient;

    //C
    @POST
    public Response createUser(UserDTO userDTO) {
        Response user = userServiceClient.createUser(userDTO);
        return Response.ok(userDTO.toString()).build();
    }

    //R
    @GET
    public List<UserDTO> getUsers() {
        return userServiceClient.getAllUsers();
    }

    @GET
    @Path("/{userId}")
    public UserDTO getUserById(@PathParam BigInteger userId) {
        return userServiceClient.getUserById(userId);
    }

    //U
    @PUT
    public Response updateUser(UserDTO userDTO) {
        Response user = userServiceClient.updateUser(userDTO);
        return Response.ok(userDTO.toString()).build();
    }

    //D
    @DELETE
    public void deleteUser(@QueryParam BigInteger userId) {
        userServiceClient.deleteUser(userId);
    }

    @DELETE
    @Path("/flush_all")
    public void deleteAllUsers() {
        userServiceClient.deleteAllUsers();
    }
}

