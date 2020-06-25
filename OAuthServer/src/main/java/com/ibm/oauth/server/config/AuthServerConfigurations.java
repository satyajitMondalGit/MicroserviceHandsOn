package com.ibm.oauth.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AuthServerConfigurations extends WebSecurityConfigurerAdapter implements AuthorizationServerConfigurer {

	
	private String clientId = "GroceryStore";
	private String clientSecret = "Welcome-To-Store";
	private String privateKey = "-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIEpAIBAAKCAQEAvf0By4V2N30NGQMjgfkP7JMaHl5vxcUgT1J3uSwrMUgnXkmA\r\n"
			+ "ZoxSCyOhw4dc3OSmGw7WPP31OqH9Oz1PijvDFYBwi7VVoRRumq5eHVzxwHYgPB/0\r\n"
			+ "to+D4baOBxrjk+EKCLZpEpof4yf8Qy0jtVjYgUzEWUOiZecXoop/Q9HrBqrqw4Hj\r\n"
			+ "8Ln/U9T38CS7V0yVHZTVWgBRcvnA5nJMdSqjchz7cGVRVycld9FbN2fuJ+Qx7mtj\r\n"
			+ "62soe4gQi2C8pL85PynBlXdYHeZCZGwARgGjOb0V2j2PSHwCq1V9qHd/M+rTPiRZ\r\n"
			+ "bu0DTig9gf2BWd7NTkqDCcMqlomMYi4fNUdDsQIDAQABAoIBAAn1N+Hd9etEn6oe\r\n"
			+ "8v59+mqw7x6GXp9kDKR7sxC+kuj7Wizj91nooug4juL7tk9RoK8sYOhDe1X+ZZJ0\r\n"
			+ "TTX2mewHll6MO5e8xWtQFli9pWIsDtZ36lCjRwtOkTUoIKOAmREJ1ooGEAPM9bjj\r\n"
			+ "pcp8hKSKTIRNOjbTHPcFAVShrQrlVVbxV/2fXyxmpwoqr5Pt0yMNhQqzA726cyn+\r\n"
			+ "x1kjctHe6cmyxPjhjgxF0DOsvdDL/ViFL5fO/iLkW8Xf2lSzk5kJdtqJekSA98L+\r\n"
			+ "+PSeJViiFdMXz+KTBCCv1834fVLlW0uDtWQ4OhuV9+Fk1vPsZRBu1kiMklvcRYR7\r\n"
			+ "MPHWW8ECgYEA4XF0H3FWT0TwgtIGtrJR+R5G/S/pMgc+BuBrzt5CY/SVrZKgrTH2\r\n"
			+ "89kpGEDkacBC+HbQ2Gt8VVwB751PLLQw9SOEEk5xlokx7o4mHM2w/+Th86BOoRvA\r\n"
			+ "7qFSI65rQ9noRsnLUOw9KDOkiZaV4qrDhqmAhNV1SJr2HR02oV05wmkCgYEA171S\r\n"
			+ "VlltnXGBJ5+ENq5DyjaN2yERgBn2iVMEFIM/TG8qK8MLw7I6e9yGZBdPT9K9T306\r\n"
			+ "ZZDhozX+g7w86/Bp3+XonjXuXok1r7s9UlJyn/6FiuxgvBBX57e8z/d98CANRCxH\r\n"
			+ "rOwYsNxadGVG84NoaYj/cy7Mzxhe8IR8RE6aPgkCgYEAmiWkG9e4By2BMkH/Wy5k\r\n"
			+ "hGziZz46Of3fuH382Q754DSdn3gRqzrtu2AyDCZax8AxSoibVk9wTUFDBZ7PQybW\r\n"
			+ "DtfA929xlVerr4y8nJc8Pkw2/wkOmnRKoB/n9QPOzi8R9k0GWwec7X8aMwWm6LyQ\r\n"
			+ "QuRlPu5hakqim9ecwgrncnkCgYEAou9BOCXiO3515M78s695U0dQa6bV6MGzCJPC\r\n"
			+ "CRv2umtaliKAyBPbR6CNfxp7s/WdNGOHrx10zCcDScro1+iCja69uH9Sv+MwwL/Q\r\n"
			+ "2FOcbmlzwjAz/tT5DvAdkZOBcdFDM7GdkGPfYfOJ/U5f/5nHSa1GAF/gHqhxS4VD\r\n"
			+ "tPMIWsECgYAmdQAZ4OF9Cbmnj6t377aodJafu7b7BkSzAG21v5f51J9UjcYL6a8g\r\n"
			+ "SqFZP8mjGdJg3ZMMFk1DIEBl9yuzyBCsDjfQH17lyjFLPectTlzu4aoy44UxtPrq\r\n"
			+ "73CLghDsxBCZPTMAZx/7O9Zk2rxlrOI/IjZ2+Zvpr2KAAKuDyLXg9w==\r\n" + "-----END RSA PRIVATE KEY-----";
	private String publicKey = "-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvf0By4V2N30NGQMjgfkP\r\n"
			+ "7JMaHl5vxcUgT1J3uSwrMUgnXkmAZoxSCyOhw4dc3OSmGw7WPP31OqH9Oz1PijvD\r\n"
			+ "FYBwi7VVoRRumq5eHVzxwHYgPB/0to+D4baOBxrjk+EKCLZpEpof4yf8Qy0jtVjY\r\n"
			+ "gUzEWUOiZecXoop/Q9HrBqrqw4Hj8Ln/U9T38CS7V0yVHZTVWgBRcvnA5nJMdSqj\r\n"
			+ "chz7cGVRVycld9FbN2fuJ+Qx7mtj62soe4gQi2C8pL85PynBlXdYHeZCZGwARgGj\r\n"
			+ "Ob0V2j2PSHwCq1V9qHd/M+rTPiRZbu0DTig9gf2BWd7NTkqDCcMqlomMYi4fNUdD\r\n" + "sQIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";
	
	
	@Bean
	public JwtAccessTokenConverter tokenEnhancer() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(privateKey);
		converter.setVerifierKey(publicKey);
		return converter;
	}


	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(tokenEnhancer());
	}
	
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Autowired
	AuthenticationManager authenticationManager;

	PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

		security.checkTokenAccess("permitAll()").checkTokenAccess("isAuthenticated()");

	}

	@Override
	public void configure(ClientDetailsServiceConfigurer client) throws Exception {

		client.inMemory().withClient("store").secret(passwordEncoder.encode("storepass")).scopes("READ", "WRITE")
				.authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(3600).refreshTokenValiditySeconds(36000);

	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoint) throws Exception {
		endpoint.authenticationManager(authenticationManager).tokenStore(tokenStore()).accessTokenConverter(tokenEnhancer());

	}
}
