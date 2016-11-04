package edu.msc.learnmicro.repo;

import edu.msc.learnmicro.model.UserAccount;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * Created by caldama on 11/4/16.
 */
public interface UserAccountRepository extends MongoRepository<UserAccount, Long> {
     UserAccount findByUsername(String username);
     UserAccount findByEmail(String email);


}
