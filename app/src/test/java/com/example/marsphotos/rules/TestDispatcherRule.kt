package com.example.marsphotos.rules

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class TestDispatcherRule(
	private val testDispatcher: TestDispatcher = UnconfinedTestDispatcher(),
): TestWatcher() {
	@OptIn(ExperimentalCoroutinesApi::class)
	override fun starting(description: Description) {
		Dispatchers.setMain(testDispatcher)
	}
}