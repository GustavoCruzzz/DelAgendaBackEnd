package com.gustavocruz.DelAgenda.repositories;

import com.gustavocruz.DelAgenda.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Deve retornar um usuário por login com sucesso")
    void shouldFindUserByLogin() {

        User user = new User("gustavo", "12345");
        userRepository.save(user);

        UserDetails result = userRepository.findByLogin("gustavo");

        assertThat(result).isNotNull();
        assertThat(result.getUsername()).isEqualTo("gustavo");
    }

    @Test
    @DisplayName("Deve retornar null quando login não for encontrado")
    void shouldReturnNullIfUserNotFound() {
        UserDetails result = userRepository.findByLogin("naoExiste");

        assertThat(result).isNull();
    }
}
