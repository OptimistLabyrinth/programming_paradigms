fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

//    test_higher_order_function()
    test_monad_and_functor()
}

fun test_higher_order_function() {
    higher_order_function_01.run_something_funny()
    higher_order_function_final.run_something_funny()
}

fun test_functional_architecture() {
    // *
}

fun test_monad_and_functor() {
    monad_and_functor_final.run_something_funny()
}
