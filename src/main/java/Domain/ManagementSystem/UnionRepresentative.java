package Domain.ManagementSystem;

import java.io.Serializable;

public class UnionRepresentative extends EnrolledUser implements Serializable {
    public UnionRepresentative(String userName, String password, String name) {
        super(userName, password, name);
    }
}
