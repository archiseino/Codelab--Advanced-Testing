- Run the test with Gradle (The JUnit was trash), just right click on the Test Class and run as Gradle
- Using the Assertation such as Hamcrest or Truth is better than plain JUnit assertation.
- Always remember the mnemonics of Unit Testing. **Arrange, Act, Assert (AAA)** that's the standard concept of testing.
- The test name meant to be descriptive, the best practice for naming test is like this
```yaml
subjectUnderTest_actionOrInput_resultState

Subject under test is the method or class that is being tested (getActiveAndCompletedStats).
Next is the action or input (noCompleted).
Finally you have the expected result (returnsHundredZero).
```
- The AndroidX Test libraries include classes and methods that provide you with versions of components like Applications and Activities that are meant for tests. When you have a local test where you need simulated Android framework classes (such as an Application Context), follow these steps to properly set up AndroidX Test:
```yaml
Add the AndroidX Test core and ext dependencies
Add the Robolectric Testing library dependency
Annotate the class with the AndroidJunit4 test runner
Write AndroidX Test code
```
- AndroidX Test is a collection lib for testing. It provide the classes or methods such as Application and Activities (for testing)
- Test Runner it a JUnit component that run test, the `@RunWith` swaps out the default test runner
- The Roboelectric test runner was trash and I don't know what's wrong with that
- To test LiveData it's recommended you do two things:
```yaml
Use InstantTaskExecutorRule
Ensure LiveData observation
```
- InstantTaskExecutorRule is a JUnit Rule. When you use it with the @get:Rule annotation, it causes some code in the InstantTaskExecutorRule class to be run before and after the tests (to see the exact code, you can use the keyboard shortcut Command+B to view the file).
When you write test that include testing LiveData, use this rule, this component make sure the component baackground-related jobs run in background.
- Here's the liveData util component to observer the LiveData (I don't know it won't work)
```kotlin
@VisibleForTesting(otherwise = VisibleForTesting.NONE)
fun <T> LiveData<T>.getOrAwaitValue(
    time: Long = 2,
    timeUnit: TimeUnit = TimeUnit.SECONDS,
    afterObserve: () -> Unit = {}
): T {
    var data: T? = null
    val latch = CountDownLatch(1)
    val observer = object : Observer<T> {
        override fun onChanged(o: T?) {
            data = o
            latch.countDown()
            this@getOrAwaitValue.removeObserver(this)
        }
    }
    this.observeForever(observer)

    try {
        afterObserve.invoke()

        // Don't wait indefinitely if the LiveData is not set.
        if (!latch.await(time, timeUnit)) {
            throw TimeoutException("LiveData value was never set.")
        }

    } finally {
        this.removeObserver(observer)
    }

    @Suppress("UNCHECKED_CAST")
    return data as T
}
```
- Lastly, you  can use the `@Before` annotation to create a setup method for each test.