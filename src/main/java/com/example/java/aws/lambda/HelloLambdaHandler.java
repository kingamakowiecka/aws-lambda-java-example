package com.example.java.aws.lambda;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.internal.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.internal.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class HelloLambdaHandler implements RequestHandler<AwsProxyRequest, AwsProxyResponse> {

    private SpringLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;

    public AwsProxyResponse handleRequest(AwsProxyRequest awsProxyRequest, Context context) {
        if (handler == null) {
            try {
                handler = SpringLambdaContainerHandler.getAwsProxyHandler(HelloAppConfig.class);
            } catch (ContainerInitializationException e) {
                e.printStackTrace();
                return null;
            }
        }
        return handler.proxy(awsProxyRequest, context);
    }
}
