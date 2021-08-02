package br.com.digivalle.configuration

import br.com.digivalle.repository.UserRepository
import io.micronaut.http.HttpRequest
import io.micronaut.security.authentication.*
import io.reactivex.Flowable
import org.reactivestreams.Publisher
import java.lang.Long
import javax.inject.Singleton

@Singleton
class UserAuthenticationProvider(private val userRepository: UserRepository): AuthenticationProvider {
    override fun authenticate(
        httpRequest: HttpRequest<*>?,
        authenticationRequest: AuthenticationRequest<*, *>?
    ): Publisher<AuthenticationResponse> {
        val user = userRepository.findById(Long.parseLong(authenticationRequest?.identity as String))
        if (user.isPresent) {
            if (user.get().password.equals(authenticationRequest.secret))
                return Flowable.just(UserDetails(user.get().cpf.toString(), listOf()))
            return Flowable.error(AuthenticationException(AuthenticationFailed(AuthenticationFailureReason.CREDENTIALS_DO_NOT_MATCH)))
        } else {
            return Flowable.error(AuthenticationException(AuthenticationFailed(AuthenticationFailureReason.CREDENTIALS_DO_NOT_MATCH)))
        }
    }
}