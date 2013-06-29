package testwsrest

class UserService {
	
	//Get list of users from DB
   def getUser() {
	   return User.list()
    }
   //Create User in DB
	def addUser(User user){
		user.save()
		return user
	}
}
