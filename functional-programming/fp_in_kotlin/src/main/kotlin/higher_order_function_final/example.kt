package higher_order_function_final

import java.security.InvalidParameterException
import java.util.function.Predicate

data class User(
    val id: Int,
    val name: String,
    var age: Int
)

val users: List<User> = listOf(
    User(1, "ID", 36),
    User(2, "BJ", 32),
    User(3, "JM", 42),
    User(4, "PJ", 27),
    User(5, "HA", 25),
    User(6, "JE", 16),
    User(7, "JI", 24),
    User(8, "MP", 44),
    User(9, "SP", 13),
    User(10, "XQ", 29),
)

fun <T> _filter(list: List<T>, predicate: Predicate<T>): List<T> {
    val filtered_list: MutableList<T> = ArrayList()
    for (element in list) {
        if (predicate.test(element)) {
            filtered_list.add(element)
        }
    }
    return filtered_list
}

fun <T, R> _map(list: List<T>, func: (T) -> R): List<R> {
    val new_list: MutableList<R> = ArrayList()
    for (element in list) {
        new_list.add(func(element))
    }
    return new_list
}

fun <T, R> _curry(func: (T, T) -> R): (T) -> (T) -> R {
    return fun(a: T): (T) -> R {
        return fun(b: T): R {
            return func(a, b)
        }
    }
}

fun <T, R> _curry_right(func: (T, T) -> R): (T) -> (T) -> R {
    return fun(a: T): (T) -> R {
        return fun(b: T): R {
            return func(b, a)
        }
    }
}

fun <T> _reduce(list: List<T>, accumulator: T, func: (T, T) -> T): T {
    var result = accumulator
    for (element in list) {
        result = func(result, element)
    }
    return result
}

fun <T> _reduce(list: List<T>, func: (T, T) -> T): T {
    if (list.isEmpty()) {
        throw InvalidParameterException("list should not be empty")
    }
    var result = list[0]
    val listSliced = list.slice(1..<list.size)
    for (element in listSliced) {
        result = func(result, element)
    }
    return result
}

fun <T> _pipe(vararg funcs: (T) -> T): (T) -> T {
    return fun(param: T): T {
        var result = param
        for (func in funcs) {
            result = func(result)
        }
        return result
    }
}

fun <T> _pipe_on(param: T, vararg funcs: (T) -> T): T {
    return _pipe(*funcs)(param)
}

fun run_something_funny() {
    users
        .run { _filter(this) { user -> user.age >= 30 } }
        .run { _map(this) { user -> user.name } }
        .run { println(this) }
    users
        .run { _filter(this) { user -> user.age < 30 } }
        .run { _map(this) { user -> user.age } }
        .run { println(this) }
}
