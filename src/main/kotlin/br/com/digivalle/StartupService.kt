package br.com.digivalle

import br.com.digivalle.domain.User
import br.com.digivalle.repository.UserRepository
import io.micronaut.context.event.StartupEvent
import io.micronaut.runtime.event.annotation.EventListener
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class StartupService(private val userRepository: UserRepository) {

    private val log = LoggerFactory.getLogger(StartupService::class.java)

    @EventListener
    fun onStartupvEvent(event: StartupEvent) {
        val user = userRepository.save(User(
            888,
            "123123"
        ))
        log.info("Usuário adicionado: {}", user)
    }
}