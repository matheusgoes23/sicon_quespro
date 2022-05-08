package br.edu.ufersa.sicon_quespro.repository;

import br.edu.ufersa.sicon_quespro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
