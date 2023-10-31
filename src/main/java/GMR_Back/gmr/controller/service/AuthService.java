package GMR_Back.gmr.controller.service;

import GMR_Back.gmr.model.repository.UserRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.util.HashMap;
import java.util.Map;


@Service
public class AuthService {

    private UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String authenticateWithKakao(String accessToken) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "Bearer " + accessToken);

        HttpEntity<String> httpEntity = new HttpEntity<>("parameters", httpHeaders);

        String kakaoApiUrl = "https://kapi.kakao.com/v2/user/me";
        HttpEntity<String> httpResponse = restTemplate.exchange(kakaoApiUrl, HttpMethod.GET, httpEntity, String.class);

        getUserInfo(httpResponse.getBody());
        return httpResponse.getBody();
    }

    private Map<String, String> getUserInfo(String httpResponseBody) {
        JSONObject jsonKakaoAccount = new JSONObject(httpResponseBody).getJSONObject("kakao_account");
        Map<String, String> responseInfo = new HashMap<>();

        responseInfo.put("email", jsonKakaoAccount.getString("email"));
        responseInfo.put("nickname", jsonKakaoAccount.getJSONObject("profile").getString("nickname"));


        return responseInfo;
    }
}
