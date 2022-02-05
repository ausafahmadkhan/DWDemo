package com.dropwizard.demo.resource;

import com.dropwizard.demo.entity.User;
import com.dropwizard.demo.service.UserService;
import com.google.inject.Inject;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/user")
public class UserResource
{

    private UserService userService;

    @Inject
    public UserResource(UserService userService)
    {
        this.userService = userService;
    }

    @Path("/addUser")
    @POST
    @Consumes(APPLICATION_JSON)
    @UnitOfWork
    public void addUser(User user)
    {
        userService.addUser(user);
    }

    @Path("/getUserById/{id}")
    @GET
    @Produces(APPLICATION_JSON)
    @UnitOfWork
    public User getUserById(@PathParam("id") String id)
    {
        return userService.getUserById(id);
    }

}
