package br.com.digivalle.repository

import br.com.digivalle.domain.User
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
abstract class UserRepository: JpaRepository<User, Long> {
}