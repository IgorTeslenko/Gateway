package ru.myproj.gateway.controller;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;
import ru.myproj.gateway.model.dto.NoteDTO;
import ru.myproj.gateway.service.NoteServiceClient;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigInteger;
import java.util.List;

@Path("/api/notes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NoteController {

    @Inject
    @RestClient
    NoteServiceClient noteServiceClient;

    //C
    @POST
    public Response createNote(NoteDTO noteDTO) {
        Response note = noteServiceClient.createNote(noteDTO);
        return Response.ok(noteDTO.toString()).build();
    }

    //R
    @GET
    public List<NoteDTO> getNotes() {
        return noteServiceClient.getAllNotes();
    }

    @GET
    @Path("/{noteId}")
    public NoteDTO getNoteById(@PathParam BigInteger noteId) {
        return noteServiceClient.getNoteById(noteId);
    }

    @GET
    @Path("/user/{userId}")
    public List<NoteDTO> getNotesByUserId(@PathParam BigInteger userId) {
        return noteServiceClient.getNotesByUserId(userId);
    }

    //U
    @PUT
    public Response updateNote(NoteDTO noteDTO) {
        Response note = noteServiceClient.updateNote(noteDTO);
        return Response.ok(noteDTO.toString()).build();
    }

    //D
    @DELETE
    public void deleteNote(@QueryParam BigInteger noteId) {
        noteServiceClient.deleteNote(noteId);
    }

    @DELETE
    @Path("/user")
    public void deleteUserNotes(@QueryParam BigInteger userId) {
        noteServiceClient.deleteUserNotes(userId);
    }

    @DELETE
    @Path("/flush_all")
    public void deleteAllNotes() {
        noteServiceClient.deleteAllNotes();
    }

}
