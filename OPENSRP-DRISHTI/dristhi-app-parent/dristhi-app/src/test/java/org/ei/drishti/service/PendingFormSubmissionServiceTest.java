package org.ei.drishti.service;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import org.ei.drishti.repository.FormDataRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class PendingFormSubmissionServiceTest {
    @Mock
    private FormDataRepository repository;
    private PendingFormSubmissionService pendingFormSubmissionService;

    @Before
    public void setUp() {
        initMocks(this);
        pendingFormSubmissionService = new PendingFormSubmissionService(repository);
    }

    @Test
    public void shouldFetchPendingFormSubmissionCount() {
        pendingFormSubmissionService.pendingFormSubmissionCount();

        verify(repository).getPendingFormSubmissionsCount();
    }
}
