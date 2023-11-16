package monad_and_functor_01

private fun square(x: Int): Int {
    return x * x
}

private fun addOne(x: Int): Int {
    return x + 1
}

fun runSomethingFunny() {
    val result01 = addOne(square(2))
    val result02 = square(addOne(3))
    println(result01)
    println(result02)
}
