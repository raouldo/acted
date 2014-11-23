import acted.utils.Account
import acted.utils.AccountRole
import acted.utils.Role



class BootStrap {

	def init = { servletContext ->
		//		new UserOld(email:"sylvain.tenkodogo@gmail.com",password:"password").save()

		def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
		def accountRole = new Role(authority: 'ROLE_ACCOUNT').save(flush: true)

		def testAccount = new Account(username: 'admin', password: 'admin')
		testAccount.save(flush: true)

		AccountRole.create testAccount, adminRole, true

		assert Account.count() == 1
		assert Role.count() == 2
		assert AccountRole.count() == 1
	}

	def destroy = {
	}
}
