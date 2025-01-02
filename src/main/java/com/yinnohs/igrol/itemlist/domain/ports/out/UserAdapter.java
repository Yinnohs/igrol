package com.yinnohs.igrol.itemlist.domain.ports.out;

import com.yinnohs.igrol.user.domain.model.User;

public interface UserAdapter {
    User findUserById(String userId);
}
