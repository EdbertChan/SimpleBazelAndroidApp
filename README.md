This branch demonstrates a bug where rules kotlin will fail coverage

# Code Coverage with Jacoco

Reproduction steps

1) Download bazel 7.2.1
2) Run bazel coverage //module_1:greeter_activity_test
3) Observe that there is a testlog failure with an IllegalAccessError

exec ${PAGER:-/usr/bin/less} "$0" || exit 1
Executing tests from //module_1:greeter_activity_test
-----------------------------------------------------------------------------
JUnit4 Test Runner
.E
Time: 0.01
There was 1 failure:
1) flatMapError(com.example.bazel.ResultTest)
   java.lang.IllegalAccessError: class com.example.bazel.ResultTest tried to access private method 'boolean[] com.example.bazel.ResultKt.$jacocoInit()' (com.example.bazel.ResultTest and com.example.bazel.ResultKt are in unnamed module of loader 'app')
   at com.example.bazel.ResultTest.flatMapError(ResultTest.kt:13)
   at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
   at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
   at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
   at java.base/java.lang.reflect.Method.invoke(Method.java:566)
   at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
   at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
   at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
   at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
   at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
   at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
   at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
   at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
   at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
   at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
   at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
   at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
   at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
   at com.google.testing.junit.runner.internal.junit4.CancellableRequestFactory$CancellableRunner.run(CancellableRequestFactory.java:108)
   at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
   at org.junit.runner.JUnitCore.run(JUnitCore.java:115)
   at com.google.testing.junit.runner.junit4.JUnit4Runner.run(JUnit4Runner.java:116)
   at com.google.testing.junit.runner.BazelTestRunner.runTestsInSuite(BazelTestRunner.java:145)
   at com.google.testing.junit.runner.BazelTestRunner.main(BazelTestRunner.java:76)
   at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
   at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
   at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
   at java.base/java.lang.reflect.Method.invoke(Method.java:566)
   at com.google.testing.coverage.JacocoCoverageRunner.main(JacocoCoverageRunner.java:612)

FAILURES!!!
Tests run: 1,  Failures: 1


BazelTestRunner exiting with a return value of 1
JVM shutdown hooks (if any) will run now.
The JVM will exit once they complete.

-- JVM shutdown starting at 2024-08-05 14:48:52 --

--
Coverage runner: Not collecting coverage for failed test.
The following commands failed with status 1
/private/var/tmp/_bazel_edbert/be4858b858e53fdee59025cce739e91f/sandbox/darwin-sandbox/59/execroot/_main/bazel-out/darwin_arm64-fastbuild/bin/module_1/greeter_activity_test.runfiles/_main/module_1/greeter_activity_test
