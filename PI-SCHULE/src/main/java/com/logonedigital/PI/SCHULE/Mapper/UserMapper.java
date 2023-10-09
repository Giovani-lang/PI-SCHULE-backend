package com.logonedigital.PI.SCHULE.Mapper;

import com.logonedigital.PI.SCHULE.Entity.User;
import com.logonedigital.PI.SCHULE.dto.user_dto.UserRequest;
import com.logonedigital.PI.SCHULE.dto.user_dto.UserResponse;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;


@Mapper(componentModel = "spring")
@Configuration
public interface UserMapper {

    User fromUserRequest (UserRequest userRequest);

    UserResponse fromUser (User user);
}
