package br.com.livraria_dh.catalogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.livraria_dh.catalogo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.username =:username")
	User findByUserName(@Param("username") String username);
}
