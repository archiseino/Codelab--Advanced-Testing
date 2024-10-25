- Testing Pyramid consist of these 3
- Scope—How much of the code does the test touch? Tests can run on a single method, across the entire application, or somewhere in between.
- Speed—How fast does the test run? Test speeds can vary from milli-seconds to several minutes.
- Fidelity—How "real-world" is the test? For example, if part of the code you're testing needs to make a network request, does the test code actually make this network request, or does it fake the result? If the test actually talks with the network, this means it has higher fidelity. The trade-off is that the test could take longer to run, could result in errors if the network is down, or could be costly to use.
- On the applied scale itself, there's also three
- Unit tests (Just a single function test, consist of 70% coverage)
- Integration test, These test the interaction of several classes to make sure they behave as expected when used together. One way to structure integration tests is to have them test a single feature, such as the ability to save a task. Example: Testing all the functionality of a single fragment and view model pair.
- End to End test (E2e) Test a combination of features working together. They test large portions of the app, simulate real usage closely, and therefore are usually slow. They have the highest fidelity and tell you that your application actually works as a whole. By and large, these tests will be instrumented tests (in the androidTest source set) Example: Starting up the entire app and testing a few features together.
- So basically, in proper architecture isolation
1.   First you'll unit test the repository.
2.   Then you'll use a test double in the view model, which is necessary for unit testing and integration testing the view model.
3.   Next, you'll learn to write integration tests for fragments and their view models.
4.   Finally, you'll learn to write integration tests that include the Navigation component.

- Test double is a solution to use a specifically data for the testing purpose, there are 5 kinds of test doubles
1. Fake, Basically, you just create a new interface or implementation for the testing purpose and get the fake data.
2. Mock, Test double to mock an entire dependencies, so you can pass them as an argument.
3. Stub, Test double to return what you expect it to return (programmatically)
4. Dummy, just to passed around as the test double
5. Spy, A test double which also keeps tracks of some additional information; for example, if you made a SpyTaskRepository, it might keep track of the number of times the addTask method was called.

- Implementation of the Test Double
```kotlin
    private lateinit var tasksRemoteDataSource: FakeDataSource
    private lateinit var tasksLocalDataSource: FakeDataSource

    // Class under test
    private lateinit var tasksRepository: DefaultTasksRepository

    @Before
    fun createRepository() {
        tasksRemoteDataSource = FakeDataSource(remoteTasks.toMutableList())
        tasksLocalDataSource = FakeDataSource(localTasks.toMutableList())
        // Get a reference to the class under test
        tasksRepository = DefaultTasksRepository(
            // TODO Dispatchers.Unconfined should be replaced with Dispatchers.Main
            //  this requires understanding more about coroutines + testing
            //  so we will keep this as Unconfined for now.
            tasksRemoteDataSource, tasksLocalDataSource, Dispatchers.Unconfined
        )
    }
```
- Use instrumented testing (androidTest) to launch UI components.
- When you can't use constructor dependency injection, for example to launch a fragment, you can often use a service locator. The Service Locator pattern is an alternative to Dependency Injection. It involves creating a singleton class called the "Service Locator", whose purpose is to provide dependencies, both for the regular and test code.
