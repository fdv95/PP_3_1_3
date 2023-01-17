package ru.fadeev.pp_3_1_2.util;

import org.springframework.stereotype.Component;
import ru.fadeev.pp_3_1_2.model.Role;
import ru.fadeev.pp_3_1_2.model.User;
import ru.fadeev.pp_3_1_2.service.RoleService;
import ru.fadeev.pp_3_1_2.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class Init {
    private final UserService userService;

    private final RoleService roleService;

    public Init(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @PostConstruct
    public void initializeDB() {
        List<User> users = userService.getUsersList();

            roleService.addRole(new Role("ROLE_ADMIN"));
            roleService.addRole(new Role("ROLE_USER"));

            Role admin = roleService.getRoleById(1L);
            Role user = roleService.getRoleById(2L);

            Set<Role> adminRole = new HashSet<>();
            Set<Role> userRole = new HashSet<>();

            adminRole.add(admin);
            userRole.add(user);

            userService.addUser(new User( "FirstName","LastName",20,"admin",
//                    "$2y$10$FCsKDohUtyblSqTWkb2NmOFMPFm/WrYUiYnjznTxvjkUINfLWK9CK", adminRole ));
                    "admin", adminRole ));
            userService.addUser(new User( "FirstName","LastName",20,"user1",
//                    "$2y$10$wpdg0REbgPY1CyeqYz8Tl.cgvVtEEEPc5yPZ3v..xNTxMb340bG/u", userRole ));
                    "user1", userRole ));

    }
}
