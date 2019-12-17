package br.com.trustion.digital.config.auth.token;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import br.com.trustion.digital.config.auth.UserPrincipal;

public class CustomTokenEnhancer implements TokenEnhancer{
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		UserPrincipal userAuth = (UserPrincipal) authentication.getPrincipal();
		
		Map<String, Object> addInfo = new HashMap<>();
		addInfo.put("user_uuid", userAuth.getUser().getUuid());
		addInfo.put("user_company", userAuth.getUser().getCompany().getCorporateName());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(addInfo);
		return accessToken;
	}

}
