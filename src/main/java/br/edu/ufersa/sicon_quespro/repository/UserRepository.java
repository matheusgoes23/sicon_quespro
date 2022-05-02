package br.edu.ufersa.sicon_quespro.repository;

import br.edu.ufersa.sicon_quespro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
