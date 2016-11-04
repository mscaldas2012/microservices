package edu.msc.learnmicro.repo;

import edu.msc.learnmicro.config.SpringMongoConfig;
import edu.msc.learnmicro.model.UserAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by caldama on 11/4/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMongoConfig.class)
public class UserAccountRepositoryTest {

    @Autowired
    private UserAccountRepository repository;

    @Test
    public void findByUsername() throws Exception {

    }

    @Test
    public void findByEmail() throws Exception {

    }

    @Test
    public void crateUser() throws Exception {
        UserAccount account = new UserAccount();
        account.setUsername("mscaldas");
        account.setEmail("mscaldas@gmail.com");
        account.setAccountStatus(UserAccount.ACCOUNT_STATUS.ACTIVE);
        account.setFullName("Marcelo Caldas");

       repository.save(account);


    }

}