package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Hello implements RequestHandler<Integer, String> {
    public String handleRequest(Integer integer, Context context) {
        return "hello world" + integer;
    }
}
