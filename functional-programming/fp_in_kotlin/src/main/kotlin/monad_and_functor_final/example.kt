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

private fun minus_five(x: number_with_logs): number_with_logs {
    return number_with_logs(
        result = x.result - 5,
        logs = x.logs + listOf("Subtracted 5 from ${x.result} to get ${x.result - 5}")
    )
}

private fun multiply_three(x: number_with_logs): number_with_logs {
    return number_with_logs(
        result = x.result * 3,
        logs = x.logs + listOf("Multiply by 3 to ${x.result} to get ${x.result * 3}")
    )
}

private fun add_twelve(x: number_with_logs): number_with_logs {
    return number_with_logs(
        result = x.result + 12,
        logs = x.logs + listOf("Added 12 to ${x.result} to get ${x.result + 12}")
    )
}

fun run_something_funny() {
    val result01 = wrap_with_logs(2)
        .run { square(this) }
        .run { add_one(this) }
        .run { minus_five(this) }
        .run { multiply_three(this) }
        .run { add_twelve(this) }
    val result02 = wrap_with_logs(3)
        .run { add_one(this) }
        .run { multiply_three(this) }
        .run { add_twelve(this) }
        .run { square(this) }
    println(result01.result)
    println(result02.result)
}

fun run_something_funny_before() {
    val result01 = add_twelve(multiply_three(minus_five(add_one(square(wrap_with_logs(2))))))
    val result02 = square(add_twelve(multiply_three(add_one(wrap_with_logs(3)))))
    println(result01.result)
    println(result02.result)
}
