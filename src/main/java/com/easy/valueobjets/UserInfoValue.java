package com.easy.valueobjets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 用户信息
 *
 * @author: daimao
 * @date: 2024-11-21 09:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserInfoValue {
    /**
     * 用户id
     */
    protected String userId;

    /**
     * 用户名
     */
    protected String username;

    /**
     * 邮箱
     */
    protected String email;

    /**
     * 手机号
     */
    protected String mobile;

    /**
     * token
     */
    protected String token;
}
