package dashfwd

import arrow.core.*

fun main(args : Array<String>) {
    val some10 = Some(10)
    val some11 = some10.map { it + 1 }

    // if present, this next line with cause:
    //    Error: Unable to initialize main class dashfwd.CrashDemoKt
    //    Caused by: java.lang.VerifyError: Bad type on operand stack
    // with jdk-11.0.2
    some11.getOrElse { Some(0) }
}
