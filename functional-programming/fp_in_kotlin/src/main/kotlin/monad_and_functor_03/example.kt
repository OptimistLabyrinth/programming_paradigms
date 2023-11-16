package monad_and_functor_03

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

private fun minusFive(x: NumberWithLogs): NumberWithLogs {
    return NumberWithLogs(
        result = x.result - 5,
        logs = x.logs + listOf("Subtracted 5 from ${x.result} to get ${x.result - 5}")
    )
}

private fun multiplyThree(x: NumberWithLogs): NumberWithLogs {
    return NumberWithLogs(
        result = x.result * 3,
        logs = x.logs + listOf("Multiply by 3 to ${x.result} to get ${x.result * 3}")
    )
}

private fun addTwelve(x: NumberWithLogs): NumberWithLogs {
    return NumberWithLogs(
        result = x.result + 12,
        logs = x.logs + listOf("Added 12 to ${x.result} to get ${x.result + 12}")
    )
}

fun runSomethingFunny() {
    val result01 = wrapWithLogs(2)
        .run { square(this) }
        .run { addOne(this) }
        .run { minusFive(this) }
        .run { multiplyThree(this) }
        .run { addTwelve(this) }
    val result02 = wrapWithLogs(3)
        .run { addOne(this) }
        .run { multiplyThree(this) }
        .run { addTwelve(this) }
        .run { square(this) }
    println(result01.result)
    println(result02.result)
}

fun runSomethingFunnyBefore() {
    val result01 = addTwelve(multiplyThree(minusFive(addOne(square(wrapWithLogs(2))))))
    val result02 = square(addTwelve(multiplyThree(addOne(wrapWithLogs(3)))))
    println(result01.result)
    println(result02.result)
}
