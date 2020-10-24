package org.owasp;

import org.owasp.esapi.ExecuteResult;
import org.owasp.esapi.codecs.Codec;

import java.io.File;
import java.util.List;
import java.util.Optional;

public interface SecureExecutor {

    Optional<ExecuteResult> executeSystemCommand(File executable, List params);

    Optional<ExecuteResult> executeSystemCommand(File executable, List params,
                                                 File workdir, Codec codec,
                                                 boolean logParams, boolean redirectErrorStream);
}
