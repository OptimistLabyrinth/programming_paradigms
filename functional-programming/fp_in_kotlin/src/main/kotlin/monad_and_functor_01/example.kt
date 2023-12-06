package monad_and_functor_01

private fun square(x: Int): Int {
    return x * x
}

private fun add_one(x: Int): Int {
    return x + 1
}

fun run_something_funny() {
    val result01 = add_one(square(2))
    val result02 = square(add_one(3))
    println(result01)
    println(result02)
}
