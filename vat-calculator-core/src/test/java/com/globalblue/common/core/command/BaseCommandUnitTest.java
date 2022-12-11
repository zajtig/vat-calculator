package com.globalblue.common.core.command;

import com.globalblue.common.core.Presenter;
import com.globalblue.common.core.exception.BadRequestException;
import com.globalblue.common.core.mock.LoggerMock;
import com.globalblue.common.core.mock.PresenterSpy;
import com.globalblue.logger.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BaseCommandUnitTest {

    private TestBaseCommand baseCommand;
    private LoggerMock loggerMock;
    private PresenterSpy presenterSpy;

    @BeforeEach
    void setUp() {
        loggerMock = new LoggerMock();
        presenterSpy = new PresenterSpy();
        baseCommand = new TestBaseCommand(presenterSpy, loggerMock);
    }

    @Test
    void executePositiveTest() {
        baseCommand.execute();
        assertTrue(baseCommand.isExecuteInnerCalled);
    }

    @Test
    void coreExceptionOccurredTest() {
        baseCommand.isCoreExceptionNeeded = true;
        baseCommand.execute();
        assertTrue(baseCommand.isExecuteInnerCalled);
        assertEquals("INVALID_VALUE", presenterSpy.deliveredErrorCode);
        assertEquals("Core exception occurred!", loggerMock.loggedInformationList.get(0));
    }

    @Test
    void unexpectedExceptionOccurredTest() {
        baseCommand.isUnexpectedExceptionNeeded = true;
        baseCommand.execute();
        assertTrue(baseCommand.isExecuteInnerCalled);
        assertEquals("SOMETHING_WENT_WRONG", presenterSpy.deliveredErrorCode);
        assertEquals("Unexpected error occurred!", loggerMock.loggedInformationList.get(0));
    }

    private static class TestBaseCommand extends BaseCommand {

        public boolean isExecuteInnerCalled;
        public boolean isCoreExceptionNeeded;
        public boolean isUnexpectedExceptionNeeded;

        public TestBaseCommand(Presenter presenter, Logger logger) {
            super(presenter, logger);
        }

        @Override
        protected void executeInner() {
            isExecuteInnerCalled = true;
            if (isCoreExceptionNeeded) {
                throw new BadRequestException("INVALID_VALUE");
            }
            if (isUnexpectedExceptionNeeded) {
                throw new RuntimeException();
            }
        }
    }
}