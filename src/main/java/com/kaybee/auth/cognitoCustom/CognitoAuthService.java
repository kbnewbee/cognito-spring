package com.kaybee.auth.cognitoCustom;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AdminInitiateAuthRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AdminInitiateAuthResponse;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AuthFlowType;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AuthenticationResultType;

@Service
public class CognitoAuthService {

  CognitoIdentityProviderClient cognitoClient;
  String clientId = "38aqcvvbbslcvl1iocha8o1ksg";
  String clientSecret = "ss70mri0lge4m63a71vokbcjfls3eooh8mmtmfla9vb6ogu2ii1";
  String userPoolId = "us-east-1_Bftm8ki6c";
  final static String HMAC_SHA256_ALGORITHM = "HmacSHA256";

  public CognitoAuthService() {
    this.cognitoClient = CognitoIdentityProviderClient.builder()
        .region(Region.US_EAST_1)
        .build();
  }

  private String calculateSecretHash(String userName) {

    SecretKeySpec signingKey = new SecretKeySpec(
        clientSecret.getBytes(StandardCharsets.UTF_8),
        HMAC_SHA256_ALGORITHM);
    try {
      Mac mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
      mac.init(signingKey);
      mac.update(userName.getBytes(StandardCharsets.UTF_8));
      byte[] rawHmac = mac.doFinal(clientId.getBytes(StandardCharsets.UTF_8));
      return Base64.getEncoder().encodeToString(rawHmac);
    } catch (Exception e) {
      throw new RuntimeException("Error while calculating ");
    }
  }

  public String authenticateAndGetToken(String username, String password) {
    String secret_hash = calculateSecretHash(username);

    Map<String, String> authParameters = new HashMap<>();
    authParameters.put("USERNAME", username);
    authParameters.put("PASSWORD", password);
    authParameters.put("SECRET_HASH", secret_hash);

    AdminInitiateAuthRequest authRequest = AdminInitiateAuthRequest.builder()
        .clientId(clientId)
        .userPoolId(userPoolId)
        .authParameters(authParameters)
        .authFlow(AuthFlowType.ADMIN_NO_SRP_AUTH)
        .build();

    AdminInitiateAuthResponse adminInitiateAuthResponse = cognitoClient.adminInitiateAuth(
        authRequest);
    Optional<AuthenticationResultType> authenticationResult = adminInitiateAuthResponse.getValueForField(
        "AuthenticationResult",
        AuthenticationResultType.class);
    Optional<String> accessToken = authenticationResult.get()
        .getValueForField("AccessToken", String.class);

    System.out.println(accessToken.get());

    return accessToken.get();
  }


}
