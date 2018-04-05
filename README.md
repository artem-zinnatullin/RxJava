# Error-Prone benchmark based on RxJava 2.x project

This branch integrates Error-Prone in RxJava project and provides ways to benchmark and profile builds with and without Error-Prone.

References:

- Error-Prone project: [google/error-prone](https://github.com/google/error-prone)
- Gradle Plugin that replaces JDK compiler with Error-Prone compiler: [tbroyer/gradle-errorprone-plugin](https://github.com/tbroyer/gradle-errorprone-plugin)
- Gradle Plugin that adds Error-Prone as compiler plugin to JDK compiler: [tbroyer/gradle-errorprone-javacplugin-plugin](https://github.com/tbroyer/gradle-errorprone-javacplugin-plugin)
- Tool to benchmark and profile Gradle builds: [gradle/gradle-profiler](https://github.com/gradle/gradle-profiler)

To ease environment setup, I've added `Dockerfile`s, benchmark/profiling scenario files and scripts to run them.

