
 * package com.neosoft.poc3.serviceImpl;
 * 
 * import static org.junit.Assert.assertEquals; import static
 * org.mockito.Mockito.when;
 * 
 * import java.util.List; import java.util.Map; import
 * java.util.stream.Collectors; import java.util.stream.Stream;
 * 
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.mockito.InjectMocks; import org.mockito.Mock; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * import com.neosoft.poc3.dao.UserRepository; import
 * com.neosoft.poc3.exception.ResourceNotFoundException; import
 * com.neosoft.poc3.model.User; import com.sun.el.stream.Optional;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @SpringBootTest public class UserSericeImplTest {
 * 
 * @InjectMocks UserSericeImpl service;
 * 
 * @Mock UserRepository repository;
 * 
 * @Test public void getAll() {
 * 
 * List<User> list = Stream .of(new User(1, "vitthal", "wankhade", 444303,
 * "vv@gmail.com", "12/12/12", "12/12/12", 12), new User(1, "vitthal",
 * "wankhade", 444303, "vv@gmail.com", "12/12/12", "12/12/12", 12))
 * .collect(Collectors.toList());
 * 
 * when(repository.findAll()).thenReturn(list);
 * 
 * assertEquals(2, service.getAll().size());
 * 
 * }
 * 
 * @Test public void saveUserTest() { User user = new User(1, "vitthal",
 * "wankhade", 444303, "vv@gmail.com", "12/12/12", "12/12/12", 12);
 * when(repository.save(user)).thenReturn(user); assertEquals(user,
 * service.createUser(user));
 * 
 * }
 * 
 * @Test public void getUserByid() { User user = new User(1, "vitthal",
 * "wankhade", 444303, "vv@gmail.com", "12/12/12", "12/12/12", 12);
 * when(repository.findAllActiveUsersNative(1)).thenReturn(user);
 * 
 * }
 * 
 * @Test public void deleteUserById() {
 * 
 * User user = new User(1, "vitthal", "wankhade", 444303, "vv@gmail.com",
 * "12/12/12", "12/12/12", 12);
 * 
 * when(repository.deleteById(1)).thenReturn(user);
 * 
 * }
 * 
 * @Test public void findByFirstname() {
 * 
 * List<User> list = Stream .of(new User(1, "vitthal", "wankhade", 444303,
 * "vv@gmail.com", "12/12/12", "12/12/12", 12), new User(1, "vitthal",
 * "wankhade", 444303, "vv@gmail.com", "12/12/12", "12/12/12", 12))
 * .collect(Collectors.toList());
 * 
 * when(repository.findByFirstName("vitthal")).thenReturn(list);
 * 
 * }
 * 
 * @Test public void findByPinCode() {
 * 
 * List<User> list = Stream .of(new User(1, "vitthal", "wankhade", 444303,
 * "vv@gmail.com", "12/12/12", "12/12/12", 12), new User(1, "vitthal",
 * "wankhade", 444303, "vv@gmail.com", "12/12/12", "12/12/12", 12))
 * .collect(Collectors.toList());
 * 
 * when(repository.findByPinCode(444303)).thenReturn(list);
 * 
 * }
 * 
 * }
 
