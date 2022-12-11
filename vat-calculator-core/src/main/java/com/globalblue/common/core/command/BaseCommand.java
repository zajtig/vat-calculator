package com.globalblue.common.core.command;

import com.globalblue.common.core.Presenter;
import com.globalblue.common.core.exception.CoreException;
import com.globalblue.common.core.exception.InternalErrorException;
import com.globalblue.logger.Logger;

public abstract class BaseCommand {

    private final Presenter presenter;
    private final Logger logger;

    protected BaseCommand(Presenter presenter, Logger logger) {
        this.presenter = presenter;
        this.logger = logger;
    }

    public void execute() {
        try {
            executeInner();
        } catch (CoreException e) {
            logger.error("Core exception occurred!", e);
            presenter.deliverError(e);
        } catch (Exception e) {
            logger.error("Unexpected error occurred!", e);
            presenter.deliverError(new InternalErrorException());
        }
    }

    protected abstract void executeInner();
}