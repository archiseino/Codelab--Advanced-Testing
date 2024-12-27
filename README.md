TO-DO Notes - Code for 5.1-5.3 Testing Codelab
============================================================================

Code for the Advanced Android Kotlin Testing Codelab 5.1-5.3

Build Config Setup
------------------
For whoever tried to download from original repo, try to downgrade the gradle into the old version one (in this case the gradle 7.4.2) to sync the project. Next, you can use the AGP Upgrade Assistant, to update to the latest or stable one. 

I think by default the Java version of Compilation will be around Java 8 which is not suitable for the Gradle 8.xx. Try to change the Java Compilation and also try to update the Kotlin version and some important dependencies.

Also note, for older dependencies, sometimes when building process, it will throw non-sense error, but try some simple solution just upgrade the dependencies related to the error to the latest or stable one.

Also run the test with the Gradle, the JUnit was trash for running test. The Fragment UI Testing is somehow is not working, It won't launch the fragment and perform the UI Testing. I don't know why.

Run The Test
------------------
For physical device, there's something odd with the Xiaomi device, you need to enable the "Display pop-up windows while running in the background" special permission after installing the app since it was resetted, as was present in here quotes
 
> I've been hitting my head on the wall for a few days on this. Try to enable the "Display pop-up windows while running in the background" special permission for your normal apk(not the .test apk).
> The first run will fail as permissions are reset each time.

> Microbenchmarks probably work fine because they don't need to launch an activity(just like standard unit tests)

> At least testing is doable this way but of course it's not normal behaviour and should at the very least be documented.



Introduction
------------

TO-DO Notes is an app where you to write down tasks to complete. The app displays them in a list.
You can then mark them as completed or not, filter them and delete them.

![App main screen, screenshot](screenshot.png)

This codelab has four branches, representing different code states:

* [starter_code](https://github.com/googlecodelabs/android-testing/tree/starter_code)
* [end_codelab_1](https://github.com/googlecodelabs/android-testing/tree/end_codelab_1)
* [end_codelab_2](https://github.com/googlecodelabs/android-testing/tree/end_codelab_2)
* [end_codelab_3](https://github.com/googlecodelabs/android-testing/tree/end_codelab_3)

The codelabs in this series are:
* [Testing Basics](https://codelabs.developers.google.com/codelabs/advanced-android-kotlin-training-testing-basics)
* [Introduction to Test Doubles and Dependency Injection](https://codelabs.developers.google.com/codelabs/advanced-android-kotlin-training-testing-test-doubles)
* [Survey of Testing Topics](https://codelabs.developers.google.com/codelabs/advanced-android-kotlin-training-testing-survey)


Pre-requisites
--------------

You should be familiar with:

* The Kotlin programming language, including [Kotlin coroutines](https://developer.android.com/kotlin/coroutines) and their interaction with [Android Jetpack components](https://developer.android.com/topic/libraries/architecture/coroutines).
* The following core Android Jetpack libraries: [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel),
 [LiveData](https://developer.android.com/topic/libraries/architecture/livedata),
  [Navigation Component](https://developer.android.com/guide/navigation) and 
  [Data Binding](https://developer.android.com/topic/libraries/data-binding).
* Application architecture, following the pattern from the [Guide to app architecture](https://developer.android.com/jetpack/docs/guide) and [Android Fundamentals codelabs](https://developer.android.com/courses/kotlin-android-fundamentals/toc).


Getting Started
---------------

1. Download and run the app.
2. Check out one of the codelabs mentioned above.

License
-------

Copyright 2019 Google, Inc.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.
