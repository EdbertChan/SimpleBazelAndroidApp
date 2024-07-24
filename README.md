This project demonstrates R8 errors with Java lambdas.

Reproduction steps
1) Download bazel-7.0.0-pre.20230906.2-darwin-arm64
2) Run bazel-7.0.0-pre.20230906.2-darwin-arm64 mobile-install //:app
3) Observe crash at runtime when starting the app

2024-07-24 13:45:27.726 28398-28398 AndroidRuntime          pid-28398                            E  FATAL EXCEPTION: main
Process: com.example.bazel, PID: 28398
java.lang.NoClassDefFoundError: Failed resolution of: Lcom/example/bazel/MainActivity$$ExternalSyntheticLambda0;
at com.example.bazel.MainActivity.onCreate(MainActivity.java:19)
at android.app.Activity.performCreate(Activity.java:7994)
at android.app.Activity.performCreate(Activity.java:7978)
at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1309)
at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:3422)
at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3601)
at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:85)
at android.app.servertransaction.TransactionExecutor.executeCallbacks(TransactionExecutor.java:135)
at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:95)
at android.app.ActivityThread$H.handleMessage(ActivityThread.java:2066)
at android.os.Handler.dispatchMessage(Handler.java:106)
at android.os.Looper.loop(Looper.java:223)
at android.app.ActivityThread.main(ActivityThread.java:7656)
at java.lang.reflect.Method.invoke(Native Method)
at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:592)
at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:947)
Caused by: java.lang.ClassNotFoundException: Didn't find class "com.example.bazel.MainActivity$$ExternalSyntheticLambda0" on path: DexPathList[[dex file "/data/local/tmp/incrementaldeployment/com.example.bazel/dex/incremental_classes1.dex"],nativeLibraryDirectories=[/data/user/0/com.example.bazel/lib, /system/lib64, /system_ext/lib64]]
at dalvik.system.BaseDexClassLoader.findClass(BaseDexClassLoader.java:207)
at com.google.devtools.build.android.incrementaldeployment.IncrementalClassLoader$DelegateClassLoader.findClass(IncrementalClassLoader.java:62)
at java.lang.ClassLoader.loadClass(ClassLoader.java:379)
at java.lang.ClassLoader.loadClass(ClassLoader.java:312)