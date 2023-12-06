package monad_and_functor_final

private data class number_with_logs(
    var result: Int = 0,
    var logs: List<String> = ArrayList()
)

private fun wrap_with_logs(x: Int): number_with_logs {
    return number_with_logs(x)
}

private fun square(x: number_with_logs): number_with_logs {
    return number_with_logs(
        result = x.result * x.result,
        logs = x.logs + listOf("Squared ${x.result} to get ${x.result * x.result}")
    )
}

private fun add_one(x: number_with_logs): number_with_logs {
    return number_with_logs(
        result = x.result + 1,
        logs = x.logs + listOf("Added 1 to ${x.result} to get ${x.result + 1}")
    )
}

fun run_something_funny() {
    val result01 = add_one(square(wrap_with_logs(2)))
    val result02 = square(add_one(wrap_with_logs(3)))
    println(result01.result)
    println(result02.result)
}
