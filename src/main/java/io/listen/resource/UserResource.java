package io.listen.resource;

import io.listen.dto.Result;
import io.listen.model.User;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

import static io.listen.dto.Result.success;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Path("/list")
    @GET
    public Result<List<User>> list() {
        return success(User.listAll());
    }
}
