fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    test_monad_and_functor()
}

fun test_functional_architecture() {
    // *
}

fun test_monad_and_functor() {
    monad_and_functor_01.runSomethingFunny()
    monad_and_functor_02.runSomethingFunny()
    monad_and_functor_03.runSomethingFunny()
    monad_and_functor_04.runSomethingFunny()
}
