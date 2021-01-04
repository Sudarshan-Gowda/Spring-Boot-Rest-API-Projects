package com.star.sud.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.star.sud.dto.User;
import com.star.sud.dto.Users;
import com.star.sud.model.TUser;
import com.star.sud.repo.UserRepository;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "users")
@Path("/users")
public class UserResource {

	@Autowired
	private UserRepository repo;

	@GET
	@Produces("application/json")
	public Users getAllUsers() {
		Users users = new Users();
		List<TUser> findAll = repo.findAll();

		List<User> usrLst = new ArrayList<>();
		findAll.stream().forEach(usr -> {
			User user = new User();
			BeanUtils.copyProperties(usr, user);
			usrLst.add(user);
		});
		users.setUsers(usrLst);
		return users;
	}

	@POST
	@Consumes("application/json")
	public Response createUser(User user) throws URISyntaxException {
		if (user.getFirstName() == null || user.getLastName() == null) {
			return Response.status(400).entity("Please provide all mandatory inputs").build();
		}
		TUser tUser = new TUser();
		BeanUtils.copyProperties(user, tUser);
		repo.save(tUser);
		return Response.status(201).contentLocation(new URI(user.getUri())).build();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getUserById(@PathParam("id") Integer id) throws URISyntaxException {
		try {
			TUser tUser = repo.findById(id).orElseThrow(() -> new Exception("No record found for Id :" + id));
			User user = new User();
			BeanUtils.copyProperties(tUser, user);
			return Response.status(200).entity(user).contentLocation(new URI("/user-management/" + id)).build();
		} catch (Exception e) {
			return Response.status(404).build();
		}

	}

	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateUser(@PathParam("id") int id, User user) throws URISyntaxException {
		try {
			TUser tUser = repo.findById(id).orElseThrow(() -> new Exception("No record found for Id :" + id));
			BeanUtils.copyProperties(user, tUser, "id");
			return Response.status(200).entity(tUser).build();
		} catch (Exception e) {
			return Response.status(404).build();
		}

	}

	@DELETE
	@Path("/{id}")
	public Response deleteUser(@PathParam("id") int id) throws URISyntaxException {
		try {
			TUser tUser = repo.findById(id).orElseThrow(() -> new Exception("No record found for Id :" + id));
			repo.delete(tUser);
			return Response.status(200).build();
		} catch (Exception e) {
			return Response.status(404).build();
		}

	}

}