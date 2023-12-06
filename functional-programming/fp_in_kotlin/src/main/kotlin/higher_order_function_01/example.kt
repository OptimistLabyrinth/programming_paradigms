package higher_order_function_01

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

val users_age_at_least_thirty: MutableList<User> = ArrayList()
fun get_users_age_at_least_thirty() {
    for (user in users) {
        if (user.age >= 30) {
            users_age_at_least_thirty.add(user)
        }
    }
}

val names_of_users_age_at_least_thirty: MutableList<String> = ArrayList()
fun get_names_of_users_age_at_least_thirty() {
    for (user in users_age_at_least_thirty) {
        names_of_users_age_at_least_thirty.add(user.name)
    }
}

val users_age_less_than_thirty: MutableList<User> = ArrayList()
fun get_users_age_less_than_thirty() {
    for (user in users) {
        if (user.age < 30) {
            users_age_less_than_thirty.add(user)
        }
    }
}

val ages_of_users_age_less_than_thirty: MutableList<Int> = ArrayList()
fun get_ages_of_users_age_less_than_thirty() {
    for (user in users_age_less_than_thirty) {
        ages_of_users_age_less_than_thirty.add(user.age)
    }
}

fun run_something_funny() {
    get_users_age_at_least_thirty()
    get_names_of_users_age_at_least_thirty()
    println(names_of_users_age_at_least_thirty)
    get_users_age_less_than_thirty()
    get_ages_of_users_age_less_than_thirty()
    println(ages_of_users_age_less_than_thirty)
}
