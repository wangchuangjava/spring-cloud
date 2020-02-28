package com.wc.util;

import com.wc.entity.User;
import com.wc.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class EntityToModelUtil {
    public static List<UserModel> entityToModel(List<User> list) {
        List<UserModel> userModelList = new ArrayList<>();
        list.forEach(t -> userModelList.add(UserModel.builder().id(t.getId()).name(t.getName()).address(t.getAddress()).groupId(t.getGroupId()).build()));
        return userModelList;
    }
}
