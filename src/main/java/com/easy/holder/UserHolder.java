package com.easy.holder;

import com.easy.valueobjets.UserInfoValue;

/**
 * 线程本地用户信息
 *
 * @author: daimao
 * @date: 2024-11-21 02:02
 */
@SuppressWarnings("ALL")
public class UserHolder  {

    private UserHolder(){

    }

    /**
     * 用户信息,通用的不满足可以自己继承UserInfoValue
     */
    private static final ThreadLocal<UserInfoValue> USER_INFO_VALUE_THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 获取用户信息
     *
     * @return UserInfoValue
     */
    public static UserInfoValue getUserInfo() {
        return USER_INFO_VALUE_THREAD_LOCAL.get();
    }

    /**
     * 设置用户信息
     *
     * @param userInfoValue UserInfoValue
     */
    public static void setUserInfo(UserInfoValue userInfoValue) {
        USER_INFO_VALUE_THREAD_LOCAL.set(userInfoValue);
    }
}
