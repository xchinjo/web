package br.com.bjbraz.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bjbraz.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

  Optional<Usuario> findById(Long id);
  
  Usuario findByNomeAndPassword(String nome, String password);
  
  Usuario findByNome(String nome);
  
  Usuario findByEmail(String email);

}
