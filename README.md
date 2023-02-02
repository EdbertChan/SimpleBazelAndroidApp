This is a branch that demonstrates the inability for Robolectric + Bazel to handle legacy mode in Robolectric.

To reproduce
bazel test //module_1:greeter_activity_test 

Observe that this test fails

  6 Time: 1.135
  7 There was 1 failure:
  8 1) testConfig(com.example.bazel.GreeterTest)
  9 org.junit.ComparisonFailure: expected:<"com.[uber.demo.app.id]"> but was:<"com.[example.bazel]">
 10         at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
 11         at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
 12         at java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
 13         at com.example.bazel.GreeterTest.testConfig(GreeterTest.java:29)
 14         at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
 15         at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
 16         at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
 17         at java.base/java.lang.reflect.Method.invoke(Method.java:566)
 18         at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
 19         at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
 20         at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
 21         at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
 22         at org.robolectric.RobolectricTestRunner$HelperTestRunner$1.evaluate(RobolectricTestRunner.java:580)
 23         at org.robolectric.internal.SandboxTestRunner$2.lambda$evaluate$2(SandboxTestRunner.java:287)
 24         at org.robolectric.internal.bytecode.Sandbox.lambda$runOnMainThread$0(Sandbox.java:99)
 25         at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
 26         at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
 27         at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
 28         at java.base/java.lang.Thread.run(Thread.java:829)

The cause of the error is that @Config() is only available in legacy mode. 

To run in non-legacy mode (by omitting the resource APK)

bazel test //module_1:greeter_activity_test --noexperimental_android_local_test_binary_resources   

Observe that this test fails

  7 There was 1 failure:
  8 1) testConfig(com.example.bazel.GreeterTest)
  9 android.content.res.Resources$NotFoundException: com.uber.demo.app.id:integer/google_play_services_version
 10         at org.robolectric.android.internal.AndroidTestEnvironment.injectResourceStuffForLegacy(AndroidTestEnvironment.java:453)
 11         at org.robolectric.android.internal.AndroidTestEnvironment.loadAppPackage_measured(AndroidTestEnvironment.java:383)
 12         at org.robolectric.android.internal.AndroidTestEnvironment.lambda$loadAppPackage$3(AndroidTestEnvironment.java:376)
 13         at org.robolectric.util.PerfStatsCollector.measure(PerfStatsCollector.java:53)
 14         at org.robolectric.android.internal.AndroidTestEnvironment.loadAppPackage(AndroidTestEnvironment.java:376)
 15         at org.robolectric.android.internal.AndroidTestEnvironment.installAndCreateApplication(AndroidTestEnvironment.java:273)
 16         at org.robolectric.android.internal.AndroidTestEnvironment.lambda$createApplicationSupplier$0(AndroidTestEnvironment.java:245)
 17         at org.robolectric.util.PerfStatsCollector.measure(PerfStatsCollector.java:53)
 18         at org.robolectric.android.internal.AndroidTestEnvironment.lambda$createApplicationSupplier$1(AndroidTestEnvironment.java:242)
 19         at com.google.common.base.Suppliers$NonSerializableMemoizingSupplier.get(Suppliers.java:183)
 20         at org.robolectric.RuntimeEnvironment.getApplication(RuntimeEnvironment.java:72)
 21         at org.robolectric.android.internal.AndroidTestEnvironment.setUpApplicationState(AndroidTestEnvironment.java:210)
 22         at org.robolectric.RobolectricTestRunner.beforeTest(RobolectricTestRunner.java:331)
 23         at org.robolectric.internal.SandboxTestRunner$2.lambda$evaluate$2(SandboxTestRunner.java:278)
 24         at org.robolectric.internal.bytecode.Sandbox.lambda$runOnMainThread$0(Sandbox.java:99)
 25         at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
 26         at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
 27         at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
 28         at java.base/java.lang.Thread.run(Thread.java:829)

Verdict: Not all resources are available in non-legacy mode
