package extensions;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

public class EnvironmentExtension implements ExecutionCondition {

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(
            ExtensionContext context) {

        String env = System.getProperty("env");
        if ("prod".equalsIgnoreCase(env)) {
            return ConditionEvaluationResult
                    .disabled("Test disabled on PROD environment");
        }

        return ConditionEvaluationResult.enabled(
                "Test enabled on non PROD environment");
    }
}
