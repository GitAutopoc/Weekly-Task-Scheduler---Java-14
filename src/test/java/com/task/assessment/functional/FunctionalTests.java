package com.task.assessment.functional;

import static com.task.assessment.testutils.TestUtils.businessTestFile;
import static com.task.assessment.testutils.TestUtils.currentTest;
import static com.task.assessment.testutils.TestUtils.yakshaAssert;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.task.assessment.WeekScheduler;

public class FunctionalTests {

	@BeforeEach
	void setup() {
		WeekScheduler.tasks[0] = "Complete Java Module";
		WeekScheduler.locations[0] = "Home Office";
		WeekScheduler.tasks[1] = "Attend Webinar";
		WeekScheduler.locations[1] = "";
		WeekScheduler.tasks[2] = null;
		WeekScheduler.locations[2] = "Online";
	}

	@Test
	void testGetTaskForDayValidInput() throws IOException {
		yakshaAssert(currentTest(),
				"Complete Java Module - Location: Home Office".equals(WeekScheduler.getTaskForDay(1)) ? "true"
						: "false",
				businessTestFile);
	}
}