package ru.myproj.gateway.service;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;
import ru.myproj.gateway.model.dto.NoteDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigInteger;
import java.util.List;

@Path("/api/notes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "noteservice.url")
public interface NoteServiceClient {

    //C
    @POST
    Response createNote(NoteDTO noteDTO);

    //R
    @GET
    List<NoteDTO> getAllNotes();

    @GET
    @Path("/{id}")
    NoteDTO getNoteById(@PathParam BigInteger id);

    @GET
    @Path("/user/{userId}")
    List<NoteDTO> getNotesByUserId(@PathParam BigInteger userId);

    //U
    @PUT
    Response updateNote(NoteDTO noteDTO);

    //D
    @DELETE
    void deleteNote(@QueryParam BigInteger noteId);

    @DELETE
    @Path("/user")
    void deleteUserNotes(@QueryParam BigInteger userId);

    @DELETE
    @Path("/flush_all")
    void deleteAllNotes();
}
