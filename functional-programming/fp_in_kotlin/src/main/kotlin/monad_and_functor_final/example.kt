package monad_and_functor_final

private data class number_with_logs(
    var result: Int = 0,
    var logs: List<String> = ArrayList()
)

private fun wrap_with_logs(x: Int): number_with_logs {
    return number_with_logs(x)
}

private fun square(x: Int): number_with_logs {
    return number_with_logs(
        result = x * x,
        logs = listOf("Squared ${x} to get ${x * x}")
    )
}

private fun add_one(x: Int): number_with_logs {
    return number_with_logs(
        result = x + 1,
        logs = listOf("Added 1 to ${x} to get ${x + 1}")
    )
}

private fun minus_five(x: Int): number_with_logs {
    return number_with_logs(
        result = x - 5,
        logs = listOf("Subtracted 5 from ${x} to get ${x - 5}")
    )
}

private fun multiply_three(x: Int): number_with_logs {
    return number_with_logs(
        result = x * 3,
        logs = listOf("Multiply by 3 to ${x} to get ${x * 3}")
    )
}

private fun add_twelve(x: Int): number_with_logs {
    return number_with_logs(
        result = x + 12,
        logs = listOf("Added 12 to ${x} to get ${x + 12}")
    )
}

private fun run_with_logs(
    input: number_with_logs,
    transform: (_: Int) -> number_with_logs
): number_with_logs {
    val new_umber_with_logs = transform(input.result)
    return number_with_logs(
        result = new_umber_with_logs.result,
        logs = input.logs + new_umber_with_logs.logs
    )
}

fun run_something_funny() {
    val result01 = wrap_with_logs(2)
        .run { run_with_logs(this) { x -> square(x) } }
        .run { run_with_logs(this) { x -> add_one(x) } }
        .run { run_with_logs(this) { x -> minus_five(x) } }
        .run { run_with_logs(this) { x -> multiply_three(x) } }
        .run { run_with_logs(this) { x -> add_twelve(x) } }
    val result02 = wrap_with_logs(3)
        .run { run_with_logs(this) { x -> add_one(x) } }
        .run { run_with_logs(this) { x -> multiply_three(x) } }
        .run { run_with_logs(this) { x -> add_twelve(x) } }
        .run { run_with_logs(this) { x -> square(x) } }
    println(result01.result)
    println(result02.result)
}
