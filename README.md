# arrow-core-crash-demo

See issue https://github.com/arrow-kt/arrow/issues/1535
 
This is a demo of how this code causes Arrow-kt.io to crash:

    val some10 = Some(10)
    val some11 = some10.map { it + 1 }

    // if present, this next line with cause:
    //    Error: Unable to initialize main class dashfwd.CrashDemoKt
    //    Caused by: java.lang.VerifyError: Bad type on operand stack
    // with jdk-11.0.2
    some11.getOrElse { Some(0) }

To run:

    $ ./gradlew runJar
    
The output:

    Error: Unable to initialize main class dashfwd.CrashDemoKt
    Caused by: java.lang.VerifyError: Bad type on operand stack
    Exception Details:
      Location:
        dashfwd/CrashDemoKt.main([Ljava/lang/String;)V @103: invokestatic
      Reason:
        Type 'java/lang/Object' (current frame, stack[0]) is not assignable to 'arrow/core/Option'
      Current Frame:
        bci: @103
        flags: { }
        locals: { '[Ljava/lang/String;', 'arrow/core/Some', 'java/lang/Object', 'arrow/core/Some', 'arrow/core/Some', 'arrow/core/Some' }
        stack: { 'java/lang/Object', 'kotlin/jvm/functions/Function0' }
      Bytecode:
        0000000: 2a12 09b8 000f bb00 1159 100a b800 17b7
        0000010: 001b 4c2b 4e2d 3a04 1904 3a05 1905 c100
        0000020: 1d99 0008 1904 a700 3719 04b6 0021 3a06
        0000030: 1906 c000 23b6 0027 3607 0336 0815 0704
        0000040: 60b8 0017 3a10 1910 3a11 bb00 1159 1911
        0000050: b700 1bc0 0029 3a09 1909 c000 2b00 004d
        0000060: 2cb2 0031 c000 33b8 0039 57b1          
      Stackmap Table:
        full_frame(@41,{Object[#76],Object[#17],Top,Object[#17],Object[#17],Object[#17]},{})
        same_locals_1_stack_item_frame(@93,Object[#4])