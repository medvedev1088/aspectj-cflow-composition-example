package example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExampleAspect {
    @Pointcut("execution(* example.Example.P(..))")
    public void P() {
    }

    @Pointcut("execution(* example.Example.Q(..))")
    public void Q() {
    }

    @Pointcut("cflow(P()) && within(example.Example)")
    public void flowP() {
    }

    @Pointcut("cflow(Q()) && within(example.Example)")
    public void flowQ() {
    }

    @Pointcut("cflow(P()) && cflow(Q()) && within(example.Example)")
    public void flowPAndflowQ() {
    }

    @Pointcut("cflow(P() && Q()) && within(example.Example)")
    public void flowPAndQ() {
    }

    @Pointcut("execution(public * *(..)) && within(example.Example)")
    public void publicMethods() {
    }

    @Pointcut("cflow(P() && publicMethods()) && within(example.Example)")
    public void flowPAndPublic() {
    }

    @Before("P()")
    public void beforeP(JoinPoint joinPoint) {
        printJoinPoint("P", joinPoint);
    }

    @Before("Q()")
    public void beforeQ(JoinPoint joinPoint) {
        printJoinPoint("Q", joinPoint);
    }

    @Before("flowP()")
    public void beforeFlowP(JoinPoint joinPoint) {
        printJoinPoint("flowP", joinPoint);
    }

    @Before("flowQ()")
    public void beforeFlowQ(JoinPoint joinPoint) {
        printJoinPoint("flowQ", joinPoint);
    }

    @Before("flowPAndflowQ()")
    public void beforeFlowPAndflowQ(JoinPoint joinPoint) {
        printJoinPoint("flowPAndflowQ", joinPoint);
    }

    @Before("flowPAndQ()")
    public void beforeFlowPAndQ(JoinPoint joinPoint) {
        printJoinPoint("flowPAndQ", joinPoint);
    }

//    @Before("flowPAndPublic()")
//    public void beforeFlowPAndPublic(JoinPoint joinPoint) {
//        printJoinPoint("flowPAndPublic", joinPoint);
//    }

    private void printJoinPoint(String p, JoinPoint joinPoint) {
        String format = String.format("pointcut: %-20s join point: %s", p, joinPoint.toShortString());
        System.out.println(format);
    }
}
