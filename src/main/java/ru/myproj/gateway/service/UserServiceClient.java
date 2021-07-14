package ru.myproj.gateway.service;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;
import ru.myproj.gateway.model.dto.UserDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigInteger;
import java.util.List;

@Path("/api/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "userservice.url")
public interface UserServiceClient {

    //C
    @POST
    Response createUser(UserDTO userDTO);

    //R
    @GET
    List<UserDTO> getAllUsers();

    @GET
    @Path("/{userId}")
    UserDTO getUserById(@PathParam BigInteger userId);

    //U
    @PUT
    Response updateUser(UserDTO userDTO);

    //D
    @DELETE
    void deleteUser(@QueryParam BigInteger userId);

    @DELETE
    @Path("/flush_all")
    void deleteAllUsers();
}
