package edu.msc.learnmicro.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Created by caldama on 11/4/16.
 */
@Data
public class UserAccount {
    public enum ACCOUNT_STATUS { ACTIVE, CLOSED, SUSPENDED}
    @Id
    private long id;
    private String username;
    private String fullName;
    private String email;
    private ACCOUNT_STATUS accountStatus;

}
