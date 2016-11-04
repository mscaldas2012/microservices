package edu.msc.learnmicro.config;

import com.mongodb.MongoClient;
import edu.msc.learnmicro.repo.UserAccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by caldama on 11/4/16.
 */
@Configuration
@EnableMongoRepositories(basePackageClasses = UserAccountRepository.class)
public class SpringMongoConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "test";
    }

    @Bean
    public MongoClient mongo() throws Exception {

        MongoClient client = new MongoClient("localhost");
        return client;
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), getDatabaseName());
    }

}
