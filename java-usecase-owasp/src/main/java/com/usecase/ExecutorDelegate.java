package com.usecase;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.ExecuteResult;
import org.owasp.esapi.Executor;
import org.owasp.esapi.codecs.Codec;
import org.owasp.esapi.errors.ExecutorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;
import java.util.Optional;

public class ExecutorDelegate implements SecureExecutor {

    private static final Logger log = LoggerFactory.getLogger(ExecutorDelegate.class);

    private Executor executor = ESAPI.executor();

    @Override
    public Optional<ExecuteResult> executeSystemCommand(File executable, List params) {
        try {
            return Optional.ofNullable(executor.executeSystemCommand(executable, params));
        } catch (ExecutorException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<ExecuteResult> executeSystemCommand(File executable, List params,
                                                        File workdir, Codec codec,
                                                        boolean logParams, boolean redirectErrorStream) {
        try {
            return Optional.ofNullable(executor.executeSystemCommand(executable, params,
                    workdir, codec, logParams, redirectErrorStream));
        } catch (ExecutorException e) {
            return Optional.empty();
        }
    }
}
