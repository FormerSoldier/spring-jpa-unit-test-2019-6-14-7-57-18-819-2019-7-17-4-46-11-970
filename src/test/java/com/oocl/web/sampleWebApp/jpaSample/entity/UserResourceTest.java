package com.oocl.web.sampleWebApp.jpaSample.entity;

import com.oocl.web.sampleWebApp.jpaSample.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserResourceTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test_should_return_user_when_the_save_user() {
        //given
        User user = new User("adsfad");
        user.setName("test");
        userRepository.save(user);

        //when
        User user1 = userRepository.save(user);

        //then
        Assertions.assertEquals("test", user1.getName());
    }

    @Test
    public void test_should_return_fail_when_save() throws Exception{
        String longName = "aajfkdslhfjkahgfajksdgflksjagfsjkagfalskjghfakjlshd;lkhasflkjhalkjdgaljkfkahsdf;laskhfkaj;ldlafhakjlshfa;kjhfalfhaljkgfljkagfaljkfglajkfhsalkdj";
////        User user = new User(longName+longName);
//
        Throwable exception = assertThrows(IllegalArgumentException.class, ()-> {
            new User(longName + longName);
        });
        assertEquals("bad name",  exception.getMessage());
    }


}