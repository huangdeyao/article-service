package com.dy.oauth2service.social;

import lombok.Data;



/**
 *
 * @author root
 */
@Data
public class SocialUserInfo {

    private String providerId;

    private String providerUserId;

    private String nickname;

    private String headImg;

}
