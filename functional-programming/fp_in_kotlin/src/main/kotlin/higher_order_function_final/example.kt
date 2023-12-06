package higher_order_function_final

import java.lang.Exception
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

fun run_something_funny() {
    val add = _curry { a: Int, b -> a + b }
    val mul = _curry { a: Int, b -> a * b }
    val add5 = add(5)
    val mul7 = mul(7)
    println(add(5)(-2) == add5(-2))
    println(mul(7)(3) == mul7(3))
    val sub = _curry_right { a: Int, b -> a - b }
    val div = _curry_right { a: Int, b -> a / b }
    val sub5 = sub(5)
    val div2 = div(2)
    println(sub(5)(10) == sub5(10))
    println(div(2)(18) == div2(18))
    val sum1 = _reduce(listOf(1, 2, 3, 4), 0) { a: Int, b -> a + b }
    val sum2 = _reduce(listOf(1, 2, 3, 4)) { a: Int, b -> a + b }
    val product1 = _reduce(listOf(2, 5, 10), 1) { a: Int, b -> a * b }
    val product2 = _reduce(listOf(2, 5, 10)) { a: Int, b -> a * b }
    println(sum1)
    println(sum2)
    println(product1)
    println(product2)
    try {
        val empty1 = _reduce(listOf(), 0) { a: Int, b -> a + b }
        val empty2 = _reduce(listOf()) { a: Int, b -> a + b }
        println(empty1)
        println(empty2)
    } catch (ex: Exception) {
        println(ex)
    }
}
