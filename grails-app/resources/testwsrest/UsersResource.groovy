package testwsrest

import grails.converters.XML
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces

@Path('/api/users')
@Consumes(['application/xml','application/json'])
@Produces(['application/xml','application/json'])
class UsersResource {
	UserService userService// automatically inject(IOC) to UserResource

	@GET
	String getUsers() {
		def xml =userService.getUser() as XML
		return xml
	}

	@POST
	String createUsers(User user) {
		userService.addUser(user)
		return user as XML
	}
}


