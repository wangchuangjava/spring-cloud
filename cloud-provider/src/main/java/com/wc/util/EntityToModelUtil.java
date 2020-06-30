package com.wc.util;

import com.wc.entity.User;
import com.wc.model.UserModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 王创
 * @Description 实体转VO
 * @Date 10:40 2020/6/30
 **/
public class EntityToModelUtil {
    public static List<UserModel> entityToModel(List<User> list) {
        List<UserModel> userModelList = new ArrayList<>();
        list.forEach(t -> userModelList.add(UserModel.builder().id(t.getId()).name(t.getName()).address(t.getAddress()).groupId(t.getGroupId()).build()));
        return userModelList;
    }
}
