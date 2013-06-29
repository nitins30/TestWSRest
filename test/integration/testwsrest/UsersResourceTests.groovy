package testwsrest
import org.grails.jaxrs.itest.IntegrationTestCase
import org.junit.Test

import static org.junit.Assert.*

class UsersResourceTests extends IntegrationTestCase {

	@Test
	void testPostAndGet() {
		def headers = ['Content-Type':'application/json', 'Accept':'application/xml']
		def content = '{"class":"testwsrest.User","username":"Sam","password":"Hill"}'
		def expected = '[<?xml version="1.0" encoding="UTF-8"?><user id="1"><password>Hill</password><username>Sam</username></user>]]'
		def User user=new User();
		user.setUsername("John")
		user.setPassword("john@")
		// create new User
		sendRequest('/api/users', 'POST', headers, content.bytes)

		assertEquals(200, response.status)
		assertEquals(expected, response.contentAsString)
		assertTrue(response.getHeader('Content-Type').startsWith('application/xml'))

		// get users
		sendRequest('/api/users', 'GET', headers)

		assertEquals(200, response.status)
		assertEquals("[${expected}]".toString(), response.contentAsString)
		assertTrue(response.getHeader('Content-Type').startsWith('application/json'))
	}
}