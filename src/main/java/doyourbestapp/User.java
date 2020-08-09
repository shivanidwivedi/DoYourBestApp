package doyourbestapp;

import java.util.Objects;

/**
 * @author shivanidwivedi on 29/07/20
 * @project DoYourBest
 */
public class User {
    int userId;
    int age;
    String email;
    String userName;

   @Override
    public boolean equals(Object o){
       if (this == o) return true;
       if (o == null || getClass() != o.getClass()) return false;
       User user = (User) o;
       return userId == user.userId ;
   }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
