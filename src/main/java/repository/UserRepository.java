package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shop.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
