package user;

import com.alex.RestForUsers.dto.RoleMappingService;
import com.alex.RestForUsers.model.Roles;
import com.alex.RestForUsers.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class UserMappingServiceTest {
    RoleMappingService roleMappingService = new RoleMappingService();


    @Test
    void toUserDtoWithoutRoles() {
        User user = new User("login1", "name1", "password1");

        Roles role1 = new Roles("role1");
        role1.setRoleId();
        Roles role2 = new Roles("role2");
        role2.setRoleId();
        Roles role3 = new Roles("role3");
        role3.setRoleId();
    }
}
