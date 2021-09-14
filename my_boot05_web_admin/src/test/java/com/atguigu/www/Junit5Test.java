package com.atguigu.www;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 *Junit5测试案例
 */

@SpringBootTest
@DisplayName("MyJunit5测试")
public class Junit5Test {

    @BeforeAll
    static void testBeforeAll(){
        System.err.println("---------------这是@BeforeAll的-----所有测试单元之前执行--------------");
    }

    @BeforeEach
    void testBeforeEach() {
        System.err.println("-----@BeforeEach--------测试就要开始了...");
    }

    @Test
    void  testMethod(){
        System.out.println("这是@Test方法---1111111111111");
    }

    @Test
    void  testMethod2(){
        System.out.println("这是@Test2方法---22222222222222");
    }

    /**
     * 抛出异常
     * java.util.concurrent.TimeoutException: testTimeOut() timed out after 500 milliseconds
     * @throws InterruptedException
     */
    @Timeout(value = 500,unit = TimeUnit.MILLISECONDS)
    @Test
    void testTimeOut() throws InterruptedException {
        Thread.sleep(600);
    }

    @RepeatedTest(3)
    @Test
    void testRepeat(){
        System.out.println("This is RepeatdTeast---------------------");
    }



    @AfterEach
    void testAfterEach() {
        System.err.println("-----@AfterEach-----测试结束了...");
    }




    @AfterAll
    static void testAfterAll(){
        System.err.println("---------------这是@AfterAll的------所有测试单元之前执行--------------");
    }

    /**
     * 简单断言
     * 断言：前面断言失败，后面的代码都不会执行
     */
    @DisplayName("简单断言")
    @Test
    void testSimpleAssertions(){
        int result = sum(3,3);
//        Assertions.assertEquals(6,result,"相加后的结果不对劲！");
        assertEquals(6,result,"相加后的结果不对劲！");
        String a="a",b="b";
        assertSame(a,b,"两个对象不一样");
        assertEquals(a,b,"这两个String的值不相等");
    }
    int sum (int x, int y ) {return  x+y;}

    /**
     * 数组断言
     */
    @DisplayName("数组断言")
    @Test
    void testArrayAssertions(){
        int []a={1,2,3,4,5};
        int []b={1,2,3,4,2};
        assertArrayEquals(a,b,"两个数组不一样");
    }
    /**
     * 组合断言
     */
    @DisplayName("组合断言")
    @Test
    void testAssertAll(){
        String a="a",b="B",C=a;
        assertAll("组合断言",()->assertEquals(1,1,"两者不相等"),
                ()->assertSame(a,C,"两者不是一个对象")
                );
        System.out.println("组合断言成功执行！");
    }

    /**
     * 异常断言
     */
    @DisplayName("异常断言")
    @Test
    void testExceptionAssertions(){
        assertThrows(ArithmeticException.class,()->{int i = 10/2;},"函数竟然能正常执行!");
    }

    /**
     * 超时异常
     */
    @DisplayName("超时异常")
    @Test
    void testAssertTimeOut(){
            assertTimeout(Duration.ofMillis(600l),()->Thread.sleep(700l),"超时异常");
    }

    /**
     * 快速失败测试
     */
    @DisplayName("快速失败异常")
    @Test
     void shouldFail() {
        fail("This should fail！----快速失败！");
        System.out.println("这是后面的代码");
    }

    /**
     * 禁止执行
     */
    @Disabled
    @Test
    void testDisabled(){
        System.out.println("禁止执行！");
    }
}
