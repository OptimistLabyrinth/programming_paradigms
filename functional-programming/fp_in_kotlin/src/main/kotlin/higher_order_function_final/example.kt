package higher_order_function_final

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
    _each(list) { element -> { if (predicate.test(element)) filtered_list.add(element) } }
    return filtered_list
}

fun <T, R> _map(list: List<T>, func: (T) -> R): List<R> {
    val new_list: MutableList<R> = ArrayList()
    _each(list) { element -> func(element) }
    return new_list
}

fun <T, R> _each(list: List<T>, func: (T) -> R) {
    for (element in list) {
        func(element)
    }
}

fun run_something_funny() {
    val users_age_at_least_thirty = _filter(users) { user -> user.age >= 30 }
    val names_of_users_age_at_least_thirty = _map(users_age_at_least_thirty) { user -> user.name }
    println(names_of_users_age_at_least_thirty)
    val users_age_less_than_thirty = _filter(users) { user -> user.age < 30 }
    val ages_of_users_age_less_than_thirty = _map(users_age_less_than_thirty) { user -> user.age }
    println(ages_of_users_age_less_than_thirty)
    println(_filter(listOf(1, 2, 3, 4)) { num -> num % 2 == 0 })
    println(_filter(listOf(1, 2, 3, 4)) { num -> num % 2 != 0 })
}
