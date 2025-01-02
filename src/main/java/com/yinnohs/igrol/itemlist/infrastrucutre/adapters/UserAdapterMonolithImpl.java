package com.yinnohs.igrol.itemlist.infrastrucutre.adapters;

import com.yinnohs.igrol.itemlist.domain.ports.out.UserAdapter;
import com.yinnohs.igrol.user.domain.model.User;
import com.yinnohs.igrol.user.domain.port.in.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAdapterMonolithImpl implements UserAdapter {

    private final UserService userService;

    @Override
    public User findUserById(String userId) {
        return userService.findBy("id", userId);
    }
}
