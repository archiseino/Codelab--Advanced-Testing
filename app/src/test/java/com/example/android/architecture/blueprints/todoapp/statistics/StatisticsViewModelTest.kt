package com.example.android.architecture.blueprints.todoapp.statistics

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.android.architecture.blueprints.todoapp.MainCoroutineRule
import com.example.android.architecture.blueprints.todoapp.data.source.FakeTestRepository
import com.example.android.architecture.blueprints.todoapp.data.source.TasksRepository
import com.example.android.architecture.blueprints.todoapp.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.pauseDispatcher
import kotlinx.coroutines.test.resumeDispatcher
import org.hamcrest.core.Is.`is`
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class StatisticsViewModelTest {
    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    // Set the main coroutines dispatcher for unit testing.
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    // Subject under test
    private lateinit var statisticsViewModel: StatisticsViewModel

    // Using fake repository
    private lateinit var tasksRepository: TasksRepository

    @Before
    fun setupViewModel() {
        // Initialise the repository with no tasks.
        tasksRepository = FakeTestRepository()

        statisticsViewModel = StatisticsViewModel(tasksRepository)
    }

    @Test
    fun loadTasks_loading() {
        // Pause the dispatcher
//        mainCoroutineRule.pauseDispatcher()

        // Load the task in the view model.
        statisticsViewModel.refresh()

        // Then progress indicator is shown.
        assertThat(statisticsViewModel.dataLoading.getOrAwaitValue(), `is`(true))

        // Execute pending coroutines actions.
//        mainCoroutineRule.resumeDispatcher()

        // Then progress indicator is hidden.
        assertThat(statisticsViewModel.dataLoading.getOrAwaitValue(), `is`(false))
    }

    @Test
    fun loadStatisticsWhenTasksAreUnavailable_callErrorToDisplay() {
        // Make the repository return errors.
        tasksRepository.setReturnError(true)
        statisticsViewModel.refresh()

        // Then empty and error are true (which triggers an error message to be shown).
        assertThat(statisticsViewModel.empty.getOrAwaitValue(), `is`(true))
        assertThat(statisticsViewModel.error.getOrAwaitValue(), `is`(true))
    }



}