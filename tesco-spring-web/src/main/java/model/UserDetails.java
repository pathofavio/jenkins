package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class UserDetails {
    private String uname;
    private String pass;
    private String cname;
    private String ename;
}
