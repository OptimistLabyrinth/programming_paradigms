package monad_and_functor_04

private data class NumberWithLogs(
    var result: Int = 0,
    var logs: List<String> = ArrayList()
)

private fun wrapWithLogs(x: Int): NumberWithLogs {
    return NumberWithLogs(x)
}

private fun square(x: Int): NumberWithLogs {
    return NumberWithLogs(
        result = x * x,
        logs = listOf("Squared ${x} to get ${x * x}")
    )
}

private fun addOne(x: Int): NumberWithLogs {
    return NumberWithLogs(
        result = x + 1,
        logs = listOf("Added 1 to ${x} to get ${x + 1}")
    )
}

private fun minusFive(x: Int): NumberWithLogs {
    return NumberWithLogs(
        result = x - 5,
        logs = listOf("Subtracted 5 from ${x} to get ${x - 5}")
    )
}

private fun multiplyThree(x: Int): NumberWithLogs {
    return NumberWithLogs(
        result = x * 3,
        logs = listOf("Multiply by 3 to ${x} to get ${x * 3}")
    )
}

private fun addTwelve(x: Int): NumberWithLogs {
    return NumberWithLogs(
        result = x + 12,
        logs = listOf("Added 12 to ${x} to get ${x + 12}")
    )
}

private fun runWithLogs(
    input: NumberWithLogs,
    transform: (_: Int) -> NumberWithLogs
): NumberWithLogs {
    val newNumberWithLogs = transform(input.result)
    return NumberWithLogs(
        result = newNumberWithLogs.result,
        logs = input.logs + newNumberWithLogs.logs
    )
}

fun runSomethingFunny() {
    val result01 = wrapWithLogs(2)
        .run { runWithLogs(this) { x -> square(x) } }
        .run { runWithLogs(this) { x -> addOne(x) } }
        .run { runWithLogs(this) { x -> minusFive(x) } }
        .run { runWithLogs(this) { x -> multiplyThree(x) } }
        .run { runWithLogs(this) { x -> addTwelve(x) } }
    val result02 = wrapWithLogs(3)
        .run { runWithLogs(this) { x -> addOne(x) } }
        .run { runWithLogs(this) { x -> multiplyThree(x) } }
        .run { runWithLogs(this) { x -> addTwelve(x) } }
        .run { runWithLogs(this) { x -> square(x) } }
    println(result01.result)
    println(result02.result)
}
