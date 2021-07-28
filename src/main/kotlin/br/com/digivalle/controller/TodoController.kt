package br.com.digivalle.controller

import br.com.digivalle.domain.Todo
import br.com.digivalle.repository.TodoRepository
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import javax.inject.Inject

@Controller
class TodoController(private val todoRepository: TodoRepository) {

    @Get
    fun getTodos(): List<Todo> {
        return todoRepository.findAll()
    }

    @Post
    fun addTodo(todo: Todo): Todo {
        return todoRepository.save(todo)
    }
}