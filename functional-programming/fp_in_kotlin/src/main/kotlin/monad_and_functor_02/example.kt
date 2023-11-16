package monad_and_functor_02

private data class NumberWithLogs(
    var result: Int = 0,
    var logs: List<String> = ArrayList()
)

private fun wrapWithLogs(x: Int): NumberWithLogs {
    return NumberWithLogs(x)
}

private fun square(x: NumberWithLogs): NumberWithLogs {
    return NumberWithLogs(
        result = x.result * x.result,
        logs = x.logs + listOf("Squared ${x.result} to get ${x.result * x.result}")
    )
}

private fun addOne(x: NumberWithLogs): NumberWithLogs {
    return NumberWithLogs(
        result = x.result + 1,
        logs = x.logs + listOf("Added 1 to ${x.result} to get ${x.result + 1}")
    )
}

fun runSomethingFunny() {
    val result01 = addOne(square(wrapWithLogs(2)))
    val result02 = square(addOne(wrapWithLogs(3)))
    println(result01.result)
    println(result02.result)
}
