package user;

import com.alex.RestForUsers.dto.RoleMappingService;
import com.alex.RestForUsers.dto.RolesDTO;
import com.alex.RestForUsers.model.Roles;
import com.alex.RestForUsers.model.User;
import com.alex.RestForUsers.repository.UserRepository;
import com.alex.RestForUsers.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    UserRepository userRepository;
    @Mock
    RoleMappingService roleService;

    @Captor
    ArgumentCaptor<User> userCaptor;

    @InjectMocks
    @Spy
    UserService userService;

    @Test
    void addUser() {
        Roles role1 = new Roles("role1");
        role1.setRoleId();
        Roles role2 = new Roles("role2");
        role2.setRoleId();
        Roles role3 = new Roles("role3");
        role3.setRoleId();

        Set<Roles> roles = Set.of(role1, role2, role3);


        when(userRepository.existsById(any())).thenReturn(false);


        verify(userRepository, times(1)).save(userCaptor.capture());

        User user = userCaptor.getValue();
        Assertions.assertEquals(roles, user.getRoles());
    }


    @Test
    void updateUser() {
        Roles role1 = new Roles("role1");
        role1.setRoleId();
        Roles role2 = new Roles("role2");
        role2.setRoleId();
        Roles role3 = new Roles("role3");
        role3.setRoleId();

        Set<Roles> roles = Set.of(role1, role2, role3);

        Set<RolesDTO> newRolesDto = Set.of(new RolesDTO("role3"), new RolesDTO("role57"));

        Roles role57 = new Roles("role3");
        role3.setRoleId();

        Set<Roles> newRoles = Set.of(role3, role57);


        verify(userRepository, times(1)).save(userCaptor.capture());

        User updatedUser = userCaptor.getValue();

    }
}
