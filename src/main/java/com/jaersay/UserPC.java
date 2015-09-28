package com.jaersay;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;


/**
 * UserPC
 */
@Path("user")
public class UserPC {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        User aUser = new User("1", "aaa", "haidian", "13811112222");
        users.add(aUser);
        User bUser = new User("2", "bbb", "HaiDian", "13822221111");
        users.add(bUser);
        return users;
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML})
    public JAXBElement<User> getUser(@PathParam("id") String id) {
        JAXBElement<User> result = new JAXBElement<User>(new QName(
                            "", "name"), User.class, this.getaUser("1"));
        return result;
    }



    private User getaUser(String id) {
        return new User(id, "aaa", "Haidian", "13822221111");
    }


}
