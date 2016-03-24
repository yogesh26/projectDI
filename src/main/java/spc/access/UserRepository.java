package spc.access;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by YogeshK on 2015-07-22.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}