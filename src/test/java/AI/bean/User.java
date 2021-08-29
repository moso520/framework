package AI.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User {
    public String userid;
    public String name;
    public String alias;
    public String mobile;
    public List<Integer> department;
    public List<Integer> order;
    public String position;
    public String gender;
    public String email;
    public List<Integer> is_leader_in_dept;
    public String enable;
//    public String avatar_mediaid;
    public String telephone;
    public String address;
    public Integer main_department;
    public Boolean to_invite;
    public String external_position;
}
