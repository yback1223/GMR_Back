package GMR_Back.gmr;

import GMR_Back.gmr.entity.User;
import GMR_Back.gmr.mapper.UserMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@SpringBootTest
@Transactional
class GmrApplicationTests {
	
 	@Autowired
 	private UserMapper userMapper;

	@Test
	public void testInsertAndDeleteUser() {
		User testUser = new User("yoyob1223@naver.com", "123123", "Yong Min Back", "01073803307", 84, 187, "normal", new Timestamp(System.currentTimeMillis()));
		userMapper.insert(testUser);

		User foundUser = userMapper.findById(testUser.getId());
		Assertions.assertThat(testUser.getId()).isEqualTo(foundUser.getId());
		Assertions.assertThat(userMapper.findAll().size()).isEqualTo(1);

		userMapper.deleteById(foundUser.getId());
		Assertions.assertThat(userMapper.findAll().size()).isEqualTo(0);
	}
}
