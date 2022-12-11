package com.globalblue.common.rest.service;

import com.globalblue.common.rest.exception.BoundaryInException;
import com.globalblue.common.rest.mock.TestEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class BaseServiceUnitTest {

    private TestBaseService service;
    private SupplierSpy supplierSpy;

    @BeforeEach
    void setUp() {
        service = new TestBaseService();
        supplierSpy = new SupplierSpy();
    }

    @Test
    void mapTest() {
        assertNotNull(service.map(supplierSpy));
        assertTrue(supplierSpy.isCalled);
    }

    @Test
    void mapIllegalArgumentExceptionOccurredTest() {
        supplierSpy.isIllegalArgumentExceptionNeeded = true;
        assertThrows(BoundaryInException.class, () -> service.map(supplierSpy));
    }

    @Test
    void mapExceptionOccurredTest() {
        supplierSpy.isUnknownExceptionNeeded = true;
        assertThrows(BoundaryInException.class, () -> service.map(supplierSpy));
    }

    private static class TestBaseService extends BaseService {

    }

    private static class SupplierSpy implements Supplier<TestEntity> {

        public boolean isCalled;
        public boolean isIllegalArgumentExceptionNeeded;
        public boolean isUnknownExceptionNeeded;

        @Override
        public TestEntity get() {
            isCalled = true;
            if (isIllegalArgumentExceptionNeeded) {
                throw new IllegalArgumentException();
            }
            if (isUnknownExceptionNeeded) {
                throw new RuntimeException();
            }
            return new TestEntity();
        }
    }
}