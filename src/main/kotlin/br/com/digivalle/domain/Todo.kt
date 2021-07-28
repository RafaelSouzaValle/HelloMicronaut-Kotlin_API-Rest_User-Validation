package br.com.digivalle.domain

import io.micronaut.core.annotation.Introspected
import javax.persistence.*

@Entity
@Introspected
class Todo (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @Column
    val description: String,

    @Column
    val done: Boolean,
)

